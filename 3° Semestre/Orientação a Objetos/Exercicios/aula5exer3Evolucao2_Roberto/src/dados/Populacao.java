package dados;

import java.util.Vector;

public class Populacao {
	
	Vector<Habitante> populacao;

	public Populacao(char sexo, int idade, float salario , int filhos) {
		 this.populacao = new Vector<Habitante>();
		 setHabitante(new Habitante( sexo, idade, salario, filhos));
	}

	public void setHabitante(Habitante habitante) {
		this.populacao.add(habitante);
	}

	public Vector<Habitante> getHabitantes() {
		return this.populacao;
	}
}