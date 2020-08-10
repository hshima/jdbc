package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	public List<Produto> list() throws SQLException{
		List<Produto> produtos = new ArrayList<Produto>();
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.execute();
			try(ResultSet rs = ps.getResultSet()){
				while(rs.next()) {
					Produto produto = new Produto(rs.getInt(1), rs.getString(2), rs.getString(3));
					produtos.add(produto);
				}
			}
		}
		return produtos;
	}
}
