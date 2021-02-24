package validacao;

import leitura.Leitura;
import servicos.Servicos;
import visao.Visao;

public class Validacao {
	public static String[] validaNome(String lido) {
		while (lido.trim().length() == 0) {
			Visao.nomeInvalido();
			lido = Leitura.lerLinha();
		}
		Visao.limpaTela(2);
		return Servicos.quebraNome(lido);
	}

	public static boolean validaContinua(String resposta) {
		return ((!resposta.toUpperCase().equals("S") | resposta.trim().length() == 0) ? false : true);
	}
}
