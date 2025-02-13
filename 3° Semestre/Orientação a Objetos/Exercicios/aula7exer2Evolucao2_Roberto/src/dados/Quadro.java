package dados;

import java.text.DecimalFormat;

public class Quadro {
	private Integer codigoIdentificacao;
	private Integer codigoIdentificacaoPintor;
	private Float preco;
	private Integer anoAquisicao;
	
	public Quadro (int codigoIdentificacao, int codigoIdentificacaoPintor, float preco, int anoAquisicao) {
		setCodigoIdentificacao(codigoIdentificacao);
		setCodigoIdentificacaoPintor(codigoIdentificacaoPintor);
		setPreco(preco);
		setAnoAquisicao(anoAquisicao);
	}
	
	public Integer getCodigoIdentificacao () {
		return codigoIdentificacao;
	}

	public void setCodigoIdentificacao (Integer codigoIdentificacao) {
		this.codigoIdentificacao = codigoIdentificacao;
	}

	public Integer getCodigoIdentificacaoPintor () {
		return codigoIdentificacaoPintor;
	}

	public void setCodigoIdentificacaoPintor (Integer codigoIdentificacaoPintor) {
		this.codigoIdentificacaoPintor = codigoIdentificacaoPintor;
	}

	public Float getPreco () {
		return preco;
	}

	public void setPreco (Float preco) {
		this.preco = preco;
	}

	public Integer getAnoAquisicao () {
		return anoAquisicao;
	}

	public void setAnoAquisicao (Integer anoAquisicao) {
		this.anoAquisicao = anoAquisicao;
	}
	public String toString() {
		String formato = "%-30s%-30s%-20s%-20s\n";
		return String.format(formato, this.getCodigoIdentificacao(),  
		this.getCodigoIdentificacaoPintor(),
		new DecimalFormat("0.00").format(this.getPreco()), 
		this.getAnoAquisicao());
	}
}
