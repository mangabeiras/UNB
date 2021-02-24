package leitura;

import javax.swing.JOptionPane;

public class Leitura {
	public static String inputDialog(String mensagem, String titulo) {
		return JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE);
	}

	public static int optionDialog(String mensagem, String titulo, String botoes[]) {
		return JOptionPane.showOptionDialog(null, mensagem, titulo, JOptionPane.DEFAULT_OPTION, botoes.length, null,
				botoes, botoes[0]);
	}
}
