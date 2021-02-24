package principal;

public class Senha {

	public static void main(String[] args) throws InterruptedException {
		// Declarações
		final int MAXIMO = 9;
		String cadastroSenha, senha;
		int contador = 0;

		// Instruções
		System.out.print("Cadastre uma senha sem espaço de no mínimo 3 dígitos e máximo 5: ");
		do {
			cadastroSenha = Leitura.lerString();
			if (cadastroSenha.length() < 3 || cadastroSenha.length() > 5)
				System.out.print("Senha inválida!\n"
								 + "Digite uma nova senha sem espaço de no mínimo 3 dígitos e máximo 5: ");
		} while (cadastroSenha.length() < 3 || cadastroSenha.length() > 5);
		limpaTela(3);
		while (contador < MAXIMO) {
			System.out.print("Tente acertar a Senha: ");
			senha = Leitura.lerString();
			contador++;
			limpaTela(20);
			if (cadastroSenha.equals(senha)) {
				contador = MAXIMO + 1;
				System.out.println("\t\t\t\t\tParabéns, você acertou a senha de acesso!");
			} else if (contador == MAXIMO) {
				System.out.println("\t\t\t\t\tO computador irá se autodesturir em 10 segundos.");
				Thread.sleep(10 * 1000);   // Calculo para 10 segundos
			} else
				System.out.println("Senha incorreta!\nTente novamente.");

		}

	}

	// ================================================
	// ============= MÉTODOS AUXILIARES ===============
	// ================================================
	public static void limpaTela(int salto) {
		for (int linha = 0; linha < salto; linha++)
			System.out.println();
	}
}
