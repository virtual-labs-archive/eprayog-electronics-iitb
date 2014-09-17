// Program to simulate basic functions which can be done on signals
// time shifting, time scaling, folding

// Example program performing these operations on a time limited unit step function

//x(n)
clc;
clear;
x = input('Enter the input sequence');

// Shift right : x(n-y)
y = input('Enter the number of right shifts required');
x_rightshift = x;
for i=1:y
  x_rightshift = [0 x_rightshift] ;
end

// Shift left : x(n+y) 
z = input('Enter the number of left shifts required');

//plot the original waveform
figure;
plot2d3(x);
//plot the right shifted version
figure;
plot2d3(x_rightshift);
//plot the left shifted version
c = k-z;
N = -z:c(2)-1
figure;
plot2d3(N,x);