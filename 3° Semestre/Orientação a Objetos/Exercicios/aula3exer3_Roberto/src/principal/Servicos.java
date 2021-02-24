package principal;

public class Servicos {
	public static void passaDados(String nomeSalvo, int idadeSalvo, float alturaSalvo, int i) {
		Pessoa dados = new Pessoa(nomeSalvo, idadeSalvo, alturaSalvo);
		
		// CASO O USUARIO INFORME QUE N VAI CADASTRAR MAIS
		if (!Validacao.validaContinua()) {
			limpaTela(30);
			System.out.println("ULTIMO CADASTRO, PESSOA NUMERO "+(i+1));
			mostraDados(dados);
		}
	}
	
	// MOSTRA OS DADOS DA ULTIMA PESSOA
	public static void mostraDados(Pessoa dados) {
		System.out.println("Nome: " +dados.nome);
		System.out.println("Idade: " + dados.idade);
		System.out.println("Altura: " +dados.altura);
	}
	
	// LIMPA TELA
	public static void limpaTela(int saltos) {
		for (int i=0; i<saltos; i++)
			System.out.println();
	}
}
