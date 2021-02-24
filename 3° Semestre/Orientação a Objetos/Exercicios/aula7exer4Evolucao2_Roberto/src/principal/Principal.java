package principal;

import dados.Empresa;
import servicos.Servicos;
import validacao.Validacao;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {
		// DECLARACOES
		final float PISO = 232f;
		Empresa empresa = new Empresa();
		char menu;
		
		// INSTRUCOES
		do {
			Visao.menu(0);
			menu = Validacao.validaChar("0123", "Insira uma opcao: ");
			switch(menu) {
			case '1':{
				Servicos.registraRegular(empresa, PISO);
				break;
			}
			case '2':{
				Servicos.registraPrestador(empresa, PISO);
				break;
			}
			case '3':{
				Servicos.registraGerente(empresa, PISO);
			}
			}
		} while(menu != '0');
		
		// RESULTADO
		Visao.mostraRelatorio(empresa);
		do {
			Visao.menu(1);
			menu = Validacao.validaChar("012", "Insira uma opcao: ");
			Visao.resultado(empresa, menu);
		} while (menu != '0');
	}

}
