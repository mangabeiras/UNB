package validacao;

import java.util.ArrayList;

import dados.Campeonato;
import dados.Time;
import leitura.Leitura;
import saida.Saida;

public class Validacao {
	public static String validaString(String msg, String titulo) {
		String lido;
		try {	
			lido = Leitura.solicitaDado(msg, titulo).trim();
			if (lido.isEmpty()) {
				Saida.mostraErro("Nao pode ser vazio!");
				return validaString(msg, titulo);
			}
		} catch (NullPointerException e) {
			if (Leitura.yesNo("Realmente deseja parar o cadastro?") == 0)
				throw new NullPointerException("Cadastro Cancelado!");
			else
				return validaString(msg, titulo);
		}
		return lido;
	}
	
	public static int validaInt(String msg, String titulo) {
		int lido;
		
		try {
			lido = Integer.parseInt(validaString(msg, titulo).trim());
		} catch(NumberFormatException e) {
			Saida.mostraErro("Digite apenas um numero!");
			return validaInt(msg, titulo);
		}
		return lido;
	}
	// VALIDA ANO INDIVIDUAL
	public static int validaAno() {
		final int ANO_MIN = 1900, ANO_MAX = 2200;
		int ano;
		
		ano = validaInt("Insira um ano em que esse time foi campeao", "Ano");
		if (ano <= ANO_MIN || ano >= ANO_MAX) {
			Saida.mostraErro("O ano precisa ser maior que "+ANO_MIN+ " e menor que "+ANO_MAX+"!");
			return validaAno();
		}
		return ano;
	}
	// VALIDA CONJUNTO DE ANOS
	public static ArrayList<Integer> validaConjuntoAnos() {
		ArrayList<Integer> anos = new ArrayList<Integer>();
		try {
			while (true)
				anos.add(validaAno());
		} catch(NullPointerException e) {};
		return anos;
	}
	// VALIDA NOME DO TIME
	public static String validaNome(Campeonato campeonato) {
		String nome = validaString("Insira o nome do time", "Time");
		if (nome.length() < 3) {
			Saida.mostraErro("O nome do time precisa ter mais que 3 caracteres!");
			return validaNome(campeonato);
		}
		if (!isAlfabetico(nome)) {
			Saida.mostraErro("O nome nao pode conter numeros!");
			return validaNome(campeonato);
		}
		if (campeonato.getCampeonato().contains(new Time(nome, null))) { // VERIFICA SE O TIME JA FOI CADASTRADO
			Saida.mostraErro("Time ja cadastrado");
			return validaNome(campeonato);
		}
		return nome;
	}
	// VERIFICA SE UMA STRING POSSUI NUMEROS
	public static boolean isAlfabetico(String lido) {
		for (char c : lido.toCharArray()) {
			if (Character.isDigit(c))
				return false;
		}
		return true;
	}
	
	public static boolean validaTermino(Campeonato campeonato) {
		if (campeonato.getCampeonato().size() == 0) {
			Saida.mostraErro("� preciso cadastrar um time antes de encerrar!");
			return true;
		}
		return (Leitura.yesNo("Realmente deseja terminar o Programa?") == 1);
	}	
}
