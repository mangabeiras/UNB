package validacao;

import java.util.ArrayList;
import java.util.InputMismatchException;

import dados.Funcionario;
import leitura.Leitura;
import visao.Visao;

public class Validacao {
	public static char validaChar(String conjunto, String mensagem) {
		char escolha;
		
		Visao.mensagem(mensagem);
		escolha = Leitura.leChar();
		while (!conjunto.contains(Character.toString(escolha))) {
			System.err.println("Insira apenas uma das opcoes do MENU");
			escolha = Leitura.leChar();
		}
		return escolha;
	}
	
	public static int validaInt(final int MIN, final int MAX, String mensagem) {
		Visao.mensagem(mensagem);
		return validaTamanho(validaExcecao(), MIN, MAX);
	}
	
	public static int validaTamanho(int num, final int MIN, final int MAX) {
		if (num < MIN || num > MAX) {
			System.err.println("Insira um numero de "+MIN+" a "+MAX);
			return validaExcecao();
		}
		return num;
	}
	public static int validaExcecao() {
		int num;
		try {
			num = Leitura.leInt();
		} catch (InputMismatchException e) {
			System.err.println("Valor Invalido! Insira apenas um numero");
			return validaExcecao();
		}
		return num;
	}

	public static String validaString() {
		String nome;
		
		do {
			Visao.mensagem("NOME COMPLETO: ");
			nome = Leitura.leLinha();
			if (nome.length() < 3 || nome.split(" ").length == 1)
				System.err.println("Apenas sao permitidos nomes COMPLETOS que tenham no minimo 3 caracteres");
		} while (nome.length() < 3 || nome.split(" ").length == 1);
		return nome;
	}
	
	public static long validaCpf(ArrayList<Funcionario> empresa) {		
		Visao.mensagem("CPF: ");		
		return validaDisponibilidade(validaDigitos(), empresa);
	}
	
	public static long validaDigitos() {
		String lido = Leitura.leString();
		try {
			Long.parseLong(lido);
		} catch(NumberFormatException e) {
			System.err.println("Valor invalido. Insira apenas um numero");
			return validaDigitos();
		}
		return validaTamanho(lido.length(), 11) ? Long.parseLong(lido) : validaDigitos();
	}
	public static boolean validaTamanho(int num, final int NUM) {
		if (num != NUM) {
			System.err.println("O cpf precisa ter "+NUM+" digitos");
			return false;
		}
		return true;
	}
	
	public static long validaDisponibilidade(Long lido, ArrayList<Funcionario> empresa) {
		if (empresa.contains(lido)) {
				System.err.println("CPF ja inserido!!");
				return validaCpf(empresa);
			}
		return lido;
	} 

	// VALIDA A DATA DE NASCIMENTO INSERIDA
	public static int[] validaNascimento() {
		Visao.mensagem("DATA DE NASCIMENTO:");
		return validaDia(Leitura.leString());
	}
	
	public static int[] validaDia(String data) {
		if (Integer.parseInt(data.split("/")[0].trim()) < 1 
			|| Integer.parseInt(data.split("/")[0].trim()) > 31) {
			System.err.println("O dia precisa estar entre 1 e 31!");
			return validaNascimento();
		}
		return validaMes(data);
	}
	
	public static int[] validaMes(String data) {
		if( Integer.parseInt(data.split("/")[1].trim()) > 12  
			|| Integer.parseInt(data.split("/")[1].trim()) < 1) {
			System.err.println("O mes precisa estar entre 1 e 12!");
			return validaNascimento();
		}
		return validaAno(data);
	}
	
	public static int[] validaAno(String data) {
		int []nascimento = new int[3];
		if (Integer.parseInt(data.split("/")[2].trim()) > 2020
			|| Integer.parseInt(data.split("/")[2].trim()) < 1950) {
			System.err.println("O ano precisa estar ente 1950 e 2020");
			return validaNascimento();
		}
		for (int i = 0; i < 3; i++)
			nascimento[i] = Integer.parseInt(data.split("/")[i]);
		return nascimento;
	} 
 }
