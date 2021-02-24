package principal;

import dados.Empregado;
import dados.Empresa;
import dados.GrupoTerreno;
import dados.Terreno;
import interfaces.AnaliseDados;
import leitura.Leitura;
import validacao.Validacao;
import visao.Visao;

public class Principal {
	public static void main(String[] args) {
		// DECLARACOES
		Empresa empresa = new Empresa();
		GrupoTerreno lotes = new GrupoTerreno();
		
		// INSTRUCOES
		menuCadastro(empresa, lotes);
		while (menuCentral(empresa, lotes));

		Visao.mostraRelatorio(empresa, lotes);
	}
	// MENU CENTRAL DO PROGRAMA
	public static boolean menuCentral(Empresa empresa, GrupoTerreno lotes) {
		String[] opcoes = { "Cadastro", "Analise", "Encerrar" };
		switch (Leitura.leMenu(opcoes)) {
		case 0:
			menuCadastro(empresa, lotes);
			return true;
		case 1:
			empregadoOuTerreno(empresa, lotes);
			return true;
		default:
			return false;
		}
	}
	// MENU QUE REALIZA O CADASTRO
	public static void menuCadastro(Empresa empresa, GrupoTerreno lotes) {
		String[] opcoes = { "Cadastro de Empregado", "Cadastro de Terreno" };
		switch (Leitura.leMenu(opcoes)) {
		case 0:
			AnaliseDados dados = empresa;
			empresa.addEmpregado(
					new Empregado(Validacao.validaNome(), Validacao.validaMatricula(dados), Validacao.validaSalario()));
			break;
		case 1:
			lotes.addTerreno(new Terreno(Validacao.validaEndereco(), Validacao.validaArea(), Validacao.validaPreco()));
		default:
			if (empresa.getEmpresa().isEmpty() && lotes.getGrupoTerrenos().isEmpty()) {
				Visao.mostraMensagemErro("É primeiro necessario salvar algum dado!");
				menuCadastro(empresa, lotes);
			}
		}
	}
	// REALIZA A ANALISE DE EMPREGADO OU DE TERRENO
	public static void empregadoOuTerreno(Empresa empresa, GrupoTerreno lotes) {
		String[] opcoes = { "Analise Empregados", "Analise Terrenos" };
		AnaliseDados dados;
		switch (Leitura.leMenu(opcoes)) {
		case 0: {
			dados = empresa;
			Visao.mostraAnalise(dados, 'E', lotes);
			break;
		}
		case 1:
			dados = lotes;
			Visao.mostraAnalise(dados, 'T', lotes);
		}
	}
}
