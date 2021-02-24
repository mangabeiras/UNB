import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;


public class SexoPeso {

	public static void main(String[] args) {
		//Campos
		final int MAXIMO = 5;
		char sexo[] = new char[MAXIMO];
		float peso[] = new float[MAXIMO];
		int numPessoa=0, numMulheres=0, numHomens=0, somaPesoHomens=0;
		Scanner leitura = new Scanner(System.in);
		DecimalFormat formaNum = new DecimalFormat("0.00");
		
		//Instruções
		for (int aux=0;aux<MAXIMO;aux++) {
			
			//numPessoa para identificar a pessoa
			numPessoa = aux+1;
			System.out.println("Por favor, pessoa nº "+numPessoa+" digite seu sexo, com apenas uma letra, e após um espaço, seu peso(com apenas números):");
			
			//Leitura do SEXO
			sexo[aux] = leitura.next().toUpperCase().charAt(0);			
			
			//Caso o caracter informado não tenha correspondência
			while (sexo[aux]!='M'&&sexo[aux]!='F') {
				System.out.println("O caracter informado não tem correspondência, por favor digite \'M\' ou \'F\':");
				sexo[aux] = leitura.next().toUpperCase().charAt(0);
			}
			
			//Levantamento da quantidade de homens e mulheres no conjunto
			if(sexo[aux]=='F')
				numMulheres++;
			else
				numHomens++;
			
			//Leitura do PESO
			peso[aux] = leitura.nextFloat();
			
			//Caso o peso informado não seja correspondente
			while (peso[aux] <= 0) {
				System.out.println("O peso informado não é correspondente, por favor, digite o peso novamente:");
				peso[aux] = leitura.nextFloat();
			}
			
			//Soma dos pesos dos homens para cálcular a média
			if(sexo[aux]=='M')
				somaPesoHomens += peso[aux];
			
		}
		//Colocando Array dos pesos em ordem crescente através da biblioteca 'Arrays'
		Arrays.sort(peso); 
		
		//Limpeza do Console
		for(int aux2=0;aux2<50;aux2++)
			System.out.print("\n");
		
		//Resposta ao Usuário
		System.out.println("Os maior e menor peso são respectivamente:\n"+formaNum.format(peso[MAXIMO-1])+" KG e "+formaNum.format(peso[0])+" KG\nA média dos pesos dos homens é:\n"+formaNum.format(somaPesoHomens/numHomens)+" KG\nExistem "+numMulheres+" mulheres entre essas "+MAXIMO+" pessoas");
				
	}

}
