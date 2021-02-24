package dados;

import java.util.ArrayList;

import interfaces.Pesquisas;

public class Pais implements Pesquisas{
	// ATRIBUTO
	ArrayList<Cidade> pais;
	
	// CONSTRUTOR
	public Pais(){
		this.pais = new ArrayList<Cidade>();
	}
	// GETTERS E SETTERS
	public ArrayList<Cidade> getPais() {
		return this.pais;
	}

	public void addCidade(Cidade cidade) {
		this.pais.add(cidade);
	}

	@Override
	public void mostraContaminados(int comparador) {
		for (Cidade cidade : getPais()) {
			if (cidade.getContaminados() >= comparador) {
				System.out.print(cidade);
			}
		}
	}

	@Override
	public boolean hasMaior(int comparador) {
		for (Cidade cidade : getPais()) {
			if (cidade.getContaminados() >= comparador)
				return true;
		}
		return false;
	}
}
