package dados;
// FUNCIONARIO BASE / REGULAR
public class Funcionario {
	private String nome;
	private Long cpf;
	private Integer []nascimento;
	private Float salario;
	
	public Funcionario(String nome, long cpf, int []nascimento, float salario) {
		setNome(nome);
		setCpf(cpf);
		setNascimento(nascimento);
		setSalario(salario);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public void setNascimento(int []nascimento) {
		this.nascimento = new Integer[3];
		this.nascimento[0] = nascimento[0];
		this.nascimento[1] = nascimento[1];
		this.nascimento[2] = nascimento[2];
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public String getNome() {
		return this.nome;
	}
	public Long getCpf() {
		return this.cpf;
	}
	public Integer[] getNascimento() {
		return this.nascimento;
	}
	public Float getSalario() {
		return this.salario;
	}
	public Float calculaSalario(float salario) {
		return (this.salario*0.1f) + this.salario;
	}
	
	public String toString() {
		String formato = "%-13s%-15s%-20s%-13s%-10s\n";
		
		return String.format(formato, this.getNome().split(" ")[0],
				String.format("%011d", this.getCpf()),
				this.getNascimento()[0]
				+"/"+ this.getNascimento()[1]
				+"/"+this.getNascimento()[2], 
				"NDA",
				"NDA");
	}
}
