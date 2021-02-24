package principal;

import dados.Empresa;
import dados.Funcionario;
import dados.Gerente;
import dados.PrestadorServicos;
import saida.Visao;
import validacao.Validacao;

public class Principal {
	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		int opcaoMenu;

		do {
			opcaoMenu = Validacao.validaMenu();
			switch (opcaoMenu) {
			case 0:
				empresa.setFuncionarios(new Funcionario(Validacao.validaNome(), Validacao.validaDataNascimento(),
										Validacao.validaCpf(empresa), 'R'));
				break;
			case 1:
				empresa.setFuncionarios(new PrestadorServicos(Validacao.validaNome(),Validacao.validaDataNascimento(), 
										Validacao.validaCpf(empresa), 'S', Validacao.validaHorasTrabalhadas()));
				break;
			case 2:
				empresa.setFuncionarios(new Gerente(Validacao.validaNome(),Validacao.validaDataNascimento(),
										Validacao.validaCpf(empresa), 'G', Validacao.validaQuantidadeProjetos()));
			
				break;
			case 3:
				Visao.mostraRelatorio(empresa);
			}
		} while (opcaoMenu != 4);
		
		Visao.mostraTodosRegistros(empresa);
	}
}
