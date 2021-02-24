package dados;

import java.util.ArrayList;

public class Galeria {
	private ArrayList<Pintor> listaPintores;
	
	public Galeria () {
		this.listaPintores = new ArrayList<Pintor>();
	}

	public ArrayList<Pintor> getListaPintores () {
		return listaPintores;
	}

	public Pintor getListaPintores (int codigo) {
		int i = 0;
		while (listaPintores.get(i++).getCodigoPessoal() != codigo) {}
		return listaPintores.get(i - 1);
	}
	
	public void setPintor (Pintor pintor) {
		this.listaPintores.add(pintor);
	}
	
	public boolean isAlgumQuadroRegistrado () {
		for (Pintor pintor : listaPintores) {
			if (pintor.isPossuiQuadros()) {
				return true;
			}
		}
		return false;
	}
}
