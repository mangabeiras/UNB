package saida;

import java.text.DecimalFormat;

public class Saida {
	public static void mostraResultado(int menorIdade, float maiorSalario, float mediaFilhos, float mediaSalarios,
			float mediaHomensCompara, final float SALARIO, int qtdSalarios) {

		DecimalFormat centesimo = new DecimalFormat("0.00");

		limpaTela(50);
		System.out.println("Menor idade registrada:" + menorIdade);
		System.out.println("Maior salario registrado:" + centesimo.format(maiorSalario));
		System.out.println("Media do número de filhos:" + centesimo.format(mediaFilhos));
		System.out.println("Media do salario das pessoas registradas: "+ centesimo.format(mediaSalarios));
		System.out.println("Media dos homens com salario superior a "+SALARIO+": " + centesimo.format(mediaHomensCompara));
		System.out.println("Quantidade de pessoas que tem salario maior que a media das pessoas registradas: "+qtdSalarios);
	}

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}
}
