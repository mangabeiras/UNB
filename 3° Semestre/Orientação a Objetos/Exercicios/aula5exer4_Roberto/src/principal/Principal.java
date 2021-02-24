package principal;

import dados.Conjunto;
import servicos.Servicos;
import validacao.Validacao;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {
		// DECLARACOES
		Conjunto nome = new Conjunto();
		
		// INTRUCOES
		Visao.intrucoesUso();
		do{
			do {
				nome.novoNome(Validacao.validaNome(nome.getQtdNomes()));
			} while (Validacao.validaContinua(nome));
			Servicos.mostraLista(nome);
		} while(Validacao.validaContinuaLista(nome));	 
	}
}
