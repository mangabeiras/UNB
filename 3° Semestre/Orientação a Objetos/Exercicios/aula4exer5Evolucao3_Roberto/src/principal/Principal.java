package principal;

import dados.Passageiro;
import saida.Saida;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {
		// DECLARACOES
		Passageiro passageiro = new Passageiro();

		// INSTRUCOES
		do {
			passageiro.criaPassageiro(Validacao.validaNome());
			Saida.padraoAereo(passageiro.getPassageiro());
		} while (Validacao.validaContinua());
	}
}
