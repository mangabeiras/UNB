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
			opcaoMenu = Validacao.validaOpcao(0);
			switch (opcaoMenu) {
			case 1:
				empresa.addFuncionarios(new Funcionario(Validacao.validaNome(), Validacao.validaDataNascimento(),
						Validacao.validaCpf(empresa)));
				break;
			case 2:
				empresa.addFuncionarios(new PrestadorServicos(Validacao.validaNome(), Validacao.validaDataNascimento(),
						Validacao.validaCpf(empresa), Validacao.validaInt("Horas trabalhadas: ", 0, 100)));
				break;
			case 3:
				empresa.addFuncionarios(new Gerente(Validacao.validaNome(), Validacao.validaDataNascimento(),
						Validacao.validaCpf(empresa), Validacao.validaInt("Projetos", 0, 50)));
				break;
			case 0:
				Visao.mostraRelatorio(empresa);
			}
		} while (opcaoMenu != 0);
	}
}
