package visao;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import dados.Cidade;
import dados.Pais;
import validacao.Validacao;

public class Visao {
	// MOSTRA MENSAGEM EM CAIXA DE DIALOGO
	public static void mostraMensagem(String msg, String titulo) {
		JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	// MOSTRA MENSAGEM DE ERRO EM CAIXA DE DIALOGO
	public static void mostraMensagemErro(String msg) {
		JOptionPane.showMessageDialog(null,  msg, "ERRO", JOptionPane.ERROR_MESSAGE);
	}
	// MOSTRA AS CIDADES QUE TENHAM NUMERO DE CONTAMINADOS MAIOR OU IGUAL QUE O INSERIDO
	public static void mostraPesquisa(Pais brasil) {
		DecimalFormat mascara = new DecimalFormat("00");
		int comparador = Validacao.validaInt("Insira uma quantidade de contaminados", "Pesquisa");
		
		if (brasil.hasMaior(comparador)) {
			limpaTela(50);
			System.out.println("Cidades com numero de contaminados maior ou igual a "+comparador+ ":\n");
			System.out.format("%-20s%-10s%-15s%-10s\n", "Cidade", "Estado", "Contaminados", "Mortos");
			brasil.mostraContaminados(comparador);
		} else
			mostraMensagem("Nao existem cidades com numero maior ou igual a " + mascara.format(comparador) + " de contaminados", "Sem Cidades");
	}
	
	public static void limpaTela(int saltos) {
		for (int i = 0; i < saltos; i++)
			System.out.println();
	}
	// RELATORIO DE TODAS AS CIDADES
	public static void mostraRelatorio(Pais brasil) {
		limpaTela(50);
		if (brasil.getPais().isEmpty())
			System.out.println("Sem cidades Cadastradas!");
		else {
			System.out.println("Cadastros Realizados:");
			System.out.format("%-20s%-10s%-15s%-10s\n", "Cidade", "Estado", "Contaminados", "Mortos");
			for (Cidade cidade : brasil.getPais())
				System.out.print(cidade);
		}
	}
}
