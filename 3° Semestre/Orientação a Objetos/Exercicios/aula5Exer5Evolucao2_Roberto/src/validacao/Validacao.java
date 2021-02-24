package validacao;

import java.util.ArrayList;
import java.util.InputMismatchException;

import dados.Aluno;
import dados.Turma;
import leitura.Leitura;
import saida.Visao;

public class Validacao {
	public static String validaNome() {
		String nome;
		boolean erro;
		
		System.out.println("\n-------------------------------CADASTRO-------------------------------");
		do {
			erro = false;
			System.out.print("Digite o nome completo do aluno: ");
			nome = Leitura.leString();
			
			if (nome.isEmpty()) {
				System.out.println("\nNome invalido !! Nao e permitido deixar esse campo em branco");
				erro = true;
			}
		} while(erro);
		return nome;
	}
	
	public static int validaMatricula(Turma alunos) {
		int matricula = 0;
		boolean erro;
		final int MAX = 1000;
		
		do {
			try {
				erro = false;
				System.out.print("Digite a matricula do aluno: ");
				matricula = Leitura.leInteiro();
				
				if(matricula < MAX) {
					System.out.println("\nNumero de matricula invalido !! Digite novamente.");
					erro = true;
				}
				else {
					int contador = 0;
					while(contador < alunos.getAlunos().size()){
						if(alunos.getAluno(contador++).getMatricula() == matricula) {
							System.out.println("\nMatricula ja existente !! Impossivel cadastrar outro aluno com a mesma matricula.");
							erro = true;
							break;
						}
					}
				}
				
			} catch (InputMismatchException e) {
				System.out.println("\nFormato de matricula invalido !! Digite somente os numeros da matricula");
				erro = true;
			}
		}while(erro);
		
		return matricula;
	}
	
	public static float validaMedia() {
		float media = -1f;
		boolean erro;
		
		do {
			try {
				erro = false;
				System.out.print("Digite a media final do aluno: ");
				media = Leitura.leFloat();
				
				if(media < 0 || media > 10) {
					System.out.println("\nMedia invalida !! O valor deve estar entre 0 e 10 !!");
					erro = true;
				}
			} catch(InputMismatchException e) {
				System.out.println("Formato invalido de media !! Se atente ao numero inserido. Caso escreva numero decimal utilize ',' e naoo '.' !!\n");
				erro = true;
			}
		}while(erro);
		Visao.limpaConsole(1);
		
		return media;
		
	}
	
	public static boolean isContinuaCadastro(){
		char continua;
		boolean erro;
		
		do {
			erro = false;
			System.out.print("Deseja cadastrar mais um aluno ? Digite 'Sim' ou 'Nao' para escolher: ");
			continua = Leitura.leCaracter();
			
			if(continua != 'S' && continua != 'N') {
				System.out.println("Opcao invalida !!\n");
				erro = true;
			}
		}while(erro);
		
		if(continua=='S') {
			Visao.limpaConsole(20);
			return true;
		}
		return false;
	}
	
	public static float validaMediaGeral(Turma alunos) {
		float soma = 0f;
		ArrayList<Aluno> alunosCadastrados = alunos.getAlunos();
		
		for(int i=0; i < alunosCadastrados.size(); i++)
			soma += alunosCadastrados.get(i).getMediaAritmetica();
		
		return soma/alunosCadastrados.size();
	}
}











