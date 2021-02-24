package leitura;

import java.util.Scanner;

public class Leitura {

	public static String lerString() {
		Scanner ler = new Scanner(System.in);
		return ler.nextLine().trim();
	}

	public static int lerInt() {
		Scanner ler = new Scanner(System.in);
		return ler.nextInt();
	}

	public static char leituraChar() {
		Scanner ler = new Scanner (System.in);
		return ler.next().toUpperCase().charAt(0);
	}

}
