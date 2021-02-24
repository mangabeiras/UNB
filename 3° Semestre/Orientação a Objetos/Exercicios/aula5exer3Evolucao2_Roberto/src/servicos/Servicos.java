package servicos;

import dados.Populacao;
import saida.Saida;

public class Servicos {
	
	public static void calculaDados(Populacao pessoa) {
		final int SALARIO_COMPARA = 300;
		int menorIdade = 0, qtdSalariosMaior = 0;;
		float maiorSalario = 0, mediaFilhos = 0, mediaSalarios = 0, mediaHomensCompara = 0;
		
		for(int i = 0; i<pessoa.getHabitantes().size(); i++) {
			if (i == 0) {
				menorIdade = pessoa.getHabitantes().get(i).getIdade();
				maiorSalario = pessoa.getHabitantes().get(i).getSalario();
			}
			if(pessoa.getHabitantes().get(i).getIdade() < menorIdade)
				menorIdade = pessoa.getHabitantes().get(i).getIdade();
			if (pessoa.getHabitantes().get(i).getIdade() > maiorSalario)
				maiorSalario = pessoa.getHabitantes().get(i).getSalario();
			if (pessoa.getHabitantes().get(i).getSalario() > SALARIO_COMPARA)
				++mediaHomensCompara;
		
			mediaFilhos += pessoa.getHabitantes().get(i).getNumeroFilhos();
			mediaSalarios += pessoa.getHabitantes().get(i).getSalario();
		}
		
		for(int i = 0; i<pessoa.getHabitantes().size(); i++) {
			if (pessoa.getHabitantes().get(i).getSalario() > mediaSalarios)
				++qtdSalariosMaior;
		}
		
		Saida.mostraResultado(menorIdade, maiorSalario, mediaFilhos/pessoa.getHabitantes().size(), mediaSalarios/pessoa.getHabitantes().size(), mediaHomensCompara/pessoa.getHabitantes().size(), SALARIO_COMPARA, qtdSalariosMaior);
	}

}
