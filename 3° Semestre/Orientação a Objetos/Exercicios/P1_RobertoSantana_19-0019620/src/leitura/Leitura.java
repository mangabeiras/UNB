package leitura;

import javax.swing.JOptionPane;


public class Leitura {
	/*public static String leEntrada(String msg, String titulo) {
		return new Entrada(msg, titulo).getEntrada();
	}*/
	public static int leOpcoes(String mensagem, String []opcoes) {
		return JOptionPane.showOptionDialog(null, mensagem, "Marque uma Opcao", 0, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
	}
	public static int leConfirma(String msg) {
		String opcoes[] = {"Sim", "Nao"};
		return JOptionPane.showOptionDialog(null, msg, "Confirmacao", 0, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
	}
}
