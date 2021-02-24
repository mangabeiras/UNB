package leitura;
import java.util.Scanner;
public class Leitura {
	public static String lerLinha() {
		Scanner ler = new Scanner(System.in);
		return (ler.nextLine());
	}
	public static String lerString() {
		Scanner ler = new Scanner(System.in);	
		return (ler.next().trim().toUpperCase());
	}
}
