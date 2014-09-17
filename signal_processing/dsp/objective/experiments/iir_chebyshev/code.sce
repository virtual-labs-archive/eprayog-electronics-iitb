///////////////////////// Calculate Filter Order /////////////////////////////////
//Funciton is used to calculate order of the analog filter.
funcprot(0)
function Order = FilterOrder(RippleFactor1, RippleFactor2,PassBandFreq, StopBandFreq)
Temp = sqrt(RippleFactor2/RippleFactor1);  
Order = ceil(acosh(Temp)/acosh(StopBandFreq/PassBandFreq));  
endfunction
//////////////////////////////////////////////////////////////////////////////////

///////////////////////////////Frequency Transformation //////////////////////////
//Function is used to normalized digital filter specification frequencies and 
// transforming it to the analog frequncies 

function TranFreq = FreqTrans(PassBandFreq1,PassBandFreq2,StopBandFreq1,StopBandFreq2,SamplingFreq)
  TranFreq(1) = tan((%pi*PassBandFreq1)/SamplingFreq); 
  TranFreq(2) = tan((%pi*PassBandFreq2)/SamplingFreq); 
  TranFreq(3) = tan((%pi*StopBandFreq1)/SamplingFreq);  
  TranFreq(4) = tan((%pi*StopBandFreq2)/SamplingFreq);   
endfunction 
///////////////////////////////////////////////////////////////////////////////////////

///////////////////// stop band calculation ///////////////////////////////////////////
////// function is used to calculate stop band of analog filter.
function SBFreq = CalSBFreq(SBHighFreq,SBLowFreq,CutOffFreq,BandWidth)
  Temp1 = (((SBHighFreq)^2 - (CutOffFreq)^2)/(BW * SBHighFreq));  
  Temp2 = (((SBLowFreq)^2 - (CutOffFreq)^2)/(BW * SBLowFreq));
  SBFreq = min(abs(Temp1),abs(Temp2));
endfunction
///////////////////////////////////////////////////////////////////////////////////////

function Arr = RevSeq(ArrArg)
  N=size(ArrArg);
  Count=N(2)
  for Index=1:Count
    Arr(Index) = ArrArg(Count-(Index-1)); 
  end   
  
endfunction 

function Shift_Result = CircularShift(InputArr,Count)
  ShiftReg =InputArr;
  N = size(InputArr);  
  for Index=1:Count
    TempVar = ShiftReg(1);
    for Index=1:N(2)-1
      ShiftReg(Index)= ShiftReg(Index+1);
    end
  ShiftReg(N(2))=TempVar;  
   end  
   Shift_Result = ShiftReg;
   
endfunction 


function AnaFilterTF1 = DesignFilter(AnaFilterTF,FilterType,PassBandFreq1,PassBandFreq2)
  s = poly(0,"s");
  CutoffFreq_0 = PassBandFreq1 * PassBandFreq2;
  BW = PassBandFreq1 - PassBandFreq2;
  
  select FilterType
    
  case 'LowPass' then
  AnaFilterTF1 = AnaFilterTF;    
  case 'HighPass' then
  AnaFilterTF1 = horner(AnaFilterTF,PassBandFreq1/s);  
  
  case 'BandPass' then
  AnaFilterTF1 = horner(AnaFilterTF,((s^2 + CutoffFreq_0)/(s * BW)));    
    
  case 'BandStop' then       
  AnaFilterTF1 = horner(AnaFilterTF,((s * BW)/(s^2 + CutoffFreq_0)));  
  end  
endfunction

//======================= Low Pass Chebyshev filter design using Bilinear Transformation method ==========================//  

//////////////////////////////  Digital Filter Design Specification ///////////////////////
PassBandHighFreq = 17300; 
PassBandLowFreq =  12300;
StopBandHighFreq = 18300;
StopBandLowFreq =  11300;
SampleRate = 90000;
PassBandTol = 0.1;
StopBandTol = 0.1;
/////////////////////////////////////////////////////////////////////////////////////////

clc;
clf;
//// Step 1: Find Out the Analaog frequencies from given digital frequencies
//// AnaFreq(1) = Analog Pass Band High Frequncy
//// AnaFreq(2) = Analog Pass Band Low Frequency
///  AnaFreq(3) = Analog Stop Band High Frequncy
///  AnaFreq(4) = Analog Stop Band Low Frequncy

AnaFreq = FreqTrans(PassBandHighFreq,PassBandLowFreq,StopBandHighFreq,StopBandLowFreq,SampleRate);
//// Step 2: Find Out the Bandwidth of the analog filter
BW = AnaFreq(1)- AnaFreq(2);           // AnaFreq1= Pass Band High Frequency, AnaFreq2 = PassBand Low Frequency

//// Step 3: Find Out Cut Off frequncy of Analog filter
CutOffFreq = sqrt(AnaFreq(1) * AnaFreq(2));

//// Step 4: Assume Pass Band Frequncy =1 and Calculate Stop Band Frequency
AnaPBFreq = 1; 
AnaSBFreq = CalSBFreq(AnaFreq(3),AnaFreq(4),CutOffFreq,BW);

//// Step 5: Find the order of the filter
D1=(1/(1-PassBandTol)^2)-1;
D2=(1/StopBandTol^2)-1;
N = FilterOrder(D1,D2,AnaPBFreq,AnaSBFreq);

//// Step 6: Calculate chebyshev filter coeffiecients ////////////////////////

for Index = 1: N
  A(Index)   = ((2*(Index + N -2)+1)*%pi)/(2*N - 1); 
  B(Index)   =  (asinh(1/(sqrt (D1))))/(N);
  SLK(Index) =  AnaPBFreq*sin(A(Index))*sinh(B(Index))+%i*AnaPBFreq*cos(A(Index))*cosh(B(Index)); 
end


//// Step 7: Implement Analog Transfer function 
e = sqrt(D1);
 if N/2 == ceil(N/2)
    Ko = (1/sqrt(1+e^2))*prod(-SLK); //find kapa Ko
 else
    Ko = prod(-SLK);
 end;
 Deno = poly(SLK,"s");
 
AnaFilterTF =[real(Ko)/real(Deno)];
disp("====Transfer Function of Low Pass Analog Filter======");
disp(AnaFilterTF);
subplot(221);
plzr(AnaFilterTF);

s = poly(0,"s");
Nume = [- 0.0000153,- 5.538D-12, 0.0000767,1.423D-11,- 0.0001534,- 1.475D-11,0.0001534,7.192D-12,-0.0000767,- 1.376D-12,0.0000153];
Denome =[0.7441570,-3.9217897,12.122759,- 25.063632,38.676711,- 45.208634,41.029476,-28.207901,14.475274,- 4.9693749,1];
//////////////////// Design High Pass, Band Pass, BandStop filter
AnaFilterTF1 = DesignFilter(AnaFilterTF,'BandStop',AnaFreq(1), AnaFreq(2));
subplot(222);
plzr(AnaFilterTF1); 
disp("====Transfer Function of Band Pass Analog Filter======");
disp(AnaFilterTF1);

//// Step 9: Perform bilinear transformation ////////////////////////////////
//// Substitute s with ((z-1)/(z+1)) in analog transfer function
z = poly(0,"z");
DisFilterTF =horner(AnaFilterTF1,((z-1)/(z+1)));
disp("====Transfer Function of Digital Filter=======");
disp(DisFilterTF);

//////Step 10: Plot frequency Response //////////////////////////////////////
[HZ,Fr] = frmag(DisFilterTF,255);
subplot(223);
plot(Fr,abs(HZ));
subplot(224);
plzr(DisFilterTF);



