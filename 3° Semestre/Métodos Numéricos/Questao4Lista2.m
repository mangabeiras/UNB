clear all; close all; clc;

f = inline('(-1)*x^(1/3) + 0.5*x.^2 - 2');

g1 = inline('(0.5*x.^2 - 2).^3');
d_g1 = inline('3* x * ((0.5*x.^2 - 2).^2)');

g2 = inline ('(( 2 + x.^(1/3))/0.5).^1/2');
d_g2 = inline ('(1/2)*((0.5) / (2 + x.^(1/3))).^(1/2) * (1 / (1.5 * x.^(2/3)))');

##fprintf("Modulo da derivada de g1(x),(com o primeiro termo de f(x)), de 2 e 3:\n%.3f | %.3f\n\n", abs(d_g1(2)), abs(d_g1(3)))
##fprintf("Modulo da derivada de g2(x)(com o segundo termo de f(x)), de 2 e 3:\n%.3f | %.3f\n\n", abs(d_g2(2)), abs(d_g2(3)))

%iteracoes
imax = 4;

%ponto de partida
a = 3;

for (i = 1: imax)
  xi = g1(a);
  a = xi;
  fprintf("%.3f\n", xi)
endfor
fprintf("\n\nValor convergido: %.3f\n\n\n", xi)
