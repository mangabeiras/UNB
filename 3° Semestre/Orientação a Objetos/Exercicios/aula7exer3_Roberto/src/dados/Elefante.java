package dados;

public class Elefante extends Mamifero {
	private Float peso;
	private String habitat;
	public Elefante(Mamifero mamifero, float peso, String habitat) {
		super(mamifero.getAmamentacao(), mamifero.getIdade(), mamifero.getEspecie(), mamifero.getTamanho());
		setPeso(peso);
		setHabitat(habitat);
	}		
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}
	public Float getPeso() {
		return this.peso;
	}
	public String getHabitat() {
		return this.habitat;
	}

}
