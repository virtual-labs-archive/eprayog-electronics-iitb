A = input('Enter the amplitude of the sine wave')
sine = zeros(361,1);
pi=3.141592653;
for i=1:361,
//The values of sin(x) for x between 0 and 360 degrees are copied into the array sine(i,1)
    sine(i,1) =  A * sin(pi/180 * (i-1));
end;
time=1:1:361;
//The sine wave is plotted for one cycle
plot(time,sine(time,1));