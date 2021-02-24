package saida;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dados.Pessoa;

public class Saida {

	public static void exibirMensagem(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);
	}

	public static void exibirRelatorio(ArrayList<Pessoa> populacao) {
		String formato = "                    ";
		DecimalFormat mascara = new DecimalFormat("00");

		limpaTela(40);
		System.out.println(formato + mascara.format(qtdPessoasNaoContaminada(populacao)) + " = NAO CONTAMINADAS");
		System.out.println(formato + mascara.format(qtdPessoasContaminadaPorSituacao(populacao, 'E', '-'))
				+ " = CONTAMINADAS EM TRATAMENTO");
		System.out.println(formato + mascara.format(qtdPessoasContaminadaPorSituacao(populacao, 'C', '-'))
				+ " = CONTAMINADAS CURADAS");
		System.out.println(formato + mascara.format(qtdPessoasContaminadaPorSituacao(populacao, 'F', 'F'))
				+ " = MULHERES CONTAMINADAS FALECIDAS");
		System.out.println(formato + mascara.format(qtdPessoasContaminadaPorSituacao(populacao, 'F', 'M'))
				+ " = HOMENS CONTAMINADOS FALECIDOS");
		System.err.print(formato + mascara.format(populacao.size()) + " = TOTAL DE PESSOAS CADASTRADAS");
	}

	// QUANTIDADE TOTAL DE PESSOAS NAO CONTAMINADAS
	private static int qtdPessoasNaoContaminada(ArrayList<Pessoa> populacao) {
		int quantidade = 0;
		for (Pessoa pessoa : populacao) {
			if (pessoa.getIdade() != null)
				quantidade++;
		}
		return quantidade;
	}

	// QUANTIDADE DE PESSOAS CONTAMINADAS (POR SITUACAO)
	private static int qtdPessoasContaminadaPorSituacao(ArrayList<Pessoa> populacao, char situacao, char genero) {
		int quantidade = 0;

		for (Pessoa pessoa : populacao) {
			// EM TRATAMENTO
			if (pessoa.getIdade() == null && pessoa.getSituacao().charAt(0) == situacao && situacao == 'E')
				quantidade++;
			// CURADA
			else if (pessoa.getIdade() == null && pessoa.getSituacao().charAt(0) == situacao && situacao == 'C')
				quantidade++;
			// FALECIDA
			else if (pessoa.getIdade() == null && pessoa.getSituacao().charAt(0) == situacao && situacao == 'F')
				if (pessoa.getGenero() == genero && genero == 'M')
					quantidade++;
				else if (pessoa.getGenero() == genero && genero == 'F')
					quantidade++;
		}

		return quantidade;
	}

	// LIMPAR A CONSOLE
	public static void limpaTela(int linhasPuladas) {
		for (int aux = 0; aux < linhasPuladas; aux++)
			System.out.println();
	}
}