clear  all; close all; clc;

f = inline('x.^3 + 3.8*(x.^2) - 8.6*x - 24.4');

%Intervalos
a = 2;
b = 3;

% Erro
err = 1e-10;

%iteracoes max
imax = 50;

for (i = 1 : imax)
  xi = b - (f(b)*(a-b))/(f(a) - f(b));
  
  if (abs(xi - b)/b)<= err
    solucao = xi;
    break;
  endif
  solucao = xi;
  a = b;
  b = xi;
endfor

fprintf ("Quantidade de iteracoes: %d\nSolucao: %.6f\nValor da funcao nesse ponto: %.6f\n\n", i, solucao, f(solucao))