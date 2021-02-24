package leitura;

import java.util.Scanner;

public class Leitura {

	public static String lerLinha() {
		return new Scanner(System.in).nextLine().toUpperCase();
	}
}