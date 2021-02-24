package principal;

import java.util.Scanner;

public class FraseVogal {

	public static void main(String[] args) {
		// DECLARACOES
		Scanner ler = new Scanner(System.in);

		String frase, verificarContinuar;
		int vogalA, vogalE, vogalI, vogalO, vogalU, totalDeVogais, totalCaracteresComEspaco, totalCaracteresSemEspaco;
		boolean continuar = false;

		// INSTRUCOES
		do {
			// SOLICITAR E LER A FRASE
			System.out.println("Por favor, digite uma frase:");
			frase = ler.nextLine();

			// CASO A FRASE SEJA INVALIDA
			while (!validarFrase(frase)) {
				System.out.println("Frase sem dados e invalida. Tente novamente, digite uma frase:");
				frase = ler.nextLine();
			}

			// ATRIBUIR QUANTIDADE DE VOGAIS
			vogalA = quantidadeCadaVogal(frase.toUpperCase(), 'A');
			vogalE = quantidadeCadaVogal(frase.toUpperCase(), 'E');
			vogalI = quantidadeCadaVogal(frase.toUpperCase(), 'I');
			vogalO = quantidadeCadaVogal(frase.toUpperCase(), 'O');
			vogalU = quantidadeCadaVogal(frase.toUpperCase(), 'U');
			totalDeVogais = quantidadeTotalDeVogais(vogalA, vogalE, vogalI, vogalO, vogalU);

			// ATRIBUIR QUANTIDADE TOTAL DE CARACTERES NA FRASE(INCLUINDO ESPACOS)
			totalCaracteresComEspaco = quantidadeTotaldeCaracteresComEspaco(frase);

			// ATRIBUIR QUANTIDADE TOTAL DE CARACTERES NA FRASE(RETIRANDO ESPACOS)
			totalCaracteresSemEspaco = quantidadeTotaldeCaracteresSemEspaco(frase);

			limpaTela(40);
			// EXIBICAO DA QUANTIDADE DE CADA VOGAL
			System.out.println("QUANTIDADE DE CADA VOGAL NA FRASE:");
			exibirQuantidadeDeCadaVogal(vogalA, 'A');
			exibirQuantidadeDeCadaVogal(vogalE, 'E');
			exibirQuantidadeDeCadaVogal(vogalI, 'I');
			exibirQuantidadeDeCadaVogal(vogalO, 'O');
			exibirQuantidadeDeCadaVogal(vogalU, 'U');

			limpaTela(1);
			// EXIBICAO DA QUANTIDADE TOTAL DE VOGAIS NA FRASE
			System.out.println("QUANTIDADE TOTAL DE VOGAIS NA FRASE");
			exibirQuantidadeTotalDeVogais(totalDeVogais);

			limpaTela(1);
			// EXIBICAO DA QUANTIDADE TOTAL DE CARACTERES NA FRASE(INCLUINDO ESPACOS)
			exibirQuantidadeDeCaracteresComEspaco(totalCaracteresComEspaco);
			// EXIBICAO DA QUANTIDADE TOTAL DE CARACTERES NA FRASE(RETIRANDO ESPACOS)
			exibirQuantidadeDeCaracteresSemEspaco(totalCaracteresSemEspaco);

			limpaTela(2);
			// VERIFICAR SE O USUARIO QUER CONTINUAR OU FINALIZAR O PROGRAMA
			System.out.println("Deseja verificar outra frase? Se sim, digite 's'. Se nao, apenas aperte enter:");
			verificarContinuar = ler.nextLine().toUpperCase();

			continuar = validarContinuar(verificarContinuar);

			if (continuar) {
				limpaTela(40);
			}

		} while (continuar);
	}

	// -------------------------------- METODOS ------------------------------

	// VERIFICAR SE A FRASE E VALIDA, SE NAO TIVER DADOS E INVALIDA
	static boolean validarFrase(String frase) {
		if (frase.trim().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	// LIMPAR A TELA
	static void limpaTela(int linhasPuladas) {
		for (int aux = 0; aux < linhasPuladas; aux++) {
			System.out.println();
		}
	}

	// CONTAR QUANTIDADE DE CADA VOGAL NA FRASE
	static int quantidadeCadaVogal(String frase, char vogal) {
		// DECLARACOES
		int quantidadeDaVogal = 0;

		// INSTRUCOES
		for (int aux = 0; aux < frase.length(); aux++) {

			if (frase.charAt(aux) == vogal) {
				quantidadeDaVogal++;
			}
		}

		return quantidadeDaVogal;
	}

	// CONTAR A QUANTITADE TOTAL DE VOGAIS NA FRASE
	static int quantidadeTotalDeVogais(int vogalA, int vogalE, int vogalI, int vogalO, int vogalU) {
		// DECLARACOES
		int totalDeVogais = vogalA + vogalE + vogalI + vogalO + vogalU;

		// INSTRUCOES

		return totalDeVogais;
	}

	// EXIBIR A QUANTIDADE DE CADA VOGAL NA FRASE
	static void exibirQuantidadeDeCadaVogal(int quantidadeVogal, char vogal) {
		System.out.println("A frase possui " + quantidadeVogal + " vogal(is) '" + vogal + "'.");
	}

	// EXIBIR QUANTIDADE TOTAL DE VOGAIS NA FRASE
	static void exibirQuantidadeTotalDeVogais(int totalDeVogais) {
		System.out.println("A frase possui " + totalDeVogais + " vogal(is).");
	}

	// VALIDAR QUANDO O USUARIO DIZ SE QUER FINALIZAR O PROGRAMA OU NAO
	static boolean validarContinuar(String verificarContinuar) {
		if (verificarContinuar.equals("S")) {
			return true;
		} else {
			return false;
		}
	}

	// CONTAR QUANTIDADE DE CARACTERES NA FRASE COM O ESPACO
	static int quantidadeTotaldeCaracteresComEspaco(String frase) {
		// INSTRUCOES
		return frase.trim().length();
	}

	// CONTAR QUANTIDADE DE CARACTERES NA FRASE SEM O ESPACO
	static int quantidadeTotaldeCaracteresSemEspaco(String frase) {
		// DECLARACOES
		String fraseSemEspaco = frase.replace(" ", "");

		// INSTRUCOES
		return fraseSemEspaco.length();
	}

	// EXIBIR A QUANTIDADE DE CARACTERES NA FRASE (INCLUINDO ESPACOS)
	static void exibirQuantidadeDeCaracteresComEspaco(int totalCaracteresComEspaco) {
		System.out.println(
				"A frase possui " + totalCaracteresComEspaco + " caracter(es) (incluindo espacos entre as palavras).");
	}

	// EXIBIR A QUANTIDADE DE CARACTERES NA FRASE (RETIRANDO ESPACOS)
	static void exibirQuantidadeDeCaracteresSemEspaco(int totalCaracteresSemEspaco) {
		System.out.println(
				"A frase possui " + totalCaracteresSemEspaco + " caracter(es) (retirando espacos entre as palavras).");
	}
}
