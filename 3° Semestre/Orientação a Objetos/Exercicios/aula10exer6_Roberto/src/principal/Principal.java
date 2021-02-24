package principal;

import dados.Time;

import validacao.Validacao;
import visao.Visao;

public class Principal {
	public static void main(String[] args) {
		// DECLARACOES
		int contador = 0;
		
		// INSTRUCOES
		do {
			try {
				Time time = new Time(Validacao.validaNome()); // CONSTROI TIME  
				while (cadastraAno(time)); // CADASTRA OS ANOS CAMPEOES
				Visao.mostraAnos(time); // MOSTRA ANOS EM ORDEM CRESCENTE
				contador++;
			} catch(NullPointerException excecao) {
				break;
			}
		} while (Validacao.validaContinua());
		
		Visao.mostraQtdTimes(contador); // MOSTRA QUANTIDADE DE TIMES CADASTRADOS
	}
	
	public static boolean cadastraAno(Time time) {
		try {
			time.addAno(Validacao.validaAno(time.getAnos()));
			return true;
		} catch(NullPointerException excecao) {
			return false;
		}
	}
}
