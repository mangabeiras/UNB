package validacao;

import java.util.ArrayList;
import java.util.InputMismatchException;

import dados.Funcionario;
import leitura.Leitura;
import visao.Visao;

public class Validacao {
	public static int validaInt(final int MAX) {
		int resposta;
		
		if (MAX == 180)
			Visao.interacao(3);
		else if(MAX == 100)
			Visao.interacao(4);
		try {
			resposta = Leitura.leInt();
			if (resposta > MAX || resposta < 0) {
				System.err.println("Valor Invalido! Insira um numero de 0 a "+MAX);
				resposta = validaInt(MAX);
			}
		} catch (InputMismatchException e) {
			System.err.println("Valor Invalido! Insira apenas um numero");
			resposta = validaInt(MAX);
		}
		Visao.limpaTela(30);
		return resposta;
	}
	public static String validaNome() {
		String nome;
		
		do {
			Visao.interacao(0);
			nome = Leitura.leLinha();
			if (nome.length() < 3 || nome.split(" ").length == 1)
				System.err.println("Apenas sao permitidos nomes COMPLETOS que tenham no minimo 3 caracteres");
		} while (nome.length() < 3 || nome.split(" ").length == 1);
		return nome;
	}
	
	public static long validaCpf(ArrayList<Funcionario> empresa) {
		String lido;
		boolean erro = false;
		
		do {
			erro = false;
			Visao.interacao(1);
			lido = Leitura.leString();
			
			try {
				Long.parseLong(lido);
			} catch(NumberFormatException e) {
				System.err.println("Valor invalido. Insira apenas um numero");
				erro = true;
			}
			if (erro == false) {
				if (lido.length() != 11) {
					System.err.println("Um cpf precisa ter apenas 11 caracteres");
					erro = true;
				}
			}
			if (erro == false) {
				int contador = 0;
				while (contador < empresa.size()) {
					if (empresa.get(contador++).getCpf().equals(Long.parseLong(lido))) {
						System.err.println("CPF ja inserido!!");
						erro = true;
						break;
					}
				}
			}
			
		} while(erro);
	
		return Long.parseLong(lido);
	}
	// VALIDA A DATA DE NASCIMENTO INSERIDA
	public static int[] validaNascimento() {
		int []nascimento = new int[3];
		String data;
		
		do {
			Visao.interacao(2);
			data = Leitura.leString();
			if (data.split("/").length != 3 || Integer.parseInt(data.split("/")[0].trim()) > 31 
					|| Integer.parseInt(data.split("/")[0].trim()) < 1 
					|| Integer.parseInt(data.split("/")[1].trim()) > 12  
					|| Integer.parseInt(data.split("/")[1].trim()) < 1 
					|| Integer.parseInt(data.split("/")[2].trim()) > 2020
					|| Integer.parseInt(data.split("/")[2].trim()) < 1950)
				System.err.println("Invalido. Insira apenas no formato DD/MM/AAAA");
		} while (data.split("/").length != 3 || Integer.parseInt(data.split("/")[0].trim()) > 31 
				|| Integer.parseInt(data.split("/")[0].trim()) < 1 
				|| Integer.parseInt(data.split("/")[1].trim()) > 12  
				|| Integer.parseInt(data.split("/")[1].trim()) < 1 
				|| Integer.parseInt(data.split("/")[2].trim()) > 2020
				|| Integer.parseInt(data.split("/")[2].trim()) < 1950);
		for (int i = 0; i < nascimento.length; i++)
			nascimento[i] = Integer.parseInt(data.split("/")[i].trim());
		return nascimento;
	}
}
