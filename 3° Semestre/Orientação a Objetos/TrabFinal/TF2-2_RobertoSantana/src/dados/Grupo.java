package dados;

import java.util.ArrayList;
// COLECAO DE PESSOA
public class Grupo {
	// ATRIBUTO
	private ArrayList<Pessoa> grupo;

	// CONSTRUTOR
	public Grupo() {
		this.grupo = new ArrayList<Pessoa>();
	}
	
	// ADICIONA PESSOA
	public void addPessoa(Pessoa pessoa) {
		this.grupo.add(pessoa);
	}
	
	// OBTEM GRUPO
	public ArrayList<Pessoa> getGrupo(){
		return this.grupo;
	}
}	
