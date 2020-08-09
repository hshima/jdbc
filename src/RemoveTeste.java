import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RemoveTeste {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection con = factory.retrieveConnection();
		
		Statement statement = con.createStatement();
		String sql = "DELETE FROM PRODUTO WHERE id > 2";
		statement.execute(sql);
		
		Integer modifiedLines = statement.getUpdateCount(); // Returns an int
		System.out.println("Quantity of modified lines: " + modifiedLines);
	}

}
