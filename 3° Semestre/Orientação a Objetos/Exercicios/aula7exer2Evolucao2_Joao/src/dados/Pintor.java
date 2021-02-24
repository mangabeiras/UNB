package dados;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Pintor {
	private String nome;
	private Integer codigoPessoal;
	private Integer anoNascimento;
	private ArrayList<Quadro> listaQuadros;

	public Pintor (String nome, int codigoPessoal, int anoNascimento) {
		setNome(nome);
		setCodigoPessoal(codigoPessoal);
		setAnoNascimento(anoNascimento);
		this.listaQuadros = new ArrayList<Quadro>();
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
	
	public ArrayList<Quadro> getListaQuadros() {
		return listaQuadros;
	}

	public void setListaQuadros(Quadro quadro) {
		this.listaQuadros.add(quadro);
	}
	
	protected boolean isPossuiQuadros () {
		return (!listaQuadros.isEmpty());
	}
	
	@Override
	public String toString() {
		return String.format(
			"%-6s%-30s",
			"",
			getCodigoPessoal() 
		);
	}
}
