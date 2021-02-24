package validacao;

import java.util.InputMismatchException;
import java.util.Vector;

import leitura.Leitura;
import principal.Principal;
import saida.Saida;

public class Validacao {

	public static float validaSalario() {
		float salario = 0;
		boolean erro;

		Saida.exibirHabitanteSendoRegistrado();
		do {
			Saida.solicitarSalario();
			try {
				salario = Leitura.lerFloat();

				if (salario >= 0) {
					erro = false;
				} else {
					Saida.salarioInvalido();
					erro = true;
				}

			} catch (InputMismatchException excecao) {
				Saida.excecaoFloat();
				erro = true;
			}
		} while (erro);

		return salario;
	}

	public static int validaIdade() {
		final int IDADEMINIMA = 0, IDADEMAXIMA = 150; // 0 para bebes que ainda nao tem 1 ano
		int idade = 0;
		boolean erro;

		do {
			Saida.solicitarIdade();
			try {
				idade = Leitura.lerInt();

				if (idade >= IDADEMINIMA && idade <= IDADEMAXIMA) {
					erro = false;
				} else {
					Saida.idadeInvalida();
					erro = true;
				}

			} catch (InputMismatchException excecao) {
				Saida.excecaoInt();
				erro = true;
			}
		} while (erro);

		return idade;
	}

	public static String validaSexo() {
		String sexo;

		Saida.solicitarSexo();
		sexo = Leitura.lerString();

		// conferir dps
		while (!sexo.equals("MASCULINO") && !sexo.equals("FEMININO")) {
			Saida.sexoInvalido();
			sexo = Leitura.lerString();
		}

		return sexo;
	}

	public static int validaNumeroDeFilhos() {
		final int QUANTIDADE_MINIMA = 0, QUANTIDADE_MAXIMA = 100;
		int quantidadeDeFilhos = 0;
		boolean erro;

		do {
			Saida.solicitarQuantidadeDeFilhos();
			try {
				quantidadeDeFilhos = Leitura.lerInt();

				if (quantidadeDeFilhos >= QUANTIDADE_MINIMA && quantidadeDeFilhos <= QUANTIDADE_MAXIMA) {
					erro = false;
				} else {
					Saida.quantidadeDeFilhosInvalida();
					erro = true;
				}

			} catch (InputMismatchException excecao) {
				Saida.excecaoInt();
				erro = true;
			}

		} while (erro);

		return quantidadeDeFilhos;
	}

	public static boolean validaLimiteHabitantes(Vector variosHabitantes) {
		return (variosHabitantes.size() < Principal.MAXIMO_HABITANTES) ? true : false;
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