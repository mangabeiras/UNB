package dados;

public class Prestador extends Funcionario {
	private Integer horas;
	
	public Prestador(String nome, long cpf, int []nascimento,float salario, int horas) {
		super(nome, cpf, nascimento, salario);
		setHoras(horas);
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public Integer getHoras() {
		return this.horas;
	}
	public Float calculaSalario(float salario) {
		return (this.horas*2) + salario;
	}
	public String toString() {
		String formato = "%-13s%-15s%-20s%-13s%-10s\n";
		
		return String.format(formato, this.getNome().split(" ")[0],
				String.format("%011d", this.getCpf()),
				this.getNascimento()[0]
				+"/"+ this.getNascimento()[1]
				+"/"+this.getNascimento()[2], 
				this.getHoras(),
				"NDA");
	}
}
