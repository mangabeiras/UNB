package dados;

import java.util.ArrayList;

public class Exposicao {
	ArrayList<Pintor> artistas;
	
	// CONSTRUTOR DE EXPOSICAO
	public Exposicao(String nome, int nascimento) {
		artistas = new ArrayList<Pintor>();
		setPintor(new Pintor(nome, nascimento));
	}
	public void setPintor(Pintor pintor) {
		this.artistas.add(pintor);
	}
	public void setQuadro(Quadro quadro, int codigoPintor) {
		this.artistas.get(codigoPintor).setQuadro(quadro);
	}
	public ArrayList<Quadro> getQuadros(int codigoPintor){
		return this.artistas.get(codigoPintor).getQuadro();
	}
	public ArrayList<Pintor> getPintor(){
		return this.artistas;
	}
}
