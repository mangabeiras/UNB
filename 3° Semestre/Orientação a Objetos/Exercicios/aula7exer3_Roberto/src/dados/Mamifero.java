package dados;

public class Mamifero {
	private Integer id_Amamentacao;
	private Integer idade;
	private String especie;
	private Float tamanho;
	
	// CONSTRUTOR DE MAMIFERO
	public Mamifero(int id_Amamentacao, int idade, String especie, float tamanho){
		this.id_Amamentacao = id_Amamentacao;
		this.idade = idade;
		this.especie = especie;
		this.tamanho = tamanho;
	}
	
	public Integer getAmamentacao() {
		return this.id_Amamentacao;
	}
	public Integer getIdade() {
		return this.idade;
	}
	public String getEspecie() {
		return this.especie;
	}
	public Float getTamanho() {
		return this.tamanho;
	}
}
