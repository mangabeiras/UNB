package dados;

// HERANCA DE PESSOA
public class Mulher extends Pessoa {
	// ATRIBUTO
	private Character situacaoGestacao;
	
	// CONSTRUTOR
	public Mulher(StringBuilder nome, char situacao, char situacaoGestacao, int codigo) {
		super(nome, situacao, codigo);
		setGestante(situacaoGestacao);
	}

	// OBTEM SITUACAO DE GESTACAO
	public Character getSituacaoGestacao() {
		return this.situacaoGestacao;
	}

	// SETAR SITUACAO DE GESTACAO
	public void setGestante(char situacaoGestacao) {
		this.situacaoGestacao = situacaoGestacao;
	}
	
	// VERIFICAR SE UMA MULHER E IGUAL A OUTRA
	public boolean equals(Object obj) {
		Mulher novo = (Mulher) obj;
		String nome_1 = novo.getNome().toString().toLowerCase();
		String nome_2 = this.getNome().toString().toLowerCase();
		
		return nome_1.equals(nome_2) && novo.getSituacaoGestacao() == this.getSituacaoGestacao();
	}
	
	// SOBRESCRITA DO TOSTRING
	public String toString() {
		String formato = "%-20s%-30s%-30s%-13s%-10s\n";
		String situacao = null;
		
		switch (this.getSituacao()) {
		case 'T':{
			situacao = "Contaminado em Tratamento";
			break;
		}
		case 'F':{
			situacao = "Contaminada Falecida";
			break;
		}
		case 'C':{
			situacao = "Contaminada e Curada";
			break;
		}
		case 'S':{
			situacao = "Nao contaminada";
		}
		}
		return String.format(formato, this.getCodigo(),
				this.getNome().toString().toLowerCase(),
				situacao,
				"--",
				(this.getSituacaoGestacao() == 'S') ? "Sim" : this.getSituacaoGestacao() == 'N' ? "Nao" : "Nao tem Certeza");
	}
	
}
