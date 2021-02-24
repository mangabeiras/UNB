package saida;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Saida {
	public static void messageDialog(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Atenção!", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void errorDialog(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "ERRO!", JOptionPane.WARNING_MESSAGE);
	}

	public static void limpaTela(int qtd) {
		for (int i = 0; i < qtd; i++)
			System.out.println();
	}

}
