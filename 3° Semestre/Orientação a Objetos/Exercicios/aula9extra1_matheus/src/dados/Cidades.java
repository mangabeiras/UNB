package dados;

import java.util.ArrayList;

import interfaces.Pesquisas;

public class Cidades implements Pesquisas {
	private ArrayList<Cidade> cidades;

	public Cidades() {
		this.cidades = new ArrayList<Cidade>();
	}

	public ArrayList<Cidade> getCidades() {
		return cidades;
	}

	public void setCidade(Cidade cidade) {
		this.cidades.add(cidade);
	}


	public void mostraContaminadas(ArrayList<Cidade> cidades, Integer minimo) {
		for (Cidade c : cidades) {
			if (c.getHabContaminados() >= minimo) {
				System.out.println(c);
			}
		}

	}

}
