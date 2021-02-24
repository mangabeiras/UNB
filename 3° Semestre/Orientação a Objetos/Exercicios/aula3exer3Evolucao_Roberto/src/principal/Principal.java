package principal;

public class Principal {
	public static void main(String[] args) {
		// DECLARACOES
		final int LIMITE = 50;
		int i = 0;
		Pessoa pessoa[] = new Pessoa[LIMITE];

		// INSTRUCOES
		do {
			Servicos.limpaTela((i>0)?30:0);
			pessoa[i] = new Pessoa();
			pessoa[i] = Servicos.interageSalva(pessoa[i], i);
			i++;
		} while (Validacao.validaContinua(Leitura.leituraChar()) & i < LIMITE);
		Servicos.limpaTela(50);
		
		Saida.mostraDados(pessoa, i);
	}
}
