package principal;

import dados.Campeonato;
import dados.Time;
import leitura.Leitura;
import saida.Saida;
import validacao.Validacao;

public class Principal {
	public static void main(String[] args) {
		// DECLARACOES
		Campeonato campeonato = new Campeonato();
		
		// INSTRUCOES
		while (menu(campeonato)); // MENU
		Saida.mostraQtdTimes(campeonato.getCampeonato().size()); // QTD DE TIMES
	}
	
	// MENU PRINCIPAL
	public static boolean menu(Campeonato campeonato) {
		try {
			String menu[] = {"Cadastrar Time", "Visualizar Times", "Sair"};
			switch (Leitura.leMenu(menu)) {
			case 0:
				campeonato.addTime(new Time(Validacao.validaNome(campeonato), Validacao.validaConjuntoAnos())); // CADASTRO
				return true;
			case 1:
				Saida.mostraOrdem(campeonato);
				return true;
			default:
				return Validacao.validaTermino(campeonato); // VERIFICA SE E POSSIVEL TERMINAR A EXECUCAO
			}
		} catch(NullPointerException excecao) {
			return true;
		}
	}
}
