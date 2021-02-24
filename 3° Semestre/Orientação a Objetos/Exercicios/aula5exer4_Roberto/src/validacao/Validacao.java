package validacao;

import java.util.InputMismatchException;

import dados.Conjunto;
import leitura.Leitura;
import visao.Visao;

public class Validacao {
	public static String validaNome(int i) {
		final int TAM_MIN = 3;
		String nome;

		Visao.pedeNome(i);
		do {
			nome = Leitura.lerLinha();
			if (nome.length() < TAM_MIN && nome.length() > 0)
				Visao.erroNome(TAM_MIN);
		} while (nome.length() < TAM_MIN && nome.length() > 0);

		return nome;
	}

	public static boolean validaContinua(Conjunto nome) {
		char resposta = 0;
		// SE O USUARIO APENAS APERTAR ENTER NO CADASTRAMENTO DE NOMES
		if (nome.getNome(nome.getQtdNomes()-1).isEmpty()) {
			Visao.continuaNome();
			resposta = Leitura.lerChar();
			nome.excluirItem(nome.getQtdNomes()-1);
			
		}
		return ((resposta == 'S') ? false : true);
	}
	
	// O USUARIO QUER CADASTRAR OUTRA LISTA?
	public static boolean validaContinuaLista(Conjunto nome) {
		Visao.continuaLista();
		char resposta = Leitura.lerChar();
		if (resposta != 'S')
			Visao.nomesCadastrados(nome.getQtdNomes());
		else
			// ZERAR NOMES PARA OUTRA LISTA
			nome.zerarLista();
		return ((resposta == 'S') ? true : false);
	}
	
	// VALIDACAO DA ENTRADA DE 0,1 OU 2 DO USUARIO
	public static int validaEntradaOrdem() {
		int entrada = 0;
		boolean erro = false;
		do {
			try {
				erro = false;
				entrada = Leitura.lerInt();
				if (entrada > 2 || entrada < 0) {
					Visao.erroOrdemNum();
					erro = true;
				}
			} catch (InputMismatchException excecao) {
				Visao.erroOrdemNum();
				erro = true;
			}

		} while (erro);
		return entrada;
	}
}
