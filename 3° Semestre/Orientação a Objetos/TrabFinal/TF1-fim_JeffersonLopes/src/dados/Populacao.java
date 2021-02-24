package dados;

import java.util.ArrayList;

public class Populacao {
	private ArrayList<Pessoa> populacao;

	public Populacao() {
		this.populacao = new ArrayList<Pessoa>();
	}

	public ArrayList<Pessoa> getPopulacao() {
		return populacao;
	}

	public void addPessoa(int identificador, Pessoa pessoa) {
		pessoa.setIdentificador(identificador);
		this.populacao.add(pessoa);
	}

}