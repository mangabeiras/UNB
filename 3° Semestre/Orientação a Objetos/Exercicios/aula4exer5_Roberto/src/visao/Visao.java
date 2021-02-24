package visao;
// TODAS AS SAIDAS
public class Visao {
	public static void limpaTela(int saltos) {
		for (int i=0;i<saltos;i++)
			System.out.println();
	}
	public static void padraoAereo(StringBuilder padrao) {
		System.out.println("\tPADRAO AEREO\n\t"+padrao.toString().toUpperCase());
	}
	
	public static void pedirNome() {
		System.out.println("Informe o nome completo do passageiro:");
	}
	public static void continua() {
		limpaTela(2);
		System.out.println("Digite S para continuar inserindo:");
	}
	
	public static void nomeInvalido() {
		System.out.println("Invalido! Insira nome e sobrenome:");
	}
}
