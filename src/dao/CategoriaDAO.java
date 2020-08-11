package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

}
