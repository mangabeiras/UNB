package validacao;

import dados.Galeria;
import dados.Pintor;
import dados.Quadro;
import leitura.Leitura;
import saida.Visao;

public class Validacao {
	public static String validaNome (String mensagem, String titulo) {
		String nome = "";
		try {
			nome = Leitura.lerEntrada(mensagem, titulo);
			if (nome.length() < 3 || isNomeComNumeros(nome)) {
				Visao.mostraMensagemErro("Erro, o nome deve conter ao menos 3 caracteres e nao possuir digitos.");
				nome = validaNome(mensagem, titulo);
			}
		} catch (NullPointerException e) {
			Visao.mostraMensagemErro("Erro, opcao ainda em desenvolvimento.");
			nome = validaNome(mensagem, titulo);
		}
		return nome;
	}
	
	public static float validaPreco (String mensagem, String titulo) {
		final float MIN = 0;
		float preco = MIN - 1;
		
		try {
			preco = Float.parseFloat(Leitura.lerEntrada(mensagem, titulo));
			if (preco < MIN) {
				Visao.mostraMensagemErro("Erro, o valor deve ser ao menos " + MIN + " (doado).");
				preco = validaPreco(mensagem, titulo);
			}
		} catch (NumberFormatException e) {
			Visao.mostraMensagemErro("Erro, a entrada deve ser numerica.");
			preco = validaPreco(mensagem, titulo);
		} catch (NullPointerException e) {
			Visao.mostraMensagemErro("Erro, opcao ainda em desenvolvimento.");
			preco = validaPreco(mensagem, titulo);
		}
		return preco;
	}
	
	public static int validaAno (String mensagem, String titulo) {
		final int ANOMINIMO = 1000, ATUAL = 2020;
		int ano = validaInteiro(mensagem, titulo);
		if (ano <= ANOMINIMO || ano > ATUAL) {
			Visao.mostraMensagemErro("Erro, o valor deve estar entre " + ANOMINIMO + " e " + ATUAL + ".");
			ano = validaAno(mensagem, titulo);
		}
		return ano;
	}
	
	public static int validaAnoCompra (String mensagem, String titulo, Pintor pintor) {
		int ano = validaAno(mensagem, titulo);
		if (ano <= pintor.getAnoNascimento()) {
			Visao.mostraMensagemErro("Erro, o quadro nao pode ser comprado antes do nascimento do pintor (" + pintor.getAnoNascimento() + ").");
			ano = validaAnoCompra(mensagem, titulo, pintor);
		}
		return ano;
	}
	
	public static int validaCodigoPessoal (Galeria galeria, String mensagem, String titulo) {
		int codigoPessoal = validaInteiro(mensagem, titulo);
		if (codigoPessoal < 1 || isCodigoPessoalRepetido(galeria, codigoPessoal)) {
			Visao.mostraMensagemErro("Erro, o valor do codigo deve ser ao menos 1 e ser unico.");
			codigoPessoal = validaCodigoPessoal(galeria, mensagem, titulo);
		}
		return codigoPessoal;
	}
	
	public static int validaCodigoPintor (Galeria galeria, String mensagem, String titulo) {
		int codigoPessoal = validaInteiro(mensagem, titulo);
		if (codigoPessoal < 1 || !isCodigoPessoalRepetido(galeria, codigoPessoal)) {
			Visao.mostraMensagemErro("Erro, o valor do codigo deve ser ao menos 1 e pertencer a um pintor.");
			codigoPessoal = validaCodigoPintor(galeria, mensagem, titulo);
		}
		return codigoPessoal;
	}
	
	public static int validaCodigoQuadro (Galeria galeria, String mensagem, String titulo) {
		int codigoQuadro = validaInteiro(mensagem, titulo);
		if (codigoQuadro < 1 || isCodigoQuadroRepetido(galeria, codigoQuadro)) {
			Visao.mostraMensagemErro("Erro, o valor do codigo deve ser ao menos 1 e ser unico.");
			codigoQuadro = validaCodigoQuadro(galeria, mensagem, titulo);
		}
		return codigoQuadro;
	}
	
	private static boolean isCodigoQuadroRepetido (Galeria galeria, int codigoQuadro) {
		for (Pintor pintor : galeria.getListaPintores()) {
			for (Quadro quadro : pintor.getListaQuadros()) {
				if (quadro.getCodigoIdentificacao().equals(codigoQuadro)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean isCodigoPessoalRepetido (Galeria galeria, int codigoPessoal) {
		for (Pintor pintor : galeria.getListaPintores()) {
			if (pintor.getCodigoPessoal().equals(codigoPessoal)) {
				return true;
			}
		}
		return false;
	}
	
	private static int validaInteiro (String mensagem, String titulo) {
		int valor = -1;
		
		try {
			valor = Integer.parseInt(Leitura.lerEntrada(mensagem, titulo));
			if (valor < 0) {
				Visao.mostraMensagemErro("Erro, o valor deve ser positivo");
				valor = validaInteiro(mensagem, titulo);
			}
		} catch (NumberFormatException e) {
			Visao.mostraMensagemErro("Erro, a entrada deve ser numerica.");
			valor = validaInteiro(mensagem, titulo);
		} catch (NullPointerException e) {
			Visao.mostraMensagemErro("Erro, opcao ainda em desenvolvimento.");
			valor = validaInteiro(mensagem, titulo);
		}
		return valor;
	}
	
	private static boolean isNomeComNumeros (String nome) {
		for (char c : nome.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}
}
