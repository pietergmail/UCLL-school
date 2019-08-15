function y=f(x)
    y=(x^2+2*x)*exp(-x)    
endfunction
function y=g(x)
    y=sin(x/2)
endfunction
x=-2:0.1:5;
clf;
a=gda();
a.x_location="middle";
a.y_location="middle";
xtitle("De functies f(x) en g(x)");
xgrid(0);
plot(x, f, 'r');
plot(x, g, 'g');

clf;
a=gda()
a.x_location="bottom";
a.y_location="left";
a.tight_limits="on";
a.data_bounds=[0, 5, 0, 5];
a.title.text="een rechthoek";
xgrid=(0);
a.thickness=1;
a.font_size=0.5;
x=[2, 2, 4, 4, 2]; y=[0, 2, 2, 0, 0];
plot2d(x, y)
