package dados;

import java.util.ArrayList;

import interfaces.Pesquisas;

public class Mundo implements Pesquisas {
	private ArrayList<Pais> paises;

	public Mundo() {
		this.paises = new ArrayList<Pais>();
	}

	public ArrayList<Pais> getPaises() {
		return this.paises;
	}

	public void addPais(Pais pais) {
		this.paises.add(pais);
	}

	// -----------------------------------------------------------------------------------

	public boolean contains(StringBuilder cidade, StringBuilder estado) {
		for (Pais pais : this.getPaises()) {

			if (pais.equals(cidade, estado))
				return true;
		}
		return false;
	}

	// METODOS DA INTERFACE
	public void mostraContaminadas(int quantidade) {
		for (Pais pais : getPaises()) {
			if (pais.getContaminados() >= quantidade) {
				System.out.print(pais);
			}
		}
	}

	public boolean isContaminadosMaior(int quantidade) {
		for (Pais pais : getPaises()) {
			if (pais.getContaminados() >= quantidade) {
				return true;
			}
		}
		return false;
	}
}