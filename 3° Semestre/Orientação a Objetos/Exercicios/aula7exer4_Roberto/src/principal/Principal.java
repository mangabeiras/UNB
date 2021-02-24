package principal;

import dados.Empresa;
import servicos.Servicos;
import validacao.Validacao;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {
		// DECLARACOES
		Empresa empresa = new Empresa();
		int escolha;
		
		// INTRUCOES
		do {
			Visao.limpaTela((empresa.getEmpresa().size() != 0) ? 50 : 0);
			Visao.menu(0);
			escolha = Validacao.validaInt(3);
			switch (escolha) {
			case 1: {
				Servicos.registraRegular(empresa);
				break;
			}
			case 2: {
				Servicos.registraPrestador(empresa);
				break;
			}
			case 3: {
				Servicos.registraGerente(empresa);
			}
			}
		} while (escolha != 0);
		
		// RESULTADO
		Visao.mostraRelatorio(empresa);
		do {
			Visao.menu(1);
			escolha = Validacao.validaInt(2);
			Visao.resultado(empresa, escolha);
		} while(escolha != 0);
	}

}
