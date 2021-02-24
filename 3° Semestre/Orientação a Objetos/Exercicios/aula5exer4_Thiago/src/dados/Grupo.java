package dados;

import java.util.Vector;

public class Grupo {
	private Vector<String> nomes;
	
	public Grupo() {
		this.nomes = new Vector<>();
		System.out.println("Criando Grupo");
	}
	
	public Vector<String> getNomes() {
		return nomes;
	}
	
	public void setNomes(String nome) {
		this.nomes.add(nome);
	}
}
