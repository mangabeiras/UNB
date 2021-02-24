package principal;

import dados.Galeria;
import dados.Pintor;
import dados.Quadro;
import leitura.Leitura;
import saida.Visao;
import validacao.Validacao;

public class Principal {
	public static void main (String [] args) {
		// Declaracoes
		Galeria galeria = new Galeria();
		int escolha;
		
		// Instrucoes
		do {
			Visao.mostraMenu();
			escolha = Validacao.validaEscolhaMenu();
			Visao.limpaTela(50);
			switch (escolha) {
			case 1:
				if (galeria.getListaPintores().isEmpty())
					Visao.mostraMensagemErro("Erro, e necessario registra ao menos 1 pintor para acessar a opcao.");
				else
					registraQuadro(galeria);
				break;
			case 2:
				registraPintor(galeria);
				break;
			case 3:
				if (galeria.getListaQuadros().isEmpty())
					Visao.mostraMensagemErro("Erro, e necessario registra ao menos 1 quadro para acessar a opcao.");
				else
					Visao.mostraQuadrosNome(galeria, Leitura.lerEntrada("Digite o nome a ser procurado:"));
				break;
			case 4:
				if (galeria.getListaQuadros().isEmpty())
					Visao.mostraMensagemErro("Erro, e necessario registra ao menos 1 quadro para acessar a opcao.");
				else
					Visao.mostraQuadros(galeria);
			}
			Visao.limpaTela(10);
		} while (escolha != 0);
	}
	
	
	// === Outros Metodos ==============
	public static void registraPintor (Galeria galeria) {
		galeria.setPintor(new Pintor(
			Validacao.validaNome("Determine o nome do Pintor:"), 
			Validacao.validaCodigoPessoal(galeria, "Determine o codigo do Pintor:"), 
			Validacao.validaAno("Determine o ano de nascimento do pintor:")
		));
	}
	
	public static void registraQuadro (Galeria galeria) {
		galeria.setQuadro(new Quadro(
			Validacao.validaCodigoQuadro(galeria, "Determine o codigo do Quadro:"), 
			Validacao.validaCodigoPintor(galeria, "Determine o codigo do Pintor responsavel pelo quadro:"), 
			Validacao.validaPreco("Determine o preco do quadro: [0 caso tenha sido doado]"), 
			Validacao.validaAno("Determine o ano da compra do quadro:")
		));
	}
}