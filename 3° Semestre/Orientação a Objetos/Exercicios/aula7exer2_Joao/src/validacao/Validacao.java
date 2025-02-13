package validacao;

import dados.Galeria;
import dados.Pintor;
import dados.Quadro;
import leitura.Leitura;
import saida.Visao;

public class Validacao {
	public static int validaEscolhaMenu() {
		int escolha = -1;
		
		try {
			escolha = Integer.parseInt(Leitura.lerEntrada(""));
			if (escolha < 0 || escolha > 4) {
				Visao.mostraMensagemErro("Erro, opcao invalida");
				escolha = validaEscolhaMenu();
			}
		} catch (NumberFormatException e) {
			Visao.mostraMensagemErro("Erro, a entrada deve ser numerica.");
			escolha = validaEscolhaMenu();
		}
		return escolha;
	}
	
	public static String validaNome (String mensagem) {
		String nome = Leitura.lerEntrada(mensagem);
		if (nome.length() < 3 || isNomeComNumeros(nome)) {
			Visao.mostraMensagemErro("Erro, o nome deve conter ao menos 3 caracteres e nao possuir digitos.");
			nome = validaNome(mensagem);
		}
		
		return nome;
	}
	
	public static float validaPreco (String mensagem) {
		final float MIN = 0;
		float preco = MIN - 1;
		
		try {
			preco = Float.parseFloat(Leitura.lerEntrada(mensagem));
			if (preco < MIN) {
				Visao.mostraMensagemErro("Erro, o valor deve ser ao menos " + MIN + " (doado).");
				preco = validaPreco(mensagem);
			}
		} catch (NumberFormatException e) {
			Visao.mostraMensagemErro("Erro, a entrada deve ser numerica.");
			preco = validaPreco(mensagem);
		}
		return preco;
	}
	
	public static int validaAno (String mensagem) {
		final int ANOMINIMO = 1000, ATUAL = 2020;
		int ano = validaInteiro(mensagem);
		if (ano <= ANOMINIMO || ano > ATUAL) {
			Visao.mostraMensagemErro("Erro, o valor deve estar entre " + ANOMINIMO + " e " + ATUAL + ".");
			ano = validaAno(mensagem);
		}
		return ano;
	}
	
	public static int validaCodigoPessoal (Galeria galeria, String mensagem) {
		int codigoPessoal = validaInteiro(mensagem);
		if (codigoPessoal < 1 || isCodigoPessoalRepetido(galeria, codigoPessoal)) {
			Visao.mostraMensagemErro("Erro, o valor do codigo deve ser ao menos 1 e ser unico.");
			codigoPessoal = validaCodigoPessoal(galeria, mensagem);
		}
		return codigoPessoal;
	}
	
	public static int validaCodigoPintor (Galeria galeria, String mensagem) {
		int codigoPessoal = validaInteiro(mensagem);
		if (codigoPessoal < 1 || !isCodigoPessoalRepetido(galeria, codigoPessoal)) {
			Visao.mostraMensagemErro("Erro, o valor do codigo deve ser ao menos 1 e pertencer a um pintor.");
			codigoPessoal = validaCodigoPintor(galeria, mensagem);
		}
		return codigoPessoal;
	}
	
	public static int validaCodigoQuadro (Galeria galeria, String mensagem) {
		int codigoQuadro = validaInteiro(mensagem);
		if (codigoQuadro < 1 || isCodigoQuadroRepetido(galeria, codigoQuadro)) {
			Visao.mostraMensagemErro("Erro, o valor do codigo deve ser ao menos 1 e ser unico.");
			codigoQuadro = validaCodigoQuadro(galeria, mensagem);
		}
		return codigoQuadro;
	}
	
	private static boolean isCodigoQuadroRepetido (Galeria galeria, int codigoQuadro) {
		for (Quadro quadro : galeria.getListaQuadros()) {
			if (quadro.getCodigoIdentificacao().equals(codigoQuadro)) {
				return true;
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
	
	private static int validaInteiro (String mensagem) {
		int valor = -1;
		
		try {
			valor = Integer.parseInt(Leitura.lerEntrada(mensagem));
			if (valor < 0) {
				Visao.mostraMensagemErro("Erro, o valor deve ser positivo");
				valor = validaInteiro(mensagem);
			}
		} catch (NumberFormatException e) {
			Visao.mostraMensagemErro("Erro, a entrada deve ser numerica.");
			valor = validaInteiro(mensagem);
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
