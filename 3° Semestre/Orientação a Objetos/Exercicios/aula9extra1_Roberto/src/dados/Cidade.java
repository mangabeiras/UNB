package dados;

public class Cidade {
	// ATRIBUTOS
	private StringBuilder nome;
	private StringBuilder estado;
	private Integer contaminados;
	private Integer mortes;
	
	// METODO CONSTRUTOR
	public Cidade(StringBuilder nome, StringBuilder estado, Integer contaminados, Integer mortes) {
		this.nome = nome;
		this.estado = estado;
		this.contaminados = contaminados;
		this.mortes = mortes;
	}
	//--GETTERS e SETTERS
	public StringBuilder getNome() {
		return nome;
	}

	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}

	public StringBuilder getEstado() {
		return estado;
	}

	public void setEstado(StringBuilder estado) {
		this.estado = estado;
	}

	public Integer getContaminados() {
		return contaminados;
	}

	public void setContaminados(Integer contaminados) {
		this.contaminados = contaminados;
	}
	
	public Integer getMortes() {
		return mortes;
	}

	public void setMortes(Integer mortes) {
		this.mortes = mortes;
	}
	public String toString() {
		String formato = "%-20s%-10s%-15s%-10s\n";
		return String.format(formato, this.getNome(), this.getEstado().toString().toUpperCase(), 
				String.format("%02d", this.getContaminados()), String.format("%02d", this.getMortes()));
	}
	public boolean equals(Object obj) {
		Cidade nova = (Cidade) obj;
		if (nova.getNome().toString().toLowerCase().equals(getNome().toString().toLowerCase()) 
				&& nova.getEstado().toString().toLowerCase().equals(getEstado().toString().toLowerCase()))
				return true;
		
		return false;
	}
	
}
