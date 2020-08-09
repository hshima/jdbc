import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoTeste {

	public static void main(String[] args) throws SQLException {

		Connection connection // Using the Connection Interface  
			= DriverManager // in the the DriverManager Class 
				.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "1234"); // Use method of dabase connection
		System.out.println("Fechando Conexão");
		connection.close(); // Closes open connection

	}

}
