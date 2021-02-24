package principal;

//import saida.Servicos;
import dados.Pessoa;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {

		do {
			Pessoa pessoa = new Pessoa(Validacao.validaNome());
			System.out.println(pessoa.getString());

		} while (Validacao.validaContinua());
	}

}
