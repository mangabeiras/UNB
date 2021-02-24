package dados;

// SUPERCLASSE DE HOMEM E MULHER
public class Pessoa {
	// ATRIBUTOS
	private Integer id;
	private StringBuilder nome;
	private Character situacao;
	
	// CONSTRUTOR
	public Pessoa(int id, String nome, char situacao) {
		setNome(nome);
		setSituacao(situacao);
		setId(id);
	}
	// SETA ID
	public void setId(int id) {
		this.id = id;
	}
	// OBTEM ID
	public Integer getId() {
		return this.id;
	}
	
	public Character getSituacao() {
		return this.situacao;
	}
	
	
	// OBTEM SITUACAO
	public String getSituacaoExtenso() {
		switch (situacao) {
		case 'T':{
			return "contaminado em tratamento";
		}
		case 'F':{
			return "contaminado falecido";
		}
		case 'C':{
			return "contaminado curado";
		}
		default:{
			return "nao contaminado";
			}
		}
	}

	// SETA SITUACAO
	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}

	// OBTEM NOME
	public String getNome() {
		return nome.toString();
	}

	// SETA NOME
	public void setNome(String nome) {
		this.nome = new StringBuilder().append(nome);
	}
}
