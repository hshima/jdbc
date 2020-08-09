import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertionWithParamTeste {

	public static void main(String[] args) throws SQLException {
		String nome = "Mouse";
		String desc = "Mouse sem fio";

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.retrieveConnection();

		String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // When using prepareStatement, the SQL command responsibility passes to JDBC

		statement.setString(1, nome); // Set variable name where '?' matches the first position
		statement.setString(2, desc);
		
		statement.execute();
		ResultSet rs = statement.getGeneratedKeys();
		while (rs.next()) {
			Integer id = rs.getInt(1);
			System.out.println("O id criado foi: " + id);
		}

	}

}
