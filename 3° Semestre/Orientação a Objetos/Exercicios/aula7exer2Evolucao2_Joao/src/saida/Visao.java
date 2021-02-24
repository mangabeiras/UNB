package saida;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import dados.Galeria;
import dados.Pintor;
import dados.Quadro;

public class Visao {
	public static void mostraMensagem (String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void mostraMensagemErro (String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void mostraMensagemAlerta (String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Alerta", JOptionPane.WARNING_MESSAGE);
	}
	
	public static int mostraMenu (String mensagem, String [] opcao) {
		return JOptionPane.showOptionDialog(null, mensagem, "Menu", 0, JOptionPane.INFORMATION_MESSAGE, null, opcao, opcao[0]);
	}
	
	public static void mostraQuadros (Galeria galeria) {
		int indice = 1;
		
		limpaTela(50);
		System.out.format("%-8s%-30s%-30s%-20s%-20s\n", "INDICE", "IDENTIFICACAO PINTOR", "IDENTIFICACAO QUADRO", "PRECO", "ANO AQUISICAO");
		for (Pintor pintor :galeria.getListaPintores()) {
			for (Quadro quadro : pintor.getListaQuadros()) {
				System.out.println(new DecimalFormat("00").format(indice++) + pintor + quadro);
			}
		}
	}
	
	public static void mostraQuadrosNome (Galeria galeria, String nome) {
		int indice = 0;
		float total = 0f;
		
		limpaTela(50);
		for (Pintor pintor : galeria.getListaPintores()) {
			if (pintor.getNome().toUpperCase().contains(nome.toUpperCase())) {
				if (indice == 0) {
					System.out.println("Quadro(s) encontrado(s) com [" + nome + "].");
					System.out.format("%-8s%-30s%-30s%-20s%-20s\n", "INDICE", "IDENTIFICACAO PINTOR", "IDENTIFICACAO QUADRO", "PRECO", "ANO AQUISICAO");
				}
				
				for (Quadro quadro : pintor.getListaQuadros()) {
					total += quadro.getPreco();
					System.out.println(new DecimalFormat("00").format(indice++ + 1) + pintor + quadro);
				}
			}
		}
		
		if (indice == 0) {
			mostraMensagemErro("Nenhum quadro encontrado para o pintor [" + nome + "].");
		}
		else {
			limpaTela(2);
			System.out.println("Soma total dos valores dos quadros: " + new DecimalFormat("0.00").format(total));
		}
	}
	
	public static void limpaTela (int qtd) {
		for (int i = 0; i < qtd; i++)
			System.out.println();
	}
}
