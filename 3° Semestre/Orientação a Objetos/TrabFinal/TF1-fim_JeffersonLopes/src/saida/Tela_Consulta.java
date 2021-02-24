package saida;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.Pessoa;
import dao.PessoaDao;
import validacao.Validacao;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Tela_Consulta extends JFrame {

	// COMPONENTES
	private JPanel painelConsulta;
	private JTextField campoID;
	private JLabel textoErroID;
	private JButton botaoConsultar;

	// CONSTRUTOR
	public Tela_Consulta() {
		configuraJanela();
		configuraPainel();
		configuraTextos();
		campoPreenchimentoID();
		configuraBotoes();
	}

	// JANELA CONSULTA
	private void configuraJanela() {
		setTitle("MENU CONSULTA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
	}

	// PAINEL PRINCIPAL
	private void configuraPainel() {
		painelConsulta = new JPanel();
		painelConsulta.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelConsulta);

		painelConsulta.setLayout(null);
		setLocationRelativeTo(null);
	}

	// TODOS OS TEXTOS
	private void configuraTextos() {
		textoSolicitacao();
		textoID();
		textoErroID();
	}

	// TEXTO DE SOLICITACAO
	private void textoSolicitacao() {
		JLabel textoSolicitacao = new JLabel("Informe o numero identificador da pessoa para consulta-la:");
		textoSolicitacao.setFont(new Font("Arial", Font.PLAIN, 15));
		textoSolicitacao.setBounds(30, 30, 400, 25);

		painelConsulta.add(textoSolicitacao);
	}

	// TEXTO DE ID
	private void textoID() {
		JLabel textoID = new JLabel("ID:");
		textoID.setFont(new Font("Arial", Font.PLAIN, 15));
		textoID.setBounds(30, 70, 25, 25);

		painelConsulta.add(textoID);
	}

	// TEXTO DE ID INVALIDO
	private void textoErroID() {
		textoErroID = new JLabel();
		textoErroID.setFont(new Font("Arial", Font.BOLD, 15));
		textoErroID.setBounds(175, 70, 300, 25);

		painelConsulta.add(textoErroID);
	}

	// CAMPO DE PREENCHIMENTO DO ID PARA CONSULTA
	private void campoPreenchimentoID() {
		campoID = new JTextField();
		campoID.setFont(new Font("Arial", Font.PLAIN, 15));
		campoID.setBounds(60, 70, 100, 25);
		campoID.setColumns(10);

		painelConsulta.add(campoID);
		campoID.addCaretListener(evento -> analisaCampoID());
	}

	// ANALISA O ID NO CAMPO DE PREENCHIMENTO
	private void analisaCampoID() {
		botaoConsultar.setEnabled(isCampoIDValido(campoID.getText()));
	}

	// VALIDA O ID INSERIDO E EXIBE UMA MENSAGEM CONFORME O STATUS DE VALIDACAO
	private boolean isCampoIDValido(String id) {
		if (!Validacao.validaInt(id)) {
			textoErroID.setForeground(Color.RED);
			textoErroID.setText("Apenas numeros positivos sao permitidos!");
			return false;
		} else {
			textoErroID.setForeground(Color.DARK_GRAY);
			textoErroID.setText("ID valido!");
			return true;
		}
	}

	// CONFIGURA TODOS OS BOTOES
	private void configuraBotoes() {
		botaoConsultar();
		botaoRetornoMenu();
	}

	// BOTAO CONSULTAR
	private void botaoConsultar() {
		botaoConsultar = new JButton("Realizar consulta");
		botaoConsultar.setFont(new Font("Arial", Font.PLAIN, 15));
		botaoConsultar.setEnabled(false);
		botaoConsultar.setBounds(30, 120, 170, 30);

		painelConsulta.add(botaoConsultar);
		botaoConsultar.addActionListener(evento -> exibirConsulta());
	}

	// EXIBE OS DADOS DA PESSOA CONSULTADA
	private void exibirConsulta() {
		Pessoa pessoaConsultada = new PessoaDao().consultaPorID(campoID.getText());

		if (pessoaConsultada != null && pessoaConsultada.getIdade() == null)
			Saida.exibirMensagem("Identificador: " + pessoaConsultada.getIdentificador() + "\nNome completo: "
					+ pessoaConsultada.getNome().toString().toUpperCase() + "\nGenero: "
					+ pessoaConsultada.getGeneroPorExtenso() + "\nSituacao de saude: "
					+ pessoaConsultada.getSituacaoPorExtenso(), "CONSULTA");
		else if (pessoaConsultada != null)
			Saida.exibirMensagem(
					"Identificador: " + pessoaConsultada.getIdentificador() + "\nNome completo: "
							+ pessoaConsultada.getNome().toString().toUpperCase() + "\nGenero: "
							+ pessoaConsultada.getGeneroPorExtenso() + "\nIdade: " + pessoaConsultada.getIdade(),
					"CONSULTA");
		else
			Saida.exibirMensagem("Nao ha pessoa cadastrada com o numero identificador " + campoID.getText() + ".",
					"CONSULTA");
	}

	// RETORNA AO MENU PRINCIPAL
	private void botaoRetornoMenu() {
		JButton botaoRetornoMenu = new JButton("Retornar ao menu");
		botaoRetornoMenu.setFont(new Font("Arial", Font.PLAIN, 16));
		botaoRetornoMenu.setBounds(240, 120, 170, 30);

		painelConsulta.add(botaoRetornoMenu);
		botaoRetornoMenu.addActionListener(evento -> telaPrincipal());
	}

	// MUDAR PARA TELA PRINCIPAL
	private void telaPrincipal() {
		new Tela_Principal().setVisible(true);
		setVisible(false);
	}

}
