package jdbc;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	String url = "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
	String user = "root";
	String password = "1234";
	Integer maxPoolSize = 20;

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
		 * Specifies the maximum number of connections. Once the connection limit is
		 * reached. For more connections than the limit, the PooledDataSource will wait
		 * for one of the previous connections to be closed before starting a new one
		 */
		comboPooledDataSource.setMaxPoolSize(maxPoolSize);

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
