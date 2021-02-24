package dados;

import java.util.ArrayList;

public class Conjunto {
	ArrayList<Ano> conjunto;
	
	// CONSTRUTOR
	public Conjunto(int ano, String evento, String presidente){
		conjunto = new ArrayList<Ano>();
		setAno(new Ano(ano, evento, presidente));
	}
	// SETTERS E GETTERS
	public void setAno(Ano ano) {
		this.conjunto.add(ano);
	}
	
	public ArrayList<Ano> getConjunto(){
		return this.conjunto;
	}
}
