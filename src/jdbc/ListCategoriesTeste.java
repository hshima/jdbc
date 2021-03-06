package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDAO;
import model.Produto;
import modelo.Categoria;

public class ListCategoriesTeste {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().retrieveConnection()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> categoriaList = categoriaDAO.listAllProducts();
			categoriaList.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				for (Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome()); // ... N Products will be shown,
																					// causing loose of database
																					// performance
				}
			});

		}
	}
}
