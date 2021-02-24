package dados;

public class Regular extends Funcionario {
	public Regular(String nome, long cpf, int []nascimento) {
		super(nome, cpf, nascimento);
	}
	
	public Float calculaSalario() {
		return this.getSalario()*0.1f;
	}
	public String getCategoria() {
		return "Regular";
	}
	public String toString() {
		String formato = "%-20s%-15s%-13s%-20s%-10s%-10s\n";
		return String.format(formato, this.getNome().split(" ")[0],this.getCategoria().toUpperCase(),
				String.format("%011d", this.getCpf()),
				this.getNascimento()[0]
				+"/"+ this.getNascimento()[1]
				+"/"+this.getNascimento()[2], 
				"NDA",
				"NDA");
	}
}
