package dados;

// HERANCA DE PESSOA
public class Homem extends Pessoa{
	// ATRIBUTO
	private Integer idade;
	
	// CONSTRUTOR
	public Homem(int id,String nome, char situacao, int idade) {
		super(id, nome, situacao);
		setIdade(idade);
	}
	
	// OBTER IDADE
	public String getIdade() {
		return idade.toString();
	}

	// SETAR IDADE
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	// SOBRESCRITA TOSTRING
	public String toString() {
		String formato = "%-20s%-30s%-30s%-13s%-10s\n";
	
		
		return String.format(formato, "--",
				this.getNome().toString().toLowerCase(),
				this.getSituacaoExtenso(),
				this.idade,
				"--");
	}
}
