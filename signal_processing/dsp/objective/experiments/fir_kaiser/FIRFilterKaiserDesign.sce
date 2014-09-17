/////////////////// Macros //////////////////////////////////////////////////////
funcprot(0)
///// calculate Transition width //////////////////////////////////////////////
deff('Width = GETTRANSWITDH(Freq1,Freq2)','Width = (min(abs(Freq1),abs(Freq2)))');

////// Normalization of frequencies //////////////////////////////////////////
deff('NormFreq = NORMFRQ(Freq,SampFreq)','NormFreq = (2*%pi*(Freq/SampFreq))')

//////////////////////// Calculate Kaiser Window Parameters ////////////////////
function Para_Ret = GetKaiserWinowPara(d1,d2,delw) 
Para_Ret(1) = -20*(log10(min(d1,d2)));  
Para_Ret(2) =ceil((Para_Ret(1)-8)/(2*2.285*delw));
endfunction
////////////////////////////////////////////////////////////////////////////////

////////////////////// calculate Alpha ////////////////////////////////////////
function Alpha_Ret = CalcAlpha(A_Arg)
if (A_Arg > 50)
    Alpha_Ret = 0.1102 * (A_Arg - 8.7);
 elseif (A_Arg>=21 & A_Arg<= 50)
        Alpha_Ret = (0.5842*(A_Arg - 21)^0.4)+0.07886 * (A_Arg - 21);
    else
        Alpha_Ret=0;
      end;

 endfunction  
///////////////////////////////////////////////////////////////////////////////
//////////////  Design filters using kaiser window.///////////////////////////


function TF = DesignFilter(FilterType,FilterOrder,CutOffFreq1,CutOffFreq2,Window_Arg)
TF_Index = 1;  
for Index = -FilterOrder:FilterOrder,
   if Index
     select FilterType  
     case 'LowPass'      
       Temp = (sin(CutOffFreq1*Index))/(%pi*Index);
     case 'HighPass'
       Temp = (-sin(CutOffFreq1*Index))/(%pi*Index);
     case 'BandPass'
       Temp = (-sin(CutOffFreq1*Index)+sin(CutOffFreq2*Index))/(%pi*Index);
     case 'BandStop'
       Temp = -(-sin(CutOffFreq1*Index)+sin(CutOffFreq2*Index))/(%pi*Index);   
     end  
   else
     select FilterType  
        case 'LowPass'
        Temp= CutOffFreq1/%pi;  
        case 'HighPass'
        Temp = 1-(CutOffFreq1/%pi);  
        case 'BandPass'
        Temp=(CutOffFreq2-CutOffFreq1)/%pi;
        case 'BandStop'
        Temp = 1-((CutOffFreq2-CutOffFreq1)/%pi); 
    end
    end  
    
  TF(TF_Index) = Temp;   
  TF(TF_Index) = TF(TF_Index)*Window_Arg(TF_Index); 
  TF_Index = TF_Index + 1;    
  end

 endfunction


///////////////////////// FIR Filter Design Specifications /////////////////////
BandPassLow = 10300;
BandPassHigh = 13300;
BandStopHigh = 14300;
BandStopLow = 9300;
d1 = 0.01;
d2 = 0.01;
SampleFreq = 70000;
/////////////////////////////////////////////////////////////////////////

BPHighFreq = NORMFRQ(BandPassHigh,SampleFreq);
BPLowFreq = NORMFRQ(BandPassLow,SampleFreq);
SBHighFreq = NORMFRQ(BandStopHigh,SampleFreq);
SBLowFreq = NORMFRQ(BandStopLow,SampleFreq);
TransWidth = GETTRANSWITDH(SBLowFreq - BPLowFreq, SBHighFreq-BPHighFreq);
KaiserPara = GetKaiserWinowPara(d1,d2,TransWidth);
A = KaiserPara(1); 
FilterOrder = KaiserPara(2); 
Alpha = CalcAlpha(A);
Beta = (Alpha/FilterOrder);
/////////////////////// filter Design///////////////////////////////////
Window = window('kr',(2*FilterOrder) + 1,Alpha );

/////////////////// display window ////////////////////////////////////
clf();
////////////////////////////////////////////////////////////////////////

CutOffFreq1= (BPLowFreq + SBLowFreq)/2;
CutOffFreq2= (BPHighFreq + SBHighFreq)/2;
HKaiser = DesignFilter('BandStop',FilterOrder,CutOffFreq1,CutOffFreq2,Window);

subplot(121);plot2d(1:(2*FilterOrder) + 1,Window,style=color('blue'))
set(gca(),'grid',[1 1]*color('gray'))
subplot(122)
n=256;[W,fr]=frmag(HKaiser,n);
plot2d(fr,20*log10(W),style=color('blue'))
set(gca(),'grid',[1 1]*color('gray'))





