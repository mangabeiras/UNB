package principal;

import dados.Grupo;
import dados.Nome;
import saida.Visao;
import validacao.Validacao;

public class Principal {
	public static void main(String[] args) {
		Grupo grupo = null;
		
		do {
			int contador = 0;
			while (Validacao.validaCadastroNome()) {
				if (contador++ == 0)
					grupo = new Grupo(Validacao.validaNome());
				else
					grupo.adicionaNome(new Nome(Validacao.validaNome()));
			}
			grupo.mostraRelatorio(Validacao.validaRelatorio());
		} while (grupo.novoGrupo(Validacao.validaNovoGrupo()));
		Visao.mostraMensagem("A ultima lista teve " + grupo.getLista().size() + " nomes cadastrados");
	}
}
