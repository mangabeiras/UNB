%Metodo de Crout para resolucao de sistema linear
clear all; close all; clc;

A = [2, 3, 1, 5; 1, 3.5, 1, 7.5; 1.4, 2.7, 5.5, 12; -2, 1, 3, 28];
b = [11, 13, 21.6, 30]';

function [somatorio] = somatorio(final, L, U, i, j)
somatorio = 0;
  for inicio = 1 : final
    somatorio += L(i, inicio)*U(inicio, j);
  endfor
endfunction
%Primeira coluna de L e diagonal de U
for i = 1 : 4
  L(i, 1) = A(i, 1);
  U(i, i) = 1;
endfor

%Primeira Linha de U
for j = 1 : 4
  U(1, j) = A(1, j)/L(1, 1);
endfor

%Demais linhas de L e U;
for i = 2 : 4
  for j = 2 : 4
    if i >= j
      L(i, j) = A(i, j) - somatorio(j - 1, L, U, i, j);
    else
      U(i, j) = (A(i, j) - somatorio(i - 1, L, U, i, j))/L(i, i);
    endif
  endfor
endfor
fprintf("Solucao do Sistema: ")
y = L\b;
x = U\y
fprintf("Prova real (A * x = B)")
A*x