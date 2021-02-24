clear all; close all; clc;

f = inline('x.^5 - (10/9) * x.^3 + (5/21) * x');

%intervalos
a = -0.75;
b = -0.5;

%iteracoes maxima
imax = 4;

for i = 1 : imax
  xi = (a + b)/2;
  if f(a)*f(xi) < 0
    b = xi;
  elseif f(b)*f(xi) < 0
    a = xi;
  endif
endfor
sprintf("\nQuantidade de iteracoes pelo metodo da bissecao: %d\nValor convergido: %.3f\n\n\n", i, xi)