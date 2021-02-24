package dados;

import java.util.ArrayList;

public class Pintor {
	private String nome;
	private Integer nascimento;
	private ArrayList<Quadro> quadro;
	
	// METODO CONSTRUTOR
	public Pintor(String nome, int nascimento) {
		setNome(nome);
		setNascimento(nascimento);
		quadro = new ArrayList<Quadro>();
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setNascimento(int nascimento) {
		this.nascimento = nascimento;
	}
	public void setQuadro(Quadro quadro) {
		this.quadro.add(quadro);
	}
	public String getNome() {
		return this.nome;
	}
	public Integer getNascimento() {
		return this.nascimento;
	}
	public ArrayList<Quadro> getQuadro(){
		return this.quadro;
	}
}

