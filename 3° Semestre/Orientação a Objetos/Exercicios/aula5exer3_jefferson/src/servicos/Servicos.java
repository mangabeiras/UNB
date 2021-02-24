package servicos;

import java.util.Vector;

import dados.Habitantes;

public class Servicos {
	public final static float SALARIO_ANALISADO = 300F;

	public static int calculoMenorIdade(Vector variosHabitantes) {
		int menorIdade = 0;

		for (int aux = 0; aux < variosHabitantes.size(); aux++) {
			Habitantes habitantes = (Habitantes) variosHabitantes.get(aux);

			if (aux == 0) {
				menorIdade = habitantes.getHabitantes().getIdade();
			} else if (habitantes.getHabitantes().getIdade() < menorIdade) {
				menorIdade = habitantes.getHabitantes().getIdade();
			}

		}

		return menorIdade;
	}

	public static float calculoMaiorSalarioRegistrado(Vector variosHabitantes) {
		float maiorSalarioRegistrado = 0F;

		for (int aux = 0; aux < variosHabitantes.size(); aux++) {
			Habitantes habitantes = (Habitantes) variosHabitantes.get(aux);

			if (aux == 0) {
				maiorSalarioRegistrado = habitantes.getHabitantes().getSalario();
			} else if (habitantes.getHabitantes().getSalario() > maiorSalarioRegistrado) {
				maiorSalarioRegistrado = habitantes.getHabitantes().getSalario();
			}

		}

		return maiorSalarioRegistrado;
	}

	public static float calculoMediaNumeroDeFilhosCadastrados(Vector variosHabitantes) {
		int somaNumeroDeFilhosCadastrados = 0;

		for (int aux = 0; aux < variosHabitantes.size(); aux++) {
			Habitantes habitantes = (Habitantes) variosHabitantes.get(aux);

			somaNumeroDeFilhosCadastrados += habitantes.getHabitantes().getNumeroDeFilhos();
		}

		return (float) somaNumeroDeFilhosCadastrados / variosHabitantes.size();
	}

	public static float calculoMediaDoSalarioDasPessoasRegistradas(Vector variosHabitantes) {
		float somaSalarioHabitantesRegistrados = 0F;

		for (int aux = 0; aux < variosHabitantes.size(); aux++) {
			Habitantes habitantes = (Habitantes) variosHabitantes.get(aux);

			somaSalarioHabitantesRegistrados += habitantes.getHabitantes().getSalario();
		}

		return somaSalarioHabitantesRegistrados / variosHabitantes.size();
	}

	public static float calculoMediaHomensComSalarioSuperior(Vector variosHabitantes) {
		int quantidadeDeHomensComSalarioMaior = 0;

		for (int aux = 0; aux < variosHabitantes.size(); aux++) {
			Habitantes habitantes = (Habitantes) variosHabitantes.get(aux);

			if (habitantes.getHabitantes().getSalario() > SALARIO_ANALISADO
					&& habitantes.getHabitantes().getSexo().equals("MASCULINO")) {
				quantidadeDeHomensComSalarioMaior++;
			}
		}

		return (float) quantidadeDeHomensComSalarioMaior / variosHabitantes.size();
	}

	public static int calculoQuantidadeDePessoasComSalarioMaiorQueMedia(Vector variosHabitantes) {
		int quantidadeDePessoasComSalarioMaiorQueMedia = 0;

		for (int aux = 0; aux < variosHabitantes.size(); aux++) {
			Habitantes habitantes = (Habitantes) variosHabitantes.get(aux);

			if (habitantes.getHabitantes()
					.getSalario() > calculoMediaDoSalarioDasPessoasRegistradas(variosHabitantes)) {
				quantidadeDePessoasComSalarioMaiorQueMedia++;
			}

		}

		return quantidadeDePessoasComSalarioMaiorQueMedia;
	}

}
