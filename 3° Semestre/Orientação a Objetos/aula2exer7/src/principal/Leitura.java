package principal;

import java.util.Scanner;

public class Leitura {
	public static String lerString () {
		// Declaracoes
		String valor;
		Scanner ler = new Scanner(System.in);
		
		// Instrucoes
		valor = ler.next().trim();
		return(valor);
	}
}
