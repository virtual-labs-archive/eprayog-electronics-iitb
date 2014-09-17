// CIRCULAR CONVOLUTION USING FFT.

//This program finds the circular convolution of the two input sequences basing on the fact that IFFT of product of the FFTs of the given two input sequences is equal to their circular convolution.


// ************** Program starts ************** //

clc //  Clears the scilab console.

x=[1,2,1];// Input sequence x(n).
h=[1,2,3];// Input sequence h(n).

len_x=length(x);// Finds the length of the input sequence x(n).
len_h=length(h);// Finds the length of the input sequence h(n).

//If the length of the two input sequences are not equal, shorter sequence will be zero padded to the length of longer sequence.//

if (len_x<len_h)//Checking whether length of x(n) is < length of h(n).
  x(len_x+1:len_h)=zeros(1,len_h-len_x);// If the above condition is true then x(n) will be zeropadded to the length of h(n).
elseif (len_h<len_x)//Checking whether length of h(n) is < length of x(n)
   h(len_h+1:len_x)=zeros(1,len_x-len_h);// If the above condition is true then h(n) will be zeropadded to the length of x(n).
end// 'if' loop ends.

fft_x=fft(x);// Finds the FFT of input sequence x(n). Length of the FFT is equal to length of x(n) after zeropadding, if it is zeropadded.
fft_h=fft(h);// Finds the FFT of input sequence h(n). Length of the FFT is equal to length of h(n) after zeropadding, if it is zeropadded.
fft_y=(fft_x.*fft_h);// Multiplying the each element of 'fft_x' with corresponding elecment in 'fft_h'.
y=ifft(fft_y);// Finds the IFFT of the sequence ,fft_y' obtained in the last step. Which is nothing but the resultant sequence after the circular convolution of the two input sequences x(n) and h(n).

// ************** Program ends ************** //
