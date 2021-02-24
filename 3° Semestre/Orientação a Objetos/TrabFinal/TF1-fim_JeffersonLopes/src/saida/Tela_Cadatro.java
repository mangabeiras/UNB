package saida;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dados.Contaminada;
import dados.NaoContaminada;
import validacao.Validacao;
import dao.PessoaDao;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Tela_Cadatro extends JFrame {

	// COMPONENTES
	private JPanel painelCadastral;
	private JLabel textoErroNome, textoSituacao, textoIdade, textoErroIdade; // TEXTOS AUXILIARES
	private JButton botaoFinalizar;

	// COMPONENTES AUXILIARES DE ATRIBUTOS DE PESSOA
	private JRadioButton opcaoGeneroMasculino, opcaoContaminadoSim;
	private JTextField campoNome, campoIdade; // CAMPOS DE PREENCHIMENTO
	private JComboBox situacoes;

	// CONSTRUTOR
	public Tela_Cadatro() {
		configuraJanela();
		configuraPainel();
		configuraTextos();
		configuraBotoes();
		configuraCamposDePreenchimento();
		configuraOpcoesSituacao();
	}

	// JANELA CADASTRAL
	private void configuraJanela() {
		setTitle("CADASTRO DE PESSOA");
		setBounds(100, 100, 700, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// PAINEL CADASTRAL
	private void configuraPainel() {
		painelCadastral = new JPanel();
		painelCadastral.setBackground(Color.LIGHT_GRAY);
		setContentPane(painelCadastral);
		painelCadastral.setLayout(null);
		setLocationRelativeTo(null);
	}

	// CONFIGURACAO DOS TEXTOS
	private void configuraTextos() {
		textoContaminacao();
		textoErroNome();
		textoNome();
		textoGenero();
		textoSituacao();
		textoID();
		textoErroIdade();
		textoIdade();
	}

	// TEXTO DE CONTAMINACAO
	private void textoContaminacao() {
		JLabel textoContaminacao = new JLabel("A pessoa esta contaminada?");
		textoContaminacao.setFont(new Font("Arial", Font.PLAIN, 16));
		textoContaminacao.setBounds(20, 20, 240, 20);

		painelCadastral.add(textoContaminacao);
	}

	// TEXTO DE ERRO DO NOME
	private void textoErroNome() {
		textoErroNome = new JLabel();
		textoErroNome.setFont(new Font("Arial", Font.BOLD, 15));
		textoErroNome.setBounds(260, 100, 300, 20);

		painelCadastral.add(textoErroNome);
	}

	// TEXTO DE NOME
	private void textoNome() {
		JLabel textoNome = new JLabel("Nome:");
		textoNome.setFont(new Font("Arial", Font.PLAIN, 16));
		textoNome.setBounds(20, 100, 60, 20);

		painelCadastral.add(textoNome);
	}

	// TEXTO DE GENERO
	private void textoGenero() {
		JLabel textoGenero = new JLabel("Genero:");
		textoGenero.setFont(new Font("Arial", Font.PLAIN, 16));
		textoGenero.setBounds(20, 140, 60, 20);

		painelCadastral.add(textoGenero);
	}

	// TEXTO DE SITUACAO
	private void textoSituacao() {
		textoSituacao = new JLabel("Situacao:");
		textoSituacao.setFont(new Font("Arial", Font.PLAIN, 16));
		textoSituacao.setBounds(20, 180, 70, 20);

		painelCadastral.add(textoSituacao);
	}

	// TEXTO DE ID
	private void textoID() {
		JLabel textoID = new JLabel("ID:");
		textoID.setFont(new Font("Arial", Font.PLAIN, 16));
		textoID.setBounds(20, 220, 60, 20);

		painelCadastral.add(textoID);
	}

	// TEXTO DE ERRO DA IDADE
	private void textoErroIdade() {
		textoErroIdade = new JLabel();
		textoErroIdade.setFont(new Font("Arial", Font.BOLD, 15));
		textoErroIdade.setBounds(260, 180, 300, 20);
		textoErroIdade.setVisible(false);

		painelCadastral.add(textoErroIdade);
	}

	// TEXTO DE IDADE
	private void textoIdade() {
		textoIdade = new JLabel("Idade:");
		textoIdade.setFont(new Font("Arial", Font.PLAIN, 16));
		textoIdade.setBounds(20, 180, 50, 20);
		textoIdade.setVisible(false);

		painelCadastral.add(textoIdade);
	}

	// GERENCIA BOTOES
	private void configuraBotoes() {
		botoesContaminacao();
		botoesGenero();
		botaoFinalizar();
		botaoLimpar();
		botaoRetornoMenu();
	}

	// BOTOES DE OPCOES DE CONTAMINACAO
	private void botoesContaminacao() {
		ButtonGroup botoesSimOuNao = new ButtonGroup();

		botoesSimOuNao.add(opcaoContaminadoSim());
		botoesSimOuNao.add(opcaoContaminadoNao());
	}

	// OPCAO DE CONTAMINACAO 'SIM'
	private JRadioButton opcaoContaminadoSim() {
		opcaoContaminadoSim = new JRadioButton("Sim");
		opcaoContaminadoSim.setFont(new Font("Arial", Font.PLAIN, 16));
		opcaoContaminadoSim.setBounds(20, 50, 100, 30);
		opcaoContaminadoSim.setBackground(Color.LIGHT_GRAY);
		opcaoContaminadoSim.setSelected(true);

		painelCadastral.add(opcaoContaminadoSim);
		opcaoContaminadoSim.addActionListener(evento -> analisaOpcaoContaminadoSim());

		return opcaoContaminadoSim;
	}

	// ANALISA OS DADOS INSERIDOS DE CONTAMINACAO 'SIM'
	private void analisaOpcaoContaminadoSim() {
		botaoFinalizar.setEnabled(isCampoNomeValido(campoNome.getText()));

		textoIdade.setVisible(false);
		campoIdade.setVisible(false);
		textoErroIdade.setVisible(false);

		textoSituacao.setVisible(true);
		situacoes.setVisible(true);
	}

	// OPCAO DE CONTAMINACAO 'NAO'
	private JRadioButton opcaoContaminadoNao() {
		JRadioButton opcaoContaminadoNao = new JRadioButton("Nao");
		opcaoContaminadoNao.setFont(new Font("Arial", Font.PLAIN, 16));
		opcaoContaminadoNao.setBounds(160, 52, 100, 30);
		opcaoContaminadoNao.setBackground(Color.LIGHT_GRAY);

		painelCadastral.add(opcaoContaminadoNao);
		opcaoContaminadoNao.addActionListener(evento -> analisaOpcaoContaminadoNao());

		return opcaoContaminadoNao;
	}

	// ANALISA OS DADOS INSERIDOS DE CONTAMINACAO 'NAO'
	private void analisaOpcaoContaminadoNao() {
		botaoFinalizar.setEnabled(isCampoNomeValido(campoNome.getText()) && isCampoIdadeValido(campoIdade.getText()));

		textoSituacao.setVisible(false);
		situacoes.setVisible(false);

		textoIdade.setVisible(true);
		campoIdade.setVisible(true);
		textoErroIdade.setVisible(true);
	}

	// BOTOES DE OPCOES DE GENERO
	private void botoesGenero() {
		ButtonGroup botoesGenero = new ButtonGroup();

		botoesGenero.add(opcaoGeneroMasculino());
		botoesGenero.add(opcaoGeneroFeminino());
	}

	// OPCAO DE GENERO MASCULINO
	private JRadioButton opcaoGeneroMasculino() {
		opcaoGeneroMasculino = new JRadioButton("Masculino");
		opcaoGeneroMasculino.setFont(new Font("Arial", Font.PLAIN, 16));
		opcaoGeneroMasculino.setBounds(90, 135, 120, 30);
		opcaoGeneroMasculino.setBackground(Color.LIGHT_GRAY);
		opcaoGeneroMasculino.setSelected(true);

		painelCadastral.add(opcaoGeneroMasculino);
		return opcaoGeneroMasculino;
	}

	// OPCAO DE GENERO FEMININO
	private JRadioButton opcaoGeneroFeminino() {
		JRadioButton opcaoGeneroFeminino = new JRadioButton("Feminino");
		opcaoGeneroFeminino.setFont(new Font("Arial", Font.PLAIN, 16));
		opcaoGeneroFeminino.setBounds(230, 135, 100, 30);
		opcaoGeneroFeminino.setBackground(Color.LIGHT_GRAY);

		painelCadastral.add(opcaoGeneroFeminino);
		return opcaoGeneroFeminino;
	}

	// BOTAO DE FINALIZAR CADASTRO
	private void botaoFinalizar() {
		botaoFinalizar = new JButton("Finalizar Cadastro");
		botaoFinalizar.setFont(new Font("Arial", Font.PLAIN, 16));
		botaoFinalizar.setBounds(20, 300, 170, 30);
		botaoFinalizar.setEnabled(false);

		painelCadastral.add(botaoFinalizar);
		botaoFinalizar.addActionListener(evento -> analisaBotaoFinalizar());
	}

	// ANALISA OS DADOS CADASTRADOS
	private void analisaBotaoFinalizar() {
		cadastraNoBD();
		telaPrincipal();
	}

	// CADASTRAR PESSOA NO BANCO DE DADOS
	private void cadastraNoBD() {
		StringBuilder nome = new StringBuilder().append(this.campoNome.getText().trim());
		char genero;

		if (this.opcaoGeneroMasculino.isSelected())
			genero = getGeneroChar(this.opcaoGeneroMasculino.getText()); // 'M'
		else
			genero = getGeneroChar("Feminino"); // 'F'

		if (this.opcaoContaminadoSim.isSelected())
			cadastraPessoaContaminada(nome, genero);
		else
			cadastraPessoaNaoContaminada(nome, genero);

	}

	// OBTER O CARACTERE RESPECTIVO AO GENERO
	private char getGeneroChar(String genero) {
		if (genero.equals("Masculino")) {
			return 'M';
		} else { // FEMININO
			return 'F';
		}
	}

	// CADASTRA PESSOA CONTAMINADA
	private void cadastraPessoaContaminada(StringBuilder nome, char genero) {
		new PessoaDao().cadastrarPessoa(
				new Contaminada(nome, genero, getSituacaoChar(this.situacoes.getSelectedItem().toString())));
	}

	// OBTER O CARACTERE RESPECTIVO A SITUACAO DE SAUDE
	private char getSituacaoChar(String situacao) {
		if (situacao.equals("Em tratamento")) {
			return 'E';
		} else if (situacao.equals("Falecido")) {
			return 'F';
		} else { // CURADO
			return 'C';
		}
	}

	// CADASTRA PESSOA NAO CONTAMINADA
	private void cadastraPessoaNaoContaminada(StringBuilder nome, char genero) {
		new PessoaDao().cadastrarPessoa(new NaoContaminada(nome, genero, Integer.parseInt(this.campoIdade.getText())));
	}

	// MUDAR PARA TELA PRINCIPAL
	private void telaPrincipal() {
		new Tela_Principal().setVisible(true);
		setVisible(false);
	}

	// BOTAO DE LIMPAR DADOS
	private void botaoLimpar() {
		JButton botaoLimpar = new JButton("Limpar Dados");
		botaoLimpar.setFont(new Font("Arial", Font.PLAIN, 16));
		botaoLimpar.setBounds(230, 300, 170, 30);

		painelCadastral.add(botaoLimpar);
		botaoLimpar.addActionListener(evento -> analisaBotaoLimpar());
	}

	// LIMPA OS CAMPOS DE PREENCHIMENTO
	private void analisaBotaoLimpar() {
		campoNome.setText("");
		campoIdade.setText("");
	}

	// CANCELA CADASTRO E RETORNA AO MENU PRINCIPAL
	private void botaoRetornoMenu() {
		JButton botaoRetornoMenu = new JButton("Retornar ao menu");
		botaoRetornoMenu.setFont(new Font("Arial", Font.PLAIN, 16));
		botaoRetornoMenu.setBounds(440, 300, 170, 30);

		painelCadastral.add(botaoRetornoMenu);
		botaoRetornoMenu.addActionListener(evento -> analisaBotaoRetornoMenu());
	}

	// ANALISA BOTAO DE RETORNO AO MENU
	private void analisaBotaoRetornoMenu() {
		Saida.exibirMensagem("Cadastro cancelado com sucesso!", "Cadastro de pessoa");
		telaPrincipal();
	}

	// GERENCIA OS CAMPOS DE INSERCAO DE DADOS
	private void configuraCamposDePreenchimento() {
		campoPreenchimentoNome();
		campoPreenchimentoIdade();
		campoPreenchimentoID();
	}

	// CAMPO DE PREENCHIMENTO DO NOME
	private void campoPreenchimentoNome() {
		campoNome = new JTextField();
		campoNome.setFont(new Font("Arial", Font.PLAIN, 16));
		campoNome.setBounds(90, 100, 150, 20);
		campoNome.setColumns(10);

		painelCadastral.add(campoNome);
		campoNome.addCaretListener(evento -> analisaCampoNome());
	}

	// ANALISA CAMPO NOME
	private void analisaCampoNome() {
		if (opcaoContaminadoSim.isSelected())
			botaoFinalizar.setEnabled(isCampoNomeValido(campoNome.getText()));
		else
			botaoFinalizar
					.setEnabled(isCampoNomeValido(campoNome.getText()) && isCampoIdadeValido(campoIdade.getText()));
	}

	// CAMPO DE PREENCHIMENTO DA IDADE
	private void campoPreenchimentoIdade() {
		campoIdade = new JTextField();
		campoIdade.setFont(new Font("Arial", Font.PLAIN, 16));
		campoIdade.setBounds(90, 180, 150, 20);
		campoIdade.setColumns(10);
		campoIdade.setVisible(false);

		painelCadastral.add(campoIdade);
		campoIdade.addCaretListener(evento -> analisaCampoIdade());
	}

	// ANALISA CAMPO DA IDADE
	private void analisaCampoIdade() {
		botaoFinalizar.setEnabled(isCampoIdadeValido(campoIdade.getText()) && isCampoNomeValido(campoNome.getText()));
	}

	// CAMPO DE PREENCHIMENTO DO ID (ID PRE-DEFINIDO)
	private void campoPreenchimentoID() {
		JTextField idDesignado = new JTextField();
		idDesignado.setText(Integer.toString(getIDGerado()));
		idDesignado.setBounds(90, 220, 150, 26);
		idDesignado.setFont(new Font("Arial", Font.PLAIN, 16));
		idDesignado.setColumns(10);
		idDesignado.setEditable(false);

		painelCadastral.add(idDesignado);
	}

	// GERACAO DE UM NOVO ID
	private int getIDGerado() {
		final int MINIMO = 1;
		return new PessoaDao().getPopulacao().size() + MINIMO;
	}

	// OPCOES DE SITUACAO
	public void configuraOpcoesSituacao() {
		situacoes = new JComboBox();
		situacoes.setFont(new Font("Arial", Font.PLAIN, 16));
		situacoes.setBounds(90, 180, 150, 20);
		situacoes.setModel(new DefaultComboBoxModel(new String[] { "Em tratamento", "Falecido", "Curado" }));

		painelCadastral.add(situacoes);
	}

	// VALIDA O NOME INSERIDO E EXIBE UMA MENSAGEM CONFORME O STATUS DE VALIDACAO
	private boolean isCampoNomeValido(String nome) {
		textoErroNome.setForeground(Color.RED);

		if (!Validacao.isTamanhoValido(nome)) {
			textoErroNome.setText("O nome deve ter no minino 3 caracteres!");
			return false;
		} else if (!Validacao.isStringComNumeros(nome)) {
			textoErroNome.setText("Digitos no nome nao sao permitidos!");
			return false;
		} else {
			textoErroNome.setForeground(Color.DARK_GRAY);
			textoErroNome.setText("Nome valido!");
			return true;
		}
	}

	// VALIDA A IDADE INSERIDA E EXIBE UMA MENSAGEM CONFORME O STATUS DE VALIDACAO
	private boolean isCampoIdadeValido(String idade) {
		textoErroIdade.setForeground(Color.RED);

		if (!Validacao.validaInt(idade)) {
			textoErroIdade.setText("Apenas numeros sao permitidos!");
			return false;
		} else if (!Validacao.validaIdade(idade)) {
			textoErroIdade.setText("A idade nao pode ser maior que 130.");
			return false;
		} else {
			textoErroIdade.setForeground(Color.DARK_GRAY);
			textoErroIdade.setText("Idade valida!");
			return true;
		}
	}

}