package validacao;

import java.util.InputMismatchException;

import leitura.Leitura;
import visao.Visao;

public class Validacao {
	// CADASTRAR OUTRO USUARIO OU NAO
	public static boolean validaContinua() {
		Visao.continua();
		return ((Leitura.lerChar() == 'S') ? true : false);
	}
	
	public static char validaSexo(int i) {
		String sexo;
		Visao.pedirSexo(i);
		do {
			sexo = Leitura.lerString();
			if (sexo.isEmpty() || (!sexo.toLowerCase().equals("m") & !sexo.toLowerCase().equals("f"))) {
				Visao.erroSexo();
			}
		} while (sexo.isEmpty() || (!sexo.toLowerCase().equals("m") & !sexo.toLowerCase().equals("f")));
		return sexo.charAt(0);
	}

	public static int validaIdade() {
		int idade = 0;
		boolean erro = false;
		do {
			try {
				Visao.pedirIdade();
				idade = Leitura.lerInt();
				erro = false;
				if (idade < 0 || idade>120) {
					System.out.println("Insira um numero inteiro positivo e menor ou igual a "+120);
					erro = true;
				}
			} catch (InputMismatchException excecao) {
				System.out.println("Erro de entrada. Insira um numero INTEIRO positivo");
				erro = true;
			} 
		} while (erro);
		return idade;
	}
	public static int validaFilhos() {
		int filhos = 0;
		boolean erro = false;
		do {
			try {
				Visao.pedirFilhos();
				filhos = Leitura.lerInt();
				erro = false;
				if (filhos < 0 || filhos > 12) {
					System.out.println("Insira um numero inteiro positivo e menor que "+13);
					erro = true;
				}
			} catch (InputMismatchException excecao) {
				System.out.println("Erro de entrada. Insira um numero INTEIRO positivo");
				erro = true;
			} 
		} while (erro);
		return filhos;
	}
	public static float validaSalario() {
		float salario = 0;
		boolean erro= false;
		do {
			try {
				Visao.pedirSalario();
				salario = Leitura.lerFloat();
				erro = false;
				if (salario < 0){
					System.out.println("Insira um numero positivo");
					erro = true;
				}
			} catch (InputMismatchException excecao) {
				System.out.println("Insira apenas um numero");
				erro = true;
			}
		} while (erro);
		Visao.limpaTela(2);
		return salario;
	}
}
