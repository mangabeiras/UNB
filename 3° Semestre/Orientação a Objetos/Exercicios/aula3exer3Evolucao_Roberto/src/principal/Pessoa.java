package principal;

public class Pessoa {
	// DECLARACOES
	private float altura;
	private int idade;
	private String nome;
	
	// PROTECAO DOS DADOS
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public String getNome() {
		return this.nome;
	}
	public int getIdade() {
		return this.idade;
	}
	public float getAltura() {
		return this.altura;
	}
	 
}
