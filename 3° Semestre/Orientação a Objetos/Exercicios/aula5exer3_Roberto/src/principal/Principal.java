package principal;

import dados.Populacao;
import servicos.Servicos;
import validacao.Validacao;
import visao.Visao;

public class Principal {
	public static void main(String[] args) {
		// DECLARACOES
		Populacao pessoa = new Populacao();
		int contador = 0;
		
		// INTRUCOES
		Visao.orientacoes();
		do {
			pessoa.criaHabitante(contador++);
		} while (Validacao.validaContinua());
		Servicos.calculaDados(pessoa);
	}
}
