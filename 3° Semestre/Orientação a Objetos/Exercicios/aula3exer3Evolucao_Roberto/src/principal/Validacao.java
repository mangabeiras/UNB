package principal;

import java.util.InputMismatchException;

public class Validacao {

	public static boolean validaContinua(char opcao) {

		while ((opcao != 'S') && (opcao != 'N')) {
			Servicos.limpaTela(30);
			Saida.erroContinua();
			opcao = Leitura.leituraChar();
		}
		return ((opcao == 'S') ? true : false);
	}

	public static float validaAltura(float altura) {
		final float ALTURA_MIN = 0.4F, ALTURA_MAX = 2.6F;
		while ((altura < ALTURA_MIN || altura > ALTURA_MAX)) {
			Saida.erroAltura(ALTURA_MIN, ALTURA_MAX);
			altura = Leitura.leituraFloat();
		}
		return altura;
	}

	public static int validaIdade(int idade) {
		final int IDMIN = 0, IDMAX = 150;
		while (idade <= IDMIN || idade > IDMAX) {
			Saida.erroIdade(IDMIN, IDMAX);
			idade = Leitura.leituraInt();
		}
		return idade;
	}

	public static String validaNome(String nome) {
		while (nome.length() < 3) {
			Saida.erroNome();
			nome = Leitura.leituraLinha();
		}
		return nome;
	}
}
