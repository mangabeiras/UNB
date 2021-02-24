package servicos;

import visao.Visao;

public class Servicos {
	public static StringBuilder concatena(StringBuilder nome, StringBuilder sobrenome) {
		Visao.limpaTela(2);
		return (sobrenome.append("/"+nome));
	}
}
