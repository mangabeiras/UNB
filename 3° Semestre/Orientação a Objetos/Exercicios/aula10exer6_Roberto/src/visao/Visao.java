package visao;

import javax.swing.JOptionPane;

import dados.Time;
// VISAO
public class Visao {
	
	public static void mostraMensagem(String msg, String titulo) {
		JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	// MOSTRA MENSAGEM DE ERRO EM JOPTION
	public static void mostraMensagemErro(String msg) {
		JOptionPane.showMessageDialog(null, msg, "ERRO", JOptionPane.WARNING_MESSAGE);
	}
	
	public static void limpaTela(int saltos) {
		for (int i = 0; i < saltos; i++)
			System.out.println();
	}
	// MOSTRA ANOS EM ORDEM CRESCENTE
	public static void mostraAnos(Time time) {
		limpaTela(50);
		if (time.getAnos().isEmpty())
			System.out.println("Time ainda nao foi Campeao!");
		else {
			System.out.println("Time: "+time.getNome().toString().toUpperCase());
			System.out.print("Anos em que foi Campeao: ");
			for (Integer ano : time.getAnosOrdem()) {
				System.out.print(" "+ano+" ");
			}
		}
	}
	// MOSTRA QUANTIDADE DE TIMES CADASTRADOS
	public static void mostraQtdTimes(int contador) {
		limpaTela(50);
		System.out.println("Foram cadastrados "+ String.format("%02d", contador)+ " Times!");
	}
}
