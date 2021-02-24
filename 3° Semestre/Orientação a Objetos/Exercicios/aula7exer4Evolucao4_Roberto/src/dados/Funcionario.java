package dados;

import java.text.DecimalFormat;

public class Funcionario extends Pessoa{
	private char categoria;
	public Funcionario(String nome, String dataNascimento, String cpf, char categoria) {
		super(nome, dataNascimento, cpf);
		this.categoria = categoria;
	}
	public char getCategoria(){
		return this.categoria;
	}
	public float calculaSalario() {
		return PISO * 1.1F;
	}
	
	public String toString() {
		DecimalFormat formato = new DecimalFormat("0.00");
		return String.format("%-15s%-15s%-15s%s", this.getNome(), this.getDataNascimento(), this.getCpf(), 
													formato.format(this.calculaSalario()));		
	}

}
