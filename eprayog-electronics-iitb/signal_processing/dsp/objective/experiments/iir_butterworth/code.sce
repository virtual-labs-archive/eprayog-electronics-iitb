///////////////////////// Calculate Filter Order /////////////////////////////////
//Funciton is used to calculate order of the analog filter.
funcprot(0)
function N = FilterOrder(RippleFactor1, RippleFactor2,PassBandFreq, StopBandFreq)
Temp = sqrt(RippleFactor2/RippleFactor1);  
N = ceil(log(Temp)/log(StopBandFreq/PassBandFreq));  
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
  //disp(Temp1);
  Temp2 = (((SBLowFreq)^2 - (CutOffFreq)^2)/(BW * SBLowFreq));
 // disp(Temp2);
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

//======================= Low Pass Butterworth filter design using Bilinear Transformation method ==========================//  

//////////////////////////////  Digital Filter Design Specification ///////////////////////

PassBandTol = 0.1;
StopBandTol = 0.1;
/////////////////////////////////////////////////////////////////////////////////////////

clc;
clf;
//////////////// get the specifications from the filter number 
PassBandLowFreq = 10400 ;
PassBandHighFreq = 13400;
StopBandHighFreq = 9400;
StopBandLowFreq = 14400;
SampleRate = 70000;

//// Step 1: Find Out the Analaog frequencies from given digital frequencies
//// AnaFreq(1) = Analog Pass Band High Frequncy
//// AnaFreq(2) = Analog Pass Band Low Frequency
///  AnaFreq(3) = Analog Stop Band High Frequncy
///  AnaFreq(3) = Analog Stop Band Low Frequncy
AnaFreq = FreqTrans(PassBandHighFreq,PassBandLowFreq,StopBandHighFreq,StopBandLowFreq,SampleRate);

//// Step 2: Find Out the Bandwidth of the analog filter
BW = AnaFreq(1)- AnaFreq(2);           // AnaFreq1= Pass Band High Frequency, AnaFreq2 = PassBand Low Frequency
//disp(BW);
//// Step 3: Find Out Cut Off frequncy of Analog filter
CutOffFreq = sqrt(AnaFreq(1) * AnaFreq(2));

//// Step 4: Assume Pass Band Frequncy =1 and Calculate Stop Band Frequency
AnaPBFreq = 1; 
AnaSBFreq = CalSBFreq(AnaFreq(3),AnaFreq(4),CutOffFreq,BW);
//AnaSBFreq = 12.63;
//// Step 5: Find the order of the filter
D1=(1/(1-PassBandTol)^2)-1;
D2=(1/StopBandTol^2)-1;
N = FilterOrder(D1,D2,AnaPBFreq,AnaSBFreq);

CutOffFreq = ((AnaPBFreq * D1^(-1/(2*N))) + (AnaSBFreq * D2^(-1/(2*N))))/2;
//CutOffFreq=1.11;
//// Step 6: Calculate Butterworth filter coeffiecients ////////////////////////
for Index = 1: N
   Coeff(Index) = %i*CutOffFreq*exp((%i*(2*Index - 1)*%pi)/(2*N)); 
end

//// Step 7: Implement Analog Transfer function 
Ko = CutOffFreq^N

Deno = poly(Coeff,"s");
AnaFilterTF =[real(Ko)/real(Deno)];
disp("====Transfer Function of Low Pass Analog Filter======");
disp(AnaFilterTF);
subplot(221);
plzr(AnaFilterTF);

CutoffFreq_0 = (AnaFreq(1)*AnaFreq(2));
s = poly(0,"s");

//////////////////// Design High Pass, Band Pass, BandStop filter
//AnaFilterTF1 = DesignFilter(AnaFilterTF,'LowPass',AnaFreq(1), AnaFreq(2));

//AnaFilterTF1 = horner(AnaFilterTF,((s * BW)/(s^2 + CutoffFreq_0)));
AnaFilterTF1 = horner(AnaFilterTF,((s^2 + CutoffFreq_0)/(s * BW)));
disp("====Transfer Function of Band Pass Analog Filter======");
disp(AnaFilterTF1);
subplot(222);
plzr(AnaFilterTF1);
//AnaFilterTF1 = horner(AnaFilterTF,(AnaFreq(1)/s))

//// Step 9: Perform bilinear transformation ////////////////////////////////
//// Substitute s with ((z-1)/(z+1)) in analog transfer function
z = poly(0,"z");
DisFilterTF =horner(AnaFilterTF1,((z-1)/(z+1)));
disp("====Transfer Function of Digital Filter=======");
disp(DisFilterTF);

//////Step 10: Plot frequency Response //////////////////////////////////////
[HZ,Fr] = frmag(DisFilterTF,255);
subplot(223);
plot2d(Fr,abs(HZ));
xtitle(" Frequency Response of Butterworth Filter ");
xlabel(" Frequency in rad ");
ylabel("Magnituide");
subplot(224);
plzr(DisFilterTF);
subplot(224);













