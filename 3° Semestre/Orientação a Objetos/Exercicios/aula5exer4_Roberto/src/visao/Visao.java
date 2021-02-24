package visao;

// TODAS AS SAIDAS DO PROGRAMA
public class Visao {
	// INSTRUCOES INICIAIS DE ESCLARECIMENTO
	public static void intrucoesUso() {
		System.out.println("----INSTRUCOES INICIAIS----");
		System.out.println("-Nomes devem ter no minimo 3 caracteres;");
		System.out.println("-Se quieser parar de preencher, apenas aperte enter quando for cadastrar um novo nome;");
		System.out.println("-Apos terminar o preenchimento de uma lista, informe a maneira como deseja visualizá-la.");
		limpaTela(1);
	}
	public static void limpaTela(int saltos) {
		for (int i = 0; i < saltos; i++)
			System.out.println();
	}

	public static void pedeNome(int i) {
		System.out.print("NOME " + (i + 1) + ": ");
	}

	public static void continuaNome() {
		limpaTela(1);
		System.out.println("Tem certeza que deseja parar? Digite 'S' para confirmar: ");
	}

	public static void continuaLista() {
		System.out.println("Digite 'S' se desejar cadastrar outra lista:");
	}

	public static void erroNome(final int MIN) {
		System.out.print("O nome precisa ter mais que " + MIN + " caracteres. Insira novamente:");
	}

	public static void erroOrdemNum() {
		System.out.println("Coloque apenas 1, 2 ou 0. Insira novamente:");
	}
	
	// ORDEM DA LISTA
	public static void ordemLista() {
		limpaTela(2);
		System.out.println("Insira o numero que corresponde a maneira como deseja ver a lista.");
		System.out.println("1 - PARA VISUALIZAR NA ORDEM INSERIDA");
		System.out.println("2 - PARA VISUALIZAR NA ORDEM INVERSA DE INSERCAO");
		System.out.println("0 - PARA NAO VISUALIZAR A LISTA");
	}
	
	// RESULTADO FINAL
	public static void mostraNome(String nome) {
		System.out.println(nome);
	}
	// QUANTIDADE DE NOMES NA ULTIMA LISTA
	public static void nomesCadastrados(int i) {
		System.out.println("Quantidade de nomes cadastrados na ultima lista: "+i);
	}
}
