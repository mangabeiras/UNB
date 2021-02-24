package dados;

import java.util.Vector;

import saida.Visao;

public class Grupo {
	private Vector<Nome> lista;
	
	public Grupo(String nome) {
		this.lista = new Vector<>();
		adicionaNome(new Nome(nome));
	}
	
	public Vector<Nome> getLista() {
		return this.lista;
	}
	
	public void adicionaNome(Nome nome) {
		this.lista.add(nome);
	}
	
	public void mostraRelatorio(int codigo) {
		switch (codigo) {
		case '1':{
			Visao.limpaTela(50);
			for (int aux = 0; aux < this.lista.size(); aux++)
				Visao.mostraMensagem(this.getLista().get(aux).getNome());
			break;
		}
		case '2':{
			Visao.limpaTela(50);
			for (int aux = 0; aux < this.lista.size(); aux++)
				Visao.mostraMensagem(this.getLista().get(aux).getNome());
		}
		}
	}
	public boolean novoGrupo(boolean resposta) {
		if (resposta == true) {
			this.lista.clear();
			return true;
		}
		else 
			return  false;
	}
}
