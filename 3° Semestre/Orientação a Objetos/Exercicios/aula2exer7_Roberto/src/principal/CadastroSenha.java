package principal;

import java.util.Scanner;

public class CadastroSenha {
	public static void main(String[] args) throws InterruptedException {
		// DECLARACOES
		final int MAXIMO = 9, MIN_CARACTERES = 3, MAX_CARACTERES = 5;
		String senha, senhaConfirmacao, senhaInserida;
		Scanner ler = new Scanner(System.in);

		// INSTRUCOES
		do {
			System.out.println("Usuario, insira uma senha de no minimo " + MIN_CARACTERES + " e maximo "
					+ MAX_CARACTERES + " caracteres. Lembre que o espaco em branco nao e permitido:");

			// PRIMEIRA INSERCAO DA SENHA
			do {
				senha = ler.nextLine();
				if (!validaSenha(senha, MIN_CARACTERES, MAX_CARACTERES))
					System.out.println("Senha invalida. Insira novamente, lembrando que ela dever ter entre "
							+ MIN_CARACTERES + " e " + MAX_CARACTERES + " caracteres, e espaco em branco nao e permitido:");

				// VALIDACAO DA SENHA INSERIDA
			} while (!validaSenha(senha, MIN_CARACTERES, MAX_CARACTERES));

			// CONFIRMACAO DA SENHA (SEGUNDA INSERCAO)
			System.out.println("Confirme sua senha digitando-a novamente:");
			senhaConfirmacao = ler.nextLine();

			// CASO A SEGUNDA SENHA SEJA DIFERENTE DA PRIMEIRA
			if (!confereSenha(senha, senhaConfirmacao)) {
				System.out.println("Senhas nao coincidentes.");
				Thread.sleep(1 * 1000);
				limpaTela(30);
			}

			// CONFERENCIA SE AS DUAS SENHAS SAO IGUAIS
		} while (!confereSenha(senha, senhaConfirmacao));

		// CASO AS DUAS SENHAS SEJAM IGUAIS E VALIDAS
		System.out.println("Senha cadastrada! Fazendo Logout...");
		Thread.sleep(2 * 1000);
		limpaTela(30);

		// INSTRUCOES PARA OUTROS USUARIOS
		System.out.println("Ola, insira a senha pra fazer login:");

		for (int i = MAXIMO; i > 0; i--) {
			senhaInserida = ler.nextLine();

			// CONFERENCIA DA SENHA INSERIDA PELO OUTRO USUARIO
			if (!confereSenha(senha, senhaInserida)) {
				System.out.println("Senha incorreta. Voce tem mais " + (i - 1) + " tentativas");

				// CASO ELE ACERTE A SENHA
			} else {
				System.out.println("Senha Correta. Entrando...");
				Thread.sleep(3 * 1000);
				limpaTela(20);
				meioHorizontal();
				System.out.println("Parabéns!");
				break;
			}

			// CASO ELE NAO ACERTE A SENHA EM 9 TENTATIVAS
			if (i == 1) {
				System.out.println(
						"Limite de tentativas ultrapassado, o computador ira se autodestruir em 10 segundos...");
				Thread.sleep(10 * 1000);
				limpaTela(20);
			}
		}
	}

	// *************************************METODOS*********************************************************
	// METODO QUE LIMPA A TELA
	public static void limpaTela(int saltos) {
		for (int i = 0; i < saltos; i++)
			System.out.println();
	}

	// METODO QUE FORMATA PARA O MEIO DA HORIZONTAL
	public static void meioHorizontal() {
		for (int i = 0; i < 40; i++)
			System.out.print(" ");
	}

	// METODO QUE VERIFOCA SE A SENHA POSSUI DE 3 A 5 CARACTERE E SE POSSUI ESPACO
	public static boolean validaSenha(String senha, int MIN_CARACTERES, int MAX_CARACTERES) {
		for (int i = 0; i < senha.length(); i++) {
			if (senha.charAt(i) == ' ')
				return false;
		}
		return ((senha.length() > MAX_CARACTERES || senha.length() < MIN_CARACTERES) ? false : true);
	}

	// METODO QUE COMPARA AS SENHAS
	public static boolean confereSenha(String senha, String senhaInserida) {
		return ((senhaInserida.equals(senha) ? true : false));
	}
}
