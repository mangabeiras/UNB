%Metodo de Jacobi para sistema linear
clear all; close all; clc;
k =1; x1(1) = 0; x2(1) = 0; x3(1) = 0;

%Erro estabelecido
err = 1e-5;

%Iteracoes
for k = 2: 100
  x1(k) = (20   +x2(k-1)  -2*x3(k-1))/8; %estabelece o 1ºx1, usando valor da iteracao anterior dos x
  x2(k) =(38   +2*x1(k-1)   -x3(k-1))/6; %estabelece o 1ºx2, usando valor da iteracao anterior dos x
  x3(k) = (-34   +3*x1(k-1)   +x2(k-1))/7; %estabelece o 1ºx3, usando valor da iteracao anterior dos x
  
  %Calculo do Erro
  e1 = abs((x1(k) - x1(k-1))/x1(k));
  e2 = abs((x2(k) - x2(k-1))/x2(k));
  e3 = abs((x3(k) - x3(k-1))/x3(k));
  
  if (e1 + e2 + e3) <= err
    break
  endif
endfor

%Resultado
fprintf("Solucao encontrada em %01d interacoes por Jacobi:\nx1 = %f\nx2 = %f\nx3 = %f\n\n\n", k, x1(k), x2(k), x3(k))
