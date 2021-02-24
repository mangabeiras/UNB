package saida;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.PessoaDao;

import javax.swing.JButton;
import java.awt.Font;

public class Tela_Principal extends JFrame {

	// COMPONENTES
	private JPanel painelPrincipal;

	// CONSTRUTOR
	public Tela_Principal() {
		configuraJanela();
		configuraPainel();
		configuraBotoes();
	}

	// JANELA CADASTRAL
	private void configuraJanela() {
		setTitle("MENU PRINCIPAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1220, 150);
	}

	// PAINEL PRINCIPAL
	private void configuraPainel() {
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);

		painelPrincipal.setLayout(null);
		setLocationRelativeTo(null);
	}

	// CONFIGURA TODOS OS BOTOES
	private void configuraBotoes() {
		botaoCadastro();
		botaoListar();
		botaoConsultar();
		botaoPesquisar();
		botaoEncerrar();
	}

	// BOTAO CADASTRO
	private void botaoCadastro() {
		JButton botaoCadastro = new JButton("Realizar Cadastro");
		botaoCadastro.setFont(new Font("Arial", Font.BOLD, 15));
		botaoCadastro.setBounds(20, 30, 200, 30);

		painelPrincipal.add(botaoCadastro);
		botaoCadastro.addActionListener(evento -> telaCadastral());
	}

	// MUDAR PARA TELA CADASTRAL
	private void telaCadastral() {
		new Tela_Cadatro().setVisible(true);
		setVisible(false);
	}

	// BOTAO LISTAR
	private void botaoListar() {
		JButton botaoListar = new JButton("Lista de Pessoas");
		botaoListar.setFont(new Font("Arial", Font.BOLD, 15));
		botaoListar.setBounds(260, 30, 200, 30);
		botaoListar.setEnabled(true);

		painelPrincipal.add(botaoListar);
		botaoListar.addActionListener(evento -> telaLista());
	}

	// MUDAR PARA TELA DE LISTAR
	private void telaLista() {

		if (new PessoaDao().getPopulacao().isEmpty())
			Saida.exibirMensagem(
					"Nenhum cadastro realizado ate o momento, realize um cadastro para acessar esta opcao.", "LISTAR");
		else {
			new Tela_Lista(new PessoaDao().getPopulacao(), '-').setVisible(true);
			setVisible(false);
		}
	}

	// BOTAO CONSULTAR
	private void botaoConsultar() {
		JButton botaoConsultar = new JButton("Consultar Pessoa");
		botaoConsultar.setFont(new Font("Arial", Font.BOLD, 15));
		botaoConsultar.setBounds(500, 30, 200, 30);
		botaoConsultar.setEnabled(true);

		painelPrincipal.add(botaoConsultar);
		botaoConsultar.addActionListener(evento -> telaConsulta());
	}

	// MUDAR PARA TELA DE CONSULTA
	private void telaConsulta() {

		if (new PessoaDao().getPopulacao().isEmpty())
			Saida.exibirMensagem(
					"Nenhum cadastro realizado ate o momento, realize um cadastro para acessar esta opcao.",
					"CONSULTAR");
		else {
			new Tela_Consulta().setVisible(true);
			setVisible(false);
		}
	}

	// BOTAO CONSULTAR
	private void botaoPesquisar() {
		JButton botaoPesquisar = new JButton("Pesquisar Pessoa");
		botaoPesquisar.setFont(new Font("Arial", Font.BOLD, 15));
		botaoPesquisar.setBounds(740, 30, 200, 30);
		botaoPesquisar.setEnabled(true);

		painelPrincipal.add(botaoPesquisar);
		botaoPesquisar.addActionListener(evento -> telaPesquisa());
	}

	// MUDAR PARA TELA DE PESQUISA
	private void telaPesquisa() { // FOI DEIXADA HABILITADA ESTA OPCAO
		new Tela_Pesquisa().setVisible(true);
		setVisible(false);
	}

	// BOTAO ENCERRAR
	private void botaoEncerrar() {
		JButton botaoEncerrar = new JButton("Encerrar");
		botaoEncerrar.setFont(new Font("Arial", Font.BOLD, 15));
		botaoEncerrar.setBounds(980, 30, 200, 30);

		painelPrincipal.add(botaoEncerrar);
		botaoEncerrar.addActionListener(evento -> encerrarPrograma());
	}

	// ENCERRAR O PROGRAMA
	private void encerrarPrograma() {
		Saida.exibirRelatorio(new PessoaDao().getPopulacao());
		System.exit(0);
	}

}
