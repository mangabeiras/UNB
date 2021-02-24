package leitura;

import java.util.Scanner;

public class Leitura {
	public static String lerLinha() {
		return new Scanner(System.in).nextLine();
	}
	public static int lerInt() {
		return new Scanner(System.in).nextInt();
	}
	public static char lerChar() {
		return new Scanner(System.in).next().toUpperCase().charAt(0);
	}
}
