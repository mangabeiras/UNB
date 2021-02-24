package principal;

import dados.Grupo;
import saida.Visao;
import validacao.Validacao;

public class Principal {
	public static void main(String[] args) {
		Grupo grupo = null;

		do {
			grupo = (grupo == null || !grupo.getNomes().isEmpty())? new Grupo(): grupo;
			
			while (Validacao.validaCadastroNome()) {
				grupo.setNomes(Validacao.validaNome());
				Visao.limpaTela(2);
			}

			Visao.limpaTela(50);
			if (!grupo.getNomes().isEmpty()) {
				Visao.mostraRelatorio(grupo);
			}
			
			Visao.limpaTela(50);
		} while (Validacao.validaNovoGrupo());
		Visao.mostraMensagem("A ultima lista teve " + grupo.getNomes().size() + " nomes cadastrados");
	}
}
