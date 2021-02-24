package validacao;

import java.util.ArrayList;

import leitura.Leitura;
import visao.Visao;
// VALIDACAO
public class Validacao {
	// VALIDA STRING
	public static String validaString(String msg, String titulo) {
		String lido;
		try {
			lido = Leitura.leEntrada(msg, titulo);
			if (lido.isEmpty()) {
				Visao.mostraMensagemErro("Nao pode ser vazio!");
				return validaString(msg, titulo);
			}
		} catch(NullPointerException e) {
			if (Leitura.leConfirma("Realmente deseja parar o Cadastro?") == 0)
				throw new NullPointerException();
			else 
				return validaString(msg, titulo);			
			}
		return lido;
	}
	
	// VALIDA INT
	public static int validaInt(String msg, String titulo) {
		int lido;
		
		try {
			lido = Integer.parseInt(validaString(msg, titulo));
		} catch (NumberFormatException e) {
			Visao.mostraMensagemErro("Insira apenas um numero!!");
			return validaInt(msg, titulo);
		}
		return lido;
	}
	// VERIFICA SE UMA STRING NAO POSSUI NUMEROS
	public static boolean isAlfabetico(String lido) {
		for (char c : lido.toCharArray()) {
			if (Character.isDigit(c))
				return false;
		}
		return true;
	}
	// VALIDA NOME DO TIME
	public static StringBuilder validaNome() {
		String nome = validaString("Insira o nome do Time", "Time");	
		if (nome.length() < 3) {
			Visao.mostraMensagemErro("O nome precisa ter no minimo 3 caracteres!");
			return validaNome();
		}
		if (!isAlfabetico(nome)) {
			Visao.mostraMensagemErro("O nome nao pode conter numeros!");
			return validaNome();
		}
		return new StringBuilder().append(nome);
	}
	// VALIDA ANO CAMPEAO
	public static int validaAno(ArrayList<Integer> anos) {
		final int MINIMO = 1900, MAXIMO = 2200;
		int ano = validaInt("Insira um ano que esse time foi campeao: ", "Anos");
		if (ano <= MINIMO || ano >= MAXIMO) {
			Visao.mostraMensagemErro("O ano precisa ser maior que "+MINIMO+" e menor que "+MAXIMO);
			return validaAno(anos);
		}
		if (anos.contains(ano)) {
			Visao.mostraMensagemErro("Ano ja inserido para esse time!");
			return validaAno(anos);
		}
		return ano;
	}
	// VALIDA CONTINUA A CADASTRAR
	public static boolean validaContinua() {
		return (Leitura.leConfirma("Deseja cadastrar outro time?") == 0);	
	}
}
