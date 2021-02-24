package saida;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dados.Pessoa;

public class Tela_Lista extends JFrame {

	private JPanel painelLista;
	private JScrollPane painelRolagem;
	private JLabel textoQuantidade;

	public Tela_Lista(ArrayList<Pessoa> populacao, char opcao) {
		configuraJanela();
		configuraPainel();
		configuraPainelDeRolagem();
		configuraTabela(populacao, opcao);
		botaoRetornoMenu();
	}

	// JANELA TABELAR
	private void configuraJanela() {
		setTitle("MENU LISTAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 580);
	}

	// PAINEL TABELAR
	private void configuraPainel() {
		painelLista = new JPanel();
		painelLista.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelLista);

		painelLista.setLayout(null);
		setLocationRelativeTo(null);
	}

	// PAINEL DE ROLAGEM
	private void configuraPainelDeRolagem() {
		painelRolagem = new JScrollPane();
		painelRolagem.setBounds(30, 30, 803, 400);

		painelLista.add(painelRolagem);
	}

	// TABELA DE DADOS
	private void configuraTabela(ArrayList<Pessoa> populacao, char opcao) {
		JTable tabelaDados = new JTable(insercaoDadosTabela(populacao));

		tabelaDados.getColumnModel().getColumn(0).setPreferredWidth(20);
		tabelaDados.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabelaDados.getColumnModel().getColumn(2).setPreferredWidth(20);
		tabelaDados.getColumnModel().getColumn(3).setPreferredWidth(10);
		tabelaDados.getColumnModel().getColumn(4).setPreferredWidth(10);

		tabelaDados.setEnabled(false);

		painelLista.add(tabelaDados);
		painelRolagem.setViewportView(tabelaDados);

		configuraOpcao(opcao, populacao.size());
	}

	// INSERCAO DE DADOS NA TABELA
	private DefaultTableModel insercaoDadosTabela(ArrayList<Pessoa> populacao) {
		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("Identificador");
		modelo.addColumn("Nome completo");
		modelo.addColumn("Genero");
		modelo.addColumn("Idade");
		modelo.addColumn("Situacao de saude");

		modelo.setNumRows(0);

		for (Pessoa pessoa : populacao) {
			if (pessoa.getSituacao() != null)
				modelo.addRow(new Object[] { pessoa.getIdentificador(), pessoa.getNome().toString().toUpperCase(),
						pessoa.getGeneroPorExtenso(), "---", pessoa.getSituacaoPorExtenso() });
			else
				modelo.addRow(new Object[] { pessoa.getIdentificador(), pessoa.getNome().toString().toUpperCase(),
						pessoa.getGeneroPorExtenso(), pessoa.getIdade(), "---" });
		}

		return modelo;
	}

	// BOTAO DE RETORNO AO MENU PRINCIPAL
	private void botaoRetornoMenu() {
		JButton botaoRetornoMenu = new JButton("Retornar ao menu");
		botaoRetornoMenu.setFont(new Font("Arial", Font.PLAIN, 16));
		botaoRetornoMenu.setBounds(30, 450, 160, 25);
		painelLista.add(botaoRetornoMenu);

		botaoRetornoMenu.addActionListener(evento -> telaPrincipal());
	}

	// MUDAR PARA TELA PRINCIPAL
	private void telaPrincipal() {
		new Tela_Principal().setVisible(true);
		setVisible(false);
	}

	// TEXTO NO CASO DE PESQUISA (EXIBE A QTD DE PESSOAS ENCONTRADAS)
	private void configuraOpcao(char opcao, int contador) {
		textoQuantidade();

		if (opcao == 'P') {
			textoQuantidade.setText("Quantidade de registros recuperados: " + contador);
			painelLista.add(textoQuantidade);
		}
	}

	// TEXTO DE SOLICITACAO
	private void textoQuantidade() {
		textoQuantidade = new JLabel();
		textoQuantidade.setFont(new Font("Arial", Font.PLAIN, 15));
		textoQuantidade.setBounds(230, 450, 400, 25);
	}

}