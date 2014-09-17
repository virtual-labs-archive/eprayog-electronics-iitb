sinc_wave = zeros(1081,1);
pi=3.141592653;
for i=2:1080,
  sine(i,1) =  sin(pi/180 * (i-1));
  x = pi/180 * (i-1);
  sinc_wave(i,1) =  sine(i,1)/x;// sinc(pi*x) = sin(pi*x)/pi*x
end;
time=(-1081:2:1081);
//Plot the sinc waveform
plot(time,sinc_wave(abs(time),1))

