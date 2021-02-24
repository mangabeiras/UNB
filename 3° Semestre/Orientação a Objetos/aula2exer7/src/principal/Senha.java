package principal;

public class Senha {

	public static void main(String[] args) throws InterruptedException {
		// Declara��es
		final int MAXIMO = 9;
		String cadastroSenha, senha;
		int contador = 0;

		// Instru��es
		System.out.print("Cadastre uma senha sem espa�o de no m�nimo 3 d�gitos e m�ximo 5: ");
		do {
			cadastroSenha = Leitura.lerString();
			if (cadastroSenha.length() < 3 || cadastroSenha.length() > 5)
				System.out.print("Senha inv�lida!\n"
								 + "Digite uma nova senha sem espa�o de no m�nimo 3 d�gitos e m�ximo 5: ");
		} while (cadastroSenha.length() < 3 || cadastroSenha.length() > 5);
		limpaTela(3);
		while (contador < MAXIMO) {
			System.out.print("Tente acertar a Senha: ");
			senha = Leitura.lerString();
			contador++;
			limpaTela(20);
			if (cadastroSenha.equals(senha)) {
				contador = MAXIMO + 1;
				System.out.println("\t\t\t\t\tParab�ns, voc� acertou a senha de acesso!");
			} else if (contador == MAXIMO) {
				System.out.println("\t\t\t\t\tO computador ir� se autodesturir em 10 segundos.");
				Thread.sleep(10 * 1000);   // Calculo para 10 segundos
			} else
				System.out.println("Senha incorreta!\nTente novamente.");

		}

	}

	// ================================================
	// ============= M�TODOS AUXILIARES ===============
	// ================================================
	public static void limpaTela(int salto) {
		for (int linha = 0; linha < salto; linha++)
			System.out.println();
	}
}
