package leitura;

import java.util.Scanner;

public class Leitura {
	public static int leInt() {
		return new Scanner(System.in).nextInt();
	}
	public static String leLinha() {
		return new Scanner(System.in).nextLine().trim();
	}
	public static float leFloat() {
		return new Scanner(System.in).nextFloat();
	}
	public static String leString() {
		return new Scanner(System.in).next().trim();
	}
	
}
