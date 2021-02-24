package dados;

import java.util.ArrayList;

public class Empresa {
	private ArrayList<Funcionario> funcionarios;

	public Empresa() {
		this.funcionarios = new ArrayList<Funcionario>();
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void addFuncionarios(Funcionario funcionario) {
		this.funcionarios.add(funcionario);
	}



}
