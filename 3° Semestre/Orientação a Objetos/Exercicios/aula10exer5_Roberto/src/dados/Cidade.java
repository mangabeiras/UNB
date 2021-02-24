package dados;
// CLASSE DE CIDADE
public class Cidade implements Comparable<Object>{
	// ATRIBUTOS
	private StringBuilder nome;
	private Integer ddd;
	
	// CONSTRUTOR
	public Cidade(StringBuilder nome, int ddd) {
		setNome(nome);
		setDdd(ddd);
	}
	// GETTERS E SETTERS
	public StringBuilder getNome() {
		return nome;
	}

	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	// SOBRESCRITAS
	@Override
	public String toString() {
		String formato = "%-15s%-10s\n";
		return String.format(formato, getNome(), getDdd());
	}

	@Override
	public boolean equals(Object obj) {
		Cidade nova = (Cidade) obj;
		return (getNome().toString().equalsIgnoreCase(nova.getNome().toString()) && getDdd() == nova.getDdd());
	}
	@Override
	public int compareTo(Object obj) {
		Cidade nova = (Cidade) obj;
		return nova.getNome().toString().toLowerCase().compareTo(getNome().toString().toLowerCase());
	}
}
