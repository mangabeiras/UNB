package dados;

import java.util.ArrayList;
// GRUPO DE FUNCIONARIOS
public class Empresa {
	ArrayList<Funcionario> empresa;
	
	public Empresa() {
		empresa = new ArrayList<Funcionario>();
	}
	
	public ArrayList<Funcionario> getEmpresa(){
		return this.empresa;
	}
	public void addFuncionario(Funcionario funcionario) {
		this.empresa.add(funcionario);
	}
}	
