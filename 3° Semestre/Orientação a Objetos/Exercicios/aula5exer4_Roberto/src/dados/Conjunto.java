package dados;

import java.util.Vector;
// CLASSE QUE SE COMUNICA COM A CLASSE NOME
public class Conjunto {
	Vector<Nome> nomes = new Vector<Nome>();
	
	public void novoNome(String nome) {
		nomes.add(new Nome(nome));
	}
	public int getQtdNomes() {
		return this.nomes.size();
	}
	public String getNome(int i) {
		return this.nomes.get(i).getNome();
	}
	public void zerarLista() {
		this.nomes.clear();
	}
	public void excluirItem(int i) {
		this.nomes.remove(i);
	}
}
