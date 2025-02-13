package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;
import dados.Homem;
import dados.Mulher;
import dados.Pessoa;

public class PessoaDao {
	private final String INSERT = "INSERT INTO pandemia.pessoa (nome, saude, gestante, idade) VALUES (?, ?, ?, ?)";
	private final String LIST = "SELECT * FROM PESSOA";
	private final String LISTBYID = "select * from pessoa where idPessoa = ?;";

	public void cadastrar(Pessoa pessoa) {
		Connection con = Conexao.getConnection();
		PreparedStatement prep;
		try {
			prep = con.prepareStatement(INSERT);

			prep.setString(1, pessoa.getNome());
			prep.setString(2, pessoa.getSituacao().toString());
			prep.setString(3, pessoa.getSituacaoGestacao());
			prep.setString(4, pessoa.getIdade());

			prep.execute();
			prep.close();
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			System.out.println("Erro causado por: " + e.getStackTrace());

		} finally {
			Conexao.fechaConnection(con);
		}
	}

	public Pessoa getPessoaId(int id) {
		Connection con = Conexao.getConnection();
		PreparedStatement prep;
		ResultSet rs;
		Pessoa pessoa = null;

		try {
			prep = con.prepareStatement(LISTBYID);
			prep.setInt(1, id);
			rs = prep.executeQuery();
			
			while(rs.next()) {
				if (rs.getString("gestante") == null) {
					pessoa = new Homem(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("saude").charAt(0), rs.getInt("idade"));
				} else {
					pessoa = new Mulher(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("saude").charAt(0),
							rs.getString("gestante").charAt(0));
				}
			}
			
			prep.execute();
			prep.close();

		} catch (SQLException e) {
			System.out.println("Erro causado por: ");
			e.printStackTrace();

		} finally {
			Conexao.fechaConnection(con);
		}
		return pessoa;
	}

	public List<Pessoa> getGrupo() {
		Connection con = Conexao.getConnection();
		PreparedStatement prep;
		ResultSet rs;
		ArrayList<Pessoa> grupo = new ArrayList<>();
		try {
			prep = con.prepareStatement(LIST);
			rs = prep.executeQuery();

			while (rs.next()) {
				if (rs.getString("gestante") == null)
					grupo.add(new Homem(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("saude").charAt(0), rs.getInt("idade")));
				else
					grupo.add(new Mulher(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("saude").charAt(0), rs.getString("gestante").charAt(0)));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro causado por: ");
			e.printStackTrace();
		}
		
		finally {
			Conexao.fechaConnection(con);
		}
		return grupo;
	}
}
