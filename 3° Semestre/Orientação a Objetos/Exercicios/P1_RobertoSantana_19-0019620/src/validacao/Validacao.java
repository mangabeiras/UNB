package validacao;

import dados.Grupo;
import leitura.Leitura;
import visao.Visao;

public class Validacao {
	public static boolean validaString(String lido) {
		if (lido.isEmpty()) {
			Visao.mostraMensagemErro("Nao pode ser vazio!");
			return false;
		}
		return true;
	}
	
	public static boolean validaInt(String lido) {
		try {
			Integer.parseInt(lido);
		} catch (NumberFormatException e) {
			Visao.mostraMensagemErro("Insira apenas numeros!");
			return false;
		}
		return true;
	}
	
	public static boolean validaNome(String nome) {
		return (validaLength(nome) && isAlfabetico(nome) && validaString(nome));
	}
	
	public static boolean validaLength(String lido) {
		if (lido.length() < 3) {
			Visao.mostraMensagemErro("O nome precisa ter no minimo 3 caracteres!");
			return false;
		}
		return true;
	}
	
	public static boolean isAlfabetico(String lido) {
		for (char c : lido.toCharArray()) {
			if (Character.isDigit(c)) {
				Visao.mostraMensagemErro("O nome nao pode conter numeros!");
				return false;
			}
		}
		return true;
	}
	public static char validaSituacao() {
		String opcoes[] = {"Contaminada em Tratamento", "Contaminada Falecida", "Contaminada Curada", "Nao Contaminada"};
		switch(Leitura.leOpcoes("Insira a situacao:", opcoes)) {
		case 0:
			return 'T';
		case 1:
			return 'F';
		case 2:
			return 'C';
		case 3:
			return 'S';
		default:
			if (Leitura.leConfirma("Realmente deseja cancelar o cadastro?") == 0)
				throw new NullPointerException();
			return validaSituacao();
		}
	}
	public static boolean validaIdade(String idade) {
		final int MAXIMO = 150;
		int id = 0;
		if (validaInt(idade))
			id = Integer.parseInt(idade);
			
		if (id > MAXIMO) {
			Visao.mostraMensagemErro("A idade nao pode ser maior que 150");
			return false;
		}
		
		return true;
	}
	
	public static char validaGestacao() {
		String opcoes[] = {"Sim", "Nao", "Nao tem Certeza"};
		switch(Leitura.leOpcoes("Ja foi gestante?", opcoes)) {
		case 0:
			return 'S';
		case 1:
			return 'N';
		case 2: 
			return 'T';
		default:
			if (Leitura.leConfirma("Realmente deseja cancelar o cadastro?") == 0)
				throw new NullPointerException();
			return validaGestacao();
		}
	}
	public static int validaCodigo(Grupo grupo) {
		final int MAIOR = 100;
		int codigo = grupo.getGrupo().size() + MAIOR + 1;
		Visao.mostraMensagem("Codigo gerado para a Pessoa: " +codigo, "Codigo");
		return codigo;
	}
}
