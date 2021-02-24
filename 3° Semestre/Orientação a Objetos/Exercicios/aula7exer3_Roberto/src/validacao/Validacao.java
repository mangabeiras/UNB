package validacao;

import java.util.InputMismatchException;

import leitura.Leitura;
import visao.Visao;

public class Validacao {
	public static int validaMenu(){
		int escolha;
		
		try {
			escolha = Leitura.leInt();
			if (escolha > 3 || escolha < 0) {
				Visao.erroEntrada(1, "0", "3", null);
				escolha = validaMenu();
			}
		} catch (InputMismatchException e) {
			Visao.erroEntrada(0, null, null, null);
			escolha = validaMenu();
		}
		return escolha;
	}
	// VALIDACAO DO NUMERO REFERENTE A AMAMENTACAO
	public static int validaAmamentacao() {
		int amamentacao;
		
		try {
			Visao.interacao(1);
			amamentacao = Leitura.leInt();
			if (amamentacao < 1 || amamentacao > 5) {
				Visao.erroEntrada(1, "1", "5", null);
				amamentacao = validaAmamentacao();
			}
		} catch (InputMismatchException e) {
			Visao.erroEntrada(0, null, null, null);
			amamentacao = validaAmamentacao();
		}
		return amamentacao;
	}
	public static int validaIdade() {
		int idade;
		
		try {
			Visao.interacao(2);
			idade = Leitura.leInt();
			if (idade < 0 || idade >= 100) {
				Visao.erroEntrada(1, "0", "100", null);
				idade = validaIdade();
			}
		} catch (InputMismatchException e) {
			Visao.erroEntrada(0, null, null, null);
			idade = validaIdade();
		}
		return idade;
	}
	public static String validaEspecie() {
		String especie;
		do {
			Visao.interacao(3);
			especie = Leitura.leString();
			if (!especie.toLowerCase().equals("macaco") && !especie.toLowerCase().equals("baleia") && !especie.toLowerCase().equals("elefante"))
				Visao.erroEntrada(2, "MACACO", "BALEIA", "ELEFANTE");
		} while (!especie.toLowerCase().equals("macaco") && !especie.toLowerCase().equals("baleia") && !especie.toLowerCase().equals("elefante"));
		return especie;
	}
	public static float validaTamanho() {
		float tamanho;
		
		try {
			Visao.interacao(4);
			tamanho = Leitura.leFloat();
			if (tamanho > 20 || tamanho < 0.3) {
				Visao.erroEntrada(1, "0.3", "20", null);
				tamanho = validaTamanho();
			}
		} catch (InputMismatchException e) {
			Visao.erroEntrada(0, null, null, null);
			tamanho = validaTamanho();
		}
		return tamanho;
	}
	public static float validaPeso() {
		float peso;
		
		try {
			Visao.interacao(5);
			peso = Leitura.leFloat();
			if (peso < 1 || peso > 3000f) {
				Visao.erroEntrada(1, "1", "1000", null);
				peso = validaPeso();
			}
		} catch (InputMismatchException e) {
			Visao.erroEntrada(0, null, null, null);
			peso = validaPeso();
		}
		return peso;
	}
	public static String validaHabitat() {
		String habitat;
		
		do {
			Visao.interacao(6);
			habitat = Leitura.leLinha();
			if (habitat.length() > 20 || habitat.length() < 3)
				Visao.erroEntrada(1, "3", "20", null);
		} while (habitat.length() > 20 || habitat.length() < 3);
		return habitat;
	}
	
	public static String validaPorte() {
		String porte;
		
		do {
			Visao.interacao(7);
			porte = Leitura.leString();
			if (!porte.toLowerCase().equals("pequeno") && !porte.toLowerCase().equals("medio") && !porte.toLowerCase().equals("grande"))
				Visao.erroEntrada(2, "pequeno", "medio", "grande");				
		} while (!porte.toLowerCase().equals("pequeno") && !porte.toLowerCase().equals("medio") && !porte.toLowerCase().equals("grande"));
		return porte;
	}
	
	// O USUARIO DESEJA CADASTRAR OUTRO ANIMAL?
	public static boolean validaContinua(int quantidade) {
		final Integer MAXIMO = 500;
		String resposta;
		
		if (quantidade == MAXIMO) {
			Visao.erroEntrada(4, MAXIMO.toString(), null, null);
			return false;
		}
		Visao.interacao(8);
		do {
			resposta = Leitura.leString().toLowerCase();
			if (!resposta.equals("s") && !resposta.equals("n"))
				Visao.erroEntrada(3, null, null, null);
		} while (!resposta.equals("s") && !resposta.equals("n"));
		return (!resposta.equals("s") || quantidade == MAXIMO) ? false : true;
	}
}
