package validacao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;

import dados.Empresa;
import dados.Funcionario;
import saida.Visao;

public class Validacao {
	public static int validaOpcao(int codigo) {
		String escolha;
		
		try {
			escolha = (String) JOptionPane.showInputDialog(null, "Escolha um item", "Menu", JOptionPane.INFORMATION_MESSAGE, null, Visao.menu(codigo), Visao.menu(codigo)[0]);
			for (int contador = 0; contador < Visao.menu(codigo).length - 1; contador++) {
				if (escolha.equals(Visao.menu(codigo)[contador]))
					return (contador + 1);
			}
		} catch(NullPointerException e) {
			return 0;
		}
		return 0;
	}
	public static String validaNome() {
		String valor = null;
		
		try {
			valor = JOptionPane.showInputDialog(null, "Nome Completo", "Inserção de Dados", JOptionPane.INFORMATION_MESSAGE);;
			if (valor.length() < 3 || valor.split(" ").length <= 1) {
				Visao.mostraMensagemErro("Insira nome COMPLETO com no mínimo 3 caracteres");
				return validaNome();
			}
		} catch(NullPointerException e) {
			Visao.mostraMensagemErro("Insira algum dado!");
			return validaNome();
		}		
		return valor;
	}

	public static int validaInt(String msg, final int MIN, final int MAX) {
		int valor = 0;
		
		try{
			valor = Integer.parseInt(JOptionPane.showInputDialog(null, msg, "Inserção de Dados", JOptionPane.INFORMATION_MESSAGE));
			if (valor < MIN || valor > MAX) {
				Visao.mostraMensagemErro("A entrada deve ser um numero entre " + MIN + " e " + MAX);
				return validaInt(msg, MIN, MAX);
			}
		} catch(Exception e) {
			Visao.mostraMensagemErro("Entrada incoerente! Digite um numero");
			return validaInt(msg, MIN, MAX);
		}		
		return valor;
	}
	
	public static float validaFloat(String msg, final float MIN, final float MAX) {
		float valor = 0;
		DecimalFormat df = new DecimalFormat("#,##0.00");
		
		try {
			valor = Float.parseFloat((JOptionPane.showInputDialog(null, msg, "Inserção de Dados", JOptionPane.INFORMATION_MESSAGE)));
			if (valor < MIN || valor > MAX) {
				Visao.mostraMensagemErro(
						"A entrada deve ser um numero entre " + df.format(MIN) + " e " + df.format(MAX));
				return validaFloat(msg, MIN, MAX);
			}
		} catch (InputMismatchException e) {
			Visao.mostraMensagemErro("A entrada deve ser um numero");
			return validaFloat(msg, MIN, MAX);
		}	
		return valor;
	}

	public static String validaDataNascimento() {
		int dia = validaInt("Digite o dia do nascimento", 1, 31);
		int mes = validaInt("Digite o mes do nascimento", 1, 12);
		int ano = validaInt("Digite o ano do nascimneto", 1900, 2020);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		sdf.setLenient(false);
		try {
			sdf.parse(dia + "/" + mes + "/" + ano);
		} catch (Exception e) {
			Visao.mostraMensagemErro("Data invalida!");
			return validaDataNascimento();
		}

		return dia + "/" + mes + "/" + ano;
	}

	public static String validaCpf(Empresa empresa) {
		String cpf = null;
		
		try {
			cpf = JOptionPane.showInputDialog(null, "CPF", "Inserção de Dados", JOptionPane.INFORMATION_MESSAGE);;
			if(cpf.length() != 11) {
				Visao.mostraMensagemErro("O CPF deve conter 11 digitos");
				return validaCpf(empresa);
			}
		} catch(NullPointerException e) {
			Visao.mostraMensagemErro("Insira algum dado!");
			return validaNome();
		}
		
		return isFuncionarioCadastrado(cpf, empresa);
	}
	public static String isFuncionarioCadastrado(String cpf, Empresa empresa) {
		for (Funcionario funcionario : empresa.getFuncionarios()) {
			if (funcionario.getCpf().equals(cpf)) {
				Visao.mostraMensagemErro("Funcionario já cadastrado!");
				return validaCpf(empresa);
			}
		}
		return cpf;
	}
}

