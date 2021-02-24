package dados;

public class Mulher extends Pessoa {
	private Character situacaoGestacao;

	public Mulher(StringBuilder nome, char situacao, char situacaoGestacao, int codigo) {
		super(codigo, nome, situacao);
		setGestante(situacaoGestacao);
	}

	public Character getSituacaoGestacao() {
		return this.situacaoGestacao;
	}

	public void setGestante(char situacaoGestacao) {
		this.situacaoGestacao = situacaoGestacao;
	}
	
	public String toString() {
		String formato = "%-20s%-30s%-20s%-13s%-10s\n";
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
				this.getNome(),
				situacao,
				"--",
				(this.getSituacaoGestacao() == 'S') ? "Sim" : this.getSituacaoGestacao() == 'N' ? "Nao" : "Nao tem Certeza");
	}
	
}
