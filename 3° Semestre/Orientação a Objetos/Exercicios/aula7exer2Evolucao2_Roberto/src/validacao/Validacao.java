package validacao;

import javax.swing.JOptionPane;

import dados.Galeria;
import leitura.Leitura;
import saida.Visao;

public class Validacao {
	public static int validaEscolhaMenu() {
		String escolha;
		try {
			escolha = (String) JOptionPane.showInputDialog(null, "Escolha um item", "Menu", JOptionPane.INFORMATION_MESSAGE, null, Visao.menu(), Visao.menu()[0]);
			for (int contador = 0; contador < Visao.menu().length - 1; contador++) {
				if (escolha.equals(Visao.menu()[contador]))
					return (contador+1);
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Marque alguma opcao", "Invalido!", JOptionPane.ERROR_MESSAGE);
			return validaEscolhaMenu();
		}
		return 0;
	}
	
	public static String validaNome () {
		String nome;
		try {
			nome = (String) JOptionPane.showInputDialog(null, "Escreva o nome do pintor", "Nome do Pintor", JOptionPane.INFORMATION_MESSAGE);
			if (nome.length() < 3) {
				JOptionPane.showMessageDialog(null, "O nome deve conter ao menos 3 caracteres", "Nome Invalido!", JOptionPane.ERROR_MESSAGE);
				nome = validaNome();
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "É nessario que voce escreva algum nome", "Invalido!", JOptionPane.ERROR_MESSAGE);
			nome = validaNome();
		}
		
		return nome;
	}
	
	public static float validaPreco () {
		float preco;
		
		try {
			preco = Float.parseFloat(JOptionPane.showInputDialog(null, "Insira o preco do quadro", "Preco", JOptionPane.INFORMATION_MESSAGE));
			if (preco < 0) {
				JOptionPane.showMessageDialog(null, "O valor deve ser ao menos 0 (doado).", "Erro!", JOptionPane.ERROR_MESSAGE);
				return validaPreco();
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "A entrada deve ser numerica", "Erro!", JOptionPane.ERROR_MESSAGE);
			preco = validaPreco();
		}
		return preco;
	}
	
	public static int validaAno (String mensagem, final int MINIMO) {
		final int ATUAL = 2020;
		
		int ano = validaInteiro(mensagem);
		if (ano < MINIMO || ano > ATUAL) {
			JOptionPane.showMessageDialog(null, "O valor deve estar entre " + MINIMO + " e " + ATUAL +".", "Erro!", JOptionPane.ERROR_MESSAGE);
			ano = validaAno(mensagem, MINIMO);
		}
		return ano;
	}
	
	
	public static int validaCodigoPintor (Galeria galeria) {
		
		int codigoPessoal = validaInteiro("Determine o codigo do Pintor responsavel pelo quadro:");
		if (codigoPessoal < 1 || codigoPessoal >  galeria.getListaPintores().size()) {
			JOptionPane.showMessageDialog(null, "O valor do codigo deve ser ao menos 1 e pertencer a um pintor.", "Erro!", JOptionPane.ERROR_MESSAGE);
			codigoPessoal = validaCodigoPintor(galeria);
		}
		return codigoPessoal;
	}
	

	private static int validaInteiro (String mensagem) {
		int valor = -1;
		
		try {
			valor = Integer.parseInt(JOptionPane.showInputDialog(null, mensagem, "Entrada de Inteiro", JOptionPane.INFORMATION_MESSAGE));
			if (valor < 0) {
				JOptionPane.showMessageDialog(null, "O valor deve ser positivo", "Erro!", JOptionPane.ERROR_MESSAGE);
				valor = validaInteiro(mensagem);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "A entrada deve ser numerica", "Erro!", JOptionPane.ERROR_MESSAGE);
			valor = validaInteiro(mensagem);
		}
		return valor;
	}
	
}
