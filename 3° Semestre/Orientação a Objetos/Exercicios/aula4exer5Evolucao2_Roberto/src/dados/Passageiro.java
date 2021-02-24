package dados;

import servicos.Servicos;

public class Passageiro {
	private Pessoa passageiro;

	public void criaPassageiro(StringBuilder lido) {
		StringBuilder nomeInicial = new StringBuilder();
		StringBuilder nomeFinal = new StringBuilder();

		nomeInicial.append(lido.toString().trim().split(" ")[0]);
		nomeFinal.append(lido.toString().trim().split(" ")[lido.toString().trim().split(" ").length - 1]);
		
		passageiro = new Pessoa(Servicos.concatena(nomeInicial, nomeFinal));
	}
	public StringBuilder getPassageiro() {
		return this.passageiro.getNomePadrao();
	}
}
