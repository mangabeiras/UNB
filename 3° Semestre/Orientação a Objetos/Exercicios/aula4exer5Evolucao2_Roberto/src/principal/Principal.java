package principal;

import dados.Passageiro;
import leitura.Leitura;
import saida.Visao;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {
		// DECLARACOES
		Passageiro passageiro = new Passageiro();

		// INSTRUCOES
		do {
			passageiro.criaPassageiro(Validacao.validaNome());
			Visao.padraoAereo(passageiro.getPassageiro());
		} while (Validacao.validaContinua(Leitura.lerLinha()));
	}
}
