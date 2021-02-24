package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
// COLECAO DE TIME
public class Campeonato {
	// ATRIBUTOS
	private List<Time> campeonato;
	
	public Campeonato () {
		this.campeonato = new ArrayList<Time>();
	}

	public List<Time> getCampeonato() {
		return this.campeonato;
	}

	public void addTime(Time time) {
		this.campeonato.add(time);
	}
	
	public List<Time> getCampeonatoOrdem(){		// OBTEM TIMES EM ORDEM ALFABETICA
		ArrayList<Time> campeonatoOrdem = new ArrayList<Time>(this.campeonato);
		Collections.sort(campeonatoOrdem, new OrdenaCampeonato());
		return campeonatoOrdem;
	}
	// CLASSE INTERNA QUE POSSIBILITA O USO DO COMPARATOR
	private class OrdenaCampeonato implements Comparator<Time>{
		@Override
		public int compare(Time time1, Time time2) {
			return time1.getNome().compareTo(time2.getNome()); 
		}
	}
}	
