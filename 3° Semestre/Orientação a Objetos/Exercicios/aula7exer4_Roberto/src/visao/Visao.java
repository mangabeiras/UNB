package visao;

import java.text.DecimalFormat;

import dados.Empresa;
import dados.Funcionario;
import servicos.Servicos;

public class Visao {
	// MENUS
	public static void menu(int codigo) {
		if (codigo == 0) {
			System.out.println("MENU "+(codigo + 1)+"\n[1] - CADASTRAR UM FUNCIONARIO REGULAR");
			System.out.println("[2] - CADASTRAR UM PRESTADOR DE SERVICOS");
			System.out.println("[3] - CADASTRAR UM GERENTE\n[0] - SAIR");
		}
		if (codigo == 1) {
			System.out.println("MENU "+(codigo + 1)+"\n[1] - TOTAL DE FUNCIONARIOS POR CATEGORIA");
			System.out.println("[2] - SALARIO TOTAL A SER PAGO PARA CADA CATEGORIA");
			System.out.println("[0] - ENCERRAR O PROGRAMA");
		}		
	}
	// REQUERIMENTO DOS DADOS
	public static void interacao(int codigo) {
		if (codigo == 0)
			System.out.print("NOME COMPLETO: ");
		if (codigo == 1)
			System.out.print("CPF: ");
		if (codigo == 2)
			System.out.print("DATA DE NASCIMENTO (no formato DD/MM/AAAA): ");
		if (codigo == 3)
			System.out.print("HORAS TRABALHADAS: ");
		if (codigo == 4)
			System.out.print("QUANTIDADE DE PROJETOS: ");
		if (codigo == 5)
			System.out.println("Digite 'S' para cadastrar outro funcionario, 'N' para parar:");
	}
	
	public static void limpaTela(int saltos) {
		for (int i = 0; i < saltos; i++)
			System.out.println();
	}
	// RESULTADO FINAL
	public static void mostraRelatorio(Empresa empresa) {
		String formato = "%-20s%-15s%-13s%-20s%-10s%-10s\n";
		System.out.format(formato, "PRIMEIRO NOME", "CATEGORIA","CPF", "DATA DE NASCIMENTO", "HORAS", "PROJETOS");
		for (Funcionario funcionario : empresa.getEmpresa())
			System.out.print(funcionario);
		
		limpaTela(2);
	}
	public static void resultado(Empresa empresa, int codigo) {
		String formato = "%-20s%-10s\n";
		DecimalFormat mascara = new DecimalFormat("0.00");
		limpaTela(20);
		if (codigo == 1) {
			System.out.format(formato, "CATEGORIA", "FUNCIONARIOS");				
			System.out.format(formato, "REGULAR", Servicos.getQuantidadeCategoria(empresa, "Regular"));
			System.out.format(formato, "PRESTADOR", Servicos.getQuantidadeCategoria(empresa, "Prestador"));
			System.out.format(formato, "GERENTE", Servicos.getQuantidadeCategoria(empresa, "Gerente"));
		}
		if (codigo == 2) {
			System.out.format(formato, "CATEGORIA", "FUNCIONARIOS");
			System.out.format(formato, "REGULAR", mascara.format(Servicos.getSalarioCategoria(empresa, "Regular")));
			System.out.format(formato, "PRESTADOR", mascara.format(Servicos.getSalarioCategoria(empresa, "Prestador")));
			System.out.format(formato, "GERENTE", mascara.format(Servicos.getSalarioCategoria(empresa, "Gerente")));
		}
		limpaTela(2);		
	}
}
