package validacao;

import java.util.InputMismatchException;
import leitura.Leitura;
import saida.Saida;

public class Validacao {
	public static boolean validaContinua() {
		String opcao;
		System.out.println("Deseja continuar cadastrando?\n Digite 'S' para sim e 'N' para nao");
		do {
			opcao = Leitura.leLinha();
			if (!opcao.toLowerCase().equals("s") && !opcao.toLowerCase().equals("n"))
				System.out.print("Opcao invalida! Insira apenas S ou N");
		} while (!opcao.toLowerCase().equals("s") && !opcao.toLowerCase().equals("n"));
		return (opcao.toLowerCase().charAt(0) == 's');
	}

	public static float validaSalario() {
		
		float salario = -1f;

		System.out.print("Salario: ");
		try {
			salario = Leitura.leituraFloat();
			if (salario < 0f) {
				System.out.println("Valor invalido!\nSalario nao pode ser menor que R$: 0.00");
				salario = validaSalario();
			}
			} catch (InputMismatchException excecao) {
				System.out.println("Invalido! Digite apenas numeros!");
				salario = validaSalario();
			}
		return salario;
	}

	public static int validaIdade() {
		int idade = 0;

		System.out.print("Idade: ");
		try {
			idade = Leitura.leituraInt();
			if (idade <= 0 || idade >= 151) {
				System.out.println("Valor invalido!\nIdade tem que ser maior que zero e menor que 151");
				idade = validaIdade();
			}
		} catch (InputMismatchException excecao) {
			System.out.println("Invalido .Digite apenas numeros!");
			idade = validaIdade();
		}
		return idade;
	}

	public static char validaSexo(int contador) {
		String sexo;
		
		Saida.limpaTela((contador == 1)?0:30);
		System.out.println("HABITANTE "+contador);
		do {
			System.out.print("Sexo (M ou F): ");
			sexo = Leitura.leLinha();
			if (!sexo.toLowerCase().equals("m") && !sexo.toLowerCase().equals("f"))
				System.out.println("Opcao invalida! Digite apenas M ou F.");
		} while (!sexo.toLowerCase().equals("m") && !sexo.toLowerCase().equals("f"));
		return sexo.toUpperCase().charAt(0);
	}

	public static int validaNumeroFilhos() {
		
		int numeroFilhos = -1;

		do {
			System.out.print("Quantidade de Filhos: ");
			try {
				numeroFilhos = Leitura.leituraInt();
				if (numeroFilhos < 0 || numeroFilhos >= 100)
					System.out.println(
							"Valor inválido!\nNúmero de filhos tem que ser maior ou igual a zero e menor que 100");
			} catch (InputMismatchException excecao) {
				System.out.println("Ocorreu um  erro.");
			}
		} while (numeroFilhos < 0 || numeroFilhos >= 100);
		return numeroFilhos;
	}
}
