package dados;

import validacao.Validacao;

public class Pessoa {
	private float salario;
	private int idade;
	private String sexo;
	private int numeroDeFilhos;

	public Pessoa() {
		setSalario(Validacao.validaSalario());
		setIdade(Validacao.validaIdade());
		setSexo(Validacao.validaSexo());
		setNumeroDeFilhos(Validacao.validaNumeroDeFilhos());
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getNumeroDeFilhos() {
		return numeroDeFilhos;
	}

	public void setNumeroDeFilhos(int numeroDeFilhos) {
		this.numeroDeFilhos = numeroDeFilhos;
	}

}
