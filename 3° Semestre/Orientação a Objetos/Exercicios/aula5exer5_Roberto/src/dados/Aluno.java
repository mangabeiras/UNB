package dados;
// CLASSE QUE SALVA OS DADOS
public class Aluno {
	private String nome;
	private int matricula;
	float media;
	
	// METODO CONSTRUTOR
	Aluno(String nome, int matricula, float media){
		setNome(nome);
		setMatricula(matricula);
		setMedia(media);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setMatricula(int matricula){
		this.matricula = matricula;
	}
	public void setMedia(float media) {
		this.media = media;
	}
	public int getMatricula() {
		return this.matricula;
	}
	public float getMedia(){
		return this.media;
	}
	public String getNome() {
		return this.nome;
	}
}
