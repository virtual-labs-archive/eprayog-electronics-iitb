// Program to scale the given waveform
clc;
clear;
// Input waveform
x = [ 1 0 0 2 5 7 3 1]
// Enter the desired scaling factor
scaling_factor = input('Enter the scaling factor');
// Finding the size of y(n) where y(n) = x(scaling factor*n)
L = size(x);
L = ceil(L(2)/scaling_factor);
y(1) = x(1);
for i = 1:L-1
  y(i+1) = x((scaling_factor * i)+1)
end
N = 1:L

// Plotting input waveform x(n)
figure;
plot2d3(x);
//Plotting output waveform y(n)
figure;
plot2d3(y);
