package principal;

import java.text.DecimalFormat;
import java.util.Scanner;

public class OrdenaPeso {
	static final float PESOMINIMO = 5;
	static final int MAX = 3;

	public static void main(String[] args) {
		// DECLARACOES
		float[] peso = new float[MAX];
		DecimalFormat mascara = new DecimalFormat("#0.00");
		Scanner ler = new Scanner(System.in);

		// INSTRUCOES
		for (int contador = 0; contador < MAX; contador++) {
			System.out.println("Digite o peso (em quilogramas) do " + (contador + 1) + " elefante:");
			do {
				peso[contador] = ler.nextFloat();
				if (peso[contador] < PESOMINIMO)
					System.out.println(
							"Peso Invalido! Informe peso maior ou igual a " + mascara.format(PESOMINIMO) + " Kg.");
				// FUNCAO QUE VERIFICA A VALIDADE DO PESO INSERIDO
			} while (validaPeso(peso[contador]) == false);

		}

		System.out.println("\n\n Pesos Gravados \n\n");
		// LIMPAR TELA
		limpaTela();

		ordenaPesos(peso);
		// COLOCAR OS PESOS EM ORDEM

		// RESPOSTA AO USUARIO
		for (int aux = 0; aux < MAX; aux++) {
			System.out.println("Peso [" + (aux + 1) + "] = " + mascara.format(peso[aux]) + " Kg");
		}
	}

	// *****************************************FUNCOES********************************************************
	// FUNCAO QUE LIMPA O CONSOLE
	public static void limpaTela() {
		for (int i = 0; i < 30; i++)
			System.out.println();
	}

	// FUNCAO QUE VALIDA O PESO
	public static boolean validaPeso(float peso) {
		if (peso < PESOMINIMO)
			return false;
		else
			return true;
	}

	// FUNCAO QUE COLOCA EM ORDEM OS PESOS
	public static void ordenaPesos(float[] peso) {
		for (int i = 0; i < MAX; i++) {
			for (int a = (i + 1); a < MAX; a++) {
				float auxiliar;
				if (peso[a] < peso[i]) {
					auxiliar = peso[i];
					peso[i] = peso[a];
					peso[a] = auxiliar;
				}
			}
		}
	}
}
