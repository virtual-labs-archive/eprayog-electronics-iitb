//Experiment 1 : Discrte time Convolution
x = [4 8 6 7 9];// input sequence x[n]
h = [1 2 3];// input sequence h[n]
xt = x';
matrixx = size(x);
sizeofx = matrixx(1,2);
matrixh = size(h);
sizeofh = matrixh(1,2);
y = zeros(sizeofx,sizeofh);
i=1;
j=1;
while i<=sizeofx;
  while j<=sizeofh;
    y(i,j)= xt(i,1)*h(1,j);
    j = j + 1;
  end
  j=1;
  i = i + 1;
end
w = zeros(sizeofx,(sizeofx + sizeofh -1));
i=1;
j=0;
while(i<=sizeofx)
  while(j<sizeofh)
    w(i,i+j) = y(i,j+1);
    j = j + 1;
  end
  j=0;
  i = i + 1;
end
w;// intermediate array to hold values
i=1;
j=1;
z = zeros (1,sizeofx + sizeofh -1);
while(i<=(sizeofx + sizeofh -1))
  while(j<= sizeofx)
    z(1,i) = z(1,i) + w(j,i);
    j = j + 1;
  end
  j=1;
  i = i + 1;
end
z // output sequence z[n]
plot2d3(z)// plot on the graphic window

