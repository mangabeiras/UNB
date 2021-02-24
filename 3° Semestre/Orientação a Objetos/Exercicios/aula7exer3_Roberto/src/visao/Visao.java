package visao;

import java.text.DecimalFormat;

import dados.Baleia;
import dados.Elefante;
import dados.Macaco;
import dados.Zoologico;
// SAIDAS
public class Visao {
	// INTERACOES DE CADASTRO
	public static void interacao(int codigo) {
		if (codigo == 0)
			System.out.println("CADASTRO DE MAMIFERO");
		if (codigo == 1)
			System.out.print("Idade geral de amamentacao:");
		if (codigo == 2)
			System.out.print("Idade do Animal:");
		if (codigo == 3)
			System.out.print("Especie:");
		if (codigo == 4)
			System.out.print("Tamanho: ");
		if (codigo == 5)
			System.out.print("Peso: ");
		if (codigo == 6)
			System.out.print("Habitat: ");
		if (codigo == 7)
			System.out.print("Porte: ");
		if (codigo == 8)
			System.out.println("Deseja cadastrar outro mamifero? Digite S ou N: ");
	}
	
	// LIMPA TELA
	public static void limpaTela(int saltos) {
		for (int i = 0; i < saltos; i++)
			System.out.println();
	}
	
	// ERROS DE ENTRADA
	public static void erroEntrada(int codigo, final String NOME, final String NOME_1, final String NOME_2) {
		if (codigo == 0)
			System.err.println("Entrada Invalida! Insira apenas um numero");
		if (codigo == 1)
			System.err.println("Entrada Invalida! Insira apenas um numero de " + NOME + " a " + NOME_1 + ".");
		if (codigo == 2)
			System.err.println("Invalido! Digite apenas " + NOME + ", " + NOME_1 + " ou " + NOME_2);
		if (codigo == 3)
			System.err.println("Invalido. Insira apenas S ou N");
		if (codigo ==4)
			System.err.println("Limite maximo de "+NOME+" animais atingido");
	}
	
	// RESULTADO FINAL
	public static void mostraRelatorio(Zoologico zoologico, int macacos, int elefantes, int baleias) {
		int indice = 1;
		DecimalFormat mascara = new DecimalFormat("00");
		DecimalFormat mascara_1 = new DecimalFormat("0.00");
		String formato = "%-10s%-10s%-25s%-10s%-10s%-10s%-20s%-10s\n";
		
		limpaTela(50);
		System.out.format(formato, "Indice", "Especie", "Idade de Amamentacao", "Idade", "Tamanho", "Peso", "Porte", "Habitat");
		
		if (baleias != 0)
			for (Baleia baleia : zoologico.getBaleias())
				System.out.format(formato, mascara.format(indice++), baleia.getEspecie(), baleia.getAmamentacao(), baleia.getIdade(), mascara_1.format(baleia.getTamanho()), mascara_1.format(baleia.getPeso()), "NDA" , "NDA");	
		
		if (macacos != 0)
			for (Macaco macaco : zoologico.getMacacos())
				System.out.format(formato, mascara.format(indice++), macaco.getEspecie(), macaco.getAmamentacao(), macaco.getIdade(), mascara_1.format(macaco.getTamanho()),"NDA" , macaco.getPorte(), "NDA");
		
		if (elefantes != 0)
			for (Elefante elefante : zoologico.getElefantes())
				System.out.format(formato, mascara.format(indice++), elefante.getEspecie(), elefante.getAmamentacao(), elefante.getIdade(), mascara_1.format(elefante.getTamanho()), mascara_1.format(elefante.getPeso()), "NDA", elefante.getHabitat());
	}
}
