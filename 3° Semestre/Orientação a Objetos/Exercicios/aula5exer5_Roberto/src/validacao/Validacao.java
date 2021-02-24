package validacao;

import leitura.Leitura;
import visao.Visao;

import java.util.InputMismatchException;

import dados.Discentes;

public class Validacao {
	public static String validaNome(int i) {
		final int MIN = 3;
		String nome;
		Visao.limpaTela((i!=0)?20:0);
		Visao.pedeNome(i);
		do {
			nome = Leitura.lerLinha().trim();
			if (nome.length() < MIN)
				Visao.erroNome(MIN);
		} while (nome.length() < MIN);
		return nome;
	}
	
	// VALIDACAO DA MATRICULA
	public static int validaMatricula(Discentes alunos) {
		// DECLARACOES
		final int MAX = 1000;
		int matricula = 0, contador=0;
		
		// INSTRUCOES 
		Visao.pedeMatricula();
		boolean erro = false;
		do {
			erro = false;
			contador = alunos.getTamanho()-1;
			try {
				matricula = Leitura.lerInt();
				if (matricula < MAX) { // MATRICULA E MENOR QUE 1000?
					Visao.erroMatricula(MAX);
					erro = true;
				}
			} catch (InputMismatchException excecao) {
				Visao.erroMatricula(MAX);
				erro= true;
			}
			while (contador >= 0) { // AVALIAR SE A MATRICULA E REPETIDA
				if(matricula == alunos.getMatricula(contador--)) {
					Visao.erroMatricula(MAX);
					erro = true;
					break;
				}
			}
		} while (erro);
		
		return matricula;
	}
	public static float validaMedia() {
		float media = 0;
		Visao.pedeMedia();
		boolean erro = false;
		do {
			erro = false;
			try {
				media = Leitura.lerFloat();
				if (media < 0 || media > 10) {
					Visao.erroMedia();
					erro = true;
				}
			} catch(InputMismatchException excecao) {
				Visao.erroMedia();
				erro = true;
				}
		} while(erro);
		return media;
	}
	
	public static boolean validaContinua() {
		Visao.continua();
		return (Leitura.lerLinha().toUpperCase().equals("S")?true:false);
	}
}
