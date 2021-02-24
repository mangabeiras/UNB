package dados;

import java.util.ArrayList;

import interfaces.AnaliseDados;
// CLASSE DE CONJUNTO DE EMPREGADOS
public class Empresa implements AnaliseDados{
	// ATRIBUTO
	private ArrayList<Empregado> empresa;
	
	// CONSTRUTOR
	public Empresa() {
		empresa = new ArrayList<Empregado>();
	}
	// GETTERS E SETTERS
	public ArrayList<Empregado> getEmpresa(){
		return this.empresa;
	}
	
	public void addEmpregado(Empregado empregado) {
		this.empresa.add(empregado);
	}
	
	// SOBREESCRITA DOS METODOS DA INTERFACE
	@Override
	public float menorMaior(char identificador) {
		float resultado = 0;
		switch(identificador) {
		case '+':
			for (Empregado empregado : getEmpresa()) {
				if (empregado.getSalario() > resultado)
					resultado = empregado.getSalario();
			}
			return resultado;
		default:
			resultado = getEmpresa().get(0).getSalario();
			for (Empregado empregado : getEmpresa()) {
				if (empregado.getSalario() < resultado)
					resultado = empregado.getSalario();
			}
			return resultado;
		}
	}

	@Override
	public boolean isRepetido(int inserido) {
		for (Empregado empregado : getEmpresa()) {
			if(empregado.getMatricula() == (int) inserido)
				return true;
		}
		return false;
	}

	@Override
	public float somaArray(char identificador) {
		float salarioTotal = 0;
		for (Empregado empregado : this.getEmpresa())
			salarioTotal += empregado.getSalario();
		return salarioTotal;
	}

	@Override
	public float media(char identificador) {
		return somaArray(identificador)/empresa.size();
	}
}
