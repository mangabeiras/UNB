import java.util.Scanner;
public class Senha {
	
	//Main
	public static void main(String[] args) {
		//Campos
		final int MAXIMO = 9;
		Scanner read = new Scanner(System.in);
		String senha = null;
		String tentativaSenha;
		
		//Chamando a função 'primeiraSenha'
		senha = primeiraSenha(senha);
		System.out.println("Senha cadastrada com sucesso, deslogando do sistema...");
		
		limparTela();
		
		System.out.println("Bem vindo novo usuário, coloque a senha:");
		tentativaSenha = read.nextLine();
		
		//Função principal do Programa para comparação de senhas
		testeSenha(senha, tentativaSenha);
	}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Função que lê e analisa a senha dada pelo primeiro usuário, pedindo outra caso seja necessário
	public static String primeiraSenha(String senha) {
		Scanner read = new Scanner(System.in);
		
		System.out.println("Por favor, digite uma senha:");
		senha = read.nextLine();
		
		while (senha.length()>5 || senha.length()<3 || senha.replace(" ", "").length() != senha.length()) {
			System.out.println("A senha deve ter entre 3 e 5 caracteres e não pode ter espaços, insira novamente:");
			senha = read.nextLine();
		}
		return senha;
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Função para limpar tela com delay de 1 seg.
	public static void limparTela() {
		Thread tempo = new Thread();
		try {
			tempo.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int aux=0;aux<22;aux++)
			System.out.print("\n");
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Função para comparar as senhas dadas pelos outros usuários com a primeira senha
	public static void testeSenha(String senha, String tentativaSenha) {
		//Campos
		final int MAXIMO = 9;
		Scanner read = new Scanner(System.in);
		Thread tempo = new Thread(); //Para o timer de 10 seg.
		
		//Permite que o usuário tenha 9 tentativas para acertar a senha
		for (int aux=0;aux<MAXIMO;aux++) {
			
			//Caso ele acerte a senha
			if (senha.equals(tentativaSenha)) {
				limparTela();
				System.out.println("\t\t\t\t\t\t\tPARABÉNS, VOCÊ ACERTOU A SENHA"); 
				break;
			}
			
			//Caso ele erre a senha mas ainda tenha tentativas
			else {
				System.out.println("Errado! "+(MAXIMO-aux)+" tentativas restantes\nDigite novamente:");
				tentativaSenha = read.nextLine();
			}
			
			//caso ele acerte na ultima tentativa
			if (aux == 8 && senha.equals(tentativaSenha)) {
				limparTela();
				System.out.println("\t\t\t\t\t\t\tPARABÉNS, VOCÊ ACERTOU A SENHA");
			}
			
			//Caso ele erre todas as tentativas
			if (aux == 8 && !senha.equals(tentativaSenha)) {
				System.out.println("O computador se autodestuirá em 10 segundos!");
				
				//timer de 10 seg
				try {
					tempo.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
