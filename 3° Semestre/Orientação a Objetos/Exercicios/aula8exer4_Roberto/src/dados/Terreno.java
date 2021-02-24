package dados;

import java.text.DecimalFormat;

import interfaces.AnaliseDados;
// CLASSE DE TERRRENO
public class Terreno{
	// ATRIBUTOS
	private StringBuilder endereco;
	private Integer area;
	private Float preco;
	
	// CONSTRUTOR
	public Terreno(StringBuilder endereco, int area, float preco) {
		setEndereco(endereco);
		setArea(area);
		setPreco(preco);
	}
	// GETTERS E SETTERS
	public StringBuilder getEndereco() {
		return this.endereco;
	}

	public void setEndereco(StringBuilder endereco) {
		this.endereco = endereco;
	}

	public Integer getArea() {
		return this.area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public Float getPreco() {
		return this.preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public String toString() {
		String formato = "%-20s%-15s%-15s\n";
		return String.format(formato, this.endereco, this.area, new DecimalFormat("0.00").format(this.preco));
	}
	
}
