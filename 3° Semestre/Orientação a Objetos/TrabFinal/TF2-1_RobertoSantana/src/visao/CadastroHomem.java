package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import validacao.Validacao;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import dados.Grupo;
import dados.Homem;

// TELA DE CADASTRO DE HOMEM
public class CadastroHomem extends JFrame {
	private TelaPrincipal telaPrincipal;
	private JPanel painelPrincipal;
	private JTextField nome, idade;
	private JComboBox situacao;
	private JLabel erroNome, erroIdade;
	private JButton salvar, cancelar, limpar;

	// CONSTRUTOR
	CadastroHomem(Grupo grupo) {
		initComponents(grupo);
	}
	
	// CARACTERISTICAS DO FRAME
	private void configuraFrame() {
		setTitle("Cadastro Homem");
		setResizable(false);
		setMinimumSize(new Dimension(500, 500));
		setMaximumSize(new Dimension(500, 500));
		setAlwaysOnTop(false);
		setLocationRelativeTo(null);
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// CRIA PAINAEL PRINCIPAL
	private void criaPanel() {
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(Color.LIGHT_GRAY);
		painelPrincipal.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(painelPrincipal, BorderLayout.CENTER);
		painelPrincipal.setLayout(null);
	}
	
	// CRIA CABECALHO DA PAGINA
	private void criaCabecalho() {
		JLabel cabecalho = new JLabel("Cadastro de Homem");
		cabecalho.setHorizontalAlignment(SwingConstants.CENTER);
		cabecalho.setFont(new Font("Arial", Font.PLAIN, 16));
		cabecalho.setForeground(Color.BLACK);
		cabecalho.setBounds(111, 41, 241, 33);
		painelPrincipal.add(cabecalho);
	}
	
	// CRIA CADASTRO NOME
	private void criaNome() {
		criaLabel("Nome", 134);
		nome = new JTextField();
		nome.setToolTipText("Digite o nome");
		nome.setForeground(Color.BLACK);
		nome.setFont(new Font("Arial", Font.BOLD, 14));
		nome.setBounds(150, 131, 233, 20);
		painelPrincipal.add(nome);
		nome.setColumns(10);
		erroNome = new JLabel();
		painelPrincipal.add(erroNome);
	}
	
	// CRIA CADASTRO SITUACAO
	private void criaSituacao() {
		criaLabel("Situacao", 209);
		situacao = new JComboBox();
		situacao.setFont(new Font("Arial", Font.BOLD, 12));
		situacao.setToolTipText("Marque a Situacao da Pessoa");
		situacao.setModel(new DefaultComboBoxModel(new String[] { "" }));
		situacao.setBounds(150, 206, 233, 22);
		situacao.addItem("Nao Contaminado");
		situacao.addItem("Contaminado Curado");
		situacao.addItem("Contaminado em Tratamento");
		situacao.addItem("Contaminado Falecido");
		painelPrincipal.add(situacao);
	}
	
	// CRIA CADASTRO IDADE
	private void criaIdade() {
		criaLabel("Idade", 286);
		idade = new JTextField();
		idade.setToolTipText("Digite a idade");
		idade.setFont(new Font("Arial", Font.BOLD, 14));
		idade.setBounds(150, 284, 86, 20);
		painelPrincipal.add(idade);
		idade.setColumns(10);
		erroIdade = new JLabel();
		painelPrincipal.add(erroIdade);
	}
	
	// CRIA SALVAR
	private void criaSalvar() {
		salvar = new JButton("Salvar");
		salvar.setToolTipText("Salvar Dados");
		salvar.setFont(new Font("Arial", Font.PLAIN, 14));
		salvar.setBounds(28, 370, 89, 23);
		salvar.setEnabled(false);
		painelPrincipal.add(salvar);
	}
	
	// CRIA LIMPAR
	private void criaLimpar() {
		limpar = new JButton("Limpar");
		limpar.setToolTipText("Limpar Campos");
		limpar.setFont(new Font("Arial", Font.PLAIN, 14));
		limpar.setBounds(170, 370, 89, 23);
		painelPrincipal.add(limpar);
	}
	
	// CRIA CANCELAR
	private void criaCancelar() {
		cancelar = new JButton("Cancelar");
		cancelar.setToolTipText("Cancelar Cadastro");
		cancelar.setFont(new Font("Arial", Font.PLAIN, 14));
		cancelar.setBounds(294, 371, 101, 23);
		painelPrincipal.add(cancelar);
	}
	
	// VAI AO MENU PRINCIPAL
	private void menuPrincipal(Grupo grupo) {
		telaPrincipal = new TelaPrincipal(grupo);
		telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaPrincipal.setVisible(true);
		setVisible(false);
	}

	// LIMPA OS DADOS INSERIDOS
	private void limpaCampos() {
		nome.setText("");
		situacao.setSelectedIndex(0);
		idade.setText("");
		erroNome.setText("");
		erroIdade.setText("");
	}
	
	// LISTENERS
	private void addEscutadores(Grupo grupo) {
		nome.addCaretListener(evt -> verificaNome());
		situacao.addActionListener(evt -> isCanSave());
		idade.addCaretListener(evt -> verificaIdade());
		salvar.addActionListener(evt -> realizaCadastro(grupo));
		limpar.addActionListener(evt -> limpaCampos());
		cancelar.addActionListener(evt -> menuPrincipal(grupo));
	}

	// CRIA TEXTO NA PANE
	private void criaLabel(String nome, int eixoY) {
		JLabel nova = new JLabel(nome);
		nova.setFont(new Font("Arial", Font.PLAIN, 14));
		nova.setForeground(Color.BLACK);
		nova.setBounds(28, eixoY, 70, 14);
		painelPrincipal.add(nova);
	}
	
	// VERIFICA SE NOME TEM ERRO
	private void verificaNome() {
		hasErroNome(nome.getText());
		isCanSave();
	}
	
	// VERIFICA SE IDADE TEM ERRO 
	private void verificaIdade() {
		hasErroIdade(idade.getText());
		isCanSave();
	}
	
	// ESTA APTO A SALVAR?
	private void isCanSave() {
		salvar.setEnabled(!hasErroNome(nome.getText()) && !hasErroIdade(idade.getText()) && validaSituacao());
	}
	
	// REALIZA O CADASTRO
	private void realizaCadastro(Grupo grupo) {
		char situacao = Validacao.validaSituacao((String) this.situacao.getSelectedItem());
		int idade = Integer.parseInt(this.idade.getText());
		StringBuilder nome = new StringBuilder().append(this.nome.getText());

		grupo.addPessoa(new Homem(nome, situacao, idade, Validacao.validaCodigo(grupo)));
		menuPrincipal(grupo);
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

		if (!Validacao.validaLength(nome)) {
			erroNome.setText("Minimo de 3 caracteres");
			return true;
		}

		else if (!Validacao.isAlfabetico(nome)) {
			erroNome.setText("Nao pode conter Numeros");
			return true;
		}

		else if (!Validacao.validaCompleto(nome)) {
			erroNome.setText("Nome precisa ser Completo");
			return true;
		} else {
			erroNome.setText("Nome Valido!");
			erroNome.setForeground(Color.BLUE);
			return false;
		}
	}

	// VERIFICA SE A IDADE INSERIDA E VALIDA
	private boolean hasErroIdade(String idade) {
		erroIdade.setText("");
		erroIdade.setFont(new Font("Arial", Font.BOLD, 12));
		erroIdade.setBounds(150, 307, 250, 14);
		erroIdade.setForeground(Color.RED);

		if (!Validacao.validaInt(idade)) {
			erroIdade.setText("Deve conter apenas numeros");
			return true;
		} else if (!Validacao.validaIdade(idade)) {
			erroIdade.setText("Nao pode ser maior que 150");
			return true;
		} else {
			erroIdade.setText("Idade Valida!");
			erroIdade.setForeground(Color.BLUE);
			return false;
		}
	}
	

	// INICIA OS COMPONENTES
	private void initComponents(Grupo grupo) {
		configuraFrame();
		
		criaPanel();
		
		criaCabecalho();
		
		criaNome();
		
		criaSituacao();
		
		criaIdade();
		
		criaSalvar();
		
		criaLimpar();
		
		criaCancelar();
		
		addEscutadores(grupo);		
	}
}
