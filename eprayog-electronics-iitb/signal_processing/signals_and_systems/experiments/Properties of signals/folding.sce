clc;
clear;
// Enter the input sequence
x = [1 2 3 4 5 7 8 9];
L = size(x);
L = L(2);
for i=1:L
  y(i) = x(L-i+1)
end
N = -L:-1;
//plot the original sequence
figure;
plot2d3(x);
// plot the folded version of the sequence
figure;
plot2d3(N,y);