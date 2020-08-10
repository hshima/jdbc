import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertionWithParamTeste {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.retrieveConnection()) { // Using try with resourses explores autoclosable method with no need of finally implementation
			connection.setAutoCommit(false); // allows Transaction commit action

			String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)";
			try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) // When
																													// using
			// prepareStatement, the
			// SQL
			// command
			// responsibility
			// passes to JDBC
			) {
				addVariable("Celular", "Android", statement);
				addVariable("Celular", "apple", statement);

				connection.commit(); // finishes the transaction
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Executando RollBack");
				connection.rollback();
			}
		}

	}

	private static void addVariable(String nome, String desc, PreparedStatement statement) throws Exception {
		statement.setString(1, nome); // Set variable name where '?' matches the first position
		statement.setString(2, desc);
		/*
		 * Erro proposital if(desc == "apple") { throw new Exception("Erro proposital");
		 * }
		 */
		statement.execute();
		try (ResultSet rs = statement.getGeneratedKeys()) {
			while (rs.next()) {
				Integer id = rs.getInt(1);
				System.out.println("O id criado foi: " + id);
			}
		}
	}

}
