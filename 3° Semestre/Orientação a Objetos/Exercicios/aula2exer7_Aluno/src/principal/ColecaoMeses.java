package principal;

/** Síntese
* Objetivo: mostrar meses impares em alguma ordem
* Entrada: nenhuma (atribuição)
* Saída: meses em algumas ordenações
*/
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class ColecaoMeses {
	public static void main(String[] args) {
		String[] meses = { "Janeiro", "Março", "Maio", "Julho", "Setembro", "Novembro" };
		List lista;
// Ordem alfabética crescente pelo nome do mês
		Arrays.sort(meses); // método de alto nível
// Transforma um Array em Lista
		lista = Arrays.asList(meses);
		System.out.println("\nMESES EM ORDEM ALFABÉTICA");
// Mostra a Lista em Ordem
		for (int aux = 0; aux < lista.size(); aux++)
			System.out.print(lista.get(aux) + "\t");
//poderia ser java.util.*;
//Coleções
// continuação do exemplo anterior
// Inverte os dados da lista
		Collections.reverse(lista);
		System.out.println("\n\nMOSTRA LISTA INVERTIDA");
// Imprime a Lista Invertida
		for (int aux = 0; aux < lista.size(); aux++)
			System.out.print(lista.get(aux) + "\t");
	}
}
