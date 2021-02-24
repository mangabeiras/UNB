package dados;

// HERANCA DE PESSOA
public class Homem extends Pessoa{
	// ATRIBUTO
	private Integer idade;
	
	// CONSTRUTOR
	public Homem(StringBuilder nome, char situacao, int idade, int codigo) {
		super(nome, situacao, codigo);
		setIdade(idade);
	}
	
	// OBTER IDADE
	public Integer getIdade() {
		return idade;
	}

	// SETAR IDADE
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	// VERIFICAR SE UM HOMEM E IGUAL A OUTRO
	public boolean equals(Object obj) {
		Homem novo = (Homem) obj;
		String nome_1 = novo.getNome().toString().toLowerCase();
		String nome_2 = this.getNome().toString().toLowerCase();
		
		return nome_1.equals(nome_2) && novo.getIdade() == this.getIdade();
	}
	
	// SOBRESCRITA TOSTRING
	public String toString() {
		String formato = "%-20s%-30s%-30s%-13s%-10s\n";
		String situacao = null;
		
		switch (this.getSituacao()) {
		case 'T':{
			situacao = "Contaminado em Tratamento";
			break;
		}
		case 'F':{
			situacao = "Contaminado Falecido";
			break;
		}
		case 'C':{
			situacao = "Contaminado Curado";
			break;
		}
		case 'S':{
			situacao = "Nao contaminado";
		}
		}
		return String.format(formato, this.getCodigo(),
				this.getNome(),
				situacao,
				this.idade,
				"--");
	}
}
