package dados;

public class Gerente extends Funcionario {
	private Integer projetos;
	
	public Gerente(String nome, long cpf, int []nascimento, int projetos) {
		super(nome, cpf, nascimento);
		setProjetos(projetos);
	}
	public void setProjetos(int projetos) {
		this.projetos = projetos;
	}
	public Integer getProjetos() {
		return this.projetos;
	}
	public Float calculaSalario() {
		return ((this.projetos * this.getSalario() / 2) + this.getSalario());
	}
	public String getCategoria() {
		return "Gerente";
	}
	public String toString() {
		String formato = "%-20s%-15s%-13s%-20s%-10s%-10s\n";
		
		return String.format(formato, this.getNome().split(" ")[0],this.getCategoria().toUpperCase(),
				String.format("%011d", this.getCpf()),
				this.getNascimento()[0]
				+"/"+ this.getNascimento()[1]
				+"/"+this.getNascimento()[2], 
				"NDA",
				this.getProjetos());
	}
}
