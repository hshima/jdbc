import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	String url = "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
	String user = "root";
	String password = "1234";

	/**
	 * Creates a dataSource Interface to be referenced
	 */
	public DataSource dataSource;

	public ConnectionFactory() {
		/**
		 * Implements a ComboPooledDataSource so a single connection is needed
		 */
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl(url);
		comboPooledDataSource.setUser(user);
		comboPooledDataSource.setPassword(password);

		/**
		 * References the stablished connection to the dataSource Interface
		 */
		this.dataSource = comboPooledDataSource;
	}

	public Connection retrieveConnection() throws SQLException {
		/**
		 * Creating the connection. Exchanges the previous each request creating a new
		 * Connection for a DataSource manager through C3P0
		 */
		return this.dataSource.getConnection();
	}

}
