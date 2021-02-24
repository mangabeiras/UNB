package principal;
import java.util.Scanner;
public class Leitura {
	// LEITURA DE INTEIROS
	public static int lerInt() {
		Scanner ler = new Scanner(System.in);
		return (ler.nextInt());
	}
	// LEITURA DE FLOATS
	public static float lerFloat() {
		Scanner ler = new Scanner(System.in);
		return (ler.nextFloat());
	}
	
	// LEITURA DE STRINGS
	public static String lerString() {
		Scanner ler = new Scanner(System.in);
		return (ler.next());
	}
	
	// LEITURA DE CHAR
	public static String lerChar() {
		String analise, resposta;
		Scanner ler = new Scanner(System.in);
		do {
			analise = ler.next();
			if (!Validacao.validaChar(analise))
				System.out.println("Caracter invalido, insira novamente");
		} while (!Validacao.validaChar(analise)); 
		resposta = analise.toUpperCase();
		return resposta;
	}
}
