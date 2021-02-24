package dados;

public class Macaco extends Mamifero {
	private String porte;
	
	// CONSTRUTOR DE MACACO
	public Macaco(Mamifero mamifero, String porte) {
		super (mamifero.getAmamentacao(), mamifero.getIdade(), mamifero.getEspecie(), mamifero.getTamanho());
		setPorte(porte);
	}
	public void setPorte(String porte) {
		this.porte = porte;
	}
	public String getPorte() {
		return this.porte;
	}
}
