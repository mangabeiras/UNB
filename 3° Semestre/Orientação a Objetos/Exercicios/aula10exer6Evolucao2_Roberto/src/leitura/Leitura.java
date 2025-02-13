package leitura;

import javax.swing.JOptionPane;
// LEITURA
public class Leitura {
	public static String solicitaDado(String msg, String titulo) {
		return JOptionPane.showInputDialog(null, msg, titulo, JOptionPane.PLAIN_MESSAGE);
	}
	
	public static char leMenu(String[] menu) {
		return (char)JOptionPane.showOptionDialog(null, "Escolha uma opcao", "Menu", 0, JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
	}
	public static char yesNo(String msg) {
		String[] menu = {"Sim", "Nao"};
		return (char) JOptionPane.showOptionDialog(null, msg, "Deseja continuar?", 0, JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
	} 
}
