package servicos;

import java.util.Vector;

import dados.CadastroPessoa;
import leitura.Leitura;
import saida.Saida;

public class Servicos {

	public static void exibirSequenciaDeInsercao(Vector conjuntoDePessoas) {
		Saida.limpaTela(40);
		System.out.println("Nomes em ordem de insercao:");

		for (int aux = 0; aux < conjuntoDePessoas.size(); aux++) {
			CadastroPessoa pessoas = (CadastroPessoa) conjuntoDePessoas.get(aux);
			System.out.println((aux + 1) + "- " + pessoas.getDadosDaPessoa().getNome());
		}

	}

	public static void exibirSequenciaInversaDeInsercao(Vector conjuntoDePessoas) {
		Saida.limpaTela(40);
		System.out.println("Nomes em ordem inversa de insercao:");

		for (int aux = conjuntoDePessoas.size()-1; aux >= 0; aux--) {
			CadastroPessoa pessoas = (CadastroPessoa) conjuntoDePessoas.get(aux);
			System.out.println(aux+1 + "- " + pessoas.getDadosDaPessoa().getNome());
		}
	}

	public static boolean encerrarSemMostrarNomesCadastrados(Vector conjuntoDePessoas) {
		char opcao;

		// INSTRUCOES
		Saida.solicitarConfirmacaoDoEncerramento();
		opcao = Leitura.leituraChar();

		while (opcao != 'S' && opcao != 'N') {
			Saida.digiteUmCaractereValido();
			opcao = Leitura.leituraChar();
		}

		if (opcao == 'S') {
			Saida.limpaTela(40);
			System.out.println(
					"Quantidade de nomes cadastrados na ultima lista: " + conjuntoDePessoas.size() + " nome(s).");
			return false;
		} else {
			removeElementosDoVetor(conjuntoDePessoas);
			Saida.limpaTela(40);
			return true;
		}
	}

	private static void removeElementosDoVetor(Vector conjuntoDePessoas) {
		conjuntoDePessoas.removeAllElements();
	}

}
