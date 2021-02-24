package dados;

public class NaoContaminada extends Pessoa {
	private Integer idade;

	public NaoContaminada(StringBuilder nome, char genero, int idade) {
		super(nome, genero);
		setIdade(idade);
	}

	public String getIdade() {
		return idade.toString();
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

}
