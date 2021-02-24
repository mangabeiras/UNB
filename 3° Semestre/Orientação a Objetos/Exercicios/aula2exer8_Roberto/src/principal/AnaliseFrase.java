package principal;

import java.util.Scanner;

public class AnaliseFrase {

	public static void main(String[] args) {
		// DECLARACOES
		String frase;
		int vogais[] = new int[6];
		Scanner ler = new Scanner(System.in);

		// INSTRUCOES
		do {
			System.out.println("Insira uma frase, com dados, para que ela seja analisada: ");
			do {
				frase = ler.nextLine().toUpperCase();
				if (!analisaFrase(frase))
					System.out.println("Frase invalida! Insira uma frase que contenha dados:");

				// VALIDACAO DA FRASE
			} while (!analisaFrase(frase));

			// REALIZAR CONTAGEM E REGISTRO DA QUANTIDADE DE CADA VOGAL
			contaCadaVogal(frase, vogais);
			limpaTela(60);

			// EXIBIR NO CONSOLE A QUANTIDADE DE CADA VOGAL E O TOTAL DELAS
			exibirVogais(vogais);

			// EXIBIR NO CONSOLE O TAMANHO DA FRASE DIGITADA
			System.out.println("A frase prossui " + frase.length() + " caracteres (com espaco).");
			System.out.println("A frase possui " + frase.replace(" ", "").length() + " caracteres (sem espaco).");

			// ANALISE DA RESPOSTA DO USUARIO (CADASTRAR OUTRA FRASE OU NAO)
		} while (analisaUsuario(vogais));
	}

	// ****************************************METODOS**************************************************
	// METODO QUE LIMPA A TELA
	public static void limpaTela(int saltos) {
		for (int i = 0; i < saltos; i++)
			System.out.println();
	}

	// METODO QUE CONTA A QUANTIDADE DE CADA TIPO DE VOGAL E O TOTAL DELAS
	// 'vogais[0]' CORRESPONDE A VOGAL 'A'; 'vogais[1]' A VOGAL 'E' E ASSIM
	// SUCESSIVAMENTE
	// 'vogais[5]' CORRESPONDE AO TOTAL DE VOGAIS
	public static void contaCadaVogal(String frase, int vogais[]) {
		for (int i = 0; i < frase.length(); i++) {
			switch (frase.charAt(i)) {
			case 'A': {
				vogais[0]++;
				break;
			}
			case 'E': {
				vogais[1]++;
				break;
			}
			case 'I': {
				vogais[2]++;
				break;
			}
			case 'O': {
				vogais[3]++;
				break;
			}
			case 'U': {
				vogais[4]++;
			}
			}
		}
		contaTotalVogal(vogais);
	}

	// METODO QUE CONTA O TOTAL DE VOGAIS
	public static void contaTotalVogal(int vogais[]) {
		for (int i = 0; i < 5; i++)
			vogais[5] += vogais[i];
	}

	// METODO QUE VALIDA A FRASE
	public static boolean analisaFrase(String frase) {
		// DECLARACOES
		int contador = 0;
		// INSTRUCOES
		for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) == ' ')
				contador++;
		}
		return ((contador == frase.length() || frase.length() == 0) ? false : true);
	}

	// METODO QUE ANALISA A VONTADE DO USUARIO
	public static boolean analisaUsuario(int vogais[]) {
		// DECLARACOES
		Scanner ler = new Scanner(System.in);
		String resposta;
		// INSTRUCOES
		System.out.println("\nDeseja analisar outra frase? (Reponda Sim ou Nao):");
		do {
			resposta = ler.next().toUpperCase();
			if (!resposta.equals("SIM") && !resposta.equals("NAO"))
				System.out.println("Resposta Invalida! Digite apenas Sim ou Nao:");

			// VALIDACAO DA RESPOSTA DADA PELO USUARIO
		} while (!resposta.equals("SIM") && !resposta.equals("NAO"));

		// CASO A RESPOSTA SEJA SIM
		if (resposta.equals("SIM")) {
			// ZERAR VARIAVEIS QUE GUARDAM AS VOGAIS
			for (int aux = 0; aux < 6; aux++)
				vogais[aux] = 0;
			limpaTela(60);
			return true;
			// CASO A RESPOSTA SEJA NAO
		} else
			return false;
	}

	// METODO QUE EXIBE AS VOGAIS E O TOTAL DELAS NO CONSOLE
	public static void exibirVogais(int vogais[]) {
		// SE A FRASE NAO TIVER VOGAIS
		if (vogais[5] == 0)
			System.out.println("Nessa frase, nao existem vogais.");

		// SE A FRASE POSSUIR VOGAIS
		else {
			limpaTela(1);
			System.out.println("Nessa frase, existem:");
			for (int i = 0; i < 6; i++) {
				// CADA 'i' CORRESPONDE A UMA VOGAL (A, E, I, O, U) INDO DE 0 A 4
				switch (i) {
				// VOGAL A
				case 0: {
					if (vogais[i] > 0)
						System.out.println(+vogais[i] + " vogal(is) A");
					break;
				}
				// VOGAL E
				case 1: {
					if (vogais[i] > 0)
						System.out.println(+vogais[i] + " vogal(is) E");
					break;
				}
				// VOGAL I
				case 2: {
					if (vogais[i] > 0)
						System.out.println(+vogais[i] + " vogal(is) I");
					break;
				}
				// VOGAL O
				case 3: {
					if (vogais[i] > 0)
						System.out.println(+vogais[i] + " vogais(is) O");
					break;
				}
				// VOGAL U
				case 4: {
					if (vogais[i] > 0)
						System.out.println(+vogais[i] + " vogais(is) U");
					// PRINT DO 'i' = 5, QUE CORRESPONDE A SOMA DAS VOGAIS
					System.out.println("No total, existem " + vogais[(i + 1)] + " vogais.");
				}
				}
			}
		}
	}
}
