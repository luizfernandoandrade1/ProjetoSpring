package br.com.granbery.tigershoes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.granbery.tigershoes.enums.EstadoProduto;

@Entity
public class Produto {
	
	@Id @GeneratedValue
	private int id;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(nullable = false)
	private String modelo;
	
	@Column(nullable = false)
	private String numero;
	
	@Column(nullable = false)
	private double preco;
	
	@Column(nullable = false)
	private EstadoProduto estadoProduto;

	private String caminhoImagem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Fornecedor fornecedor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public String getCaminhoImagem() {
		return caminhoImagem;
	}
	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}
	public EstadoProduto getEstadoProduto() {
		return estadoProduto;
	}
	public void setEstadoProduto(EstadoProduto estadoProduto) {
		this.estadoProduto = estadoProduto;
	}

}
