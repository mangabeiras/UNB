package principal;

import java.util.Vector;

import dados.Habitantes;
import saida.Saida;
import validacao.Validacao;

public class Principal {

	public static final int MAXIMO_HABITANTES = 1000;

	public static void main(String[] args) {
		Vector variosHabitantes = new Vector();

		do {
			Habitantes habitante = new Habitantes();
			habitante.setHabitantes(habitante.getHabitantes());

			variosHabitantes.add(habitante);
		} while (Validacao.validaLimiteHabitantes(variosHabitantes) && Validacao.validaContinua());

		Saida.exibirResultados(variosHabitantes);
	}
}
