package leitura;

import javax.swing.JOptionPane;

public class Leitura {
	// LE ENTRADA
	public static String leEntrada(String msg, String titulo) {
		return JOptionPane.showInputDialog(null, msg, titulo, JOptionPane.QUESTION_MESSAGE).trim();
	}
	// CONFIRMA (SIM OU NAO)
	public static char leConfirma(String msg) {
		String opcoes[] = {"Sim", "Nao"};
		return (char) JOptionPane.showOptionDialog(null, msg, "Confirma", 0, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
	}
}	
