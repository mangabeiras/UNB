package dados;

public class Gerente extends Funcionario {
	private Integer quantidadeProjetos;

	public Gerente(String nome, String dataNascimento, String cpf, Integer quantidadeProjetos) {
		super(nome, dataNascimento, cpf);
		setQuantidadeProjetos(quantidadeProjetos);
	}

	public float calculaSalario() {
		return PISO * (1 + 0.5f * quantidadeProjetos);
	}

	public Integer getQuantidadeProjetos() {
		return quantidadeProjetos;
	}

	public void setQuantidadeProjetos(Integer quantidadeProjetos) {
		this.quantidadeProjetos = quantidadeProjetos;
	}
	
	public String toString() {
		String formato = "%-20s%-30s%-55s%-20s%-20s\n";
		
		return String.format(formato, this.getNome().split(" ")[0],
				this.getCpf(),
				this.getDataNascimento(),
				"---",
				this.getQuantidadeProjetos());
	}
}
