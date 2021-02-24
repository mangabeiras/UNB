package servicos;

import dados.Discentes;
import visao.Visao;

public class Servicos {
	// MOSTRA O RESULTADO ATRAVES DA CLASSE VISAO
	public static void resultadoFinal(Discentes alunos) {
		float mediaTotal=0;
		
		Visao.limpaTela(50);
		Visao.montaTabela();
		for (int i=0;i<alunos.getTamanho();i++) {
			mediaTotal += alunos.getMedia(i);
			Visao.corpoTabela(alunos.getMatricula(i), alunos.getNome(i), alunos.getMedia(i));
		}
		Visao.mediaAritmetica(mediaTotal/alunos.getTamanho());
	}
}	
