package validacao;

public class Validacao {

	// VALIDACAO DE SE EXISTE OU NAO DIGITOS NA STRING
	public static boolean isStringComNumeros(String frase) {
		for (char c : frase.toCharArray()) {
			if (Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	// VALIDACAO DO TAMANHO DA STRING
	public static boolean isTamanhoValido(String nome) {
		if (nome.trim().length() < 3) {
			return false;
		}
		return true;
	}

	// VALIDACAO DE INTEIRO POSITIVO
	public static boolean validaInt(String idade) {
		int numero = 0;
		try {
			numero = Integer.parseInt(idade);
			if (numero < 0) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	// VALIDACAO DA IDADE
	public static boolean validaIdade(String idade) {
		final int MAXIMO = 130;
		if (Integer.parseInt(idade) > MAXIMO) {
			return false;
		}
		return true;
	}

}