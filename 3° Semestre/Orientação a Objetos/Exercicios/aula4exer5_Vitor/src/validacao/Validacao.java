package validacao;

import leitura.Leitura;
import saida.Servicos;

public class Validacao {

	public static String validaNome() {
		String nome;

		System.out.println("Nome: ");

		nome = Leitura.lerNome().toUpperCase();

		while (nome.length() < 3 || nome.equals(null) || nome.trim().equals("")) {
			Servicos.limpaTela(20);
			
			if(nome.equals(null) || nome.trim().equals("")) {
				System.out.println("Nenhum nome foi informado, por favor informe um nome valido: ");
				nome = Leitura.lerNome().toUpperCase();
			}else {
				System.out.print("Nome invalido! O nome deve ter pelo menos 3 caracteres.\nDigite o nome novamente: ");
				nome = Leitura.lerNome().toUpperCase();
			}

		}

		nome = nome.concat("/");

		int ultimoEspaço = nome.lastIndexOf(" ");
		int primeiroEspaco = nome.indexOf(" ");

		nome = nome.substring(ultimoEspaço) + nome.substring(0, primeiroEspaco);

		return nome;

	}

	public static boolean validaContinua() {
		// Declaracoes
		char opcao;

		// Instrucoes
		System.out.println("\nDeseja continuar cadastrando?\n Digite 'S' para sim e 'N' para sair do programa: ");
		opcao = Leitura.lerChar();
		Servicos.limpaTela(30);

		while ((opcao != 'S') && (opcao != 'N')) {
			Servicos.limpaTela(30);
			System.out.print(
					"Opção inválida! Continuar cadastrando?\nDigite 'S' para sim e 'N' para encerrar o programa: ");
			opcao = Leitura.lerChar();
		}
		if (opcao == 'N') {
			System.out.println("Ate mais!");
		}

		return ((opcao == 'S') ? true : false);
	}

}
