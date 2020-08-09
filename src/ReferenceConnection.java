import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ReferenceConnection {
	public Connection retrieveConnection() throws SQLException {
		/**
		 * Creating the connection
		 */
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "1234");
		
		return connection;
	}

}
