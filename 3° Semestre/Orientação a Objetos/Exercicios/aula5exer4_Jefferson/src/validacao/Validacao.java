package validacao;

import java.util.InputMismatchException;

import leitura.Leitura;
import saida.Saida;

public class Validacao {

	public static String validaNome() {
		String nome;

		Saida.solicitaNome();
		nome = Leitura.lerString();

		while (nome.isEmpty()) {
			Saida.nomeInvalido();
			nome = Leitura.lerString();
		}

		return nome;
	}

	public static int validaInt() {
		int opcao = 0;
		int[] opcoesValidas = { 0, 1, 2 };
		boolean erro = true;

		do {
			try {
				opcao = Leitura.lerInt();

				for (int aux = 0; aux < opcoesValidas.length; aux++) {
					if (opcao == opcoesValidas[aux]) {
						erro = false;
					}
				}

				if (erro) {
					Saida.digitoInvalido();
				}

			} catch (InputMismatchException excecao) {
				Saida.excecaoInt();
				erro = true;
			}
		} while (erro);

		return opcao;
	}

	public static boolean validaContinua() {
		// DECLARACOES
		char opcao;

		// INSTRUCOES
		Saida.verificarContinuacao();
		opcao = Leitura.leituraChar();

		while (opcao != 'S' && opcao != 'N') {
			Saida.digiteUmCaractereValido();
			opcao = Leitura.leituraChar();
		}

		if (opcao == 'S') {
			Saida.limpaTela(40);
		}

		return (opcao == 'S') ? true : false;
	}
}
