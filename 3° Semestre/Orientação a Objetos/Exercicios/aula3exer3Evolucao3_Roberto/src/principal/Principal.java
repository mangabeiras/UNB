package principal;

import dados.Grupo;
import validacao.Validacao;
import visao.Saida;

public class Principal {
	public static void main(String[] args) {
		// DECLARACOES
		final int MAXIMO = 50;
		Grupo grupo = new Grupo(MAXIMO);
		int i = 0;
		// INSTRUCOES
		do {
			Saida.limpaTela((i > 0) ? 30 : 0);
			grupo.criaPessoa(i);
			i++;
		} while ((i < MAXIMO) ? Validacao.validaContinua() : false);
		Saida.mostraResultado(grupo, i);

	}
}
