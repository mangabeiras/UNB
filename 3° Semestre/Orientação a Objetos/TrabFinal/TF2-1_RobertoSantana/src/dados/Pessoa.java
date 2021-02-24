package dados;

// SUPERCLASSE DE HOMEM E MULHER
public class Pessoa {
	// ATRIBUTOS
	private Integer codigo;
	private StringBuilder nome;
	private Character situacao;
	
	// CONSTRUTOR
	public Pessoa(StringBuilder nome, char situacao, int codigo) {
		setCodigo(codigo);
		setNome(nome);
		setSituacao(situacao);
	}

	// OBTEM CODIGO IDENTIFICADOR
	public Integer getCodigo() {
		return codigo;
	}

	// SETA CODIGO IDENTIFICADOR
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	// OBTEM SITUACAO
	public Character getSituacao() {
		return situacao;
	}

	// SETA SITUACAO
	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}

	// OBTEM NOME
	public StringBuilder getNome() {
		return nome;
	}

	// SETA NOME
	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}
	
	public Character getSituacaoGestacao() {
		return '-';
	} 
	
	public Integer getIdade() {
		return 0;
	}
}
