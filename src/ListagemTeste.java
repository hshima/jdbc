import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListagemTeste {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.retrieveConnection();
		
		Statement statement = connection.createStatement();

		/**
		 * Creating the request statement
		 */
		String sql = "SELECT id, nome, descricao FROM produto";
		
		
		/**
		 * Executing the statement
		 */
		// List<String> produtos = statement.execute(sql); //this command won't work,
		// because execute statement returns a success or fail result, but stores in a
		// resultSet Variable
		statement.execute(sql); // since it's needed to process the statement once, this request is made only
								// calling the method but not storing in a variable
		
		/**
		 * retrieving the statement information
		 */
		ResultSet rs = statement.getResultSet(); // reaches a ResultSet stored in the statement Object;
		if (rs.next()) {
			Integer id = rs.getInt("id");
			System.out.println(id);
			String nome = rs.getString("nome");
			System.out.println(nome);
			String desc = rs.getString("descricao");
			System.out.println(desc);
		}
		

		/**
		 * closing the connection
		 */
		connection.close(); // Closes open connection
	}

}
