package leitura;

import java.util.Scanner;

public class Leitura {
	public static String leLinha() {
		return new Scanner(System.in).nextLine().trim();
	}

	public static int leituraInt() {
		return (new Scanner(System.in).nextInt());
	}

	public static float leituraFloat() {
		return (new Scanner(System.in).nextFloat());
	}

}
