clear all; close all; clc;

f = inline('x.^3 + 3.8*(x.^2) - 8.6*x - 24.4');
d_f = inline('3*(x.^2) + 7.6*x - 8.6');

%intervalos
a = 3;

%iteracoes maxima
imax = 50;
%erro
err = 1e-6;

for (i = 1 : imax)
  xi = a - f(a)/d_f(a);
  if abs((xi - a)/xi) <= err
    solucao = xi;
    break
   endif
   solucao = xi;
   a = xi;
endfor

fprintf("Quantidade de iteracoes: %d\nRaiz aproximada: %.3f.\nValor da Funcao nesse ponto: %.3f\n\n", i, solucao, f(solucao))


