package validacao;

import leitura.Leitura;
import servicos.Servicos;
import visao.Visao;

public class Validacao {
	public static StringBuilder validaNome(String lido) {
		// DECLARACOES
		StringBuilder nomeInicial = new StringBuilder();
		StringBuilder nomeFinal = new StringBuilder();

		// INSTRUCOES
		while (lido.trim().split(" ")[0].equals(lido.trim())) {
			Visao.nomeInvalido();
			lido = Leitura.lerLinha();
		}
		nomeInicial.append(lido.trim().split(" ")[0]);
		nomeFinal.append(lido.trim().split(" ")[lido.trim().split(" ").length - 1]);

		return (Servicos.concatena(nomeInicial, nomeFinal));
	}

	public static boolean validaContinua(String resposta) {
		return ((resposta.equals("S") ? true : false));
	}
}
