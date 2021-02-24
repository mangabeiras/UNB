package dados;

public class PrestadorServicos extends Funcionario {
	public Integer horasTrabalhadas;

	public PrestadorServicos(String nome, String dataNascimento, String cpf, int horasTrabalhadas) {
		super(nome, dataNascimento, cpf);
		setHorasTrabalhadas(horasTrabalhadas);
	}

	public float calculaSalario() {
		return 2 * horasTrabalhadas + PISO;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public Integer getHorasTrabalhadas() {
		return this.horasTrabalhadas;
	}
	public String toString() {
		String formato = "%-21s%-30s%-55s%-19s%-20s\n";
		
		return String.format(formato, this.getNome().split(" ")[0],
				this.getCpf(),
				this.getDataNascimento(),
				this.getHorasTrabalhadas(),
				"---");
	}
}
