package dados;
// CLASSE DO HABITANTE
public class Habitante {
	private char sexo;
	private int idade, filhos;
	private float salario;
	
	// CONSTRUTOR
	Habitante(char sexo, int idade, int filhos, float salario){
		setSexo(sexo);
		setIdade(idade);
		setFilhos(filhos);
		setSalario(salario);
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setFilhos(int filhos) {
		this.filhos = filhos;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public char getSexo() {
		return this.sexo;
	}
	public int getIdade() {
		return this.idade;
	}
	public int getFilhos() {
		return this.filhos;
	}
	public float getSalario() {
		return this.salario;
	}
}

