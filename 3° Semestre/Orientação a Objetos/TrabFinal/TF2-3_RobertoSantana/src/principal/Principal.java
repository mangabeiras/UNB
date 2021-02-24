package principal;

import javax.swing.JFrame;
import dados.Grupo;
import visao.TelaPrincipal;

public class Principal {	
	public static void main(String[] args) {		
		// INICIO DA TELA PRINCIPAL
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaPrincipal.setVisible(true);
	}
}

