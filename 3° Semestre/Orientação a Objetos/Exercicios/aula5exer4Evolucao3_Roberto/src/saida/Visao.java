package saida;

public class Visao {

	public static void mostraMensagem(String msg) {
		System.out.println(msg);
	}

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++) {
			System.out.println();
		}
	}
}