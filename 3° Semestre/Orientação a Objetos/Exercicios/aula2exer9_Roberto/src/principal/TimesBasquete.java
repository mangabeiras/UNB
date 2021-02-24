package principal;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TimesBasquete {

	public static void main(String[] args) {
		// DECLARACOES
		final int QTD_EQUIPES = 5, QTD_JOGADORES = 10, IDADE_MIN = 0, IDADE_MAX = 120;
		final float ALTURA_MIN = 0.00F, ALTURA_MAX = 7.00F; // LIMITE HUMANO DE ALTURA AINDA EXAGERADO
		int idade[][] = new int[QTD_EQUIPES][QTD_JOGADORES];
		float altura[][] = new float[QTD_EQUIPES][QTD_JOGADORES];
		Scanner ler = new Scanner(System.in);
		DecimalFormat mascara = new DecimalFormat("0.00");

		// INSTRUCOES
		for (int i = 0; i < QTD_EQUIPES; i++) {
			for (int aux = 0; aux < QTD_JOGADORES; aux++) {
				// INSTRUCOES PARA IDADE
				System.out.println("Insira a idade do jogador " + (aux + 1) + " do time " + (i + 1) + ":");
				do {
					idade[i][aux] = ler.nextInt();
					if (!validaIdade(idade[i][aux], IDADE_MIN, IDADE_MAX))
						System.out.println("Valor invalido! A idade minima para estar em um time e " + IDADE_MIN
								+ ". Insira novamente:");

					// VALIDACAO DA IDADE
				} while (!validaIdade(idade[i][aux], IDADE_MIN, IDADE_MAX));

				// INSTRUCOES PARA ALTURA
				System.out.println("Agora, insira a altura do jogador " + (aux + 1) + " do time " + (i + 1) + ":");
				do {
					altura[i][aux] = ler.nextFloat();
					if (!validaAltura(altura[i][aux], ALTURA_MIN, ALTURA_MAX))
						System.out.println("Altura Invalida. Insira uma altura maior que " + mascara.format(ALTURA_MIN)
								+ " e menor que " + mascara.format(ALTURA_MAX));

					// VALIDACAO DA ALTURA
				} while (!validaAltura(altura[i][aux], ALTURA_MIN, ALTURA_MAX));

				// LIMPAR TELA APOS INSERIR IDADE E ALTURA
				limpaTela(15);
			}
		}
		// DESCOBRIR JOGADORES COM IDADE MAIOR QUE 15 ANOS E MOSTRAR RESULTADO AO
		// USUARIO
		quantidadeJogadoresPorIdade(15, idade, QTD_EQUIPES, QTD_JOGADORES, mascara);

		// PORCENTAGEM DE JOGADORES MENORES QUE 1.50 METROS E MOSTRAR RESULTADO AO
		// USUARIO
		porcentagemJogadoresPorAltura(1.50F, altura, QTD_EQUIPES, QTD_JOGADORES, mascara);
	}

	// ************************************METODOS******************************************************
	// METODO QUE LIMPA A TELA
	public static void limpaTela(int saltos) {
		for (int i = 0; i < saltos; i++)
			System.out.println();
	}

	// METODO QUE VALIDA A IDADE DEPENDENDO DAS CONSTANTES MINIMAS E MAXIMAS
	public static boolean validaIdade(int idade, int IDADE_MIN, int IDADE_MAX) {
		return ((idade < IDADE_MIN || idade > IDADE_MAX) ? false : true);
	}

	// METODO QUE VALIDA A ALTURA DEPENDENDO DAS CONSTANTES MINIMAS E MAXIMAS
	public static boolean validaAltura(float altura, float ALTURA_MIN, float ALTURA_MAX) {
		return ((altura < ALTURA_MIN || altura > ALTURA_MAX) ? false : true);
	}

	// METODO QUE DESCOBRE A QUANTIDADE DE JOGADORES MAIORES QUE 15 ANOS, A MEDIA
	// DESSAS IDADES EM CADA EQUIPE E PRINTA O RESULTADO
	public static void quantidadeJogadoresPorIdade(int idadeComparacao, int idade[][], int QTD_EQUIPES,
			int QTD_JOGADORES, DecimalFormat mascara) {
		// DECLARACOES
		int numJogadoresEquipe = 0, somaIdadesEquipe = 0, numJogadoresTotal = 0;
		float mediaIdadesEquipe[] = new float[QTD_EQUIPES];

		// LEVANTAMENTO DOS DADOS NECESSARIOS
		for (int i = 0; i < QTD_EQUIPES; i++) {
			for (int aux = 0; aux < QTD_JOGADORES; aux++) {
				if (idade[i][aux] > idadeComparacao) {
					numJogadoresEquipe++;
					numJogadoresTotal++;
					somaIdadesEquipe += idade[i][aux];
				}
			}
			if (numJogadoresEquipe != 0)
				mediaIdadesEquipe[i] = somaIdadesEquipe / numJogadoresEquipe;
			numJogadoresEquipe = 0;
			somaIdadesEquipe = 0;
		}

		// EVITAR DIVISAO POR ZERO
		if (numJogadoresTotal == 0)
			System.out.println("Nao existem jogadores maiores que " + idadeComparacao + " anos nestas equipes.");

		// RESPOSTA AO USUARIO DO NUM DE JOGADORES MAIORE QUE 15 EM TODAS AS EQUIPES
		else
			System.out.println("Numero de jogadores maiores do que " + idadeComparacao + " anos: " + numJogadoresTotal);

		// RESPOSTA AO USUARIO DAS MEDIAS DAS IDADES MAIORES QUE 15 NAS EQUIPES
		for (int i = 0; i < QTD_EQUIPES; i++) {

			// CASO NAO EXISTA JOGADORES MAIORES QUE 15 ANOS NAS EQUIPES
			if (mediaIdadesEquipe[i] == 0)
				System.out.println(
						"Nao existe jogador maior que " + idadeComparacao + " anos na equipe " + (i + 1) + ".");

			// CASO TENHA
			else
				System.out.println("A media da equipe " + (i + 1) + " de idades maiores que " + idadeComparacao + " e: "
						+ mascara.format(mediaIdadesEquipe[i]));
		}
	}

	// METODO QUE CALCULA A PORCENTAGEM DE JOGADORES MENORES QUE 1.50 ENTRE TODAS AS
	// EQUIPES
	public static void porcentagemJogadoresPorAltura(float alturaComparacao, float altura[][], int QTD_EQUIPES,
			int QTD_JOGADORES, DecimalFormat mascara) {

		// DECLARACOES
		int numJogadoresTotal = 0;
		float porcentagemEntreEquipes;

		// LEVANTAMENTO DOS DADOS NECESSARIOS
		for (int i = 0; i < QTD_EQUIPES; i++) {
			for (int aux = 0; aux < QTD_JOGADORES; aux++) {
				if (altura[i][aux] < alturaComparacao) {
					numJogadoresTotal++;
				}
			}
		}

		// CALCULO
		porcentagemEntreEquipes = (100 * numJogadoresTotal) / (QTD_EQUIPES * QTD_JOGADORES);

		// RESPOSTA AO USUARIO
		System.out.println("A porcentagem de jogadores menores que " + mascara.format(alturaComparacao) + " metros e: "
				+ mascara.format(porcentagemEntreEquipes) + " %");
	}
}