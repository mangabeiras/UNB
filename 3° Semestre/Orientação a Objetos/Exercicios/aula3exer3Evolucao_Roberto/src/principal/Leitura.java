package principal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Leitura {
	
	public static char leituraChar() {
		Scanner ler = new Scanner(System.in);
		return (ler.next().trim().toUpperCase().charAt(0));
	}
	
	
	public static float leituraFloat() {
		Scanner ler = new Scanner(System.in);
		float numero=0;
		boolean erro = false;
		try {
			numero = ler.nextFloat();
			
			//TRATAMENTO DE EXCECAO (QUANDO NAO E UM NUMERO LIDO)
		} catch (InputMismatchException excecao) {
			erro = true;
		}
		return (numero);
	}

	
	public static int leituraInt() {
		Scanner ler = new Scanner(System.in);
		int numero=0;
		boolean erro=false;
		try {
			numero = ler.nextInt();
			
			//TRATAMENTO DE EXCECAO (QUANDO NAO E UM NUMERO INTEIRO LIDO)
		} catch (InputMismatchException excecao) {
			erro = true;
		}
		return(numero);
	}
	

	public static String leituraLinha() {
		Scanner ler = new Scanner(System.in);
		return(ler.nextLine());
	}
}
