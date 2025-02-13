package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	// FAZER CONEXAO COM BD
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pandemia?useTimezone=true&serverTimezone=UTC", "root", "root");
		} catch (SQLException e) {
			
			System.out.println("Sem conectar!\n" + e.getMessage());
		} catch (ClassNotFoundException e1) {
			
			System.out.println("Falha na Conex�o!\n" + e1.getMessage());
			e1.printStackTrace();
		}
		return con;
	}
	
	// FECHAR CONEXAO COM BD
	public static void fechaConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.print("Falha ao fechar a conexao.");
				System.out.println("Causa: " + e.getMessage());
			}
		}
	}
}
