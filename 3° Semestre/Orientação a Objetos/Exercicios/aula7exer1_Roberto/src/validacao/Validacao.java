package validacao;

import java.util.InputMismatchException;

import leitura.Leitura;
import saida.Saida;

public class Validacao {
	public static int validaAno(int contador) {
		int ano;
		final int MIN = 1900, ATUAL = 2020;
		
		if(contador > 0)
			Saida.limpaTela(20);
		Saida.interage(0, contador);
		try {
			Saida.interage(1, contador);
			ano = Leitura.leInt();
			if(ano <= MIN || ano >= ATUAL) {
				Saida.erroEntrada(1);
				ano = validaAno(contador);
			}
		} catch (InputMismatchException e) {
			Saida.erroEntrada(0);
			ano = validaAno(contador);
		}
		return ano;		
	}
	public static String validaEvento() {
		String evento;
		
		Saida.interage(2, 0);
		evento = Leitura.leLinha();
		if (evento.isEmpty() || evento.length() < 5 || evento.length() > 30) {
			Saida.erroEntrada(2);
			evento = validaEvento();
		}
		return evento;
	}
	
	public static String validaPresidente() {
		String presidente;
		
		Saida.interage(3, 0);
		presidente = Leitura.leLinha();
		if(presidente.isEmpty() || presidente.split(" ").length > 2) {
			Saida.erroEntrada(3);
			presidente = validaPresidente();
		}
		return presidente;
	}	
	public static boolean validaContinua() {
		char resposta;
		
		Saida.limpaTela(2);
		Saida.interage(4, 0);
		resposta = Leitura.leChar();
		return ((resposta == 'S')?true:false);
	}
}
