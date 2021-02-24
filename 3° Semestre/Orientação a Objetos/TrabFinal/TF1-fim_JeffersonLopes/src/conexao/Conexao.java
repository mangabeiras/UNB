package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid19?useTimezone=true&serverTimezone=UTC",
					"root", "root");
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Sem conectar!\n" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Falha na Conexao!\n" + e.getMessage());
			e.printStackTrace();
		}

		return con;
	}

	public static void encerrarConexao(Connection con) {
		if (con != null) {
			try {
				con.close();
				System.out.println("Conexao com Banco de Dados encerrada!");
			} catch (SQLException e) {
				System.out.println("Erro ao encerrar a conexao:\n" + e.getMessage());
			}
		}
	}

}