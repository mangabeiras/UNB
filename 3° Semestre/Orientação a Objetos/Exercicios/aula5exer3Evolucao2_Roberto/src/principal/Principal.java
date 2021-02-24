package principal;

import dados.*;
import validacao.Validacao;
import saida.Saida;
import servicos.Servicos;

public class Principal {
	public static void main(String[] args) {
		Populacao populacao;
		int contador = 0;
		
		// INSTRUCOES
		populacao = new Populacao(Validacao.validaSexo(++contador), Validacao.validaIdade(), Validacao.validaSalario(), Validacao.validaNumeroFilhos());
		
		while (Validacao.validaContinua())
			populacao.setHabitante(new Habitante(Validacao.validaSexo(++contador), Validacao.validaIdade(), Validacao.validaSalario(), Validacao.validaNumeroFilhos()));
		Servicos.calculaDados(populacao);
	}
}
