package visao;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import dados.Empregado;
import dados.Empresa;
import dados.GrupoTerreno;
import dados.Terreno;
import interfaces.AnaliseDados;
import leitura.Leitura;

public class Visao {
	// MOSTRA JANELA COM MENSAGEM INFORMACIONAL
	public static void mostraMensagem(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	// MOSTRA JANELA COM MENSAGEM DE ERRO
	public static void mostraMensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "ERRO", JOptionPane.WARNING_MESSAGE);
	}

	// MENU DE ANALISES
	public static void mostraAnalise(AnaliseDados dados, char id, GrupoTerreno lotes) {
		if (id == 'E') {
			String[] opcoes = { "Menores e Maiores", "Somatorios", "Medias" };
			switch (Leitura.leMenu(opcoes)) {
			case 0:
				mostraMenorMaior(dados, id);
				break;
			case 1:
				mostraSomatorio(dados, id);
				break;
			case 2:
				mediaValores(dados, id);
			}
		} 
		if (id == 'T') {
			String[] opcoes = { "Menores e Maiores", "Duplicidade", "Somatorios", "Medias" };
			switch (Leitura.leMenu(opcoes)) {
			case 0:
				mostraMenorMaior(dados, id);
				break;
			case 1:
				analisaDuplicidade(lotes);
				break;
			case 2:
				mostraSomatorio(dados, id);
				break;
			case 3:
				mediaValores(dados, id);
			}
		}
	}

	// MOSTRA MENOR E MAIOR SALARIO OU MENOR E MAIOR PRECO DOS TERRENOS
	public static void mostraMenorMaior(AnaliseDados dados, char id) {
		DecimalFormat mascara = new DecimalFormat("0.00");

		switch (id) {
		case 'E':
			if (dados.somaArray('S') == 0)
				mostraMensagemErro("Sem funcionarios cadastrados!");
			else
				mostraMensagem("Maior Salario: " + mascara.format(dados.menorMaior('+')) + "\nMenor Salario: "
						+ mascara.format(dados.menorMaior('-')), "SALARIOS");
			break;
		case 'T':
			if (dados.somaArray('P') == 0)
				mostraMensagemErro("Sem Terrenos Cadastrados!");
			else
				mostraMensagem(
						"Maior Preco de Terreno: " + mascara.format(dados.menorMaior('+'))
								+ "\nMenor Preco de Terreno: " + mascara.format(dados.menorMaior('-')),
						"PRECOS DOS TERRENOS");
		}
	}
	// ANALISA EXISTENCIA DE VALORES REPETIDOS NAS AREAS DOS LOTES
	public static void analisaDuplicidade(GrupoTerreno lotes) {
		int aux = 0;
		for (Terreno terreno : lotes.getGrupoTerrenos()) {
			if (lotes.isRepetido(terreno.getArea())) {
				if (aux == 0)
					mostraMensagem("Lotes de mesma area encontrados!", "Duplicidade");
				mostraDuplicidade(terreno, aux++);
			}
		}
		if (aux == 0)
			mostraMensagem("Sem duplicidade", "Duplicidade");
	}
	// MOSTRA TERRENOS COM VALORES REPETIDOS ENCONTRADOS
	public static void mostraDuplicidade(Terreno terreno, int aux) {
		if (aux == 0) {
			limpaTela(50);
			System.out.println("Lotes com mesma Area: ");
			System.out.format("%-20s%-15s%-15s\n", "ENDERECO", "AREA", "PRECO");
		}
		System.out.print(terreno);
	}
	// ANALISE DE SOMATORIOS DE VALORES
	public static void mostraSomatorio(AnaliseDados dados, char id) {
		DecimalFormat mascara = new DecimalFormat("0.00");

		switch (id) {
		case 'E':
			mostraMensagem("Soma dos Salarios: " + mascara.format(dados.somaArray('S')), "Soma dos Salarios");
			break;
		case 'T':
			String[] opcoes = { "Soma das Areas", "Soma dos Precos" };
			switch (Leitura.leMenu(opcoes)) {
			case 0:
				mostraMensagem("Soma das Areas: " + mascara.format(dados.somaArray('A')), "Soma das Areas");
				break;
			case 1:
				mostraMensagem("Soma dos Precos: " + mascara.format(dados.somaArray('P')), "Soma dos Precos");
			}
		}
	}
	// ANALISE DE MEDIAS DE VALORES
	public static void mediaValores(AnaliseDados dados, char id) {
		DecimalFormat mascara = new DecimalFormat("0.00");

		switch (id) {
		case 'E':
			mostraMensagem("Media dos Salarios: " + mascara.format(dados.media('S')), "Media dos Salarios");
			break;
		case 'T':
			String[] opcoes = { "Media das Areas", "Media dos Precos" };
			switch (Leitura.leMenu(opcoes)) {
			case 0:
				mostraMensagem("Media das areas dos Terrenos: " + mascara.format(dados.media('A')), "Media das Areas");
				break;
			case 1:
				mostraMensagem("Media dos Precos dos Terrenos: " + mascara.format(dados.media('P')),
						"Media dos Precos");
			}
		}
	}

	public static void limpaTela(int saltos) {
		for (int i = 0; i < saltos; i++)
			System.out.println();
	}
	// RELATORIO FINAL
	public static void mostraRelatorio(Empresa empresa, GrupoTerreno lotes) {
		limpaTela(50);
		if (empresa.getEmpresa().isEmpty())
			System.out.println("SEM FUNCIONARIOS CADASTRADOS");
		else {
			System.out.println("Funcionarios: ");
			System.out.format("%-20s%-15s%-15s\n", "NOME", "MATRICULA", "SALARIO");
			for (Empregado empregado : empresa.getEmpresa())
				System.out.print(empregado);
		}

		limpaTela(2);
		if (lotes.getGrupoTerrenos().isEmpty())
			System.out.println("SEM TERRENOS CADASTRADOS");
		else {
			System.out.println("Terrenos: ");
			System.out.format("%-20s%-15s%-15s\n", "ENDERECO", "AREA", "PRECO");
			for (Terreno terreno : lotes.getGrupoTerrenos())
				System.out.print(terreno);
		}
	}
}
