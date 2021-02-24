package visao;

import dados.Grupo;
import servicos.Servicos;

// TODAS AS SAIDAS DO PROGRAMA
public class Visao {
	public static void limpaTela(int saltos) {
		for (int i = 0; i < saltos; i++)
			System.out.println();
	}

	public static void pedeSemana() {
		System.out.println("Insira a quantidade de semanas referentes a esse mes: ");
	}

	public static void erroSemana(int semanaMin, int semanaMax) {
		System.out.println(
				"As semanas de um mes podem ser apenas " + semanaMin + " ou " + semanaMax + ". Insira novamente:");
	}

	public static void excecaoInt() {
		System.out.println("Erro de entrada. Insira um numero inteiro apenas: ");
	}

	public static void erroVendas() {
		System.out.println("O numero de vendas nao pode ser menor que zero. Insira novamente:");
	}

	public static void pedeVendas(int aux) {
		System.out.println("\t\t |VENDAS| ");
		System.out.print("\t\t|SEMANA " + (aux + 1) + "|\n\n");
	}

	public static void vendedor(int i) {
		System.out.print("VENDEDOR " + (i + 1) + ":");
	}

	// RESULTADO FINAL AO USUARIO
	public static void mostraTabela(Grupo grupo, int qtdVendedores) {
		for (int aux = 0; aux < qtdVendedores; aux++) {
			System.out.print("\t\t|VENDEDOR " + (aux + 1) + "|");
		}
		for (int aux = 0; aux < grupo.getSemana(); aux++) {
			System.out.print("\n|SEMANA " + (aux + 1) + "|");
			for (int i = 0; i < qtdVendedores; i++) {
				System.out.print("\t       " + grupo.getVenda(i, aux) + "\t");
			}
		}
		limpaTela(2);
		System.out.print("|   MES  | ");
		for (int aux = 0; aux < qtdVendedores; aux++)
			System.out.print("\t       " + Servicos.somaSemana(grupo, aux) + "\t");
		limpaTela(2);
		System.out.println("|  TOTAL |\t       " + Servicos.somaMes(grupo, qtdVendedores));
	}
}
