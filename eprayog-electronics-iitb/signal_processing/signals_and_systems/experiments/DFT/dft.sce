// Discrete fourier transform
// Enter the input sequence
clc;
clear;
x = input("Enter the input sequence");
N = length(x);// Length of the sequence
Y = zeros(1,N);
w = zeros(1,N);
for j=0:N-1
  for  k=0:N-1
  // Compute the DFT
  Y(j+1) = Y(j+1) + (x(k+1)* exp(-((%i*2*%pi*k*j)/N)));
end
end

disp(Y);
//Compare with the fft function given by Scilab
Z = fft(x);

// Inverse DFT
for j=0:N-1
  for  k=0:N-1
  // Compute the IDFT
  w(j+1) = real((w(j+1) + (Y(k+1)* exp((%i*2*%pi*k*j/N)))/N));
end
end
// Compare with inbuilt ifft function given by Scilab
s = ifft(Z);
