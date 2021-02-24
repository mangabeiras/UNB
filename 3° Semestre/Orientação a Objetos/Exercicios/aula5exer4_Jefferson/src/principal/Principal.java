package principal;

import java.util.Vector;

import dados.CadastroPessoa;
import saida.Saida;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {

		// FALTA PARAMETRIZAR OS VETORES (?????????????????????)
		Vector conjuntodePessoas = new Vector();

		do {
			CadastroPessoa pessoas = new CadastroPessoa();
			pessoas.setDadosDaPessoa(pessoas.getDadosDaPessoa());

			conjuntodePessoas.add(pessoas);
		} while (Validacao.validaContinua() || Saida.solicitarEncerramento(conjuntodePessoas));
	}
}