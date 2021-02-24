package principal;

public class Validacao {
	public static boolean validaContinua() {
		// SERA CADASTRADO OUTRO USUARIO?
		String resposta;
		do {
			resposta = Leitura.lerChar();
			if (!resposta.equals("S") & !resposta.equals("N"))
				System.out.println("Insira apenas S ou N:");
		} while (!resposta.equals("S") & !resposta.equals("N"));
		return (resposta.equals("S") ? true : false);
	}

	// METODO QUE AVALIA SE O CHAR INSERIDO E VALIDO
	public static boolean validaChar(String analise) {
		return ((analise.length() != 1) ? false : true);
	}

	// LEITURA E VALIDACAO DO NOME
	public static String validaNome(String nome) {
		final int CARACTER_MAX = 3;
		nome = Leitura.lerString();
		while (nome.trim().length() < CARACTER_MAX) {
			System.out.println("O nome precisa ter no minimo " + CARACTER_MAX + " caracteres. Insira novamente:");
			nome = Leitura.lerString();
		}
		return nome;
	}

	// LEITURA E VALIDACAO DA IDADE
	public static int validaIdade(int idade) {
		final int IDADE_MAX = 151;
		idade = Leitura.lerInt();
		while (idade > IDADE_MAX || idade < 0) {
			System.out.println("Idade precisa ter entre 0 e " + (IDADE_MAX) + ". Insira novamente:");
			idade = Leitura.lerInt();
		}
		return idade;
	}

	// LEITURA E VALIDACAO DA ALTURA
	public static float validaAltura(float altura) {
		final float ALTURA_MIN = 0.4F, ALTURA_MAX = 2.6F;
		altura = Leitura.lerFloat();
		while (altura < ALTURA_MIN || altura > ALTURA_MAX) {
			System.out.println(
					"Altura precisa ter entre " + ALTURA_MIN + " e " + ALTURA_MAX + " metros. Insira novamente:");
			altura = Leitura.lerFloat();
		}
		return altura;
	}
}
