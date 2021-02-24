package dados;

import java.util.ArrayList;
import java.util.Collections;
// CLASSE DE COLECAO DE CIDADES
public class Pais {
	// ATRIBUTO
	private ArrayList<Cidade> pais;
	
	// CONSTRUTOR
	public Pais() {
		this.pais = new ArrayList<Cidade>();
	}
	
	public void addCidade(Cidade cidade) {
		this.pais.add(cidade);
	}
	
	public ArrayList<Cidade> getPais(){
		return this.pais;
	}
	// RETORNA O PAIS EM ORDEM DE DDD
	public ArrayList<Cidade> getPaisCrescente(){
		ArrayList<Cidade> crescente = new ArrayList<Cidade>(getPais());
		Collections.sort(crescente);		
		return crescente;
	}
}
