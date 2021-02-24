package validacao;

import dados.Cidade;
import dados.Pais;
import leitura.Leitura;
import visao.Visao;
// CLASSE DE VALIDACAO
public class Validacao {
	// VALIDA STRING
	public static String validaString(String msg, String titulo) {
		String nome;
		
		try {
			nome = Leitura.leEntrada(msg, titulo);	
			if (nome.isEmpty()) {
				Visao.mostraMensagemErro("Nao pode ser vazio!");
				return validaString(msg, titulo);
			}
		} catch(NullPointerException e) { // CONFIRMA SE O USUARIO QUER CANCELAR O CADASTRO
			if (Leitura.confirma("Deseja realmente cancelar?") == 0)
				throw new NullPointerException();
			return validaString(msg, titulo);
		} 
		return nome;
	}
	
	// VALIDA INT
	public static int validaInt(String msg, String titulo) {
		int lido;
		try {
			lido = Integer.parseInt(Validacao.validaString(msg, titulo));
		
		} catch(NumberFormatException e) {
			Visao.mostraMensagemErro("Insira apenas um numero!");
			return validaInt(msg, titulo);
		}
						
		return lido;
	}
	// VERIFICA SE UMA STRING POSSUI NUMEROS
	public static boolean isAlfabetic(String nome) {
		for (char c : nome.toCharArray()) {
			if (Character.isDigit(c))
				return false;
		}
		return true;
	}
	// VALIDA NOME DA CIDADE
	public static StringBuilder validaNome() {
		StringBuilder nome = new StringBuilder().append(validaString("Insira o nome da cidade", "Cidade"));
		
		if (nome.length() < 3) {
			Visao.mostraMensagemErro("O nome precisa ter no minimo 3 caracteres!");
			return validaNome();
		}
		if (!isAlfabetic(nome.toString())) {
			Visao.mostraMensagemErro("O nome nao pode conter numeros!");
			return validaNome();
		}
		return nome;
	}
	// VALIDA DDD DA CIDADE
	public static int validaDdd(Pais brasil, StringBuilder nome) {
		int ddd = validaInt("Insira o ddd dessa cidade", "DDD");
		
		if (ddd < 11 || ddd > 99) {
			Visao.mostraMensagemErro("O ddd so pode estar entre 11 e 99");
			return validaDdd(brasil, nome);
		}
		if (brasil.getPais().contains(new Cidade(nome, ddd))) {
			Visao.mostraMensagemErro("Cidade ja cadastrada!"); // NAO PERMITE CADASTRO DE CIDADES IGUAIS
			throw new NullPointerException();
		}
		return ddd;
	}
	// VERIFICA SE O USUARIO QUER TERMINAR O PROGRAMA
	public static char validaTermino(Pais pais) { 
		switch(Leitura.confirma("Deseja realmente terminar o programa?")) {
		case 0:
			Visao.mostraRelatorio(pais.getPais());
			return 'x';
		default:
			return 0;
		}
	}
}
