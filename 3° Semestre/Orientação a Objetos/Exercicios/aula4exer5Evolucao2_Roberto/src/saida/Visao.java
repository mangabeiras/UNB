package saida;
// TODAS AS SAIDAS DO PROGRAMA
public class Visao {

	public static void limpaTela(int linhas) {
		for (int i = 0; i <= linhas; i++) {
			System.out.println();
		}
	}
	// RESULTADO FINAL
	public static void padraoAereo(StringBuilder padrao) {
		System.out.println("\tPADRAO AEREO\n\t"+padrao.toString().toUpperCase());
		continua();
	}
		
	public static void pedirNome() {
		System.out.println("Informe o nome completo do passageiro:");
	}
	public static void continua() {
		limpaTela(3);
		System.out.println("Digite S para continuar inserindo:");
	}
		
	public static void nomeInvalido() {
		System.out.println("Invalido! Insira nome e sobrenome:");
	}
}

