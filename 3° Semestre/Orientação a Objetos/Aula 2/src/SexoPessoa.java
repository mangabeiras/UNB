import java.util.Scanner;

public class SexoPessoa {
	
	public static void main(String[] args) {
		//Campos
		Scanner read = new Scanner(System.in);
		char sexo;
		
		//Instru��es
		System.out.print("Por favor digite seu sexo usando apenas uma letra:");
		
		//Leitura dos Dados
		sexo = read.next().toUpperCase().charAt(0);
		
		//Caso o caracter n�o seja M ou F
		while (sexo != 'M' & sexo != 'F') {
			System.out.print("N�o h� correspondencia de sexo, por favor digite novamente:");
			sexo = read.next().toUpperCase().charAt(0);
		}
		
		//Resposta ao Usu�rio
		System.out.println((sexo =='M')?"\n\n\n\t\t\tMASCULINO" : "\n\n\n\t\t\tFEMININO");
	}
}
