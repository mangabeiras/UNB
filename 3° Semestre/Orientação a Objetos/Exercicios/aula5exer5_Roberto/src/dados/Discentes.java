package dados;

import java.util.Vector;
// CLASSE QUE SE COMUNICA COM A ALUNO
public class Discentes {
	Vector<Aluno> corpoDiscente;
	
	public Discentes(){
		this.corpoDiscente = new Vector<Aluno>(); 
	}
	
	// FUNCAO QUE GUARDA OS VALORES INSERIDOS NA CLASSE ALUNO
	public void criaAluno(String nome, int matricula, float media) {
		this.corpoDiscente.add(new Aluno(nome, matricula, media));
	}
	
	// QUANTOS ALUNOS FORAM CADASTRADOS ATE O MOMENTO
	public int getTamanho() {
		return this.corpoDiscente.size();
	}
	public int getMatricula(int i) {
		return this.corpoDiscente.get(i).getMatricula();
	}
	public float getMedia(int i) {
		return this.corpoDiscente.get(i).getMedia();
	}
	public String getNome(int i) {
		return this.corpoDiscente.get(i).getNome();
	}
}
