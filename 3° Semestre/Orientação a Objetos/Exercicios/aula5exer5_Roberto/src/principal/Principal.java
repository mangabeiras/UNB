package principal;

import dados.Discentes;
import servicos.Servicos;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {
		// DECLARACOES
		Discentes aluno = new Discentes();

		// INSTRUCOES
		do {
			aluno.criaAluno(Validacao.validaNome(aluno.getTamanho()), Validacao.validaMatricula(aluno),
					Validacao.validaMedia());
		} while (Validacao.validaContinua());
		Servicos.resultadoFinal(aluno);
	}
}
