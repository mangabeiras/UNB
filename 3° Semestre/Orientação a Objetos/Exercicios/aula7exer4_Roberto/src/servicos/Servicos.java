package servicos;

import dados.Empresa;
import dados.Funcionario;
import validacao.Validacao;

public class Servicos {
	// REGISTRADORAS
	public static void registraRegular(Empresa empresa) {
		empresa.registraRegular(Validacao.validaNome(),
				Validacao.validaCpf(empresa.getEmpresa()), 
				Validacao.validaNascimento());
	}
	public static void registraPrestador(Empresa empresa) {
		empresa.registraPrestador(Validacao.validaNome(),
				Validacao.validaCpf(empresa.getEmpresa()),
				Validacao.validaNascimento(),
				Validacao.validaInt(180));
	}
	public static void registraGerente(Empresa empresa) {
		empresa.registraGerente(Validacao.validaNome(),
				Validacao.validaCpf(empresa.getEmpresa()),
				Validacao.validaNascimento(),
				Validacao.validaInt(100));
	}
	
	// OBTEM A QTD DE TRABALHADORES POR CATEGORIA
	public static int getQuantidadeCategoria(Empresa empresa, String codigo) {
		int contador = 0;
		
		for (Funcionario funcionario : empresa.getEmpresa()) {
			if (funcionario.getCategoria().equals(codigo))
				contador++;
		}
		return contador;
	}
	// OBTEM A SOMA DOS SALARIOS POR CATEGORIA
	public static float getSalarioCategoria(Empresa empresa, String codigo) {
		float total = 0;
		
		for (Funcionario funcionario : empresa.getEmpresa())
			if (funcionario.getCategoria().equals(codigo))
				total += funcionario.calculaSalario();
		return total;
	}
}
