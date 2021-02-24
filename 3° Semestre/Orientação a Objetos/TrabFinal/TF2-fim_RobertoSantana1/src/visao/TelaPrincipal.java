package visao;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import dados.Grupo;
import dados.Pessoa;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.SwingConstants;

import conexao.PessoaDao;

// TELA PRINCIPAL DA APLICACAO
public class TelaPrincipal extends JFrame {
	// COMPONENTS PRINCIPAIS
	private Lista listar;
	private JComboBox novo;
	private JButton lista, sair, mostra, pesquisa;
	private JMenuBar menuBar;

	public TelaPrincipal() {
		initComponents();
	}

	private void configuraFrame() {
		setTitle("Menu");
		setResizable(false);
		setMinimumSize(new Dimension(500, 500));
		setMaximumSize(new Dimension(500, 500));
		setAlwaysOnTop(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
	}

	// BOTOES DE CADASTRO
	private void criaBotoesCadastro() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		novo = new JComboBox();
		novo.setToolTipText("Clique para cadastrar");
		novo.setMaximumSize(new Dimension(100, 30));
		novo.setFont(new Font("Arial", Font.PLAIN, 14));
		novo.setModel(new DefaultComboBoxModel(new String[] { "Novo" }));
		novo.addItem("Homem");
		novo.addItem("Mulher");
		menuBar.add(novo);

		novo.addItemListener(evt -> defineCadastro(evt));
	}

	private void criaBotaoLista() {
		lista = new JButton("Lista");
		setCaracteristicas(lista);
		lista.setToolTipText("Clique para Visualizar todos os Cadastros");
		
		menuBar.add(lista);
		lista.addActionListener(evt -> lista());
	}

	private void criaBotaoPesquisa() {
		pesquisa = new JButton("Pesquisa");
		setCaracteristicas(pesquisa);
		menuBar.add(pesquisa);

		pesquisa.addActionListener(evt -> pesquisa());
	}

	private void criaBotaoSair() {
		JButton sair = new JButton("Sair");
		setCaracteristicas(sair);
		menuBar.add(sair);

		sair.addActionListener(evt -> fecha());
	}

	// BOTAO MOSTRA
	private void criaBotaoMostra() {
		mostra = new JButton("Mostra");
		setCaracteristicas(mostra);
		menuBar.add(mostra);

		mostra.addActionListener(evt -> mostra());
	}

	private void pesquisa() {
		Pesquisa telaPesquisa = new Pesquisa(new Lista().getTabela());
		telaPesquisa.setVisible(true);
		setVisible(false);
	}

	private void mostra() {
		Mostra mostra = new Mostra();
		mostra.setVisible(true);
		setVisible(false);
	}

	// LISTA PESSOAS CADASTRADAS
	private void lista() {
		listar = new Lista();
		listar.setVisible(true);
		setVisible(false);
	}

	// FECHA A JANELA
	private void fecha() {
		if (lista.isEnabled())
			Console.mostraResultado(new PessoaDao().getGrupo());
		System.exit(0);
	}

	// UM HOMEM OU UMA MULHER
	private void defineCadastro(ItemEvent e) {
		if (e.getItem().equals("Homem")) {
			CadastroHomem cadastroHomem = new CadastroHomem();
			cadastroHomem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cadastroHomem.setVisible(true);
			setVisible(false);
		}
		if (e.getItem().equals("Mulher")) {
			CadastroMulher cadastroMulher = new CadastroMulher();
			cadastroMulher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cadastroMulher.setVisible(true);
			setVisible(false);
		}
	}

	// CARACTERISTICAS DOS BOTOES
	private void setCaracteristicas(JButton botao) {
		botao.setPreferredSize(new Dimension(30, 22));
		botao.setMinimumSize(new Dimension(30, 22));
		botao.setMaximumSize(new Dimension(100, 30));
		botao.setHorizontalTextPosition(SwingConstants.LEFT);
		botao.setHorizontalAlignment(SwingConstants.LEFT);
		botao.setFont(new Font("Arial", Font.PLAIN, 14));
	}

	// IMG DA TELA DE FUNDO
	private void setImgFundo() {
		JLabel imgTela = new JLabel("");
		imgTela.setMinimumSize(new Dimension(500, 500));
		imgTela.setMaximumSize(new Dimension(500, 500));
		imgTela.setIcon(new ImageIcon("img\\telaPrincipal.png"));
		imgTela.setBounds(0, 0, 544, 436);
		getContentPane().add(imgTela);
	}

	private void initComponents() {

		configuraFrame();

		criaBotoesCadastro();

		criaBotaoLista();

		criaBotaoMostra();

		criaBotaoPesquisa();

		criaBotaoSair();

		setImgFundo();
	}
}
