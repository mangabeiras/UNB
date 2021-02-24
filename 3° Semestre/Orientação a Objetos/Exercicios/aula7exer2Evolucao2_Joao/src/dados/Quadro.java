package dados;

import java.text.DecimalFormat;

public class Quadro {
	private Integer codigoIdentificacao;
	private Float preco;
	private Integer anoAquisicao;
	
	public Quadro (int codigoIdentificacao, float preco, int anoAquisicao) {
		setCodigoIdentificacao(codigoIdentificacao);
		setPreco(preco);
		setAnoAquisicao(anoAquisicao);
	}
	
	public Integer getCodigoIdentificacao () {
		return codigoIdentificacao;
	}

	public void setCodigoIdentificacao (Integer codigoIdentificacao) {
		this.codigoIdentificacao = codigoIdentificacao;
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
	
	@Override
	public String toString() {
		return String.format(
			"%-30s%-20s%-20s", 
			getCodigoIdentificacao(),
			new DecimalFormat("0.00").format(getPreco()), 
			getAnoAquisicao()
		);
	}
}
