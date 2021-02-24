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
		return "-- " + this.getIdade();
	
	}
}
