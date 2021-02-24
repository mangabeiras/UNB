package visao;

import javax.swing.JOptionPane;
import dados.Grupo;
import dados.Pessoa;

public class Console {
	// MOSTRA MSG POR JOPTION
	public static void mostraMensagem(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	
	// LIMPA A TELA DA CONSOLE
	public static void limpaTela(int saltos) {
		for (int contador = 0; contador < saltos; contador++)
			System.out.println();
	}
	
	
	// RELATORIO
		public static void mostraRelatorio(Grupo grupo) {
			String formato = "%-20s%-30s%-30s%-13s%-10s\n";
			
			limpaTela(50);
			System.out.format(formato, "CODIGO", "NOME COMPLETO", "SITUACAO  DE SAUDE", "IDADE", "GESTACAO");
			
			for (Pessoa pessoa : grupo.getGrupo())
				System.out.print(pessoa);
		}
	
	// RESULTADO
		/*public static void mostraResultado(Grupo grupo) {
			 int casos[] = Servicos.identificaSituacao(grupo);
			 DecimalFormat mascara = new DecimalFormat("00");
			 
			 limpaTela(50);
			 System.out.println(mascara.format(casos[0])+ " = CONTAMINADOS CURADOS");
			 System.out.println(mascara.format(casos[1])+ " = CONTAMINADOS EM TRATAMENTO");
			 System.out.println(mascara.format(casos[2])+ " = CONTAMINADOS FALECIDOS");
			 System.out.println(mascara.format(casos[3])+ " = HOMENS SEM CONTAMINAÇÃO");
			 System.out.println(mascara.format(casos[4])+ " = MULHERES SEM CONTAMINAÇÃO");
			 System.out.println(mascara.format(grupo.getGrupo().size()) +" = TOTAL DE REGISTRO DE PESSOAS");
		}*/
}
