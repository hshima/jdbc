package jdbc;
import java.sql.SQLException;

public class PoolConnectionTeste {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();

		/*
		 * Tries to creates more connections than the max limit allows
		 */
		for (int i = 0; i < 25; i++) {
			connectionFactory.retrieveConnection();
			System.out.println("Connection #: " + i);
		}
	}

}
