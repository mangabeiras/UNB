package servicos;

import dados.Conjunto;
import saida.Saida;

public class Servicos {
	public static void mostraConjunto(Conjunto ano) {
		// INSTRUCOES
		Saida.limpaTela(50);
		Saida.resultado(0, 0, null, null);
		
		// OBTEM OS DADOS SALVOS PARA OS MOSTRAR AO USUARIO
		for (int contador = 0; contador < ano.getConjunto().size(); contador++) {
			Saida.resultado(1, ano.getConjunto().get(contador).getAno(), ano.getConjunto().get(contador).getEvento(),
					ano.getConjunto().get(contador).getPresidente());
		}
	}
}
