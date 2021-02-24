package visao;
import java.text.DecimalFormat;
// TODAS AS SAIDAS DO PROGRAMA
public class Visao {
	public static void limpaTela(int saltos) {
		for (int i=0;i<saltos;i++)
			System.out.println();
	}
	public static void pedeNome(int i) {
		System.out.print("ALUNO "+(i+1)+"\nNOME:");
	}
	public static void erroNome(final int MIN) {
		System.out.println("Insira um nome que tenha no minimo "+MIN+" caracteres:");
	}
	public static void pedeMatricula() {
		System.out.print("MATRICULA:");
	}
	public static void erroMatricula(int MAX) {
		System.out.println("A matricula deve ser maior que "+MAX+" e nao pode ser repetida. Insira novamente:");
	}
	public static void pedeMedia() {
		System.out.print("MEDIA:");
	}
	public static void erroMedia() {
		System.out.println("Insira uma media que seja um numero real e esteja entre 0 e 10:");
	}
	public static void continua() {
		System.out.println("Digite S se quiser continuar:");
	}
	public static void montaTabela() {
		System.out.println("MATRICULA   \t\t        NOME      \t\t        MEDIA   ");
	}
	public static void corpoTabela(int matricula, String nome, float media) {
		DecimalFormat mascara = new DecimalFormat("0.00");
		System.out.println(matricula+"             \t\t"+nome+"               \t\t"+mascara.format(media));
	}
	public static void mediaAritmetica(float media) {
		DecimalFormat mascara = new DecimalFormat("0.00");
		System.out.println("MEDIA DA TURMA: "+mascara.format(media));
	}
}
