// Program to synthesize musical tone by additive synthesis
//f = input('Enter the fundamental frequency(Hz)   ');
n = input('Enter the number of harmonics   ');
// Duration of the speech in terms of samples
N = 0 : 8000;
// Sampling frequency
Fs = 8000;
//fundamental frequency
f = 100;
x = 2 * %pi * (f/Fs) * N;
//Initialize result to zeros
result = zeros(1,8001);
// s is a cell containing all samples
// cell is an array of matrices. cell is like a structure in C language. elements of the cell can be accessed through the '.entries' operator.
s = cell(1,8001,n+1);
// Ask the user if he wants to enter the amplitude and phase for each harmonic
Enter_amplitude = input('Do you want to enter the amplitude and phase for harmonics (yes = 1/no = 0)');
//disp(y);
// if yes execute the below commands
if(Enter_amplitude == 1)
// Enter the amplitudes of all harmonics and add the sinusoids
  for i=1:n+1
    A(i) = input('Enter the amplitude of the sinusoids');
    phi(i) = input('Enter the phase for the harmonic');
    s(1,8001,i).entries = A(i)* sin((i*x)+phi(i));
    // Addition of sinusoids
    result(:,:,1) = result(:,:,1) + s(1,8001,i).entries
  end
// if NO, use random number generator for generating amplitudes and use %pi/i for generating phase where i= 0 to number of harmonics
else
    for i=1:n+1
    A(i) = rand(1);
    phi(i) = %pi/i;
    s(1,8001,i).entries = A(i)* sin((i*x)+phi(i));
    result(:,:,1) = result(:,:,1) + s(1,8001,i).entries
  end
end

//plot the time domian signal
figure(1);
plot(N,result);
// taking fourier transform to plot the magnitude spectrum
fresp = fft(result);
//plotting magnitude spectrum
figure(2);
plot(N,abs(fresp));
// take ifft and compare the plot with figure 1
r = ifft(fresp);
figure(3);
plot(N,r)

// play the result (addition of sinusoids)
sound(result,8000);


