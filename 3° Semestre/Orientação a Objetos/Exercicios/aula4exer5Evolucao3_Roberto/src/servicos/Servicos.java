package servicos;

import saida.Saida;
// METODO QUE JUNTA O NOME INICIAL E FINAL
	public class Servicos {
	public static StringBuilder concatena(StringBuilder nome, StringBuilder sobrenome) {
		Saida.limpaTela(2);
		return (sobrenome.append("/"+nome));
	}
}
