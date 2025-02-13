package visao;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import conexao.PessoaDao;
import dados.Grupo;
import dados.Mulher;
import validacao.Validacao;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

// TELA DE CADASTRO DE MULHER
public class CadastroMulher extends JFrame {
	// COMPONENTES
	private JPanel painelPrincipal;
	private JTextField nome;
	private JComboBox situacao, gestacao;
	private JLabel erroNome;
	private JButton salvar;
	
	CadastroMulher() {
		initComponents();
	}
	
	private void configuraFrame() {
		setTitle("Cadastro Mulher");
		setResizable(false);
		setMinimumSize(new Dimension(450, 480));
		setMaximumSize(new Dimension(450, 480));
		setAlwaysOnTop(false);
		setLocationRelativeTo(null);
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	// VOLTA AO MENU PRINCIPAL
	private void menuPrincipal() {
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		telaPrincipal.setVisible(true);
		setVisible(false);
	}
	
	private void limpaCampos() {
		nome.setText("");
		situacao.setSelectedIndex(0);
		gestacao.setSelectedIndex(0);
		erroNome.setText("");
	}

	private void criaPanel() {
		painelPrincipal = new JPanel();
		getContentPane().add(painelPrincipal, BorderLayout.CENTER);
		painelPrincipal.setLayout(null);
	}
	
	// CRIA O CABECALHO DA JANELA
	private void criaCabecalho() {
		JLabel cabecalho = new JLabel("Cadastro de Mulher");
		cabecalho.setHorizontalAlignment(SwingConstants.CENTER);
		cabecalho.setFont(new Font("Arial", Font.PLAIN, 16));
		cabecalho.setForeground(Color.BLACK);
		cabecalho.setBounds(111, 41, 241, 33);
		painelPrincipal.add(cabecalho);
	}
	
	private void criaLabel(String nome, int eixoY) {
		JLabel nova = new JLabel(nome);
		nova.setFont(new Font("Arial", Font.PLAIN, 14));
		nova.setForeground(Color.BLACK);
		nova.setBounds(28, eixoY, 109, 14);
		painelPrincipal.add(nova);
	}
	
	// CRIA TEXTO E ESPACO PARA NOME
	private void criaCadastroNome() {
		criaLabel("Nome", 134);
		nome = new JTextField();
		nome.setToolTipText("Digite o Nome");
		nome.setForeground(Color.BLACK);
		nome.setFont(new Font("Arial", Font.BOLD, 14));
		nome.setBounds(150, 131, 233, 20);
		erroNome = new JLabel();
		painelPrincipal.add(nome);
		nome.setColumns(10);
		painelPrincipal.add(erroNome);
		
		nome.addCaretListener(evt -> verificaNome());
	}
	
	private void criaCadastroSituacao(){
		criaLabel("Situacao", 209);
		situacao = new JComboBox();
		situacao.setFont(new Font("Arial", Font.BOLD, 12));
		situacao.setToolTipText("Marque a Situacao da Pessoa");
		situacao.setModel(new DefaultComboBoxModel(new String[] {""}));
		situacao.setBounds(150, 206, 233, 22);
		situacao.addItem("Nao Contaminada");
		situacao.addItem("Contaminada Curada");
		situacao.addItem("Contaminada em Tratamento");
		situacao.addItem("Contaminada Falecida");
		painelPrincipal.add(situacao);
		
		situacao.addActionListener(evt -> isCanSave());
	}
	
	private void criaCadastroSituacaoGestacao() {
		criaLabel("Ja foi Gestante?", 290);
		gestacao = new JComboBox();
		gestacao.setToolTipText("Marque uma Opcao");
		gestacao.setFont(new Font("Arial", Font.BOLD, 12));
		gestacao.setModel(new DefaultComboBoxModel(new String[] {""}));
		gestacao.setBounds(150, 287, 233, 22);
		gestacao.addItem("Sim");
		gestacao.addItem("Nao");
		gestacao.addItem("Nao tem Certeza");
		painelPrincipal.add(gestacao);
		
		gestacao.addActionListener(evt -> isCanSave());
	}
	
	private void criaBotaoSalvar() {
		salvar = new JButton("Salvar");
		salvar.setToolTipText("Salvar os Dados");
		salvar.setFont(new Font("Arial", Font.PLAIN, 14));
		salvar.setBounds(28, 370, 89, 23);
		painelPrincipal.add(salvar);
		salvar.setEnabled(false);
		
		salvar.addActionListener(evt -> realizaCadastro());
	}
	
	private void criaBotaoLimpar() {
		JButton limpar = new JButton("Limpar");
		limpar.setToolTipText("Limpar os Campos");
		limpar.setFont(new Font("Arial", Font.PLAIN, 14));
		limpar.setBounds(170, 370, 89, 23);
		painelPrincipal.add(limpar);
		limpar.addActionListener(evt -> limpaCampos());
	}
	
	private void criaBotaoCancelar() {
		JButton cancelar = new JButton("Cancelar");
		cancelar.setToolTipText("Cancelar Cadastro");
		cancelar.setFont(new Font("Arial", Font.PLAIN, 14));
		cancelar.setBounds(294, 371, 102, 23);
		painelPrincipal.add(cancelar);
		cancelar.addActionListener(evt -> menuPrincipal());
	}
	
	private void verificaNome() {
		hasErroNome(nome.getText());
		isCanSave();
	}
	
	// DEFINE SE O BOTAO SALVAR ESTA LIBERADO
	private void isCanSave() {
		salvar.setEnabled(!hasErroNome(nome.getText()) && validaSituacao() && validaGestacao());
	}
	
	// REALIZA O CADASTRO
	private void realizaCadastro() {
		char situacao = Validacao.validaSituacao((String) this.situacao.getSelectedItem());
		char situacaoGestacao = Validacao.validaGestacao((String) this.gestacao.getSelectedItem());
		
		PessoaDao pessoa = new PessoaDao();
		pessoa.cadastrar(new Mulher(0, nome.getText(), situacao, situacaoGestacao));
		menuPrincipal();
	}
	
	// VERIFICA SE A SITUACAO INSERIDA E VALIDA
	private boolean validaGestacao() {
		return Validacao.validaGestacao((String) this.gestacao.getSelectedItem()) != 0;
	}

	
	// VERIFICA SE A SITUACAO INSERIDA E VALIDA
	private boolean validaSituacao() {
		return Validacao.validaSituacao((String) this.situacao.getSelectedItem()) != 0;
	}
	
	// VERIFICA SE O NOME INSERIDO E VALIDO
	private boolean hasErroNome(String nome) {
		erroNome.setText("");
		erroNome.setFont(new Font("Arial", Font.BOLD, 12));
		erroNome.setBounds(150, 155, 250, 20);
		erroNome.setForeground(Color.RED);	
		
		if (!Validacao.validaLength(nome))
			erroNome.setText("Minimo de 3 caracteres");
		else if (!Validacao.isAlfabetico(nome))
			erroNome.setText("Nao pode conter Numeros");
		else if (!Validacao.validaCompleto(nome))
			erroNome.setText("Nome precisa ser Completo");
		else {
			erroNome.setText("Nome Valido!");
			erroNome.setForeground(Color.BLUE);
			return false;
		}
		return true;
	}
	
	// INICIA OS COMPONENTES
	private void initComponents() {
		configuraFrame();
		
		criaPanel();
		
		criaCabecalho();
		
		criaCadastroNome();
		
		criaCadastroSituacao();
		
		criaCadastroSituacaoGestacao();
		
		criaBotaoSalvar();
		
		criaBotaoLimpar();
		
		criaBotaoCancelar();
	}
}
