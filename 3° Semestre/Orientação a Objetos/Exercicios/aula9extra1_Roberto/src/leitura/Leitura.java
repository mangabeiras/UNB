package leitura;

import javax.swing.JOptionPane;

public class Leitura {
	// LEITURA DE ENTRADA
	public static String leEntrada(String msg, String titulo) {
		return JOptionPane.showInputDialog(null, msg, titulo, JOptionPane.QUESTION_MESSAGE);
	}
	// LEITURA DE MENU
	public static char leMenu(String[] opcoes) {
		return (char) JOptionPane.showOptionDialog(null, "Marque uma Opcaos", "MENU", 0, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
	}
}
