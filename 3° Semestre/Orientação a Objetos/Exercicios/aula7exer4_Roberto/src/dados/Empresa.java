package dados;

import java.util.ArrayList;
// CONJUNTO DE FUNCIONARIOS
public class Empresa {
	ArrayList<Funcionario> empresa;

	public Empresa() {
		this.empresa = new ArrayList<Funcionario>();
	}
	public ArrayList<Funcionario> getEmpresa(){
		return this.empresa;
	}
	public void addFuncionario(Funcionario funcionario) {
		this.empresa.add(funcionario);
	}
	// ADICIONAR UM TIPO FUNCIONARIO A EMPRESA
	public void registraRegular(String nome, long cpf, int []nascimento) {
		this.addFuncionario(new Regular(nome, cpf, nascimento));
	}
	public void registraPrestador(String nome, long cpf, int []nascimento, int horas) {
		this.addFuncionario(new Prestador(nome, cpf, nascimento, horas));
	}
	public void registraGerente(String nome, long cpf, int []nascimento, int projetos) {
		this.addFuncionario(new Gerente(nome, cpf, nascimento, projetos));
	}
}
