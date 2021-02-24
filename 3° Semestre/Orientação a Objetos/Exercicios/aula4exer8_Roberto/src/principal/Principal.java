package principal;

import dados.Grupo;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {
		// DECLARACOES
		final int QTDVENDEDORES = 4;
		Grupo grupo = new Grupo(QTDVENDEDORES);

		// INSTRUCOES
		grupo.atribuiGrupo(QTDVENDEDORES);
		Visao.mostraTabela(grupo, QTDVENDEDORES);
	}
}
