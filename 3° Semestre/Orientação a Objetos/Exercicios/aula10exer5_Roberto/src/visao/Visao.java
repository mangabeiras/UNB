package visao;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import dados.Cidade;

public class Visao {
	// MOSTRA MENSAGEM
	public static void mostraMensagem(String msg, String titulo) {
		JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	// MOSTRA MENSAGEM ERRO
	public static void mostraMensagemErro(String msg) {
		JOptionPane.showMessageDialog(null, msg, "ERRO", JOptionPane.WARNING_MESSAGE);
	}
	
	// MOSTRA RELATORIO
	public static void mostraRelatorio(ArrayList<Cidade> pais) {
		limpaTela(50);
		if (pais.isEmpty()) 
			System.out.println("Sem Cidades Cadastradas!");
		else {
			System.out.println("Cidades Cadastradas: ");
			System.out.format("%-15s%-10s\n", "Nome", "DDD");
			for (Cidade cidade : pais)
				System.out.print(cidade);
		}
	}
	// LIMPA TELA
	public static void limpaTela(int saltos) {
		for (int i = 0; i < saltos; i++)
			System.out.println();
	}
}
