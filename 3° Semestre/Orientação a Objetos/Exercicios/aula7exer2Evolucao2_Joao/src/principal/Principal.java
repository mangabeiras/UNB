package principal;

import dados.Galeria;
import saida.Visao;
import servicos.Servicos;
import validacao.Validacao;

public class Principal {
	public static void main (String [] args) {
		// Atributos
		Galeria galeria = new Galeria();
		int escolha;
		
		// Metodos
		do {
			String [] opcao = {"Cadastrar Novo Pintor", "Cadastrar Novo Quadro", "Listar Quadro(s) de um Pintor", "Mostrar todo(s) Quadro(s)", "Encerrar Programa"};
			escolha = Visao.mostraMenu("Escolha uma opcao.", opcao);
			switch (escolha) {
			case 0:
				Servicos.registraPintor(galeria);
				break;
			case 1:
				if (galeria.getListaPintores().isEmpty()) {
					Visao.mostraMensagemErro("Erro, e necessario registra ao menos 1 pintor para acessar a opcao.");
				}
				else {
					Servicos.registraQuadro(galeria);
				}
				break;
			case 2:
				if (!galeria.isAlgumQuadroRegistrado()) {
					Visao.mostraMensagemErro("Erro, e necessario registra ao menos 1 quadro para acessar a opcao.");
				}
				else {
					Visao.mostraQuadrosNome(galeria, Validacao.validaNome("Digite o nome a ser procurado:", "Procura Quadros"));
				}
				break;
			case 3:
				if (!galeria.isAlgumQuadroRegistrado()) {
					Visao.mostraMensagemErro("Erro, e necessario registra ao menos 1 quadro para acessar a opcao.");
				}
				else {
					Visao.mostraQuadros(galeria);
				}
			}
		} while (escolha != 4 && escolha != -1);
	}
}