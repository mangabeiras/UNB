//BIBLIOTECAS
import java.util.Scanner;

//CLASSE DO PROGRAMA
public class PesoElefante {
	
	//DECLARAÇÃO DE FUNÇÃO PARA ORDENAR OS PESOS
	public static float[] ordenaPesos(float pesos[]) {
		
		//CAMPOS
		float elefanteMaisLeve;
		
		//INSTRUÇÕES
		for (int aux=0; aux<pesos.length; aux++) {
			for (int aux2=0; aux2<pesos.length;aux2++) {
				if (pesos[aux] < pesos[aux2]) {    
					elefanteMaisLeve = pesos[aux];     //TROCANDO A ORDEM DO ARRAY
					pesos[aux] = pesos[aux2];
					pesos[aux2]= elefanteMaisLeve;
				}
			}
		}
		return pesos;
	}
	
	//MÉTODO MAIN
	public static void main(String args[]) {
		
		//CAMPOS
		final int QTD = 3;
		float pesoElefante[] = new float[QTD];
		Scanner read = new Scanner(System.in);
		
		//INSTRUÇÕES
		System.out.println("Insira os pesos dos elefantes:");
		
		//LEITURA
		for (int aux = 0; aux < pesoElefante.length; aux++) {
			pesoElefante[aux] = read.nextFloat();
			
			//CASO O PESO SEJA MENOR QUE 5
			while (pesoElefante[aux] < 5) {
				System.out.println("O peso não pode ser menor do que 5 kg, insira novamente:");
				pesoElefante[aux] = read.nextFloat();
			}
		}
		//CHAMADA DA FUNÇÃO
		pesoElefante = ordenaPesos(pesoElefante); 
		
		//RESPOSTA AO USUÁRIO
		System.out.println("\n\nOs pesos em ordem crescente são:");
		for (int aux=0; aux<pesoElefante.length; aux++)
			System.out.println(+pesoElefante[aux]+" kg");
	}
}
