package visao;

import java.text.DecimalFormat;

import dados.Grupo;

public class Saida {
	public static void continua() {
		System.out.println("Digite S se quiser continuar");
	}

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}

	public static void pedirNome(int i) {
		System.out.print("PESSOA " + (i + 1) + "\nNome: ");
	}

	public static void pedirIdade() {
		System.out.print("Idade: ");
	}

	public static void pedirAltura() {
		System.out.print("Altura: ");
	}

	public static void erroNome() {
		System.out.println("Nome invalido! O nome deve ter pelo menos 3 caracteres.\nDigite o nome novamente: ");
	}

	public static void erroAltura(float altura_min, float altura_max) {
		System.out.println("A altura deve possuir entre " + altura_min + " e " + altura_max + ". Insira novamente:");
	}

	public static void erroIdade(int idmin, int idmax) {
		System.out.println("A idade precisa estar entre " + idmin + " e " + idmax + ". Insira novamente:");
	}

	// RESULTADO FINAL
	public static void mostraResultado(Grupo grupo, int i) {
		DecimalFormat centesimo = new DecimalFormat("0.00");
		limpaTela(50);
		System.out.println("\t\t     NOME\t\tIDADE\t\tALTURA");

		for (int aux = 0; aux < i; aux++) {
			System.out.println("PESSOA " + (aux + 1) + "\t     " + grupo.getPessoa(aux).getNome() + "\t\t"
					+ grupo.getPessoa(aux).getIdade() + "\t\t" + centesimo.format(grupo.getPessoa(aux).getAltura()));
		}
	}
}
