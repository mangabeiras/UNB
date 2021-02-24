package visao;
import java.text.DecimalFormat;
// TODAS AS SAIDAS DO PROGRAMA
public class Visao {
	public static void interacao(int codigo) {
		if(codigo == 0)
			System.out.println("CADASTRO DE PINTOR");
		// MENU PRINCIPAL
		if(codigo == 1) {
			limpaTela(30);
			System.out.println("Escolha uma opcao:\n1 - CADASTRO NOVO QUADRO");
			System.out.println("2 - CADASTRO NOVO PINTOR");
			System.out.println("3 - LISTAR TODOS OS QUADROS DE UM PINTOR");
			System.out.println("4 - QUADROS CADASTRADOS ATE O MOMENTO");
			System.out.println("0 - ENCERRAR O PROGRAMA");
		}
		if (codigo == 2)
			System.out.print("Nome: ");
		if (codigo == 3)
			System.out.print("Ano de Nascimento: ");
		if (codigo == 4)
			System.out.println("\nCADASTRO DE QUADRO");
		if (codigo == 5)
			System.out.print("Codigo do Artista:");
		if (codigo == 6)
			System.out.print("Preco: ");
		if (codigo == 7)
			System.out.println("Insira o nome do pintor que deseja:");
		if (codigo == 8)
			System.out.print("Nome do Quadro: ");
		if (codigo == 9)
			System.out.print("Ano de Compra do quadro: ");
		if (codigo == 10)
			System.out.println("Digite 'S' se desejar voltar ao menu:");
	}
	
	public static void limpaTela(int saltos) {
		for(int i = 0; i<saltos;i++)
			System.out.println();
	}
	
	public static void erroEntrada(int codigo, final int ANONIMO, final int MAXIMO) {
		if (codigo == 0)
			System.out.println("Nome invalido! Nomes precisam tem entre 3 e 30 caracteres.");
		if (codigo == 1)
			System.out.println("Ano invalido! Ele precisa estar entre "+(ANONIMO+1)+ " e "+MAXIMO);
		if (codigo == 2)
			System.out.println("Entrada invalida! Insira apenas um numero para ANO.");
		if (codigo == 3)
			System.out.println("Entrada invalida! A opcao precisa estar entre 0 e 4.");
		if (codigo == 4)
			System.out.println("Entrada invalida! Insira apenas um numero para OPCAO desejada.");
		if (codigo == 5)
			System.out.println("Codigo invalido! Digite um numero que corresponda a um pintor");
		if (codigo == 6)
			System.out.println("Preco invalido. Insira um preco maior que 15.");
		if (codigo == 7)
			System.out.println("Invalido! Insira apenas um numero que esteja nos conjuntos dos racionais.");
		if (codigo == 8)
			System.out.println("O nome inserido nao corresponde a um artista cadastrado.");
	}
	
	public static void resultado(int codigo, String nome, float soma, int contador) {
		DecimalFormat mascara = new DecimalFormat("0.00");
		if (codigo == 0)
			System.out.println((contador==0)?"QUADROS\n-" +nome: "-"+nome);
		if (codigo == 1)
			System.out.println("Preco total em quadros: "+mascara.format(soma));
		if (codigo == 2)
			System.out.println("CATALOGO DE ARTISTAS");
		if (codigo == 3)
			System.out.println("Codigo "+contador+" = "+nome);
	}
	
}
