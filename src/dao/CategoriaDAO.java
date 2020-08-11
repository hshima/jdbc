package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;
import modelo.Categoria;

public class CategoriaDAO {

	private Categoria categoria;
	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Categoria> list() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		String sql = "SELECT ID, NOME FROM CATEGORIA";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.execute();
			try (ResultSet rs = ps.getResultSet()) {
				while (rs.next()) {
					Categoria categoria = new Categoria(rs.getInt(1), rs.getString(2));
					categorias.add(categoria);
				}
			}
		}

		return categorias;
	}

	public List<Categoria> listAllProducts() throws SQLException {

		Categoria last = null; // Creates a reference for the last

		List<Categoria> categorias = new ArrayList<>();
		String sql = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA C INNER JOIN PRODUTO P ON C.ID = P.CATEGORIA_ID";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.execute();

			try (ResultSet rs = ps.getResultSet()) {
				while (rs.next()) {
					if (last == null || !last.getNome().contentEquals(rs.getString(2))) {
						Categoria categoria = new Categoria(rs.getInt(1), rs.getString(2));
						last = categoria;
						categorias.add(categoria);
					}
					Produto produto = new Produto(rs.getInt(3), rs.getString(4), rs.getString(5));
					last.add(produto);
				}
			}
		}

		return categorias;
	}

}
