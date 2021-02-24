import java.text.DecimalFormat;
import java.util.Scanner;

public class PercentualPiso {
	public static void main(String[] args) {
		// Declarações
		final float PISO = 1000.00F;
		float percentual, valorCorrespondente;
		Scanner ler = new Scanner(System.in);
		DecimalFormat mascara = new DecimalFormat("0.00");
		// Instruções
		System.out.println(
				"Por favor, insira um valor percentual para descobrir qual é o seu valor correspondente no piso: ");
		percentual = ler.nextFloat();
		valorCorrespondente = (percentual / 100) * PISO;
		System.out.print("\n\n\n\n\n\n\nO valor informado foi de " + mascara.format(percentual)
				+ " %, e isso corresponde a R$ " + mascara.format(valorCorrespondente) + " do piso");
	}
}
