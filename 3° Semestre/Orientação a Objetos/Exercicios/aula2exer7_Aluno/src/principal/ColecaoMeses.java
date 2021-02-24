package principal;

/** S�ntese
* Objetivo: mostrar meses impares em alguma ordem
* Entrada: nenhuma (atribui��o)
* Sa�da: meses em algumas ordena��es
*/
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class ColecaoMeses {
	public static void main(String[] args) {
		String[] meses = { "Janeiro", "Mar�o", "Maio", "Julho", "Setembro", "Novembro" };
		List lista;
// Ordem alfab�tica crescente pelo nome do m�s
		Arrays.sort(meses); // m�todo de alto n�vel
// Transforma um Array em Lista
		lista = Arrays.asList(meses);
		System.out.println("\nMESES EM ORDEM ALFAB�TICA");
// Mostra a Lista em Ordem
		for (int aux = 0; aux < lista.size(); aux++)
			System.out.print(lista.get(aux) + "\t");
//poderia ser java.util.*;
//Cole��es
// continua��o do exemplo anterior
// Inverte os dados da lista
		Collections.reverse(lista);
		System.out.println("\n\nMOSTRA LISTA INVERTIDA");
// Imprime a Lista Invertida
		for (int aux = 0; aux < lista.size(); aux++)
			System.out.print(lista.get(aux) + "\t");
	}
}
