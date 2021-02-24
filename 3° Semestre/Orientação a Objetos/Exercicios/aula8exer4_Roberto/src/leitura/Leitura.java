package leitura;

import javax.swing.JOptionPane;

public class Leitura {
	// LEITURA DE STRING POR MEIO DE JANELA DE DIALOGO
	public static String leEntrada(String msg, String titulo) {
		return JOptionPane.showInputDialog(null, msg, titulo, JOptionPane.QUESTION_MESSAGE).trim();
	}
	// LEITURA DE MENUS POR MEIO DE JANELA DE DIALOGO
	public static int leMenu(String[] opcoes) {
		return JOptionPane.showOptionDialog(null, "Escolha uma opcao", "MENU", 0, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
	}
}
