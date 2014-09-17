clear;
clc;
x=input('enter the given sequence');       // sequence of any desired length
L=length(x);
h=zeros(1,L);
for j=1:L
    h(L-j+1)=x(j);                       // invert the sequence and store in h(n)
end
P=2*L-1;                               
for i=L+1:P
     x(i)=0;
     h(i)=0;
end
out=zeros(1,P);
for n=1:P
    for k=1:P
        if(n>=k) 
         out(n)=out(n)+x(n-k+1)*h(k);            // convolution of x(n) and h(n)
end
end
end
disp(out);                    // autocorrelation sequence output
