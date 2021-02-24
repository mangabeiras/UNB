package leitura;

import javax.swing.JOptionPane;

public class Leitura {
	// LE STRING DE ENTRADA
	public static String leEntrada(String msg, String titulo) {
		return JOptionPane.showInputDialog(null, msg, titulo, JOptionPane.QUESTION_MESSAGE);
	}
	// LE OPCOES DE UM MENU
	public static char leMenu(String[] opcoes) {
		return (char) JOptionPane.showOptionDialog(null, "Escolha", "Menu", 0, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
	}
	// LE SIM OU NAO
	public static int confirma(String msg) {
		String opcoes[] = {"Sim", "Nao"};
		return JOptionPane.showOptionDialog(null, msg, "Cancelamento", 0, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
	}
}
