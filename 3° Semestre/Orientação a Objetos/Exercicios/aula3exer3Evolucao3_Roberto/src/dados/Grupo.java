package dados;

import validacao.Validacao;

public class Grupo {
	private Pessoa pessoas[];
	
	public Grupo(int MAXIMO) {
		this.pessoas = new Pessoa[MAXIMO];
	}
	
	public void criaPessoa(int i) {
		this.pessoas[i] = new Pessoa(Validacao.validaNome(i),
				Validacao.validaIdade(),
				Validacao.validaAltura());
	}
	public Pessoa getPessoa(int i) {
		return this.pessoas[i];
	}
}
