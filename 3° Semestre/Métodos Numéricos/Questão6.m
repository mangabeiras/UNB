format short;
function cossenoDeTaylor = taylor(x, a)
c =0;
for i = 0: a
c = c + ((-1)^i.*x^(i.*2))/factorial(i.*2);
endfor
cossenoDeTaylor = c
endfunction

function [erroAbsoluto, erroAproximado] = compara(x , b)
erroAbsoluto = (b - cos(x))
erroAproximado = erroAbsoluto/cos(x)
endfunction

%Cosseno de pi/3 usando 2 numeros da serie de Taylor
taylor(pi/3, 2)

%Cosseno de pi/3 usando 4 numeros da serie de Taylor
taylor(pi/3, 4)

%Cosseno de pi/3 usando 6 numeros da serie de Taylor
taylor(pi/3, 6)

%Comparacao com cosseno original

compara(pi/3, taylor(pi/3, 2));

compara(pi/3, taylor(pi/3, 4));

compara(pi/3, taylor(pi/3, 6));

