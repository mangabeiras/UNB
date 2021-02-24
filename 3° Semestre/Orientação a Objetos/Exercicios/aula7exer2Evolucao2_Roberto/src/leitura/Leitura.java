package leitura;

import java.util.Scanner;
import saida.Visao;

public class Leitura {
	public static String lerEntrada () {
		return new Scanner(System.in).nextLine().trim();
	}
}
