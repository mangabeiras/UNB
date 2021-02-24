package dados;

public class Ano {
	private Integer ano;
	private String evento;
	private String presidente;
	
	// CONSTRUTOR
	public Ano (int ano, String evento, String presidente){
		setAno(ano);
		setEvento(evento);
		setPresidente(presidente);
	}
	
	// SETTERS E GETTERS
	public void setAno(int ano) {
		this.ano = ano;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}
	public Integer getAno() {
		return this.ano;
	}
	public String getEvento() {
		return this.evento;
	}
	public String getPresidente() {
		return this.presidente;
	}
}
