package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import conexao.PessoaDao;
import dados.Homem;
import dados.Mulher;
import dados.Pessoa;
import validacao.Validacao;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

// TELA PESQUISA
public class Pesquisa extends JFrame {
	private JLabel erroNome, registros;
	private JTextField textField;
	private JTable table;
	private JButton pesquisar;

	// CONSTRUTOR
	Pesquisa(JTable tabela) {
		initComponents(tabela);
	}

	private void menuPrincipal() {
		TelaPrincipal janela = new TelaPrincipal();
		janela.setVisible(true);
		setVisible(false);
	}

	private void criaBotaoVoltar() {
		JButton voltar = new JButton("Voltar");
		voltar.setFont(new Font("Arial", Font.BOLD, 12));
		voltar.setBounds(355, 421, 90, 23);
		getContentPane().add(voltar);

		voltar.addActionListener(evt -> menuPrincipal());
	}

	// VERIFICA SE O NOME INSERIDO E VALIDO
	private boolean hasErroNome(String nome) {
		erroNome.setText("");
		erroNome.setForeground(Color.RED);

		if (!Validacao.isAlfabetico(nome) || nome.isEmpty()) {
			erroNome.setText("Nao pode conter Numeros ou ser vazio!");
			return true;
		} else {
			erroNome.setText("");
			erroNome.setForeground(Color.BLUE);
			return false;
		}
	}

	private void configuraFrame() {
		setTitle("Pesquisa");
		setResizable(false);
		setMinimumSize(new Dimension(800, 500));
		setMaximumSize(new Dimension(800, 500));
		setAlwaysOnTop(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
	}

	// LABEL AO LADO DO NOME
	private void insereLabel() {
		JLabel label = new JLabel("Insira o nome para Pesquisar");
		label.setFont(new Font("Arial", Font.BOLD, 12));
		label.setBounds(24, 21, 174, 14);
		getContentPane().add(label);
	}

	// ESPACO PARA DIGITAR
	private void criaTextFieldNome() {
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 12));
		textField.setBounds(135, 46, 440, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		criaLabelErro();

		textField.addCaretListener(evt -> hasErroNome(textField.getText()));
		textField.addCaretListener(evt -> pesquisar.setEnabled(!hasErroNome(textField.getText())));
	}

	// CASO O NOME SEJA INVALIDO
	private void criaLabelErro() {
		erroNome = new JLabel();
		erroNome.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		erroNome.setBounds(135, 72, 230, 14);
		getContentPane().add(erroNome);
	}

	private void criaBotaoPesquisar() {
		pesquisar = new JButton("Pesquisar");
		pesquisar.setEnabled(!textField.getText().isEmpty());
		pesquisar.setFont(new Font("Arial", Font.BOLD, 12));
		pesquisar.setBounds(635, 45, 111, 23);
		getContentPane().add(pesquisar);
		pesquisar.addActionListener(evt -> atualizaTabela());
	}

	// CRIA REGIAO DA TABELA E A ADICIONA
	private void criaAreaTabela(JTable tabela) {
		JPanel panel = new JPanel();
		panel.setBounds(0, 124, 785, 280);
		panel.setLayout(new BorderLayout());
		getContentPane().add(panel);

		table = tabela;
		panel.add(table);
		registros = new JLabel();
		getContentPane().add(registros);

		panel.add(getBarraRolagem());
	}

	// CRIA E RETORNA UMA BARRA DE ROLAGEM
	private JScrollPane getBarraRolagem() {
		JScrollPane barra;
		barra = new JScrollPane(table);
		barra.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		barra.doLayout();
		barra.setBounds(0, 0, 784, 380);
		return barra;
	}

	// ATUALIZA OS DADOS DA TABELA
	private void atualizaTabela() {
		registros.setText("");
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		PessoaDao dao = new PessoaDao();
		int qtd = 0;

		for (Pessoa p : dao.getGrupoByName(textField.getText()).getGrupo()) {
			modelo.addRow(new Object[] { p.getId(), p.getNome().toLowerCase(), p.getSituacaoExtenso(),
					(p.toString().split(" ")[1].equals("--")) ? ((Mulher) p).getSituacaoGExtenso() : "--",
					(p.toString().split(" ")[0].equals("--")) ? ((Homem) p).getIdade() : "--" });
			qtd++;
		}
		if (modelo.getRowCount() == 0)
			JOptionPane.showMessageDialog(null,
					"Nao existem pessoas que contenham a(s) palavra(s) '" + textField.getText() + "'");

		criaRegistros(qtd);
	}

	private void criaRegistros(int qtd) {
		registros.setText("Quantidade de registros encontrados: " + String.format("%01d", qtd));
		registros.setFont(new Font("Arial", Font.BOLD, 12));
		registros.setBounds(24, 425, 251, 14);
	}

	private void initComponents(JTable tabela) {
		configuraFrame();

		insereLabel();

		criaTextFieldNome();

		criaBotaoPesquisar();

		criaAreaTabela(tabela);

		criaBotaoVoltar();
	}
}
