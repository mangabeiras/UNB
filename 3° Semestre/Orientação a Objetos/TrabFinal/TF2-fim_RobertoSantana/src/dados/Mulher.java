package dados;

// HERANCA DE PESSOA
public class Mulher extends Pessoa {
	// ATRIBUTO
	private Character situacaoGestacao;
	
	// CONSTRUTOR
	public Mulher(int id, String nome, char situacao, char situacaoGestacao) {
		super(id, nome, situacao);
		setGestante(situacaoGestacao);
	}

	// OBTEM SITUACAO DE GESTACAO
	public String getSituacaoGestacao() {
		return this.situacaoGestacao.toString();
	}

	// SETAR SITUACAO DE GESTACAO
	public void setGestante(char situacaoGestacao) {
		this.situacaoGestacao = situacaoGestacao;
	}
	
	public String getSituacaoGExtenso() {
		if (this.situacaoGestacao == 'S')
			return "sim";
		else if (this.situacaoGestacao == 'N')
			return "nao";
		else
			return "nao tem certeza";
	}
	
	// SOBRESCRITA DO TOSTRING
	public String toString() {	
		return this.getSituacaoGestacao() + " --";
	}
	
}
