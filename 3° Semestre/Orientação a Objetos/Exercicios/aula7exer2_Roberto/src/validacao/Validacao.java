package validacao;

import java.util.InputMismatchException;

import dados.Exposicao;
import leitura.Leitura;
import visao.Visao;

public class Validacao {
	public static String validaNome(int codigo) {
		String nome;
		do {
			Visao.interacao(codigo);
			nome = Leitura.leLinha();
			if (nome.isEmpty() || nome.length() < 3 || nome.length() > 30)
				Visao.erroEntrada(0, 0, 0);
		} while (nome.isEmpty() || nome.length() < 3 || nome.length() > 30);
		return nome;
	}
	
	public static int validaAno(int codigo, final int ANONIMO, final int MAXIMO) {
		int ano;
		try {
			Visao.interacao(codigo);
			ano = Leitura.leInt();
			if (ano <= ANONIMO || ano > MAXIMO) {
				Visao.erroEntrada(1, ANONIMO, MAXIMO);
				ano = validaAno(codigo, ANONIMO, MAXIMO);
			}
		} catch (InputMismatchException e) {
			Visao.erroEntrada(2, 0, 0);
			ano = validaAno(codigo, ANONIMO, MAXIMO);
		}
		return ano;
	}
	public static int validaOpcao() {
		int opcao;
		
		try {
			opcao = Leitura.leInt();
			if (opcao > 4 || opcao < 0) {
				Visao.erroEntrada(3, 0, 0);
				opcao = validaOpcao();
			}
		} catch (InputMismatchException e) {
			Visao.erroEntrada(4, 0, 0);
			opcao = validaOpcao();
		}
		return opcao;
	}
	public static int validaPintor(Exposicao exposicao) {
		int codigo = -1;
		
		Visao.interacao(5);
		try {
			codigo = Leitura.leInt();
			if (codigo > exposicao.getPintor().size() || codigo <= 0) {
				Visao.erroEntrada(5, 0, 0);
				codigo = validaPintor(exposicao);
			}
		} catch (InputMismatchException e) {
			Visao.erroEntrada(5, 0, 0);
			codigo = validaPintor(exposicao);
		}
		return codigo;
	}
	public static float validaPreco() {
		float preco;
		
		try {
			Visao.interacao(6);
			preco = Leitura.leFloat();
			if (preco < 15) {
				Visao.erroEntrada(6, 0, 0);
				preco = validaPreco();
			}
		} catch (InputMismatchException e) {
			Visao.erroEntrada(7, 0, 0);
			preco = validaPreco();
		}
		return preco;
	}
	public static boolean validaContinua() {
		Visao.interacao(10);
		return ((Leitura.leLinha().trim().toLowerCase().equals("s")?true: false));
	}
}
