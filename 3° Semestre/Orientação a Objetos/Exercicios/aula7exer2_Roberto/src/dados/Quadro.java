package dados;

public class Quadro {
	private String nome;
	private Float preco;
	private Integer ano_Aquisicao;
	
	// METODO CONSTRUTOR DE QUADRO
	public Quadro(String nome, float preco, int ano) {
		setNome(nome);
		setPreco(preco);
		setAnoAquisicao(ano);
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public void setAnoAquisicao(int ano) {
		this.ano_Aquisicao = ano;
	}
	public String getNome() {
		return this.nome;
	}
	public Float getPreco() {
		return this.preco;
	}
	public Integer getAno(){
		return this.ano_Aquisicao;
	}
}
