package principal;

import dados.Cidade;
import dados.Pais;
import leitura.Leitura;
import validacao.Validacao;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {
		// DECLARACOES
		Pais brasil = new Pais();
		int opcao;
		
		// INSTRUCOES
		do {
			try {
				String []menu = {"Nova Cidade", "Pesquisa Cidade Contaminada"};
				opcao = Leitura.leMenu(menu);
	 			switch(opcao) {
	 			case 0:
	 				int contaminados;
	 				StringBuilder nome;
	 				brasil.addCidade(new Cidade(nome = Validacao.validaNome(), Validacao.validaEstado(brasil, nome), contaminados = Validacao.validaCasos(), Validacao.validaMortes(contaminados)));	
	 				break;
	 			case 1:
	 				Visao.mostraPesquisa(brasil);
	 				break;
	 			default:
	 				Visao.mostraRelatorio(brasil); // RELATORIO DE TODAS AS CIDADES CADASTRADADAS
	 				opcao = -1;
	 			}
 			} catch(NullPointerException excecao) {
 				opcao = 0;
 			}
		} while (opcao != -1);
	}
}
