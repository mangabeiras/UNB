package leitura;

import java.util.Scanner;

public class Leitura {

	public static float leituraFloat() {
		Scanner ler = new Scanner(System.in);
		return (ler.nextFloat());
	}

	public static int leituraInt() {
		Scanner ler = new Scanner(System.in);
		return (ler.nextInt());
	}

	public static String leituraLinha() {
		Scanner recebe = new Scanner(System.in);
		return (recebe.nextLine());
	}
}
