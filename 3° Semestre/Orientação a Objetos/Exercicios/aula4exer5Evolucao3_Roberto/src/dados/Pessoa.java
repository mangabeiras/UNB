package dados;

public class Pessoa {
	private StringBuilder nomePadrao;

	public Pessoa(StringBuilder nome) {
		this.nomePadrao = nome;
	}
	
	public void setNomePadrao(StringBuilder padraoAereo) {
		this.nomePadrao = padraoAereo;
	}
	public StringBuilder getNomePadrao() {
		return nomePadrao;
	}
}
