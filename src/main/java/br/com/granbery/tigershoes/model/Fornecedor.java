package br.com.granbery.tigershoes.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Fornecedor {

	@Id @GeneratedValue
	private int id;
	
	@Column(nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY)
	private Set<Produto> produtos;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Endereco endereco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produto) {
		this.produtos.add(produto);
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
