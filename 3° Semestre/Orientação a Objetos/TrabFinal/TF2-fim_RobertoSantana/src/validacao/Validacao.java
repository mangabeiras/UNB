package validacao;

import dados.Grupo;
import visao.Console;

public class Validacao {
	// VERIFICA SE O QUE FOI DIGITADO E INTEIRO
	public static boolean validaInt(String lido) {
		int num = 0;
		try {
			num = Integer.parseInt(lido);
			if (num < 0) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	// VERIFICA SE A GESTACAO FOI MARCADA
	public static char validaGestacao(String gestacao) {
		if (gestacao.equals("Nao tem Certeza"))
			return 'T';
		else if (gestacao.equals("Sim"))
			return 'S';
		else if (gestacao.equals("Nao"))
			return 'N';
		return 0;
	}
	
	// VERIFICA SE O NOME INSERIDO E VALIDO
	public static boolean validaNome(String nome) {
		return (validaLength(nome) && isAlfabetico(nome) && validaCompleto(nome));
	}
	
	// VERIFICA TAMANHO DE STRING
	public static boolean validaLength(String lido) {
		if (lido.length() < 3) {
			return false;
		}
		return true;
	}
	// VERIFICA SE UMA STRING POSSUI NUMEROS
	public static boolean isAlfabetico(String lido) {
		for (char c : lido.toCharArray()) {
			if (Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}
	
	// VERIFICA SE O NOME ESTA COMPLETO
	public static boolean validaCompleto(String nome) {
		return nome.split(" ").length > 1;
	}
	
	// VERIFICA SE A SITUACAO INSERIDA E VALIDA 
	public static char validaSituacao(String situacao) {
		if (situacao.contains("Contaminad") && situacao.contains("em Tratamento")) {
			return 'T';
		}
		else if (situacao.contains("Contaminad") &&  situacao.contains("Falecid")) {
			return 'F';
		}
		else if (situacao.contains("Contaminad") && situacao.contains("Curad")) {
			return 'C';
		}
		else if (situacao.contains("Nao Contaminad")) {
			return 'S';
		}
		return 0;
	}
	
	// VERIFICA SE IDADE E VALIDA
	public static boolean validaIdade(String idade) {
		final int MAXIMO = 150;
		if (Integer.parseInt(idade) > MAXIMO) {
			return false;
		}
		return true;
	}
	
}
