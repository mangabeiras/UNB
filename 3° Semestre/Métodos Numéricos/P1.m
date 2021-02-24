%P1 Métodos
%Roberto Gabriel
clc; clear all; close all;

f = inline('x.^5 - (10/9) * x.^3 + (5/21) * x');

%TOLERANCIA MAXIMA
err = 1e-5;

%INTERVALOS
a = 0.75;
b = 1;


% METODO DA SECANTE
for i = 1 : 100
  xi = b - (f(b)*(a-b))/(f(a) - f(b));
  % CALCULO DO ERRO RELATIVO
  if abs((xi - b)/b) < err
    break;
  endif
  a = b;
  b = xi;
endfor

fprintf("Quantidade de iteracoes pelo metodo da Secante: %d\nValor da QUINTA RAIZ RAIZ: %.3f\n\n\n", i, xi)
  
