function [libras, polegadas] = paraIngles(peso, metro)
libras = peso/0.453592
polegadas = metro/0.0254
end
function [peso, metro] = paraMetrico(libras, polegadas)
peso = libras*0.453592
metro = polegadas*0.0254
endfunction
paraIngles(66, 1.89)
paraIngles(55, 1.999)
paraMetrico(176.37, 70.8661)
paraMetrico(209.439, 59.0551)