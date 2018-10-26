x = -1:0.01:1;
y1 = x.^2-x+10;
y2 = x.^3+cos(2*pi*x);
plot(x,y1,x,y2)
title('Task 2 Solution')
xlabel('x')
ylabel('y')
legend('y=x^2-x+10','y=x^3+cos(2{\pi}x)')
clear x y1 y2