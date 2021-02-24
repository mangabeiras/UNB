package principal;

import java.util.Locale;
import java.util.Scanner;

public class SexoPeso {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		// DECLARACOES
		final int QTDPESSOAS = 2;
		String sexo = null;
		float peso = 0, pesoMax = 0, pesoMin = 0;
		float somaPesoMasc = 0;
		int qtdFem = 0;
		Scanner ler = new Scanner(System.in);

		// INSTRUCOES
		for (int i = 0; i < QTDPESSOAS; i++) {

			System.out.print("Digite o peso da " + (i + 1) + " pessoa: ");
			peso = leValidaPeso(peso, ler, i);

			System.out.println("Insira o sexo (masculino/feminino) da " + (i + 1) + " pessoa:");
			sexo = leValidaSexo(sexo, ler, i);

			pesoMin = menorPeso(peso, pesoMin, i);
			pesoMax = maiorPeso(peso, pesoMax, i);

			if (pesoMasc(sexo))
				somaPesoMasc += peso;
			else
				qtdFem++;

			limpaTela(15);
		}

		limpaTela(30);

		mostraResultado(pesoMin, pesoMax, QTDPESSOAS, qtdFem, somaPesoMasc);
	}

	// *********************************************METODOS********************************************
	// LIMPA TELA
	public static void limpaTela(int saltos) {
		for (int i = 0; i < saltos; i++)
			System.out.println();
	}

	// LEITURA E VALIDACAO DOS PESOS
	public static float leValidaPeso(float peso, Scanner ler, int i) {
		do {
			peso = ler.nextFloat();
			if (peso <= 0)
				System.out.println("Peso invalido! Insira um peso maior que 0");
		} while (peso <= 0);
		return peso;
	}

	// LEITURA E VALIDACAO DOS SEXOS
	public static String leValidaSexo(String sexo, Scanner ler, int i) {
		do {
			sexo = ler.next();
			if (!sexo.toLowerCase().equals("masculino") && !sexo.toLowerCase().equals("feminino"))
				System.out.print("Sexo invalido! Digite novamente (masculino/feminino): ");
		} while (!sexo.toLowerCase().equals("masculino") && !sexo.toLowerCase().equals("feminino"));
		return sexo;
	}

	// DEFINICAO MENOR PESO
	public static float menorPeso(float peso, float pesoMin, int i) {
		if (i == 0)
			pesoMin = peso;

		if (peso < pesoMin)
			pesoMin = peso;

		return pesoMin;
	}

	// DEFINICAO MAIOR PESO
	public static float maiorPeso(float peso, float pesoMax, int i) {
		if (i == 0)
			pesoMax = peso;

		if (peso > pesoMax)
			pesoMax = peso;

		return pesoMax;
	}

	// ANALISE SE O PESO CORRESPONDENTE E MASCULINO
	public static boolean pesoMasc(String sexo) {
		return ((sexo.toLowerCase().equals("masculino")) ? true : false);
	}

	// MOSTRA RESPOSTAS NO CONSOLE
	public static void mostraResultado(float pesoMin, float pesoMax, int QTDPESSOAS, int qtdFem, float somaPesoMasc) {
		System.out.println("O menor e o maior peso informados foram: " + pesoMin + " KG, " + pesoMax + " KG");
		System.out.println((qtdFem == QTDPESSOAS) ? "Media dos pesos dos homens é 0"
				: "A media dos pesos dos homens e: " + somaPesoMasc / (QTDPESSOAS - qtdFem));
		System.out.println("A quantidade de mulheres e: " + qtdFem);
	}
}
