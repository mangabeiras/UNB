package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
// CLASSE DE TIME
public class Time {
	// ATRIBUTOS
	private StringBuilder nome;
	private ArrayList<Integer> anos_Campeao;
	
	// METODOS
	public Time(StringBuilder nome) {
		setNome(nome);
		anos_Campeao = new ArrayList<Integer>();
	}
	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}
	
	public void addAno(int ano) {
		this.anos_Campeao.add(ano);
	}
	
	public ArrayList<Integer> getAnos(){
		return this.anos_Campeao;
	}
	// OBTEM ARRAY COM ANOS EM ORDEM CRESCENTE
	public ArrayList<Integer> getAnosOrdem(){
		ArrayList<Integer> ordem = new ArrayList<>();
		ordem = this.anos_Campeao;
		Collections.sort(ordem, new OrdemTime());
		return this.anos_Campeao;
	}
	
	public StringBuilder getNome() {
		return this.nome;
	}
	// CLASSE INTERNA QUE IMPLEMENTE COMPARATOR PARA ORDENAR O ARRAY
	private class OrdemTime implements Comparator<Integer>{
		@Override
		public int compare(Integer ano1, Integer ano2) {
			if (ano1 < ano2)
				return -1;
			else if (ano1 > ano2)
				return 1;
			else
				return 0;
		}
	} 
}
