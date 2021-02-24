package dados;

public class Cidade {
	private StringBuilder nome;
	private StringBuilder sigla;
	private Integer HabContaminados;
	private Integer HabContaminadosMortos;

	public Cidade(StringBuilder nome, StringBuilder sigla, Integer habContaminados, Integer habContaminadosMortos) {
		setNome(nome);
		setSigla(sigla);
		setHabContaminados(habContaminadosMortos);
		setHabContaminadosMortos(habContaminadosMortos);
	}

	public StringBuilder getNome() {
		return nome;
	}

	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}

	public StringBuilder getSigla() {
		return sigla;
	}

	public void setSigla(StringBuilder sigla) {
		this.sigla = sigla;
	}

	public Integer getHabContaminados() {
		return HabContaminados;
	}

	public void setHabContaminados(Integer habContaminados) {
		HabContaminados = habContaminados;
	}

	public Integer getHabContaminadosMortos() {
		return HabContaminadosMortos;
	}

	public void setHabContaminadosMortos(Integer habContaminadosMortos) {
		HabContaminadosMortos = habContaminadosMortos;
	}

	public boolean equals(Cidade cidade) {
		Boolean resultado = false;

		// Se nome minusculo ou sigla minuscula do objeto comparador e do objeto a
		// comparar forem iguais, retorna true
		if (this.getNome().toString().toLowerCase().equals(cidade.getNome().toString().toLowerCase())
				&& this.getSigla().toString().toLowerCase().equals(cidade.getSigla().toString().toLowerCase())) {
			return true;
		}

		return resultado;
	}

	@Override
	public String toString() {
		return "Cidade: \tnome=" + nome + ", sigla=" + sigla + ", HabContaminados=" + HabContaminados
				+ ", HabContaminadosMortos=" + HabContaminadosMortos;
	}

}
