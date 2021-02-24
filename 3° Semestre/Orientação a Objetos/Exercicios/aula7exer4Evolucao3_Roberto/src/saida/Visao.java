package saida;

import java.text.DecimalFormat;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;

import dados.Empresa;
import dados.Funcionario;
import dados.Gerente;
import dados.PrestadorServicos;
import validacao.Validacao;

public class Visao {
	public static void mostraMensagem(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Titulo", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void mostraMensagemErro(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Erro de entrada", JOptionPane.WARNING_MESSAGE);
	}

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++) {
			System.out.println();
		}
	}

	public static String[] menu(int codigo) {
		if (codigo == 0) {
			String menu[] = { "CADASTRAR UM FUNCIONARIO REGULAR", "CADASTRAR UM PRESTADOR DE SERVICOS",
					"CADASTRAR UM GERENTE", "SAIR" };
			return menu;
		} else {
			String menu[] = { "TOTAL DE FUNCIONARIOS POR CATEGORIA", "SALARIO TOTAL A SER PAGO PARA CADA CATEGORIA",
					"ENCERRAR O PROGRAMA" };
			return menu;
		}
	}

	public static void mostraRelatorio(Empresa empresa) {
		if (empresa.getFuncionarios().isEmpty()) {
			Visao.mostraMensagem("Nenhum funcionario cadastrado!");
			return;
		}
		StringBuilder resultado = new StringBuilder();
		for (Funcionario funcionario : empresa.getFuncionarios())
			resultado.append(funcionario.toString());
	
		mostraMensagem(String.format("%-20s%-30s%-40s%-20s%-20s\n", "1º NOME", "CPF", "DATA DE NASCIMENTO", "HORAS",
					"PROJETOS") + resultado);
		int opcaoMenu;

		while ((opcaoMenu = Validacao.validaOpcao(1)) != 0) {
			Visao.limpaTela(2);
			switch (opcaoMenu) {
			case 1:
				mostraQuantidadeFuncionarios(empresa);
				break;
			case 2:
				mostraTotalSalarialFuncionarios(empresa);
			}
		}
	}

	private static void mostraTotalSalarialFuncionarios(Empresa empresa) {
		double salarioFuncionarioRegular = 0;
		double salarioPrestadorServico = 0;
		double salarioGerente = 0;
		DecimalFormat mascara = new DecimalFormat("0.00");
		
		for (Funcionario funcionario : empresa.getFuncionarios()) {
			try {
				salarioGerente += ((Gerente) funcionario).calculaSalario();
			} catch(ClassCastException e) {
				try {
					salarioPrestadorServico += ((PrestadorServicos) funcionario).calculaSalario();
				} catch(ClassCastException e1) {
					salarioFuncionarioRegular += funcionario.calculaSalario();
				}
			}	
		}

		Visao.limpaTela(30);
		mostraMensagem(String.format("%-20s%-10s\n","CATEGORIA", "FUNCIONARIOS") +
				String.format("%-25s%10s\n","REGULAR", mascara.format(salarioFuncionarioRegular)) +
				String.format("%-25s%10s\n","SERVICOS", mascara.format(salarioPrestadorServico)) +
				String.format("%-25s%10s\n","GERENTE", mascara.format(salarioGerente)) +
				String.format("%-28s%10s\n","TOTAL", mascara.format(salarioFuncionarioRegular + salarioGerente + salarioPrestadorServico)));	
	}

	private static void mostraQuantidadeFuncionarios(Empresa empresa) {
		int qtdFuncionarioRegular = 0;
		int qtdPrestadorServicos = 0;
		int qtdGerente = 0;
		DecimalFormat mascara = new DecimalFormat("00");

		for (Funcionario funcionario : empresa.getFuncionarios()) {
			try {
				funcionario = ((Gerente) funcionario);
				qtdGerente++;
			} catch(ClassCastException e) {
				try {
					funcionario = ((PrestadorServicos) funcionario);
					qtdPrestadorServicos++;
				} catch(ClassCastException e2) {
					qtdFuncionarioRegular++;
				}
			}
		}

		Visao.limpaTela(30);
		mostraMensagem(String.format("%-20s%-10s\n","CATEGORIA", "FUNCIONARIOS") +
				String.format("%-26s%10s\n","REGULAR", mascara.format(qtdFuncionarioRegular)) +
				String.format("%-25s%10s\n","SERVICOS", mascara.format(qtdPrestadorServicos)) +
				String.format("%-26s%10s\n","GERENTE", mascara.format(qtdGerente)) +
				String.format("%-29s%10s\n","TOTAL", mascara.format(qtdFuncionarioRegular + qtdPrestadorServicos + qtdGerente)));
	}
}
