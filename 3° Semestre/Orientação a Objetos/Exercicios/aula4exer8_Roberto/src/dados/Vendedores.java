package dados;

public class Vendedores {
	private int vendedor;

	// CONSTRUTOR
	Vendedores(int vendaSemana) {
		this.vendedor = vendaSemana;
	}

	public int getVendas() {
		return this.vendedor;
	}
}
