package saida;

import java.util.Vector;

import leitura.Leitura;
import servicos.Servicos;
import validacao.Validacao;

public class Saida {

	public static void solicitaNome() {
		System.out.println("Informe um nome: ");
	}

	public static void nomeInvalido() {
		limpaTela(1);
		System.out.println("Nome vazio e invalido. Informe um nome valido:");
	}

	public static void limpaTela(int linhasPuladas) {
		for (int x = 0; x < linhasPuladas; x++) {
			System.out.println();
		}
	}

	public static void ordemDeApresentacao() {
		limpaTela(40);
		System.out.println("Deseja visualizar os nomes em qual ordem? Digite 1, 2 ou 0:");
		System.out.println("1 - Sequencia de insercao;");
		System.out.println("2 - Sequencia inversa de insercao;");
		System.out.println("0 - Encerra sem mostrar os dados cadastrados.");
	}

	public static boolean solicitarEncerramento(Vector conjuntoDePessoas) {
		int opcaoEscolhida;

		ordemDeApresentacao();
		opcaoEscolhida = Validacao.validaInt();

		if (opcaoEscolhida == 1) {
			Servicos.exibirSequenciaDeInsercao(conjuntoDePessoas);
			return false;
		} else if (opcaoEscolhida == 2) {
			Servicos.exibirSequenciaInversaDeInsercao(conjuntoDePessoas);
			return false;
		} else {
			return (Servicos.encerrarSemMostrarNomesCadastrados(conjuntoDePessoas));
		}
	}

	public static void excecaoInt() {
		limpaTela(1);
		System.out.println("Entrada invalida. Insira apenas um valor inteiro:");
	}

	public static void digitoInvalido() {
		limpaTela(1);
		System.out.println("Digito invalido. Informe apenas um dos digitos validos (1, 2 ou 0):");
	}

	public static void solicitarConfirmacaoDoEncerramento() {
		limpaTela(1);
		System.out.println(
				"Deseja realmente encerrar o programa? Se sim, digite 's', mas se deseja fazer uma nova lista de nomes, digite 'n':");
	}

	public static void digiteUmCaractereValido() {
		limpaTela(1);
		System.out.println("Entrada invalida. Digite apenas 'S' ou 'N'.");
	}

	public static void verificarContinuacao() {
		limpaTela(2);
		System.out.println("Deseja cadastrar outro nome? Se sim, digite 'S'. Se nao, digite 'N'.");
	}

}
