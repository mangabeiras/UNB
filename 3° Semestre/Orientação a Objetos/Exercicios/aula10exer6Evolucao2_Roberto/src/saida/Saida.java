package saida;

import java.util.List;

import javax.swing.JOptionPane;

import dados.Campeonato;
import dados.Time;
import leitura.Leitura;
// SAIDA
public class Saida {
	public static void limpaTela(int n) {
		for (int i = 0; i < n; i++)
			System.out.println();
	}
	
	public static void mostraMensagem(String msg, String titulo) {
		JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void mostraErro(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
	}
	// MOSTRA QUANTOS TIMES FORAM CADASTRADOS
	public static void mostraQtdTimes(int qtd) {
		limpaTela(5);
		System.out.println("Foram cadastrados "+String.format("%02d", qtd)+ " times.");
	}
	// DECIDE QUAL ORDEM DE TIMES O USUARIO ESCOLHEU
	public static void mostraOrdem(Campeonato campeonato) {		
		String []menu = {"Visualizar times em Ordem de Insercao", "Visualizar times em Ordem Alfabetica"};
		switch (Leitura.leMenu(menu)) {
		case 0: 
			mostraTimes(campeonato.getCampeonato());
			break;
		case 1:
			mostraTimes(campeonato.getCampeonatoOrdem());
		}
	}
	
	// MOSTRA COLECAO DE TIMES
	public static void mostraTimes(List<Time> campeonato) {
		limpaTela(50);
		if (campeonato.isEmpty()) 
			System.out.println("Sem times Cadastrados!");
		else {
			System.out.format("%-25s%-10s\n", "TIME", "Anos Campeao");
			for (Time time : campeonato) {
				System.out.print(time);
			}
		}
	}
}
