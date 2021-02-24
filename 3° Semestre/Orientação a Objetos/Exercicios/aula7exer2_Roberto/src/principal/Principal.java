package principal;

import dados.Exposicao;
import servicos.Servicos;
import validacao.Validacao;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {
		// DECLARACOES
		final int ANONIMO = 1000, MAXIMO = 2015;
		Exposicao exposicao;
		
		// INSTRUCOES
		Visao.interacao(0);
		exposicao = new Exposicao(Validacao.validaNome(2), Validacao.validaAno(3, ANONIMO, MAXIMO));
		while (Servicos.opcoes(exposicao, ANONIMO, MAXIMO));
	}
}
