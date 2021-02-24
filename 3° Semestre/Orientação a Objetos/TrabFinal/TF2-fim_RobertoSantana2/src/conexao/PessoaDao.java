package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dados.Grupo;
import dados.Homem;
import dados.Mulher;
import dados.Pessoa;

// CONTROLADOR (SE COMUNICA COM O BD) 
public class PessoaDao {
	private final String INSERT = "INSERT INTO pandemia.pessoa (nome, saude, gestante, idade) VALUES (?, ?, ?, ?)";
	private final String LIST = "SELECT * FROM pessoa";
	private final String LISTBYID = "select * from pessoa where idPessoa = ?;";
	private final String LISTBYNAME = "SELECT * from pessoa where nome LIKE ? ORDER BY nome";

	// CADASTRO DE UMA PESSOA NO BD
	public void cadastrar(Pessoa pessoa) {
		Connection con = Conexao.getConnection();
		PreparedStatement prep;
		try {
			prep = con.prepareStatement(INSERT);
			prep.setString(1, pessoa.getNome());
			prep.setString(2, pessoa.getSituacao().toString());
			prep.setString(3, pessoa.toString().split(" ")[0].equals("--") ? null : ((Mulher) pessoa).getSituacaoGestacao());
			prep.setString(4, pessoa.toString().split(" ")[1].equals("--") ? null : ((Homem) pessoa).getIdade());

			prep.execute();
			prep.close();
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e1) {
			System.out.println("Conexao com BD excedida");
			e1.printStackTrace();
		} finally {
			Conexao.fechaConnection(con);
		}
	}
	
	// OBTER PESSOA PELO SEU ID
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
			e.printStackTrace();
		} catch (NullPointerException e1) {
			System.out.println("Conexao com BD excedida");
			e1.printStackTrace();
		} finally {
			Conexao.fechaConnection(con);
		}
		return pessoa;
	}
	
	// OBTEM TODAS AS PESSOAS CADASTRADAS
	public Grupo getGrupo() {
		Connection con = Conexao.getConnection();
		PreparedStatement prep;
		ResultSet rs;
		Grupo grupo = new Grupo();
		try {
			prep = con.prepareStatement(LIST);
			rs = prep.executeQuery();
			
			while (rs.next()) {
				if (rs.getString("gestante") == null)
					grupo.addPessoa(new Homem(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("saude").charAt(0), rs.getInt("idade")));
				else
					grupo.addPessoa(new Mulher(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("saude").charAt(0), rs.getString("gestante").charAt(0)));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro causado por: ");
			e.printStackTrace();
		} catch (NullPointerException e1) {
			System.out.println("Conexao com BD excedida");
			e1.printStackTrace();
		}
		finally {
			Conexao.fechaConnection(con);
		}
		return grupo;
	}
	
	// OBTEM GRUPO ORDENADO POR NOME E QUE CONTENHA A STRING
	public Grupo getGrupoByName(String nome) {
		Connection con = Conexao.getConnection();
		PreparedStatement prep;
		ResultSet rs;
		Grupo grupo = new Grupo();
		try {
			prep = con.prepareStatement(LISTBYNAME);
			prep.setString(1, "%"+nome+"%");
			rs = prep.executeQuery();

			while (rs.next()) {
				if (rs.getString("gestante") == null)
					grupo.addPessoa(new Homem(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("saude").charAt(0), rs.getInt("idade")));
				else
					grupo.addPessoa(new Mulher(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("saude").charAt(0), rs.getString("gestante").charAt(0)));
			}
		} catch (SQLException e) {
			System.out.println("Erro causado por: ");
			e.printStackTrace();
		} catch (NullPointerException e1) {
			System.out.println("Conexao com BD excedida");
			e1.printStackTrace();
		}
		
		finally {
			Conexao.fechaConnection(con);
		}
		return grupo;
	}
}
