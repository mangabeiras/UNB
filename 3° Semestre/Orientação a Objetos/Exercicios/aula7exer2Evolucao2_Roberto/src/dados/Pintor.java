package dados;

import java.util.ArrayList;

public class Pintor {
	private String nome;
	private Integer codigoPessoal;
	private Integer anoNascimento;
	private ArrayList<Quadro> quadros;
	
	public Pintor (String nome, int codigoPessoal, int anoNascimento) {
		setNome(nome);
		setCodigoPessoal(codigoPessoal);
		setAnoNascimento(anoNascimento);
		quadros = new ArrayList<Quadro>();
	}
	
	public void addQuadro(Quadro quadro) {
		this.quadros.add(quadro);
	}
	
	public ArrayList<Quadro> getQuadros(){
		return this.quadros;
	}
	
	public String getNome () {
		return nome;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public Integer getCodigoPessoal () {
		return codigoPessoal;
	}
	
	public void setCodigoPessoal (Integer codigoPessoal) {
		this.codigoPessoal = codigoPessoal;
	}
	
	public Integer getAnoNascimento () {
		return anoNascimento;
	}
	
	public void setAnoNascimento (Integer anoNascimento) {
		this.anoNascimento = anoNascimento;
	}
}
