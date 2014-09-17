A = input('Enter the amplitude of the square wave')
for i=1:361,
  if i<181 then
//The wave will hold the value of amplitude for the first half of cycle
    square_wave(i,1) =  A;
  else
//The wave will hold the negative value of amplitude for the second half of cycle
    square_wave(i,1) =  -A; 
    end;
  end;
  t = 1:1:361;
// A single cycle of square wave is plotted
plot(t,square_wave(t,1));