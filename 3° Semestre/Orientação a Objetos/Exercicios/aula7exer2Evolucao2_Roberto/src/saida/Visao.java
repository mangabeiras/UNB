package saida;

import java.text.DecimalFormat;
import dados.Galeria;
import dados.Pintor;
import dados.Quadro;

public class Visao {
	public static void mostraMensagem (String mensagem) {
		System.out.println(mensagem);
	}
	
	public static String[] menu () {
		String opcoes[] = {"Cadastrar Novo Quadro",
				"Cadastrar Novo Pintor",
				"Listar Quadro(s) de um Pintor",
				"Mostrar todo(s) Quadro(s)",
				"Encerrar Programa"};
		return opcoes;
	}
	
	public static void mostraQuadros (Galeria galeria) {
		limpaTela(50);
		System.out.format("%-30s%-30s%-20s%-20s\n", "IDENTIFICACAO QUADRO", "IDENTIFICACAO PINTOR", "PRECO", "ANO AQUISICAO");
		for (Pintor pintor : galeria.getListaPintores()) {
			for (Quadro quadro : pintor.getQuadros()) {
				System.out.print(quadro);
			}
		}
	}
	
	public static void mostraQuadrosNome (Galeria galeria, String nome) {
		float total = 0f;
		int codigoProcurado = achaCodigoPintor(galeria, nome);
		
		limpaTela(50);
		if (codigoProcurado == -1) {
			mostraMensagem("Nenhum quadro encontrado para o pintor [" + nome + "].");
			return ;
		}
		
		mostraMensagem("Quadro(s) encontrado(s) com [" + nome + "].");
		System.out.format("%-30s%-30s%-30s%-20s%-20s\n", "NOME PINTOR", "IDENTIFICACAO QUADRO",  "IDENTIFICACAO PINTOR", "PRECO", "ANO AQUISICAO");
		for (Pintor pintor : galeria.getListaPintores()) {
			for (Quadro quadro : pintor.getQuadros()) {
				if (pintor.getNome().toUpperCase().contains(nome.toUpperCase())) {
					total += quadro.getPreco();
					System.out.format("%-30s", pintor.getNome());
					System.out.print(quadro);
				}
			}
		}
		limpaTela(2);
		mostraMensagem("Soma total dos valores dos quadros: " + new DecimalFormat("0.00").format(total));
	}
	
	public static int achaCodigoPintor (Galeria galeria, String nome) {
		for (Pintor pintor : galeria.getListaPintores()) {
			if (pintor.getNome().toUpperCase().contains(nome.toUpperCase())) {
				return pintor.getCodigoPessoal();
			}
		}
		return -1;
	}
	
	public static void limpaTela (int qtd) {
		for (int i = 0; i < qtd; i++)
			System.out.println();
	}
}
