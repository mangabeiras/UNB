package dados;

import java.util.Vector;

import validacao.Validacao;
import visao.Visao;
// CLASSE DO GRUPO DE HABITANTES
public class Populacao {
	Vector<Habitante> populacao = new Vector<Habitante>();

	public void criaHabitante(int i) {
		this.populacao.add(new Habitante(Validacao.validaSexo(i), Validacao.validaIdade(), Validacao.validaFilhos(),
				Validacao.validaSalario()));
		Visao.limpaTela(20);
	}
	public int getTamanho() {
		return this.populacao.size();
	}
	public Habitante getHabitante(int i) {
		return this.populacao.get(i);
	}
}
