package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.ProductDAO;
import jdbc.ConnectionFactory;

public class ProductInsertionTeste {

	public static void main(String[] args) throws SQLException {
		Produto comoda = new Produto("Comoda", "Cômoda Vertical");
		try (Connection connection = new ConnectionFactory().retrieveConnection()) {
			ProductDAO productDAO = new ProductDAO(connection); // Instantiates in a variable so further method could be
																// called
			productDAO.save(comoda);
			// Example: List<Produto> produtos = productDAO.method();
		}
		System.out.println(comoda.toString());
	}

}
