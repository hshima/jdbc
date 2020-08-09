import java.sql.Connection;
import java.sql.SQLException;

public class ConexaoTeste {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory rc = new ConnectionFactory();
		Connection connection = rc.retrieveConnection();
		
		System.out.println("Fechando Conex�o");
		connection.close(); // Closes open connection

	}

}
