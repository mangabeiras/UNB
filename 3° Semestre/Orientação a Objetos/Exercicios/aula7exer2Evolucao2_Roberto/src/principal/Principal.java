package principal;

import javax.swing.JOptionPane;

import dados.Galeria;
import dados.Pintor;
import dados.Quadro;
import leitura.Leitura;
import saida.Visao;
import validacao.Validacao;

public class Principal {
	public static void main(String[] args) {
		// ATRIBUTOS
		final int ANONIMO = 1000;
		Galeria galeria = new Galeria();
		int escolha;

		// METODOS
		galeria.addPintor(new Pintor(Validacao.validaNome(), (galeria.getListaPintores().size()),
				Validacao.validaAno("Determine o ano de nascimento do pintor:", ANONIMO)));
		JOptionPane.showMessageDialog(null, "Codigo gerado para o pintor: " + (galeria.getListaPintores().size()),
				"Codigo!", JOptionPane.INFORMATION_MESSAGE);
		
		do {
			escolha = Validacao.validaEscolhaMenu();
			switch (escolha) {
			case 1:
				int indice = Validacao.validaCodigoPintor(galeria) - 1;
				galeria.getListaPintores().get(indice)
						.addQuadro(new Quadro(galeria.getQuantidadeQuadros() + 1, (indice + 1), Validacao.validaPreco(),
								Validacao.validaAno("Determine o ano da compra do quadro:",
										galeria.getListaPintores().get(indice).getAnoNascimento())));
				JOptionPane.showMessageDialog(null, "Codigo gerado para o Quadro: " + galeria.getQuantidadeQuadros(),
						"Codigo!", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 2:
				galeria.addPintor(new Pintor(Validacao.validaNome(), galeria.getListaPintores().size(),
						Validacao.validaAno("Determine o ano de nascimento do pintor:", ANONIMO)));
				JOptionPane.showMessageDialog(null,
						"Codigo gerado para o pintor: " + (galeria.getListaPintores().size()), "Codigo!",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			case 3:
				Visao.mostraQuadrosNome(galeria, JOptionPane.showInputDialog(null, "Digite o nome a ser procurado: ",
						"Nome do Pintor", JOptionPane.INFORMATION_MESSAGE));
				break;
			case 4:
				Visao.mostraQuadros(galeria);
			}
		} while (escolha != 0);
	}
}