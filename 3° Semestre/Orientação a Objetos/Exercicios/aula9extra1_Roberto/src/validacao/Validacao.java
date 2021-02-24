package validacao;

import dados.Cidade;
import dados.Pais;
import leitura.Leitura;
import visao.Visao;

public class Validacao {
	// VALIDA STRINGBUILDER
	public static StringBuilder validaString (String msg, String titulo){
		String lido;
		lido = Leitura.leEntrada(msg, titulo);
		if (lido.length() == 0) {
			Visao.mostraMensagemErro("Nao pode ser vazio!");
			return validaString(msg, titulo);
		}
		return new StringBuilder().append(lido);
	}
	// VALIDA INT
	public static int validaInt(String msg, String titulo) {
		int lido;
		try {
			lido = Integer.parseInt(validaString(msg, titulo).toString());
			if (lido < 0) {
				Visao.mostraMensagemErro("O numero nao pode ser menor que zero!");
				return validaInt(msg, titulo);
			}
		} catch(NumberFormatException e) {
			Visao.mostraMensagemErro("Insira apenas um numero!");
			return validaInt(msg, titulo);
		}
		return lido;
	}
	// VALIDA NOME CIDADE
	public static StringBuilder validaNome(){
		StringBuilder nome = validaString("Insira o nome da Cidade", "Cidade");
		if (nome.length() < 3) {
			Visao.mostraMensagemErro("O nome da cidade deve possuir ao menos 3 caracteres!");
			return validaNome();
		} else
			return (isAlfabetico(nome)) ? nome : validaNome();
	}
	// VERIFICA SE UMA STRINGBUILDER CONTEM NUMEROS
	public static boolean isAlfabetico(StringBuilder nome) {
		char []array = nome.toString().toCharArray();
		for (char caracter : array) {
			if (Character.isDigit(caracter)) {
				Visao.mostraMensagemErro("O nome de uma cidade deve conter apenas letras!");
				return false;
			}
		}
		return true;
	}
	
	// VALIDA ESTADO
	public static StringBuilder validaEstado(Pais brasil, StringBuilder nome) {
		StringBuilder estado = (validaString("Insira o Estado(com apenas duas letras) ao qual a Cidade pertence", "Estado"));
		// VERIFICA SE O ESTADO E EXISTENTE
		if (!isExistente(estado))
			return validaEstado(brasil, nome);
		if (isCidadeExistente(brasil, new Cidade(nome, estado, null, null)))
			throw new NullPointerException();
		return estado;
	}
	
	// VERIFICA EXISTENCIA DO ESTADO
	public static boolean isExistente(StringBuilder estado) {
		String []estadosBrasil = {"DF", "PR", "RR", "PE", "AM", "MG", "SP", "RJ", "ES", 
									"BA", "SE", "AL", "RN", "MA", "PA", "RS", "SC","GO", 
									"MT", "MS", "AC", "AP", "RO", "TO", "PI", "CE", "PB"};	
		for (String estadoBr : estadosBrasil) {
			if (estadoBr.equals(estado.toString().toUpperCase()))
				return true;
		}
		Visao.mostraMensagemErro("Estado nao existente no Brasil");
		return false;
	}
	public static boolean isCidadeExistente(Pais brasil, Cidade cidade) {
		if (brasil.getPais().contains(cidade)) {
			Visao.mostraMensagemErro("Cidade já Cadastrada!!");
			return true;
			}
		return false;
	}
	
	// VALIDA CONTAMINADOS
	public static int validaCasos() {
		return validaInt("Insira a quantidade de contaminados por Covid-19 nessa Cidade", "Contaminados");
	}
	
	// VALIDA MORTES
	public static int validaMortes(int contaminados) {
		int mortes = validaInt("Insira a quantidade de falecidos por Covid nessa Cidade", "Contaminados");
		if (mortes > contaminados) {
			Visao.mostraMensagemErro("O numero de mortes nao pode ser maior que o de contaminados");
			return validaMortes(contaminados);
		}
		return mortes;
	}
}
