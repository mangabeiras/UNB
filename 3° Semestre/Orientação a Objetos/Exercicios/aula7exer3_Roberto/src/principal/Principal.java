package principal;

import dados.Zoologico;
import validacao.Validacao;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {
		// DECLARACOES
		Zoologico zoologico =  new Zoologico();
		int macacos = 0, elefantes = 0, baleias = 0;
		
		// INSTRUCOES
		Visao.interacao(0);
		do {
			switch(Validacao.validaMenu()) {
			case 0:
				zoologico.addZoologico();
			}
			
		} while (Validacao.validaContinua((elefantes + macacos + baleias)));
		
		Visao.mostraRelatorio(zoologico, macacos, elefantes, baleias);
	}
}
