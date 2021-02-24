package servicos;

public class Servicos {
	// QUEBRA O NOME
	public static String[] quebraNome(String lido) {
		String[] nomeDiv = lido.trim().split(" ");
		return nomeDiv;
	}
}
