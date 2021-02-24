package principal;

import dados.*;
import saida.Saida;
import validacao.Valida;

public class Principal {

	public static void main(String[] args) {
		Cidades cidades = new Cidades();
		Boolean continua = true;
		Integer opcao;

		do {
			continua = true;
			opcao = Valida.menu();

			switch (opcao) {
			case 0:
				String nome = Valida.strings("Insira o nome da cidade:", "Nome", 3);
				String sigla = Valida.strings("Insira a sigla do estado:", "Sigla", 0);
				Integer qtdHabInfec = Valida.inteiros(
						"Se essa cidade tiver habitantes contaminados pelo Covid-19, insira a quantidade por favor:",
						"Quantidade de Habitantes Contaminados");
				Integer qtdIntegerMortos;

				if (qtdHabInfec > 0) {
					qtdIntegerMortos = Valida.inteiros("Insira a quantidade de habitantes mortos pelo Covid-19",
							"Quantidade de Habitantes Contaminados Mortos");
				} else {
					qtdIntegerMortos = 0;
				}

				Cidade cidade = new Cidade(new StringBuilder(nome), new StringBuilder(sigla), qtdHabInfec,
						qtdIntegerMortos);

				if (Valida.validaCidade(cidades, cidade))
					cidades.setCidade(cidade);
				else
					Saida.errorDialog("Cidade não armezenada, pois já existe nos cadastros!");

				break;
			case 1:
				Integer qtd = Valida.inteiros(
						"Para finalizar sua pesquisa, insira por favor a quantidade mínima de Habitantes contaminadas, a ser considerada:",
						"Minimo de Habitantes Contaminados");
				cidades.mostraContaminadas(cidades.getCidades(), qtd);

			default:
				continua = false;
			}

		} while (continua);

	}

}
