package visao;

import java.text.DecimalFormat;
//SAIDAS DO PROGRAMA
public class Visao {
	public static void orientacoes() {
		// ORIENTACOES PARA USO DO PROGRAMA
		System.out.println("-----ORIENTACOES PARA USO-----\n1.Insira os sexo apenas com 'M' ou 'F'");
		System.out.println("2.As idades e filhos deverao ser apenas numeros inteiros nao negativos, e condizerem com a realidade. Exemplo: 10");
		System.out.println("3.Salarios tambem sao apenas numeros, porem podem possuir casas decimais. Exemplo: 1300.56");
		System.out.println("4.Ao terminar de cadastrar um habitande digite S para cadastrar outro. Qualquer outra entrada ira terminar o programa");
		limpaTela(2);
	}
	
	// LIMPA TELA
	public static void limpaTela(int saltos) {
		for (int i = 0; i < saltos; i++)
			System.out.println();
	}

	public static void pedirSexo(int i) {
		System.out.print("HABITANTE " + (i + 1) + "\nSEXO:");
	}

	public static void pedirIdade() {
		System.out.print("IDADE:");
	}

	public static void pedirFilhos() {
		System.out.print("FILHOS:");
	}

	public static void pedirSalario() {
		System.out.print("SALARIO:");
	}

	public static void continua() {
		System.out.println("Digite S se desejar continuar:");
	}

	public static void erroSexo() {
		System.out.println("Insira apenas M ou F:");
	}
// RESULTADO FINAL
	public static void mostraResultado(int menorIdade, float maiorSalario, float mediaFilhos, float mediaSalarios,
			float mediaHomensCompara, final float SALARIO, int qtdSalarios) {
		DecimalFormat mascara = new DecimalFormat("0.00");
		limpaTela(50);
		System.out.println("Menor idade nessa populacao: " + menorIdade);
		System.out.println("Maior salario: " + mascara.format(maiorSalario));
		System.out.println("Media do numero de filhos: " + mascara.format(mediaFilhos));
		System.out.println("Media dos salarios: " + mascara.format(mediaSalarios));
		System.out.println("Media dos homens com salarios maiores que "+mascara.format(SALARIO)+": " + mascara.format(mediaHomensCompara));
		System.out.println("Quantidade de pessoas que recebem salario acima da media: "+qtdSalarios);
	}

}
