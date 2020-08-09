import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListagemTeste {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.retrieveConnection();
		
		/**
		 * Creating the request statement
		 */
		String sql = "SELECT id, nome, descricao FROM produto";
		
		PreparedStatement statement = connection.prepareStatement(sql);

		/**
		 * Executing the statement
		 */
		statement.execute(); // since it's needed to process the statement once, this request is made only
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
