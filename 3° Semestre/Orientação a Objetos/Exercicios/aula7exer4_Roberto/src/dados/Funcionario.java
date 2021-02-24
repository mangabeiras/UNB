package dados;

public class Funcionario {
	private final Float PISO = 232f;
	private String nome;
	private Long cpf;
	private Integer []nascimento = new Integer[3];
	private Float salario = PISO;
	
	public Funcionario(String nome, long cpf, int []nascimento) {
		setNome(nome);
		setCpf(cpf);
		setNascimento(nascimento);
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public void setNascimento(int []nascimento) {
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
	
	public Float calculaSalario() {
		return this.PISO;
	}
	public String getCategoria() {
		return "Funcionario";
	}
}
