package principal;

import java.util.Scanner;
import java.text.DecimalFormat;

public class PesoSexo {

	public static void main(String[] args) {
		// DECLARACOES
		final int QTDPESSOAS = 3;
		final float PESOMIN = 0;
		String[] sexo = new String[QTDPESSOAS];
		float[] peso = new float[QTDPESSOAS];
		float menorPeso, maiorPeso = 0, mediaHomens = 0;
		int qtdHomens = 0, qtdMulheres = 0;
		''
		// USO DAS CLASSES IMPORTADAS
		Scanner ler = new Scanner(System.in);
		DecimalFormat mascara = new DecimalFormat("#0.00");

		// INSTRUCOES
		for (int i = 0; i < QTDPESSOAS; i++) {
			// -------------------------------------SEXO----------------------------------------------

			System.out.println("Por favor, insira o sexo da " + (i + 1) + " pessoa:");

			// LEITURA
			do {
				sexo[i] = ler.next().toUpperCase();
				if (!(sexo[i].equals("MASCULINO") || sexo[i].equals("FEMININO")))
					System.out.println(
							"Invalido! Digite apenas masculino ou feminino para o sexo da " + (i + 1) + " pessoa:");
			} while (!validaSexo(sexo[i])); // VALIDACAO DO SEXO
			sexo.eq

			// -------------------------------------PESO------------------------------------------------

			System.out.println("Agora, insira o peso da " + (i + 1) + " pessoa");

			// LEITURA
			do {
				peso[i] = ler.nextFloat();
				if (peso[i] <= PESOMIN)
					System.out.println("Valor invalido! Insira um peso maior que " + mascara.format(PESOMIN) + ":");
			} while (!validaPeso(peso[i], PESOMIN)); // VALIDACAO DO PESO

			// LIMPAR TELA
			limpaTela();
		}

		// DEFINICAO DO MENOR E MAIOR PESO
		menorPeso = peso[0];
		for (int i = 0; i < QTDPESSOAS; i++) {
			if (peso[i] > maiorPeso)
				maiorPeso = peso[i];
			if (peso[i] < menorPeso)
				menorPeso = peso[i];
		}

		// MEDIA DOS PESOS DOS HOMENS E QUANTIDADE DE MULHERES
		for (int i = 0; i < QTDPESSOAS; i++) {
			if (sexo[i].equals("MASCULINO")) {
				qtdHomens++;
				mediaHomens += peso[i];
			} else
				qtdMulheres++;
		}
		mediaHomens = mediaHomens / qtdHomens;


		// PRINT DO MAIOR E MENOR PESO
		System.out.println("O menor e maior peso foram, respectivamente:" + mascara.format(menorPeso) + " e "
				+ mascara.format(maiorPeso) + ";");

		// PRINT DA MEDIA DOS PESOS DOS HOMENS
		System.out.println(
				(qtdHomens == 0) ? "Não houve participacao de homens na analise, portanto nao ha media de peso deles;"
						: "A media dos pesos dos homens e " + mascara.format(mediaHomens));

		// PRINT DA QUANTIDADE DE MULHERES
		System.out.println(+qtdMulheres + " mulheres participaram desta analise.");
	}
	// *****************************************METODOS**************************************************************

	// METODO QUE LIMPA A TELA
	public static void limpaTela() {
		for (int i = 0; i < 30; i++)
			System.out.println();
	}

	// METODO QUE VALIDA O SEXO
	public static boolean validaSexo(String sexo) {
		return ((sexo.equals("MASCULINO") || sexo.equals("FEMININO")) ? true : false);
	}

	// METODO QUE VALIDA O PESO (MAIOR QUE ZERO)
	public static boolean validaPeso(float peso, float PESOMIN) {
		return ((peso <= PESOMIN) ? false : true);
	}
}
