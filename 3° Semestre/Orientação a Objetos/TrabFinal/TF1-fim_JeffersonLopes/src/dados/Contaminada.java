package dados;

public class Contaminada extends Pessoa {
	private Character situacao;

	public Contaminada(StringBuilder nome, char genero, char situacao) {
		super(nome, genero);
		setSituacao(situacao);
	}

	public String getSituacao() {
		return situacao.toString();
	}

	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}

	public String getSituacaoPorExtenso() {

		switch (this.situacao) {
		case 'E': {
			return "EM TRATAMENTO";
		}
		case 'F': {
			return "FALECIDA";
		}
		default: { // 'C' -> CURADA
			return "CURADA";
		}
		}

	}

}
