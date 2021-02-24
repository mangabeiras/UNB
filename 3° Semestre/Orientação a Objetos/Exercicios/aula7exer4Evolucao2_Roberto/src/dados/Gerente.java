package dados;

public class Gerente extends Funcionario {
	private Integer projetos;
	
	public Gerente(String nome, long cpf, int []nascimento,float salario, int projetos) {
		super(nome, cpf, nascimento, salario);
		setProjetos(projetos);
		
	}
	public void setProjetos(int projetos) {
		this.projetos = projetos;
	}
	public Integer getProjetos() {
		return this.projetos;
	}
	public Float calculaSalario(float salario) {
		return (this.projetos*salario/2) + salario;
	}
	public String toString() {
		String formato = "%-13s%-15s%-20s%-13s%-10s\n";
		
		return String.format(formato, this.getNome().split(" ")[0],
				String.format("%011d", this.getCpf()),
				this.getNascimento()[0]
				+"/"+ this.getNascimento()[1]
				+"/"+this.getNascimento()[2], 
				"NDA",
				this.getProjetos());
	}
}
