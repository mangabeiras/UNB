package dados;

import validacao.Validacao;

public class Pessoa {
	private String nome;
	
	public Pessoa() {
		setNome(Validacao.validaNome());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
