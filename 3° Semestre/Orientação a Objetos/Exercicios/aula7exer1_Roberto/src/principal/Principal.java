package principal;

import dados.Ano;
import dados.Conjunto;
import servicos.Servicos;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {
		// DECLARACOES
		int contador = 0;
		Conjunto ano = null;
		
		//INSTRUCOES
		do {
			if(contador == 0)
				ano = new Conjunto(Validacao.validaAno(contador++), Validacao.validaEvento() , Validacao.validaPresidente());
			else 
				ano.setAno(new Ano(Validacao.validaAno(contador++), Validacao.validaEvento() , Validacao.validaPresidente()));
		} while (Validacao.validaContinua());
		Servicos.mostraConjunto(ano);
	}
}
