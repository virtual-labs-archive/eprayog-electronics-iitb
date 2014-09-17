for i=1:1:360
  if i<=91 then
    triangle(i,1) = i/90;//The wave holds the value of i during first quarter of the cycle
  elseif ((i>91)&(i<=271)) then
    triangle(i,1) = (180 - i)/90;//The wave decreases once it reaches the amplitude of 1 unit during next half of the cycle.
  else
    triangle(i,1) = (i - 360)/90;// It again starts increasing during the last quarter
  end;
end;
t=1:1:360;
// A triangular wave is plotted
  plot(t,triangle(t,1));
  