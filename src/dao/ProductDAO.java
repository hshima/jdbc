package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Produto;

public class ProductDAO {

	private Connection connection;

	/*
	 * Injects a connection
	 */
	public ProductDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void save(Produto product) throws SQLException {
		String sql = "INSERT INTO produto (NOME, DESCRICAO) VALUES (?,?)";
		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, product.getNome());
			pstm.setString(2, product.getDescricao());
			pstm.execute();
			try (ResultSet rs = pstm.getGeneratedKeys()) {
				while (rs.next()) {
					product.setId(rs.getInt(1));
				}
			}
		}
	}
}
