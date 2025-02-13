package saida;

import dados.*;

public class Visao {
	public static void mostraMenu(GrupoMamiferos grupoMamiferos) {
		System.out.println("Total Registrados: " + grupoMamiferos.getGrupoMamiferos().size()
				+ "\nEscolha uma das opcoes a seguir");
		System.out.println(
				"[0] - Registrar Macaco\n[1] - Registrar Elefante\n[2] - Registrar Baleia\n[3] - Finalizar Programa");
	}

	public static void mostraAnimais(GrupoMamiferos grupoMamiferos) {
		if (grupoMamiferos.getGrupoMamiferos().size() == 0)
			System.out.println("Nenhum mamifero foi cadastrado!");
		else {
			limpaTela(50);
			String formato = "%-10s%-15s%-20s%-20s%-10s%-10s%-10s%-40s\n";
			System.out.format(formato, "MAMIFERO |", "IDADE VIDA |", "IDADE AMAMENTACAO |", "DESCRICAO |", "TAMANHO |",
					"PORTE |", "PESO |", "HABITAT |");
			System.out.println(
					"=================================================================================================================");
			for (Mamifero mamidero : grupoMamiferos.getGrupoMamiferos())
				System.out.println(mamidero);
		}
	}

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}
}
