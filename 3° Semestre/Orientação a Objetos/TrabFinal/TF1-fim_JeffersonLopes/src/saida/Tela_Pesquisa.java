package saida;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.PessoaDao;
import validacao.Validacao;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Tela_Pesquisa extends JFrame {

	private JPanel painelPesquisa;
	private JTextField campoNome;
	private JLabel textoErroNome;
	private JButton botaoPesquisar;

	// CONSTRUTOR
	public Tela_Pesquisa() {
		configuraJanela();
		configuraPainel();
		configuraTextos();
		campoPreenchimentoNome();
		configuraBotoes();
	}

	// JANELA PESQUISA
	private void configuraJanela() {
		setTitle("MENU PESQUISA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 250);
	}

	// PAINEL PESQUISA
	private void configuraPainel() {
		painelPesquisa = new JPanel();
		painelPesquisa.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPesquisa);

		painelPesquisa.setLayout(null);
		setLocationRelativeTo(null);
	}

	// TODOS OS TEXTOS
	private void configuraTextos() {
		textoSolicitaNome();
		textoNome();
		textoErroNome();
	}

	// TEXTO DE SOLICITACAO
	private void textoSolicitaNome() {
		JLabel textoSolicitaNome = new JLabel("Informe o nome da pessoa que queira consultar:");
		textoSolicitaNome.setFont(new Font("Arial", Font.PLAIN, 16));
		textoSolicitaNome.setBounds(30, 30, 340, 20);

		painelPesquisa.add(textoSolicitaNome);
	}

	// TEXTO DE NOME
	private void textoNome() {
		JLabel textoNome = new JLabel("Nome:");
		textoNome.setFont(new Font("Arial", Font.PLAIN, 16));
		textoNome.setBounds(30, 70, 50, 20);

		painelPesquisa.add(textoNome);
	}

	// TEXTO DE ERRO DO NOME
	private void textoErroNome() {
		textoErroNome = new JLabel();
		textoErroNome.setFont(new Font("Arial", Font.BOLD, 15));
		textoErroNome.setBounds(280, 70, 300, 20);

		painelPesquisa.add(textoErroNome);
	}

	// CAMPO DE PREENCHIMENTO DO NOME PARA PESQUISA
	private void campoPreenchimentoNome() {
		campoNome = new JTextField();
		campoNome.setFont(new Font("Arial", Font.PLAIN, 16));
		campoNome.setBounds(90, 70, 150, 25);
		campoNome.setColumns(10);

		painelPesquisa.add(campoNome);
		if (campoNome.getText() != "")
			campoNome.addCaretListener(evento -> analisaCampoNome());
	}

	// ANALISA O NOME NO CAMPO DE PREENCHIMENTO
	private void analisaCampoNome() {
		botaoPesquisar.setEnabled(isCampoNomeValido(campoNome.getText().trim()));
	}

	// VALIDA O NOME INSERIDO E EXIBE UMA MENSAGEM CONFORME O STATUS DE VALIDACAO
	private boolean isCampoNomeValido(String nome) {
		textoErroNome.setForeground(Color.RED);

		if (!Validacao.isStringComNumeros(nome) || nome.isEmpty()) {
			textoErroNome.setText("Digitos no nome nao sao permitidos!");
			return false;
		} else {
			textoErroNome.setForeground(Color.DARK_GRAY);
			textoErroNome.setText("Nome valido!");
			return true;
		}
	}

	// CONFIGURA TODOS OS BOTOES
	private void configuraBotoes() {
		botaoPesquisar();
		botaoRetornoMenu();
	}

	// BOTAO PESQUISAR
	private void botaoPesquisar() {
		botaoPesquisar = new JButton("Pesquisar");
		botaoPesquisar.setFont(new Font("Arial", Font.PLAIN, 16));
		botaoPesquisar.setBounds(30, 110, 130, 30);
		botaoPesquisar.setEnabled(false);

		painelPesquisa.add(botaoPesquisar);
		botaoPesquisar.addActionListener(evento -> acaoPesquisar());
	}

	// ACAO DE PESQUISAR, EXIBE A LISTA
	private void acaoPesquisar() {
		new Tela_Lista(new PessoaDao().pesquisaPorNome(campoNome.getText().trim()), 'P').setVisible(true);
		setVisible(false);
	}

	// RETORNA AO MENU PRINCIPAL
	private void botaoRetornoMenu() {
		JButton botaoRetornoMenu = new JButton("Retornar ao menu");
		botaoRetornoMenu.setFont(new Font("Arial", Font.PLAIN, 16));
		botaoRetornoMenu.setBounds(200, 110, 170, 30);

		painelPesquisa.add(botaoRetornoMenu);
		botaoRetornoMenu.addActionListener(evento -> telaPrincipal());
	}

	// MUDAR PARA TELA PRINCIPAL
	private void telaPrincipal() {
		new Tela_Principal().setVisible(true);
		setVisible(false);
	}

}