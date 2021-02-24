//BIBLIOTECAS
import java.util.Scanner;

//CLASSE DO PROGRAMA
public class PesoElefante {
	
	//DECLARA��O DE FUN��O PARA ORDENAR OS PESOS
	public static float[] ordenaPesos(float pesos[]) {
		
		//CAMPOS
		float elefanteMaisLeve;
		
		//INSTRU��ES
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
	
	//M�TODO MAIN
	public static void main(String args[]) {
		
		//CAMPOS
		final int QTD = 3;
		float pesoElefante[] = new float[QTD];
		Scanner read = new Scanner(System.in);
		
		//INSTRU��ES
		System.out.println("Insira os pesos dos elefantes:");
		
		//LEITURA
		for (int aux = 0; aux < pesoElefante.length; aux++) {
			pesoElefante[aux] = read.nextFloat();
			
			//CASO O PESO SEJA MENOR QUE 5
			while (pesoElefante[aux] < 5) {
				System.out.println("O peso n�o pode ser menor do que 5 kg, insira novamente:");
				pesoElefante[aux] = read.nextFloat();
			}
		}
		//CHAMADA DA FUN��O
		pesoElefante = ordenaPesos(pesoElefante); 
		
		//RESPOSTA AO USU�RIO
		System.out.println("\n\nOs pesos em ordem crescente s�o:");
		for (int aux=0; aux<pesoElefante.length; aux++)
			System.out.println(+pesoElefante[aux]+" kg");
	}
}
