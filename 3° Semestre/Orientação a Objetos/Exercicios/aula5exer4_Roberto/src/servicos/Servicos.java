package servicos;

import dados.Conjunto;
import validacao.Validacao;
import visao.Visao;

public class Servicos {
	public static void mostraLista(Conjunto nome) {
		Visao.ordemLista();
		int entrada = Validacao.validaEntradaOrdem();
		if (entrada == 1)
			mostraOrdem1(nome);
		if (entrada == 2)
			mostraOrdem2(nome);
		Visao.limpaTela(1);
	}
	public static void mostraOrdem1(Conjunto nome) {
		Visao.limpaTela(50);
		for (int i = 0; i < nome.getQtdNomes(); i++)
			Visao.mostraNome(nome.getNome(i));
	}
	public static void mostraOrdem2(Conjunto nome) {
		Visao.limpaTela(50);
		for (int i = (nome.getQtdNomes() - 1); i >= 0; i--)
			Visao.mostraNome(nome.getNome(i));
	}
}
