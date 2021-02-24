package validacao;

import leitura.Leitura;
import saida.Visao;

public class Validacao {
	public static StringBuilder validaNome() {
		// DECLARACOES
		String valida;
		StringBuilder resposta = new StringBuilder(); 
		
		// INSTRUCOES
		Visao.pedirNome();
		valida = Leitura.lerLinha();
		while (valida.toString().trim().split(" ")[0].equals(valida.toString().trim())) {
			Visao.nomeInvalido();
			valida = Leitura.lerLinha();;
		}
		resposta.append(valida);
		
		return resposta;
	}
	
	public static boolean validaContinua(String resposta) {
		return ((resposta.toUpperCase().equals("S") ? true : false));
	}
}
