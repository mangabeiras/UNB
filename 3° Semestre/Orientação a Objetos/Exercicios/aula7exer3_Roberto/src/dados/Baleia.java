package dados;

public class Baleia extends Mamifero {
	
	private Float peso;
	
	// CONSTRUTOR DE BALEIA
	public Baleia(Mamifero mamifero, float peso) {
		super(mamifero.getAmamentacao(), mamifero.getIdade(), mamifero.getEspecie(), mamifero.getTamanho());
		this.peso = peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public Float getPeso() {
		return this.peso;
	}
}
