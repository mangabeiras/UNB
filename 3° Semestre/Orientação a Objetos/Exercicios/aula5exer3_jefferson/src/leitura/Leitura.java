package leitura;

import java.util.Scanner;

public class Leitura {

	public static float lerFloat() {
		Scanner ler = new Scanner(System.in);
		return ler.nextFloat();
	}

	public static int lerInt() {
		Scanner ler = new Scanner(System.in);
		return ler.nextInt();
	}

	public static String lerString() {
		Scanner ler = new Scanner(System.in);
		return ler.nextLine().trim().toUpperCase();
	}
	
	public static char leituraChar() {
		Scanner ler = new Scanner (System.in);
		return ler.next().toUpperCase().charAt(0);
	}

}
