package modelo;

import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class Categoria {

	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<Produto>();

	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		
		return this.nome;
	}

	public Integer getId() {

		return this.id;
	}

	public void add(Produto produto) {
		produtos.add(produto);
		
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
}
