package dados;

public class Pessoa {
	private StringBuilder nome;
	private Character genero;
	private Integer identificador;

	public Pessoa(StringBuilder nome, char genero) {
		setNome(nome);
		setGenero(genero);
	}

	public StringBuilder getNome() {
		return nome;
	}

	public Character getGenero() {
		return genero;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}

	public void setGenero(Character genero) {
		this.genero = genero;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getGeneroPorExtenso() {
		switch (this.genero) {
		case 'M': {
			return "MASCULINO";
		}
		default: {
			return "FEMININO";
		}
		}
	}

	public String getSituacao() {
		return null;
	}

	public String getSituacaoPorExtenso() {
		return null;
	}

	public String getIdade() {
		return null;
	}

}