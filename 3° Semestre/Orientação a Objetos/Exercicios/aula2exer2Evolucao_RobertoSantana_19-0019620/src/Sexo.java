import java.util.Scanner;

public class Sexo {
	static Scanner ler = new Scanner(System.in);

	// MAIN
	public static void main(String[] args) {
		// DECLARACOES
		String sexo = null;

		// INSTRUCOES
		System.out.println("Insira a primeira letra que corresponde ao seu sexo(M ou F): ");

		sexo = validarSexo(sexo);

		System.out.print((sexo.charAt(0) == 'M') ? "\n\n\n\t\t\t\t\tMasculino\n\n" : "\n\n\n\t\t\t\t\tFeminino\n\n");
	}

	// ********************************************FUNCOES******************************************************
	// FUNCAO QUE VALIDA O SEXO
	public static String validarSexo(String sexo) {
		do {
			sexo = ler.next().toUpperCase();
			if (sexo.length() != 1 || (sexo.charAt(0) != 'M' & sexo.charAt(0) != 'F'))
				System.out.println("'" + sexo + "' é invalido, insira seu sexo somente com M ou F: ");
		} while (sexo.length() != 1 || (sexo.charAt(0) != 'M' & sexo.charAt(0) != 'F'));
		return sexo;
	}
}
