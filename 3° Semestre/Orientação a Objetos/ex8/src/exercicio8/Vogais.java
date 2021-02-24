package exercicio8;
import java.util.Scanner;

public class Vogais {		

	public static void main(String[] args) {
		char proximo;
		int ver;
		Scanner leitura = new Scanner (System.in);
		String texto;


		do {		
			int vogal_A = 0, vogal_E = 0, vogal_I = 0, vogal_O = 0, vogal_U = 0;

			System.out.println ("Escreva um texto: ");
			texto = leitura.nextLine().trim(); //.TRIM EVITA TEXTOS SÓ COM ESPAÇOS

			while (texto.equals("")) { //VERIFICADOR
				System.out.println("Texto inválido. Escreva novamente: ");
				texto = leitura.nextLine().trim();			
			}
			
			Limpar(); //LIMPAR A TELA

			//VER VOGAIS
			for (int aux = 0; aux < texto.length(); aux++) {
				if (texto.toUpperCase().charAt(aux) == 'A') {
					vogal_A++;
				}

				if (texto.toUpperCase().charAt(aux) == 'E') {
					vogal_E++;
				}

				if (texto.toUpperCase().charAt(aux) == 'I') {
					vogal_I++;
				}

				if (texto.toUpperCase().charAt(aux) == 'O') {
					vogal_O++;
				}

				if (texto.toUpperCase().charAt(aux) == 'U') {
					vogal_U++;
				}
			}

			//NÚMERO DE VOGAIS
			System.out.println ("Existem "+vogal_A+" vogal(is) 'A' no texto.");
			System.out.println ("Existem "+vogal_E+" vogal(is) 'E' no texto.");
			System.out.println ("Existem "+vogal_I+" vogal(is) 'I' no texto.");
			System.out.println ("Existem "+vogal_O+" vogal(is) 'O' no texto.");
			System.out.println ("Existem "+vogal_U+" vogal(is) 'U' no texto.");

			int total = vogal_A + vogal_E + vogal_I + vogal_O + vogal_U;
			System.out.println ("Total de vogais no texto = "+total+".\n");
			System.out.println ("O texto recebido possui "+texto.length()+" caracter(es) (contando com espaços).\n");


			ver = 0;
			System.out.println ("Quer escrever outro texto? 's' ou 'n':");
			proximo = leitura.nextLine().toUpperCase().charAt(0);

			do {
				if (proximo == 'S') {
					ver = 1;
				}else if(proximo == 'N'){
					ver = 1;
				}

				if (ver == 0) {	
					System.out.println ("\nErro. Escreva apenas 's' ou 'n'.");
					proximo = leitura.nextLine().toUpperCase().charAt(0);

					if (proximo == 'S') {
						ver = 1;
					}else if(proximo == 'N'){
						ver = 1;
					}
				}

			}while (ver == 0);

			System.out.println();
		}while (proximo == 'S');
	}
	//***********************************************************************************************************************************************
	public static void Limpar() {
		for (int aux = 0; aux < 70; aux++) {
			System.out.println ();
		}
	}
	
}