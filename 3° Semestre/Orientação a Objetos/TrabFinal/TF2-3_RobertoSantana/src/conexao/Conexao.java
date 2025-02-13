package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pandemia?useTimezone=true&serverTimezone=UTC", "root", "root");
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Sem conectar!\n" + e.getMessage());
		} catch (ClassNotFoundException e1) {
			System.out.println("Falha na Conex�o!\n" + e1.getMessage());
			e1.printStackTrace();
		}
		return con;
	}
	
	public static void fechaConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
				System.out.println("Conexao com Banco de Dados fechada");
			} catch (SQLException e) {
				System.out.print("Falha ao fechar a conex�o.");
				System.out.println("Causa: " + e.getMessage());
			}
		}
	}
}
