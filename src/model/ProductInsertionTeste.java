package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.ConnectionFactory;

public class ProductInsertionTeste {

	public static void main(String[] args) throws SQLException {
		Produto comoda = new Produto("Comoda", "Cômoda Vertical");
		try (Connection connection = new ConnectionFactory().retrieveConnection()) {
			String sql = "INSERT INTO produto (NOME, DESCRICAO) VALUES (?,?)";
			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, comoda.getNome());
				pstm.setString(2, comoda.getDescricao());
				pstm.execute();
				try (ResultSet rs = pstm.getGeneratedKeys()) {
					while (rs.next()) {
						comoda.setId(rs.getInt(1));
					}
				}
			}
		}
		System.out.println(comoda.toString());
	}

}
