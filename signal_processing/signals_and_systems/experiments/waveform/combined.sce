A_sine = input('Enter the amplitude of the sine wave')
sine = zeros(361,1);
pi=3.141592653;
//Sine wave
for i=1:361,
    sine(i,1) =  A_sine * sin(pi/180 * (i-1));
  end;
//Square wave
A_square = input('Enter the amplitude of the square wave')
square_wave = zeros(361,1); 
for i=361:1:721,
  if i<541 then
    square_wave(i-360,1) =  A_square;
  else
    square_wave(i-360,1) =  -A_square; 
  end;
end;
//Triangular wave
triangle = zeros(361,1);
for i=721:1:1080
  if i<=811 then
    triangle(i-720,1) = (i - 721)/90;
  elseif ((i>811)&(i<=991)) then
    triangle(i-720,1) = (900 - i)/90;
  else
    triangle(i-720,1) = (i - 1080)/90;
  end;
end;
// Combining the three waves to be plotted
comb = cat(1,sine,square_wave,triangle);
t=1:1:1081;
plot(t,comb(t,1));