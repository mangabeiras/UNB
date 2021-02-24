package validacao;

import java.util.InputMismatchException;

import leitura.Leitura;
import visao.Visao;

public class Validacao {
	// VALIDA QUANTIDADE DE SEMANA INSERIDA
	public static int validaSemana() {
		final int SEMANA_MAX = 4, SEMANA_MIN = 3;
		int resposta = 0;
		boolean erro = false;
		Visao.pedeSemana();
		do {
			try {
				resposta = Leitura.lerInt();
				while (resposta < SEMANA_MIN | resposta > SEMANA_MAX) {
					Visao.erroSemana(SEMANA_MIN, SEMANA_MAX);
					resposta = Leitura.lerInt();

				}
				erro = false;
			} catch (InputMismatchException excecao) {
				Visao.excecaoInt();
				erro = true;
			}
		} while (erro);
		return resposta;
	}

	// VALIDA O VALOR DAS VENDAS INSERIDAS
	public static int validaVendas(int i) {
		int resposta = 0;
		boolean erro = false;
		Visao.vendedor(i);
		do {
			try {
				resposta = Leitura.lerInt();
				while (resposta < 0) {
					Visao.erroVendas();
					resposta = Leitura.lerInt();
				}
				erro = false;
			} catch (InputMismatchException excecao) {
				Visao.excecaoInt();
				erro = true;
			}
		} while (erro);
		return resposta;
	}
}
