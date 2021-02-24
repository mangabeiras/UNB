import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Aula2exer4_RobertoSantana_190019620 {
	static Scanner ler = new Scanner(System.in);
	static final int MAX = 3;
	public static void main(String[] args) {

		// DECLARACOES
		float[] peso = new float[MAX];

		DecimalFormat mascara = new DecimalFormat("0.00");

		// METODOS
		System.out.print("Insira os pesos dos elefantes: ");

		// ANALISE PESO
		LerPeso(peso);

		Limpar();

		// RESPOSTA AO USUARIO
		System.out.println("Os pesos em ordem crescente são:");
		for (int i = 0; i < MAX; i++)
			System.out.print("" + mascara.format(peso[i]) + " Kg        ");
		System.out.println("\n\n");
	}

	// **********************************************FUNCOES************************************************
	// FUNCAO QUE LIMPA TELA
	public static void Limpar() {
		for (int i = 0; i < 30; i++)
			System.out.println();
	}

	// FUNCAO QUE LE E COLOCA EM ORDEM OS PESOS
	public static float[] LerPeso(float peso[]) {
		for (int i = 0; i < MAX; i++) {
			peso[i] = ler.nextFloat();
			peso[i] = AnalisePeso(peso[i]);
		}
		Arrays.sort(peso);
		return peso;
	}

	// FUNCAO QUE ANALISA A VALIDADE DOS PESOS
	public static float AnalisePeso(float peso) {
		while (peso < 5) {
			System.out.println("\nPeso inválido, insira novamente: ");
			peso = ler.nextFloat();
		}
		return peso;
	}

}
