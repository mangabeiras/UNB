package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import conexao.PessoaDao;
import dados.Homem;
import dados.Mulher;
import dados.Pessoa;
import validacao.Validacao;

// MOSTRA PESSOA POR ID
public class Mostra extends JFrame {
	private JButton mostra;
	private JLabel erroCodigo;
	private JTextField codigo;

	Mostra() {
		initComponents();
	}

	private void menuPrincipal() {
		TelaPrincipal principal = new TelaPrincipal();
		principal.setVisible(true);
		setVisible(false);
	}

	private void configuraFrame() {
		setTitle("Mostra");
		setResizable(false);
		setMinimumSize(new Dimension(500, 200));
		setMaximumSize(new Dimension(500, 200));
		setAlwaysOnTop(false);
		setLocationRelativeTo(null);
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// CRIA TEXTO NA JANELA
	private void criaLabel(String nome, int eixoY) {
		getContentPane().setLayout(null);
		JLabel nova = new JLabel(nome);
		nova.setFont(new Font("Arial", Font.PLAIN, 14));
		nova.setForeground(Color.BLACK);
		nova.setBounds(58, 43, 190, 15);
		getContentPane().add(nova);
	}

	// CRIA JANELA PARA INSERIR CODIGO
	private void criaTextCodigo() {
		criaLabel("Insira o codigo da pessoa", 50);
		codigo = new JTextField();
		codigo.setToolTipText("Digite o Codigo");
		codigo.setForeground(Color.BLACK);
		codigo.setFont(new Font("Arial", Font.BOLD, 14));
		codigo.setBounds(127, 76, 233, 20);

		erroCodigo = new JLabel();
		getContentPane().add(codigo);
		codigo.setColumns(10);
		getContentPane().add(erroCodigo);

		codigo.addCaretListener(evt -> validaCodigo(codigo.getText()));
	}

	// VERIFICA SE O CODIGO INSERIDO E VALIDO
	private void validaCodigo(String codigo) {
		erroCodigo.setText("");
		erroCodigo.setFont(new Font("Arial", Font.BOLD, 12));
		erroCodigo.setBounds(137, 96, 140, 20);

		if (!Validacao.validaInt(codigo)) {
			erroCodigo.setText("Insira apenas Numeros!");
			erroCodigo.setForeground(Color.RED);
			mostra.setEnabled(false);
		} else {
			erroCodigo.setText("Valor valido");
			erroCodigo.setForeground(Color.BLUE);
			mostra.setEnabled(true);
		}
	}

	private void criaBotaoMostra() {
		mostra = new JButton("Mostra");
		mostra.setBounds(254, 127, 89, 23);
		getContentPane().add(mostra);

		mostra.addActionListener(evt -> mostraPessoa());
	}

	// CRIA BOTAO VOLTAR
	private void criaBotaoVoltar() {
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(147, 127, 89, 23);
		getContentPane().add(voltar);

		voltar.addActionListener(evt -> menuPrincipal());
	}

	// ACAO QUE MOSTRA A PESSOA
	private void mostraPessoa() {
		PessoaDao dao = new PessoaDao();
		int codigo = Integer.parseInt(this.codigo.getText());
		Pessoa mostra = dao.getPessoaId(codigo);

		if (mostra != null && mostra.toString().split(" ")[0].equals("--"))
			JOptionPane.showMessageDialog(null, "Nome: " + mostra.getNome() + "\nSaude: " + mostra.getSituacaoExtenso()
					+ "\nIdade: " + ((Homem) mostra).getIdade(), "Mostra", JOptionPane.PLAIN_MESSAGE);
		
		else if (mostra != null)
			JOptionPane.showMessageDialog(null, "Nome: " + mostra.getNome() + "\nSaude: " + mostra.getSituacaoExtenso()
					+ "\nGestacao: " + ((Mulher)mostra).getSituacaoGExtenso(), "Mostra", JOptionPane.PLAIN_MESSAGE);
		
		else
			JOptionPane.showMessageDialog(null, "Nao existe pessoa cadastrada com o codigo " + codigo, "Mostra",
					JOptionPane.PLAIN_MESSAGE);

		menuPrincipal();
	}

	// INICIA OS COMPONENTS
	private void initComponents() {
		configuraFrame();

		criaTextCodigo();

		criaBotaoMostra();

		criaBotaoVoltar();
	}
}
