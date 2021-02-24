package dados;

import validacao.Validacao;
import visao.Visao;

// CLASSE QUE COMUNICA COM A CLASSE VENDEDORES E AS OUTRAS CLASSES
public class Grupo {
	Vendedores grupo[][];

	public Grupo(int qtdVendedor) {
		int qtdSemanas = Validacao.validaSemana();
		this.grupo = new Vendedores[qtdVendedor][qtdSemanas];
	}

	public void atribuiGrupo(int qtdVendedores) {
		for (int aux = 0; aux < getSemana(); aux++) {
			Visao.pedeVendas(aux);
			for (int i = 0; i < qtdVendedores; i++) {
				this.grupo[i][aux] = new Vendedores(Validacao.validaVendas(i));
			}
			Visao.limpaTela(10);
		}
		Visao.limpaTela(40);
	}

	// RETORNA QTD DE SEMANAS
	public int getSemana() {
		return this.grupo[0].length;
	}

	// RETORNA VENDA NA SEMANA
	public int getVenda(int aux, int i) {
		return this.grupo[aux][i].getVendas();
	}
}
