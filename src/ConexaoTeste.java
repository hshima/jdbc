import java.sql.Connection;
import java.sql.SQLException;

public class ConexaoTeste {

	public static void main(String[] args) throws SQLException {

		ReferenceConnection rc = new ReferenceConnection();
		Connection connection = rc.retrieveConnection();
		
		System.out.println("Fechando Conexão");
		connection.close(); // Closes open connection

	}

}
