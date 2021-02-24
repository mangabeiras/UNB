package principal;



import javax.swing.JFrame;


// ROBERTO GABRIEL MANGABEIRA SANTANA / 190019620
import dados.Grupo;
import dados.Pessoa;
import interfaceGrafica.TelaPrincipal;
import validacao.Validacao;


public class Principal {
	
	public static void main(String[] args) {
		JFrame janela = new TelaPrincipal(new Pessoa(200, new StringBuilder().append("Me"), '0'));
	}
}

