package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// CLASSE DE TIME
public class Time {
	// ATRIBUTOS
	private String nome;
	private ArrayList<Integer> anosCampeao;
	
	public Time(String nome, ArrayList<Integer> anos) {
		setNome(nome);
		anosCampeao = anos;
	}
	
	public List<Integer> getAnos(){
		return this.anosCampeao;
	}

	public String getNome() {
		return this.nome.toString();
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Integer> getAnosOrdem(){ // OBTEM LISTA DOS ANOS EM ORDEM
		List<Integer> anosOrdem = new ArrayList<Integer>(this.anosCampeao);
		anosOrdem.sort(null);
		Collections.reverse(anosOrdem);
		return anosOrdem;
	}
	
	public String toString() {
		String anos = "";
		
		if (this.anosCampeao.isEmpty()) 
			anos = "Ainda nao foi Campeao";
		else {
			for (Integer ano : getAnosOrdem()) 
				anos += ano +"\t";
		}
		return String.format("%-25s%-10s\n", this.nome.toUpperCase(), anos);
	}
	
	public boolean equals(Object obj) {
		Time novo = (Time) obj;
		return this.nome.toLowerCase().equals(novo.nome.toLowerCase());
	}	

}
