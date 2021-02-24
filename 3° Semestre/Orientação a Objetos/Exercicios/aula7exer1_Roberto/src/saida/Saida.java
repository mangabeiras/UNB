package saida;
// TODAS AS SAIDAS DO PROGRAMA
public class Saida {
	public static void interage(int codigo, int contador) {
		if (codigo == 0)
			System.out.println("CADASTRO "+(contador+1));
		if (codigo == 1)
			System.out.print("Ano: ");
		if (codigo == 2)
			System.out.print("Evento: ");
		if (codigo == 3)
			System.out.print("Presidente: ");
		if (codigo == 4)
			System.out.print("Digite S se deseja cadastrar outro ano:");
	}
	
	public static void erroEntrada(int codigo) {
		if (codigo == 0)
			System.out.println("Entrada Invalida. Apenas um numero inteiro e permitido para ANO.");
		if (codigo == 1)
			System.out.println("Invalido! Apenas e permitido um ano na faixa de 1901 a 2019.");
		if (codigo == 2)
			System.out.println("Evento invalido. Apenas e permitido uma definicao que tenha entre 5 e 30 caracteres");
		if (codigo == 3)
			System.out.println("Presidente invalido. Coloque apenas o primeiro e/ou o ultimo nome com apenas um espaco entre eles.");
	}
	public static void resultado(int codigo, Integer ano, String evento, String presidente) {
		if(codigo == 0)
			System.out.println("ANO\tEVENTO\t\t\tPRESIDENTE");
		if(codigo == 1)
			System.out.println(+ano+"\t"+evento+"\t\t\t"+presidente);
	}
	public static void limpaTela(int saltos) {
		for (int i = 0; i<saltos; i++)
			System.out.println();
	}
}
