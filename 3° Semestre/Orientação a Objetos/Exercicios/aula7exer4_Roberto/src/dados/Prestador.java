package dados;

public class Prestador extends Funcionario{
	private Integer horas;
	public Prestador(String nome, long cpf, int []nascimento, int horas) {
		super(nome, cpf, nascimento);
		setHoras(horas);
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public Integer getHoras() {
		return this.horas;
	}
	public Float calculaSalario() {
		return (this.horas * 2 + this.getSalario());
	}
	public String getCategoria() {
		return "Prestador";
	}
	public String toString() {
		String formato = "%-20s%-15s%-13s%-20s%-10s%-10s\n";
		
		return String.format(formato, this.getNome().split(" ")[0],this.getCategoria().toUpperCase(),
				String.format("%011d", this.getCpf()),
				this.getNascimento()[0]
				+"/"+ this.getNascimento()[1]
				+"/"+this.getNascimento()[2], 
				this.getHoras(),
				"NDA");
	}
}
