package validacao;

import interfaces.AnaliseDados;
import leitura.Leitura;
import visao.Visao;
// CLASSE DE VALIDACAO
public class Validacao {
	// METODOS
	// VALIDA STRINGBUILDER
	public static StringBuilder validaString(String msg, String titulo) {
		String nome;
		try {
			nome = Leitura.leEntrada(msg, titulo);
			if(nome.isEmpty() || nome.length() < 3) {
				Visao.mostraMensagemErro("O nome precisa ter no minimo 3 caracteres");
				return validaString(msg, titulo);
			}
		} catch(NullPointerException e) {
			Visao.mostraMensagemErro("Digite algum dado!");
			return validaString(msg, titulo);
		}
		return new StringBuilder().append(nome);
	}
	// VALIDA INTEIRO
	public static int validaInt(String msg, String titulo) {
		int lido;
		try {
			lido = Integer.parseInt((Leitura.leEntrada(msg, titulo)));
			if(lido <= 0) {
				Visao.mostraMensagemErro("Insira um valor maior que zero");
				return validaInt(msg, titulo);
			}
			
		} catch(NumberFormatException e) {
			Visao.mostraMensagemErro("Insira apenas um numero");
			return validaInt(msg, titulo);
			
		} catch(NullPointerException e1) {
			Visao.mostraMensagemErro("Insira algum dado");
			return validaInt(msg, titulo);
		}
		return lido;
	}
	// VALIDA PONTO FLUTUANTE
	public static float validaFloat(String msg, String titulo) {
		float lido;
		
		try {
			lido = Float.parseFloat((Leitura.leEntrada(msg, titulo)));
			if(lido <= 0) {
				Visao.mostraMensagemErro("Insira um valor maior que zero");
				return validaFloat(msg, titulo);
			}
		} catch(NumberFormatException e) {
			Visao.mostraMensagemErro("Insira apenas um numero");
			return validaFloat(msg, titulo);
			
		} catch(NullPointerException e1) {
			Visao.mostraMensagemErro("Insira algum dado");
			return validaFloat(msg, titulo);
		}
		return lido;
	}
	// ANALISA SE UMA STRING CONTEM NUMEROS
	public static boolean isDigito(String str) {
		int contador = 0;
		char []conjunto = str.toCharArray();
		while(contador < str.length() ) {
			 if (Character.isDigit(conjunto[contador++]))
				 return true;
		}
		return false;
	}
	
	public static StringBuilder validaNome() {
		StringBuilder nome = validaString("Nome do Empregado", "Dados");
		if (isDigito(nome.toString()) || nome.toString().split(" ").length <= 1) {
			Visao.mostraMensagemErro("Insira um nome COMPLETO apenas com letras");
			return validaNome();
		}
		return nome;
	}
	
	public static StringBuilder validaEndereco() {
		return validaString("Endereco do Terreno", "Dados");
	}
	// NAO PERMITE QUE MATRICULA SEJA REPETIDA
	public static int validaMatricula(AnaliseDados dados) {
		int matricula = validaInt("Matricula Funcional", "Dados");
		if (dados.isRepetido(matricula)) {
			Visao.mostraMensagemErro("Matricula ja inserida!");
			return validaMatricula(dados);
		}
		return matricula;
	}
	
	public static int validaArea() {
		return validaInt("Area do Terreno", "Dados");
	}
	
	public static float validaSalario() {
		return validaFloat("Salario do funcionario", "Dados");
	}
	
	public static float validaPreco() {
		return validaFloat("Valor do terreno", "Dados");
	}
	
}
