package dados;

import java.util.ArrayList;

public class Zoologico {
	ArrayList<Mamifero> zoologico;
	
	public Zoologico() {
		zoologico = new ArrayList<Mamifero>();
	}
	
	public void addMamifero(Mamifero mamifero) {
		this.zoologico.add(mamifero);
	}
	
	public ArrayList<Mamifero> getZoologico(){
		return this.zoologico;
	}
}
