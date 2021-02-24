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
		char escolha = 0;
		
		
		// INSTRUCOES
		do {
			try {
				String menu[] = {"Cadastrar Cidade", "Visualizar Cidades em Ordem Crescente"};
				switch(escolha = Leitura.leMenu(menu)) {
				case 0:
					StringBuilder nome;
					brasil.addCidade(new Cidade(nome = Validacao.validaNome(),Validacao.validaDdd(brasil, nome)));
					break;
				case 1:
					Visao.mostraRelatorio(brasil.getPaisCrescente()); // MOSTRA EM ORDEM DE DDD
					break;				
				default:
					escolha = Validacao.validaTermino(brasil); // VERIFICA SE O USUARIO QUER TERMINAR O PROGRAMA
				}
			} catch (NullPointerException excecao) {}; // PARAR O CADASTRO CASO O USUARIO CANCELE
		} while(escolha != 'x');
	}
}