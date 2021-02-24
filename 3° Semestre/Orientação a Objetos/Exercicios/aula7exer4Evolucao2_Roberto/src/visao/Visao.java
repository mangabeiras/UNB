package visao;

import java.text.DecimalFormat;

import dados.Empresa;
import dados.Funcionario;
import servicos.Servicos;

public class Visao {
	// MOSTRA UMA MENSAGEM DESEJADA
	public static void mensagem(String mensagem) {
		System.out.print(mensagem);
	}
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
	
	public static void limpaTela(int saltos) {
		for (int i = 0; i < saltos; i++)
			System.out.println();
	}
	
	// RELATORIO
	public static void mostraRelatorio(Empresa empresa) {
		String formato = "%-13s%-15s%-20s%-13s%-10s\n";
		System.out.format(formato, "1º NOME", "CPF", "DATA DE NASCIMENTO", "HORAS", "PROJETOS");
		for (Funcionario funcionario : empresa.getEmpresa())
			System.out.print(funcionario);
		limpaTela(2);
	}
	// RESULTADO FINAL
	public static void resultado(Empresa empresa, char codigo) {
		String formato = "%-20s%-10s\n";
		DecimalFormat mascara = new DecimalFormat("0.00");
		limpaTela(20);
		if (codigo == '1') {
			int quantidade[] = Servicos.getQuantidadeCategoria(empresa);
			System.out.format(formato, "CATEGORIA", "FUNCIONARIOS");				
			System.out.format(formato, "REGULAR", quantidade[2]);
			System.out.format(formato, "PRESTADOR", quantidade[1]);
			System.out.format(formato, "GERENTE", quantidade[0]);
			System.out.format(formato, "TOTAL",  quantidade[3]);
		}
		if (codigo == '2') {
			float total[] = Servicos.getSalarioCategoria(empresa);
			System.out.format(formato, "CATEGORIA", "FUNCIONARIOS");
			System.out.format(formato, "REGULAR", mascara.format(total[2]));
			System.out.format(formato, "PRESTADOR", mascara.format(total[1]));
			System.out.format(formato, "GERENTE", mascara.format(total[0]));
			System.out.format(formato, "TOTAL",  mascara.format(total[3]));
		}
		limpaTela(2);		
	}
}
