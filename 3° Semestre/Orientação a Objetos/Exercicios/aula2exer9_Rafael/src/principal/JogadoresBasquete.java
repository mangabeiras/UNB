package principal;

import java.text.DecimalFormat;
import java.util.Scanner;

public class JogadoresBasquete {

	public static void main(String[] args) {
		// Declaracoes
		final int equipes = 2;
		final int jogadores = 2;
		int idade;
		float mediaIdade[] = new float[equipes], altura, percent = 0;
		int maiorIdade[] = new int[equipes];
		Scanner ler = new Scanner(System.in);

		// Instrucoes
		for (int cont = 0; cont < equipes; cont++) {
			maiorIdade[cont] = 0;
			mediaIdade[cont] = 0;
		}
		for (int cont = 0; cont < equipes; cont++) {
			System.out.println("Insira os dados da equipe " + (cont + 1) + ":\n");
			for (int aux = 0; aux < jogadores; aux++) {
				System.out.println("Informe a idade do " + (aux + 1) + "° jogador :");
				idade = ler.nextInt();
				idade = validaIdade(idade, ler);
				mediaIdade[cont] += idade;
				if (idade > 15)
					maiorIdade[cont]++;

				System.out.println("Informe a altura do " + (aux + 1) + "° jogador :");
				altura = ler.nextFloat();
				altura = validaAltura(altura, ler);
				if (altura < 1.50)
					percent += 1;
			}
			System.out.println();
		}
		limpaTela();
		mostraDados(equipes, jogadores, mediaIdade, maiorIdade, percent);
	}

	public static int validaIdade(int idade, Scanner ler) {
		while (idade < 1 || idade > 150) {
			System.out.println("Informe uma idade valida (entre 1 e 150):");
			idade = ler.nextInt();
		}
		return idade;
	}

	public static float validaAltura(float altura, Scanner ler) {
		while (altura < 0.1 || altura > 3.0) {
			System.out.println("Informe uma altura valida (entre 0.1 e 3.0) :");
			altura = ler.nextFloat();
		}
		return altura;
	}

	public static void limpaTela() {
		for (int i = 0; i < 30; i++)
			System.out.println();
	}

	public static void mostraDados(final int equipes, final int jogadores, float mediaIdade[], int maiorIdade[],
			float percent) {
		DecimalFormat mascara = new DecimalFormat("0.00");
		for (int i = 0; i < equipes; i++) {
			System.out.println("Dados da equipe " + (i + 1));
			System.out.println("Jogadores maiores que 15 anos: " + maiorIdade[i]);
			System.out.println(
					"Media de idade entre os jogadores da equipe: " + mascara.format(mediaIdade[i] / jogadores));
			System.out.println("\n");
		}
		System.out.println("\nPorcentagem de jogadores menores que 1.50 entre todas as equipes: "
				+ mascara.format(percent / (equipes * jogadores) * 100) + " %");
	}

}
