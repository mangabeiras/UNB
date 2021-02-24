package dados;

import java.text.DecimalFormat;

import interfaces.AnaliseDados;
// CLASSE DE EMPREGADO
public class Empregado {
	// ATRIBUTOS
	private StringBuilder nome;
	private Integer matricula;
	private Float salario;
	
	// CONSTRUTOR
	public Empregado(StringBuilder nome, Integer matricula, Float salario) {
		setNome(nome);
		setMatricula(matricula);
		setSalario(salario);
	}
	// GETTERS E SETTERS
	public StringBuilder getNome() {
		return nome;
	}

	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public Float getSalario() {
		return this.salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}


	public String toString() {
		String formato = "%-20s%-15s%-15s\n";
		return String.format(formato, this.nome, this.matricula, new DecimalFormat("0.00").format(this.salario));
	}
}
