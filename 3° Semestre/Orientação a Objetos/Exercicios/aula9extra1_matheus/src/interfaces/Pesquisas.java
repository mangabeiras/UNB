package interfaces;

import java.util.ArrayList;

import dados.Cidade;

public interface Pesquisas {
	public abstract void mostraContaminadas(ArrayList<Cidade> cidades, Integer minimo);
}
