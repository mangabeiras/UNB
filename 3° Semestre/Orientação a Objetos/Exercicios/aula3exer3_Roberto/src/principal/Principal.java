package principal;

public class Principal {

	public static void main(String[] args) {
		String salvaNome = null;
		int salvaIdade=0;
		float salvaAltura=0;
		int i=0;
		do {
			System.out.println("CADASTRO "+(i+1)+" PESSOA\n");
			
			System.out.print("Nome:");
			salvaNome = Validacao.validaNome(salvaNome);
			
			System.out.print("Idade:");
			salvaIdade = Validacao.validaIdade(salvaIdade);
			
			System.out.print("Altura:");
			salvaAltura = Validacao.validaAltura(salvaAltura);
			
			Servicos.limpaTela(10);
			System.out.println("Deseja continuar cadastrando?(S/N):");
			
			// INDICE DO NUM DA PESSOA
			i++;
			
			// CADASTRO DOS DADOS SALVOS
			Servicos.passaDados(salvaNome, salvaIdade, salvaAltura, i);
				
		} while (Validacao.validaContinua());

	}

}
