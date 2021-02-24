package principal;

import dados.*;
import saida.Visao;
import validacao.Validacao;

public class Principal {
	public static void main(String[] args) {
		Turma alunos = new Turma();
		do {
			Aluno aluno = new Aluno(Validacao.validaNome(), Validacao.validaMatricula(alunos), Validacao.validaMedia());
			alunos.setAluno(aluno);
		} while (Validacao.isContinuaCadastro());

		Visao.mostraRelatorio(alunos);
	}
}
