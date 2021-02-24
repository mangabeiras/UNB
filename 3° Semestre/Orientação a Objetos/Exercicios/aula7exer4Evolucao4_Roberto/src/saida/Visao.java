package saida;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import dados.Empresa;
import dados.Funcionario;
import dados.Pessoa;
import validacao.Validacao;

public class Visao {
	public static void mostraMensagem(String msg, String titulo) {
		JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void mostraMensagemErro(String msg) {
		JOptionPane.showMessageDialog(null, msg, "ERRO", JOptionPane.WARNING_MESSAGE);
	}

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++) {
			System.out.println();
		}
	}

	public static void mostraRelatorio(Empresa empresa) {
		int qtdFuncionarios[] = new int[3];
		float salarios[] = new float[3];
		if (empresa.getFuncionarios().isEmpty()) {
			Visao.mostraMensagem("Nenhum funcionario cadastrado!", "Informacao");
			return;
		}
		for (Funcionario funcionario : empresa.getFuncionarios()) {
			if (funcionario.getCategoria() == 'R') {
				qtdFuncionarios[0]++;
				salarios[0] += funcionario.calculaSalario();
			}
			else if (funcionario.getCategoria() == 'S') {
				qtdFuncionarios[1]++;
				salarios[1] += funcionario.calculaSalario();
			}
			else {
				qtdFuncionarios[2]++;
				salarios[2] += funcionario.calculaSalario();
			}
		}

		int opcaoMenu;

		while ((opcaoMenu = Validacao.validaMenuRelatorio()) != 2) {
			Visao.limpaTela(2);
			switch (opcaoMenu) {
			case 0:
				mostraQuantidadeFuncionarios(empresa, qtdFuncionarios[0], qtdFuncionarios[1], qtdFuncionarios[2]);
				break;
			case 1:
				mostraTotalSalarialFuncionarios(empresa, salarios[0], salarios[1], salarios[2]);
			}
		}
		limpaTela(2);
	}

	private static void mostraTotalSalarialFuncionarios(Empresa empresa, float salarioFuncionarioRegular, float salarioPrestadorServico, float salarioGerente) {
		DecimalFormat mascara = new DecimalFormat("0.00");

		Visao.limpaTela(30);
		System.out.format("%-20s%-10s\n", "CATEGORIA", "SALARIO");
		System.out.format("%-20s%-10s\n", "REGULAR", mascara.format(salarioFuncionarioRegular));
		System.out.format("%-20s%-10s\n", "SERVIDOR", mascara.format(salarioPrestadorServico));
		System.out.format("%-20s%-10s\n", "GERENTE", mascara.format(salarioGerente));
		System.out.format("%-20s%-10s\n", "TOTAL", mascara.format(salarioFuncionarioRegular + salarioPrestadorServico + salarioGerente));
		Visao.limpaTela(2);
	}

	private static void mostraQuantidadeFuncionarios(Empresa empresa, int qtdFuncionarioRegular, int qtdPrestadorServicos, int qtdGerente) {
		Visao.limpaTela(30);
		DecimalFormat mascara = new DecimalFormat("00");
		System.out.format("%-20s%-10s\n", "CATEGORIA", "SALARIO");
		System.out.format("%-20s%-10s\n", "REGULAR", mascara.format(qtdFuncionarioRegular));
		System.out.format("%-20s%-10s\n", "SERVIDOR", mascara.format(qtdPrestadorServicos));
		System.out.format("%-20s%-10s\n", "GERENTE", mascara.format(qtdGerente));
		System.out.format("%-20s%-10s\n", "TOTAL", mascara.format(qtdFuncionarioRegular + qtdPrestadorServicos + qtdGerente));
		Visao.limpaTela(2);
	}
	
	public static void mostraTodosRegistros(Empresa empresa) {
		
		System.out.format("%-15s%-15s%-15s%-15s%-22s%s\n", "NOME", "NASCIMENTO", "CPF", 
				"SALARIO", "HORAS TRABALHADAS", "QUANTIDADE PROJETOS" );
		for (Pessoa pessoa : empresa.getFuncionarios()) {
			System.out.println(pessoa);
		}
	}
}

