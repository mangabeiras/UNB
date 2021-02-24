package servicos;

import dados.Exposicao;
import dados.Pintor;
import dados.Quadro;
import leitura.Leitura;
import validacao.Validacao;
import visao.Visao;

// APOS A ESCOLHA NO MENU, SERVICOS EXECUTA O DESEJO DO USUARIO
public class Servicos {
	// REALIZA A FUNCAO DE CADA OPCAO
	public static boolean opcoes(Exposicao exposicao, final int ANONIMO, final int MAXIMO) {
		// DECLARACAO
		int codigoPintor;

		// INSTRUCOES
		Visao.interacao(1);
		switch (Validacao.validaOpcao()) {
		case 1: {
			
			// CATALOGO DE ARTISTAS
			Visao.resultado(2, null, 0, 0);
			for (int i = 0; i < exposicao.getPintor().size(); i++)
				Visao.resultado(3, exposicao.getPintor().get(i).getNome(), 0, (i + 1));
			
			// CADASTRO DE QUADRO
			Visao.interacao(4);
			codigoPintor = Validacao.validaPintor(exposicao);
			exposicao.setQuadro(new Quadro(Validacao.validaNome(8), Validacao.validaPreco(), Validacao.validaAno(9, exposicao.getPintor().get(codigoPintor-1).getNascimento(), (MAXIMO+5))),
					(codigoPintor - 1));
			break;
		}
		case 2: {
			// CADASTRO DE PINTOR
			Visao.interacao(0);
			exposicao.setPintor(new Pintor(Validacao.validaNome(2), Validacao.validaAno(3, ANONIMO, MAXIMO)));
			break;
		}
		case 3: {
			
			// PESQUISA PINTOR
			float soma = 0;
			codigoPintor = identificaPintor(exposicao);
			for (int i = 0; i < exposicao.getQuadros(codigoPintor - 1).size(); i++) {
				Visao.resultado(0, exposicao.getQuadros(codigoPintor - 1).get(i).getNome(), 0, i);
				soma += exposicao.getQuadros(codigoPintor - 1).get(i).getPreco();
			}
			Visao.resultado(1, null, soma, 0);
			return Validacao.validaContinua();
		}
		case 4: {
			
			// TOTAL DE QUADROS CADASTRADOS ATE O MOMENTO
			for (int i = 0; i < exposicao.getPintor().size(); i++) {
				for (int aux = 0; aux < exposicao.getQuadros(i).size(); aux++)
					Visao.resultado(0, exposicao.getQuadros(i).get(aux).getNome(), 0, 1);
			}
			return Validacao.validaContinua();
		}
		default:
			return false;
		}
		return true;
	}

	public static int identificaPintor(Exposicao exposicao) {
		// DECLARACOES
		String nomeLido;
		int contador = 0;

		// INSTRUCOES
		Visao.interacao(7);
		do {
			nomeLido = Leitura.leString();
			while (contador < exposicao.getPintor().size()) {
				if (exposicao.getPintor().get(contador).getNome().toLowerCase().contains(nomeLido.toLowerCase()))
					return (contador + 1);
				contador++;
			}
			contador = 0;
			Visao.erroEntrada(8, 0, 0);
		} while (contador == 0);
		return contador;
	}
}
