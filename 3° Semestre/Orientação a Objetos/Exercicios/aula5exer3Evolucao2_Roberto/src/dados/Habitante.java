package dados;

public class Habitante {
	private Float salario;
	private Integer idade;
	private Integer numeroFilhos;
	private Character sexo;

	// CONSTRUTOR
	public Habitante( char sexo, int idade, float salario, int numeroFilhos) {
		setSalario(salario);
		setIdade(idade);
		setSexo(sexo);
		setNumeroFilhos(numeroFilhos);
	}

	// Getters e Setters
	public void setSalario(float salario) {
		this.salario = salario;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void setNumeroFilhos(int numeroFilhos) {
		this.numeroFilhos = numeroFilhos;
	}

	public float getSalario() {
		return this.salario;
	}

	public int getIdade() {
		return this.idade;
	}

	public char getSexo() {
		return this.sexo;
	}

	public int getNumeroFilhos() {
		return this.numeroFilhos;
	}
}
