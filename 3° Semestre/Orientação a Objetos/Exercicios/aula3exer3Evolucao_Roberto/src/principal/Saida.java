package principal;

public class Saida {
	// TODAS AS SAIDAS DO PROGRAMA
	public static void pedirNome(int i) {
		System.out.print("PESSOA " + (i + 1) + "\nNome: ");
	}

	public static void pedirIdade() {
		System.out.print("Idade: ");
	}

	public static void pedirAltura() {
		System.out.print("Altura: ");
	}

	public static void continua() {
		System.out.println("Deseja cadastrar outro? (Digite S para continuar): ");
	}

	public static void erroAltura(float ALTURA_MIN, float ALTURA_MAX) {
		System.out.println("A altura precisa ser um numero entre " + ALTURA_MIN + " e " + ALTURA_MAX + ":");
	}

	public static void erroIdade(int IDMIN, int IDMAX) {
		System.out.println("A idade precisa ser um numero inteiro entre " + IDMIN + " e " + IDMAX + ":");
	}

	public static void erroNome() {
		System.out.print("Nome invalido! O nome deve ter pelo menos 3 caracteres.\nDigite o nome novamente: ");
	}

	public static void erroContinua() {
		System.out.print("Opção inválida! Continuar cadastrando?\nDigite 'S' para sim");
	}
	
	// RESULTADO FINAL AO USUARIO
	public static void mostraDados(Pessoa pessoa[], int i) {
		System.out.println("\t\tNOME\t\t\tIDADE\t\t\tALTURA");
		for (int aux = 0; aux < i; aux++) {
			System.out.println("PESSOA " + (aux + 1) + "\t" + pessoa[aux].getNome() + "\t\t\t" + pessoa[aux].getIdade()
					+ "\t\t\t" + pessoa[aux].getAltura());
		}
	}
}
