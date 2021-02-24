package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import dados.Contaminada;
import dados.NaoContaminada;
import dados.Pessoa;
import dados.Populacao;
import saida.Saida;

public class PessoaDao {

	// CADASTRAR PESSOA
	public void cadastrarPessoa(Pessoa pessoa) {
		Connection con = Conexao.getConnection();
		String cadastroSQL = "INSERT INTO PESSOA (nome, genero, saude, idade) VALUES (?,?,?,?);";

		try {
			PreparedStatement preparador = con.prepareStatement(cadastroSQL);

			preparador.setString(1, pessoa.getNome().toString());
			preparador.setString(2, pessoa.getGenero().toString());
			preparador.setString(3, pessoa.getSituacao());
			preparador.setString(4, pessoa.getIdade());

			preparador.execute();
			preparador.close();

			Saida.exibirMensagem("Cadastro realizado com sucesso!", "Cadastro de pessoa");
		} catch (SQLException e) {
			System.out.println("Erro recebido:\n" + e.getStackTrace());
		} finally {
			Conexao.encerrarConexao(con);
		}
	}

	// PEGAR PESSOAS CADASTRADAS
	public ArrayList<Pessoa> getPopulacao() {
		Connection con = Conexao.getConnection();
		String selecaoSQL = "SELECT * FROM PESSOA ORDER BY idPessoa;";
		Populacao populacao = new Populacao();

		try {
			PreparedStatement preparacao = con.prepareStatement(selecaoSQL);
			ResultSet resultado = preparacao.executeQuery();

			while (resultado.next()) {
				if (resultado.getString("idade") == null)
					populacao.addPessoa(resultado.getInt("idPessoa"),
							new Contaminada(new StringBuilder(resultado.getString("nome")),
									resultado.getString("genero").charAt(0), resultado.getString("saude").charAt(0)));
				else
					populacao.addPessoa(resultado.getInt("idPessoa"),
							new NaoContaminada(new StringBuilder(resultado.getString("nome")),
									resultado.getString("genero").charAt(0),
									Integer.parseInt(resultado.getString("idade"))));
			}

		} catch (SQLException e) {
			System.out.println("Erro recebido:\n" + e.getStackTrace());
		} finally {
			Conexao.encerrarConexao(con);
		}

		return populacao.getPopulacao();
	}

	// CONSULTAR PESSOA POR ID
	public Pessoa consultaPorID(String id) {
		Connection con = Conexao.getConnection();
		String consultarSQL = "SELECT * FROM PESSOA WHERE idPessoa = ?;";
		Pessoa pessoa = null;

		try {
			PreparedStatement preparacao = con.prepareStatement(consultarSQL);
			preparacao.setString(1, id);
			ResultSet resultado = preparacao.executeQuery();

			while (resultado.next()) {
				if (resultado.getString("idade") == null) {
					pessoa = new Contaminada(new StringBuilder(resultado.getString("nome")),
							resultado.getString("genero").charAt(0), resultado.getString("saude").charAt(0));
					pessoa.setIdentificador(resultado.getInt("idPessoa"));
				} else {
					pessoa = new NaoContaminada(new StringBuilder(resultado.getString("nome")),
							resultado.getString("genero").charAt(0), resultado.getInt("idade"));
					pessoa.setIdentificador(resultado.getInt("idPessoa"));
				}
			}

			preparacao.execute();
			preparacao.close();

		} catch (SQLException e) {
			System.out.println("Erro recebido:\n" + e.getStackTrace());
		} finally {
			Conexao.encerrarConexao(con);
		}
		return pessoa;
	}

	// PESQUISAR PESSOA POR NOME
	public ArrayList<Pessoa> pesquisaPorNome(String nome) {
		Connection con = Conexao.getConnection();
		String pesquisaSQL = "SELECT * FROM PESSOA WHERE nome LIKE ? ORDER BY nome;";
		Populacao populacao = new Populacao();

		try {
			PreparedStatement preparacao = con.prepareStatement(pesquisaSQL);
			preparacao.setString(1, "%" + nome + "%");

			ResultSet resultado = preparacao.executeQuery();

			while (resultado.next()) {
				if (resultado.getString("idade") == null)
					populacao.addPessoa(resultado.getInt("idPessoa"),
							new Contaminada(new StringBuilder(resultado.getString("nome")),
									resultado.getString("genero").charAt(0), resultado.getString("saude").charAt(0)));
				else
					populacao.addPessoa(resultado.getInt("idPessoa"),
							new NaoContaminada(new StringBuilder(resultado.getString("nome")),
									resultado.getString("genero").charAt(0),
									Integer.parseInt(resultado.getString("idade"))));
			}

		} catch (SQLException e) {
			System.out.println("Erro recebido:\n" + e.getStackTrace());
		} finally {
			Conexao.encerrarConexao(con);
		}

		return populacao.getPopulacao();
	}

}