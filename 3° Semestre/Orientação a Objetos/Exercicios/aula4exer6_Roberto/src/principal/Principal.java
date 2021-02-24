package principal;

import leitura.Leitura;
import validacao.Validacao;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {
		// INSTRUCOES
		do {
			Visao.pedeNome();
			Visao.mostraResultado(Validacao.validaNome(Leitura.lerLinha()));
			Visao.continua();
		} while (Validacao.validaContinua(Leitura.lerLinha()));

	}

}
