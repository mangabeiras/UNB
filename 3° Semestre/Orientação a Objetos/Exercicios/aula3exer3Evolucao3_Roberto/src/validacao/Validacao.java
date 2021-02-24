package validacao;

import java.util.InputMismatchException;

import leitura.Leitura;
import visao.Saida;

public class Validacao {

	// VALIDACAO DA VONTADE DO USUARIO
	public static boolean validaContinua() {
		Saida.continua();
		String resposta = Leitura.leituraLinha();
		return ((!resposta.toUpperCase().equals("S") || resposta.length() != 1) ? false : true);
	}

	public static String validaNome(int i) {
		Saida.pedirNome(i);
		String nome = Leitura.leituraLinha();
		while (nome.length() < 3) {
			Saida.erroNome();
			nome = Leitura.leituraLinha();
		}
		return nome;
	}

	public static float validaAltura() {
		final float ALTURA_MIN = 0.4F, ALTURA_MAX = 2.6F;
		float altura = 0;
		boolean erro = false;
		Saida.pedirAltura();
		do {
			try {
				altura = Leitura.leituraFloat();
				while (altura < ALTURA_MIN || altura > ALTURA_MAX) {
					Saida.erroAltura(ALTURA_MIN, ALTURA_MAX);
					altura = Leitura.leituraFloat();
				}
				erro = false;
			} catch (InputMismatchException excecao) {
				System.out.println("Insira UM NUMERO que corresponde a altura: ");
				erro = true;
			}
		} while (erro);
		return altura;
	}

	public static int validaIdade() {
		int idade = 0;
		final int IDMIN = 0, IDMAX = 150;
		boolean erro = false;
		Saida.pedirIdade();
		do {
			try {
				idade = Leitura.leituraInt();
				while (idade <= IDMIN || idade > IDMAX) {
					Saida.erroIdade(IDMIN, IDMAX);
					idade = Leitura.leituraInt();
				}
				erro = false;
			} catch (InputMismatchException excecao) {
				System.out.println("Insira UM NUMERO inteiro que corresponde a idade:");
				erro = true;
			}
		} while (erro);
		return idade;
	}
}
