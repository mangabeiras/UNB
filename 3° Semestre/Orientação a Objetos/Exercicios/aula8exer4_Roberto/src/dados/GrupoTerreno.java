package dados;

import java.util.ArrayList;

import interfaces.AnaliseDados;
// CLASSE DE CONJUNTO DE TERRENOS
public class GrupoTerreno implements AnaliseDados {
	// ATRIBUTOS
	ArrayList<Terreno> grupo;
	
	// CONSTRUTOR 
	public GrupoTerreno() {
		grupo = new ArrayList<Terreno>();
	}
	// GETTERS E SETTERS
	public ArrayList<Terreno> getGrupoTerrenos() {
		return grupo;
	}
	
	public void addTerreno(Terreno terreno) {
		this.grupo.add(terreno);
	}
	// SOBREESCRITA DOS METODOS DA INTERFACE ANALISEDADOS
	@Override
	public float menorMaior(char identificador) {
		float resultado = 0;
		switch(identificador) {
		case '+':
			for (Terreno terreno : getGrupoTerrenos()) {
				if (terreno.getPreco() > resultado)
					resultado = terreno.getPreco();
			}
			return resultado;
		default:
			resultado = grupo.get(0).getPreco();
			for (Terreno terreno : getGrupoTerrenos()) {
				if (terreno.getPreco() < resultado)
					resultado = terreno.getPreco();
			}
			return resultado;
		}
	}

	@Override
	public boolean isRepetido(int inserido) {
		int contador = 0;
		for (Terreno terreno : getGrupoTerrenos()) {
			if(terreno.getArea() == inserido)
				contador++;
		}
		return contador > 1;
	}


	@Override
	public float somaArray(char identificador) {
		if (identificador == 'A') {
			int areaTotal = 0;
			for (Terreno terreno : getGrupoTerrenos())
				areaTotal += terreno.getArea();
			return (float) areaTotal;
		} else {
			float precoTotal = 0;
			for (Terreno terreno : getGrupoTerrenos())
				precoTotal += terreno.getPreco();
			return precoTotal;
		}
	}

	@Override
	public float media(char identificador) {
		return (somaArray(identificador)/getGrupoTerrenos().size());
	}
	
	
}
