clc; close all; clear all;

newtonLA = inline('0.905 - 0.86 .* (x - 0.1) + 0.383 .* (x - 0.1) .*(x - 0.2) - 0.066 .* (x - 0.1) .*(x - 0.2) .* (x - 0.4) - 0.114 .* (x - 0.1) .*(x - 0.2) .* (x - 0.4) .* (x - 0.6) + 0.415 .* (x - 0.1) .*(x - 0.2) .* (x - 0.4) .* (x - 0.6) .* (x - 0.8)');
newtonLB = inline('0.21 + 0.55 .* (x -1) + 0.625 .* (x -1) .* (x - 1.2) - 2.82 .* (x -1) .* (x - 1.2) .* (x - 1.4) + 15.82 .* (x -1) .* (x - 1.2) .* (x - 1.4) .* x- 1.7');

err = 1e-3;
y = 0.4;
x = 1.5;

while (true)
  if abs(newtonLA(y) - 0.6) < err
    break;
  endif;
  y = y + 0.01;
endwhile;

while (true)
  if abs(newtonLB(x) - y) < err
    break;
  endif;
  x = x + 0.01;
endwhile;