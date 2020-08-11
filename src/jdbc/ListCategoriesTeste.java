package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDAO;
import dao.ProductDAO;
import model.Produto;
import modelo.Categoria;

public class ListCategoriesTeste {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().retrieveConnection()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection); // Base query
			List<Categoria> categoriaList = categoriaDAO.list();
			categoriaList.stream().forEach(ct -> { // In a cicle of new queries
				System.out.println(ct.getNome()); // For each Categoria...
				try {
					for (Produto produto : new ProductDAO(connection).search(ct) ) {
						System.out.println(ct.getNome() + " - " + produto.getNome()); // ... N Products will be shown, causing loose of database performance
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}

	}

}
