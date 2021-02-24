package servicos;

import dados.Populacao;
import visao.Visao;

public class Servicos {
	
	public static void calculaDados(Populacao pessoa) {
		final int SALARIO_COMPARA = 300;
		int menorIdade = 0, qtdSalariosMaior = 0;;
		float maiorSalario = 0, mediaFilhos = 0, mediaSalarios = 0, mediaHomensCompara = 0;
		
		for(int i = 0; i<pessoa.getTamanho(); i++) {
			if (i == 0) {
				menorIdade = pessoa.getHabitante(i).getIdade();
				maiorSalario = pessoa.getHabitante(i).getSalario();
			}
			if(pessoa.getHabitante(i).getIdade() < menorIdade)
				menorIdade = pessoa.getHabitante(i).getIdade();
			if (pessoa.getHabitante(i).getIdade() > maiorSalario)
				maiorSalario = pessoa.getHabitante(i).getSalario();
			if (pessoa.getHabitante(i).getSalario() > SALARIO_COMPARA)
				++mediaHomensCompara;
		
			mediaFilhos += pessoa.getHabitante(i).getFilhos();
			mediaSalarios += pessoa.getHabitante(i).getSalario();
		}
		mediaFilhos /= pessoa.getTamanho();
		mediaSalarios /= pessoa.getTamanho();
		mediaHomensCompara /= pessoa.getTamanho();
		
		for(int i = 0; i<pessoa.getTamanho(); i++) {
			if (pessoa.getHabitante(i).getSalario() > mediaSalarios)
				++qtdSalariosMaior;
		}
		
		Visao.mostraResultado(menorIdade, maiorSalario, mediaFilhos, mediaSalarios, mediaHomensCompara, SALARIO_COMPARA, qtdSalariosMaior);
	}

}
