clear all; close all; clc;

f = inline('x.^5 - (10/9) * x.^3 + (5/21) * x');

%intervalo
a = -0.5;
b = 0.5;

%Iteracoes max;
imax = 3;


for (iteracoes = 1: imax)
  Xns = (a*f(b) - b*f(a))/(f(b) - f(a));
  
  if f(a)*f(Xns) < 0
    b = Xns;
  elseif (f(b)*f(Xns) < 0)
    a = Xns;
    endif
endfor

fprintf("Quantidade de iteracoes pelo Metodo da posicao falsa %d.\nRaiz : %.3f\n\n", iteracoes, Xns)
  