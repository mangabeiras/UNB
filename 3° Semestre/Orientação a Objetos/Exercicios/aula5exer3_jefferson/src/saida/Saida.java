package saida;

import java.text.DecimalFormat;
import java.util.Vector;

import servicos.Servicos;

public class Saida {

	public static int habitanteAtual = 1;

	public static void exibirHabitanteSendoRegistrado() {
		System.out.println("Registro do " + (habitanteAtual++) + "º habitante:");
	}

	public static void solicitarSalario() {
		System.out.println("Informe o valor do salario (em reais):");
	}

	public static void excecaoFloat() {
		System.out.println("Entrada invalida. Digite apenas um valor real.");
		limpaTela(1);
	}

	public static void salarioInvalido() {
		System.out.println("Salario invalido. Valores negativos nao sao permitidos.");
		limpaTela(1);
	}

	public static void solicitarIdade() {
		System.out.println("Informe a idade (em anos):");
	}

	public static void excecaoInt() {
		System.out.println("Entrada invalida. Informe apenas um valor inteiro.");
		limpaTela(1);
	}

	public static void solicitarSexo() {
		System.out.println("Informe o sexo (masculino ou feminino):");
	}

	public static void sexoInvalido() {
		limpaTela(1);
		System.out.println("Sexo invalido. Informe apenas 'masculino' ou 'feminino':");
	}

	public static void idadeInvalida() {
		System.out.println("Idade invalida. Informe uma idade que condiz com a realidade:");
		limpaTela(1);
	}

	public static void solicitarQuantidadeDeFilhos() {
		System.out.println("Informe a quantidade de filhos:");
	}

	public static void quantidadeDeFilhosInvalida() {
		System.out.println("Quantidade de filhos invalida. Informe uma quantidade que condiz com a realidade:");
		limpaTela(1);
	}

	public static void verificarContinuacao() {
		limpaTela(2);
		System.out.println("Deseja cadastrar outro habitante? Se sim, digite 'S'. Se nao, digite 'N'.");
	}

	public static void digiteUmCaractereValido() {
		limpaTela(1);
		System.out.println("Entrada invalida. Digite apenas 'S' ou 'N'.");
	}

	public static void exibirMenorIdade(Vector variosHabitantes) {
		System.out.println("A menor idade entre os entrevistados foi de: "
				+ Servicos.calculoMenorIdade(variosHabitantes) + " ano(s).");
	}

	public static void exibirMaiorSalarioRegistrado(Vector variosHabitantes) {
		DecimalFormat mascara = new DecimalFormat("0.00");

		System.out.println("O maior salario registrado foi de: R$"
				+ mascara.format(Servicos.calculoMaiorSalarioRegistrado(variosHabitantes)));
	}

	public static void exibirMediaNumeroDeFilhosCadastrados(Vector variosHabitantes) {
		DecimalFormat mascara = new DecimalFormat("0.00");

		System.out.println("A media do numero de filhos entre todos os habitantes foi de: "
				+ mascara.format(Servicos.calculoMediaNumeroDeFilhosCadastrados(variosHabitantes)) + " filho(s).");
	}

	public static void exibirMediaDoSalarioDasPessoasRegistradas(Vector variosHabitantes) {
		DecimalFormat mascara = new DecimalFormat("0.00");

		System.out.println("A media do salario dos habitantes registrados foi de: R$"
				+ mascara.format(Servicos.calculoMediaDoSalarioDasPessoasRegistradas(variosHabitantes)));
	}

	public static void exibirMediaHomensComSalarioSuperior(Vector variosHabitantes) {
		DecimalFormat mascara = new DecimalFormat("0.00");

		System.out.println("A media dos homens com salario superior a R$" + mascara.format(Servicos.SALARIO_ANALISADO)
				+ " foi de: " + mascara.format(Servicos.calculoMediaHomensComSalarioSuperior(variosHabitantes))
				+ " homem(ns).");
	}

	public static void exibirQuantidadeDePessoasComSalarioMaiorQueMedia(Vector variosHabitantes) {
		System.out.println(
				"A quantidade de pessoas com salario maior que a media de todas as pessoas registradas foi de: "
						+ Servicos.calculoQuantidadeDePessoasComSalarioMaiorQueMedia(variosHabitantes) + " pessoa(s).");
	}

	public static void exibirResultados(Vector variosHabitantes) {
		Saida.limpaTela(40);

		exibirMenorIdade(variosHabitantes);
		exibirMaiorSalarioRegistrado(variosHabitantes);
		exibirMediaNumeroDeFilhosCadastrados(variosHabitantes);
		exibirMediaDoSalarioDasPessoasRegistradas(variosHabitantes);
		exibirMediaHomensComSalarioSuperior(variosHabitantes);
		exibirQuantidadeDePessoasComSalarioMaiorQueMedia(variosHabitantes);
	}

	public static void limpaTela(int linhasPuladas) {
		for (int aux = 0; aux < linhasPuladas; aux++)
			System.out.println();
	}

}
