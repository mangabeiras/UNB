package servicos;

import dados.Grupo;

public class Servicos {
	public static int somaSemana(Grupo grupo, int aux) {
		int soma = 0;
		for (int i = 0; i < grupo.getSemana(); i++) {
			soma += grupo.getVenda(aux, i);
		}
		return soma;
	}

	public static int somaMes(Grupo grupo, int qtdVendedores) {
		int soma = 0;
		for (int aux = 0; aux < qtdVendedores; aux++) {
			for (int i = 0; i < grupo.getSemana(); i++)
				soma += grupo.getVenda(aux, i);
		}
		return soma;
	}
}
