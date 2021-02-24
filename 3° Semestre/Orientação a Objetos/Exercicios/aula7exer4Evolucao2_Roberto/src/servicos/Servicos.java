package servicos;

import dados.Empresa;
import dados.Funcionario;
import dados.Gerente;
import dados.Prestador;
import validacao.Validacao;

public class Servicos {
	// REGISTRADORAS
	public static void registraRegular(Empresa empresa, final float PISO) {
		empresa.addFuncionario(new Funcionario(Validacao.validaString(),
				Validacao.validaCpf(empresa.getEmpresa()),
				Validacao.validaNascimento(), PISO));
	}
	public static void registraPrestador(Empresa empresa, final float PISO) {
		empresa.addFuncionario(new Prestador(Validacao.validaString(),
				Validacao.validaCpf(empresa.getEmpresa()),
				Validacao.validaNascimento(), PISO,
				Validacao.validaInt(0, 200, "NUMERO DE HORAS TRABALHADAS: ")));
	}
	public static void registraGerente(Empresa empresa, final float PISO) {
		empresa.addFuncionario(new Gerente(Validacao.validaString(),
				Validacao.validaCpf(empresa.getEmpresa()),
				Validacao.validaNascimento(), PISO,
				Validacao.validaInt(0, 200, "NUMERO DE PROJETOS EXECUTADOS: ")));
	}
	
	// OBTEM A QUANTIDADE DE TRABALHADORES POR CATEGORIA
	public static int[] getQuantidadeCategoria(Empresa empresa) {
		int quantidade[] = new int[4];
		
		/* quantidade[0] = QTD DE GERENTES
		 * quantidade[1] = QTD DE PRESTADORES
		 * quantidade[2] = QTD DE REGULARES 
		 * quantidade[3] = QTD TOTAL
		 */
		for (Funcionario funcionario : empresa.getEmpresa()) {
			if (funcionario instanceof Gerente)
				quantidade[0]++;
			else if (funcionario instanceof Prestador)
					quantidade[1]++;
			else 
				quantidade[2]++; // QTD DE REGULAR
			}
		quantidade[3] = quantidade[0] + quantidade[1] + quantidade[2];
		return quantidade;
	}
	
	// OBTEM OS SALARIOS TOTAIS POR CATEGORIA
	public static float[] getSalarioCategoria(Empresa empresa) {
		float total[] = new float[4];
		
		/* total[0] = SALARIO GERENTES
		 * total[1] = SALARIO PRESTADORES
		 * total[2] = SALARIO REGULARES
		 * total[3] = TOTAL 
		 */
		for (Funcionario funcionario : empresa.getEmpresa()) {
			if (funcionario instanceof Gerente)
				total[0] += ((Gerente) funcionario).calculaSalario(funcionario.getSalario());
			else if (funcionario instanceof Prestador)
				total[1] += ((Prestador) funcionario).calculaSalario(funcionario.getSalario());
			else
				total[2] += funcionario.calculaSalario(funcionario.getSalario()); // SALARIO REGULAR 
		}
		total[3] = total[0] + total[1] + total[2]; // SOLMA DOS SALARIOS
		return total;
	}
}	
