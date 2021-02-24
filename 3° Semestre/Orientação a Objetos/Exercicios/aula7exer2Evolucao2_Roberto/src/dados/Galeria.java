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

	public void addPintor (Pintor pintor) {
		this.listaPintores.add(pintor);
	}
	public int getQuantidadeQuadros() {
		int total = 0;
		for (Pintor pintor : getListaPintores()) {
			total += pintor.getQuadros().size();
		}
		return total;
	}

}
