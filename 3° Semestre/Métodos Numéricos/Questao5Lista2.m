clear all; close all; clc;

f = inline('2*x.^3 - 11.7*x.^2 + 17.7*x -5'); 
d_f = inline('6*x.^2 - 23.4*x + 17.7');

g1 = inline ('(5 + 11.7*x.^2 - 2*x.^3)/17.7');

%Intervalos
a = 2;
b = 4;

%iteracoes
imax = 50;

%Erro max
err = 0.001;

% METODO DA BISSECAO
for (i = 1 : imax)
  xi = (a + b)/2;
  if (f(a)*f(xi) < 0)
    b = xi;
  elseif (f(b)*f(xi) < 0)
    a = xi;
  endif
  if abs(a - b) <= err
    fprintf("Quantidade de iteracoes pelo metodo da bissecao: %d\nValor convergido: %.6f\n\n\n", i, xi)
    break;
  endif;
endfor

%Intervalos
a = 2;
b = 4;
x2 = 200;

% METODO DA POSICAO FALSA
for (t = 1 : imax)
  xi = (a*f(b) - b*(f(a)))/(f(b) - f(a));
  if (f(a)*f(xi) < 0)
   b = xi;
  endif
  if (f(b)*f(xi) < 0)
   a = xi;
  endif
  if  abs(xi - x2) <= err
    fprintf("Quantidade de iteracoes pelo metodo da posicao falsa: %d\nValor convergido: %.6f\n\n\n", t, xi)
    break
  endif;
  x2 = xi;
endfor

a = 2;
b = 4;

% METODO DE NEWTON
for i = 1 : imax
  xi = b - f(b)/d_f(b);
  if abs((xi - b)) <= err
    fprintf("Quantidade de iteracoes pelo metodo de Newton: %d\nValor convergido: %.6f\n\n\n", i, xi)
    break
  endif
  b = xi;
endfor

a = 3;
b = 4;

% METODO DA SECANTE
for i = 1 : imax
  xi = b - (f(b)*(a-b))/(f(a) - f(b));
  if abs((xi - b)/b) <= err
    fprintf("Quantidade de iteracoes pelo metodo da Secante: %d\nValor convergido: %.6f\n\n\n", i, xi)
    break;
  endif
  a = b;
  b = xi;
endfor

a = 2;
b = 4;

% METODO DO PONTO FIXO
for i = 1 : imax
 xi = g1(b);
 if abs(xi - b)/b <= err 
  fprintf("Quantidade de iteracoes pelo metodo do Ponto Fixo: %d\nValor convergido: %.6f\n\n\n", i, xi)
  break
 endif
 b = xi;
endfor

    