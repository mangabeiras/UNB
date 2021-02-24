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
			return "Sim";
		else if (this.situacaoGestacao == 'N')
			return "Nao";
		else
			return "Nao tem Certeza";
	}
	
	// SOBRESCRITA DO TOSTRING
	public String toString() {
		String formato = "%-20s%-30s%-30s%-13s%-10s\n";
	
		return String.format(formato, "--",
				this.getNome().toString().toLowerCase(),
				this.getSituacaoExtenso(),
				"--",
				this.getSituacaoGExtenso());
	}
	
}
