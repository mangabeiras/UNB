package leitura;

import java.util.Scanner;

public class Leitura {
	public static String leLinha() {
		return new Scanner(System.in).nextLine().trim();
	}
	public static int leInt() {
		return new Scanner(System.in).nextInt();
	}
	public static char leChar() {
		return new Scanner(System.in).next().toUpperCase().charAt(0);
	}
}
