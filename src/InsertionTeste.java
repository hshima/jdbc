import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertionTeste {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.retrieveConnection();
		
		Statement statement = connection.createStatement();
		String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES ('Mouse', 'Mouse sem fio')";

		/**
		 * test if the query passes
		 * expects: false, since  there's no information retrieved in the resultSet attribute
		 */
		/*
		boolean result = statement.execute(sql);
		System.out.println(result);
		*/
		
		/**
 		 * However, information was registered. so the following application is better fit
		 */
		
		statement.execute(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = statement.getGeneratedKeys();
		while(rs.next()) {
			Integer id = rs.getInt(1); // in SQL, the first item of a list is 1
			System.out.println("O id criado foi: "+ id);
		}
		
	}

}
