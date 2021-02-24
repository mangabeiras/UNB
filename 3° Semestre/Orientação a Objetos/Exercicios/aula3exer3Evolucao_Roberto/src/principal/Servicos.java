package principal;
import java.text.*;

public class Servicos {
	public static void limpaTela(int linhas){
		for(int i = 0;i < linhas;i++)
			System.out.println();
	}
	
	// METODO QUE CHAMA OUTROS METODOS DE OUTRAS CLASSES PARA INTERAGIR COM O USUARIO DURANTE TODO O PROGRAMA
	public static Pessoa interageSalva(Pessoa pessoa, int i) {
		Saida.pedirNome(i);
		pessoa.setNome(Validacao.validaNome(Leitura.leituraLinha()));
		
		Saida.pedirIdade();
		pessoa.setIdade(Validacao.validaIdade(Leitura.leituraInt()));
		
		Saida.pedirAltura();
		pessoa.setAltura(Validacao.validaAltura(Leitura.leituraFloat()));
		
		Saida.continua();
		
		return pessoa;
	}
}
