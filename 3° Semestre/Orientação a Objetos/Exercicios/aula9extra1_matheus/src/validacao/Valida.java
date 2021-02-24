package validacao;

import dados.Cidade;
import dados.Cidades;
import leitura.Leitura;
import saida.Saida;

public class Valida {
	public static Integer menu() {
		Integer opcao = null;
		String mensagem = "Escolha uma opção por favor: ";
		String titulo = "Menu";
		String botoes[] = { "Nova Cidade", "Pesquisa Cidade Contaminada" };

		try {
			opcao = Leitura.optionDialog(mensagem, titulo, botoes);
		} catch (NullPointerException e) {
			System.exit(0);
		}

		return opcao;
	}

	public static Integer inteiros(String mensagem, String titulo) {
		Boolean erro = false;
		String inputUsuario;
		Integer inteiro = 0;

		do {
			erro = false;

			try {
				inputUsuario = Leitura.inputDialog(mensagem, titulo);
				if (inputUsuario.length() < 1) {
					return 0;
				}
				try {
					inteiro = Integer.parseInt(inputUsuario);
				} catch (NumberFormatException e) {
					Saida.errorDialog("Insira apenas números inteiros!");
					erro = true;
				}
			} catch (NullPointerException e) {
				System.exit(0);
			}

		} while (erro);
		return inteiro;
	}

	public static String strings(String mensagem, String titulo, Integer requisito) {
		String string;

		string = Leitura.inputDialog(mensagem, titulo);

		if (string == null)
			System.exit(0);

		if (requisito > 0 && string.length() <= 3) {
			Saida.messageDialog("Por favor, insira um nome com mais de 3 caractéres!");
			strings(mensagem, titulo, requisito);
		}

		return string;
	}

	public static Boolean validaCidade(Cidades cidades, Cidade cidade) {
		for (Cidade c : cidades.getCidades()) {
			if (cidade.equals(c))
				return false;
		}
		return true;
	}
}
