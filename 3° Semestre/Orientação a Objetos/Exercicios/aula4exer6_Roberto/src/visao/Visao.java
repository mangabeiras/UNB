package visao;

// TODAS AS SAIDAS
public class Visao {
	public static void limpaTela(int saltos) {
		for (int i = 0; i < saltos; i++)
			System.out.println();
	}

	public static void pedeNome() {
		System.out.println("Insira o nome completo da pessoa: ");
	}

	// RESULTADO AO USUARIO
	public static void mostraResultado(String[] nomeDiv) {
		for (int i = 0; i < nomeDiv.length; i++) {
			System.out.println((i == 0) ? "NOME\t\t" + nomeDiv[i].toUpperCase()
					: "SOBRENOME " + i + "\t" + nomeDiv[i].toUpperCase());
		}
	}

	public static void continua() {
		limpaTela(2);
		System.out.println("Digite S para continuar:");
	}

	public static void nomeInvalido() {
		System.out.println("Nome nao pode ser vazio, insira novamente:");
	}
}
