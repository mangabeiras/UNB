package validacao;

import leitura.Leitura;
import saida.Saida;

public class Validacao {
	public static StringBuilder validaNome() {
		// DECLARACOES
		String valida;
		StringBuilder resposta = new StringBuilder(); 
		
		// INSTRUCOES
		Saida.pedirNome();
		valida = Leitura.lerLinha();
		while (valida.toString().trim().split(" ")[0].equals(valida.toString().trim())) {
			Saida.nomeInvalido();
			valida = Leitura.lerLinha();;
		}
		resposta.append(valida);
		
		return resposta;
	}
	
	public static boolean validaContinua() {
		return ((Leitura.lerLinha().toUpperCase().equals("S") ? true : false));
	}
}
