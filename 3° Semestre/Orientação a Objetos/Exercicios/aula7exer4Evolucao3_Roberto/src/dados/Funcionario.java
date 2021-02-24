package dados;

public class Funcionario{
	static final float PISO = 232f;
	private String nome;
	private String dataNascimento;
	private String cpf;

	public Funcionario(String nome, String dataNascimento, String cpf) {
		setNome(nome);
		setDataNascimento(dataNascimento);
		setCpf(cpf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public float calculaSalario() {
		return 1.1f*PISO;
	}
	public String toString() {
		String formato = "%-20s%-30s%-55s%-20s%-20s\n";
		
		return String.format(formato, this.getNome().split(" ")[0],
				this.getCpf(),
				this.getDataNascimento(),
				"---",
				"---");
	}
}
