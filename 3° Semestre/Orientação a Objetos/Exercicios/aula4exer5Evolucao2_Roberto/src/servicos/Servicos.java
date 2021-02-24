package servicos;

import saida.Visao;
// METODO QUE JUNTA O NOME INICIAL E FINAL
	public class Servicos {
	public static StringBuilder concatena(StringBuilder nome, StringBuilder sobrenome) {
		Visao.limpaTela(2);
		return (sobrenome.append("/"+nome));
	}
}
