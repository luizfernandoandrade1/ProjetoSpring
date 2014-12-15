package br.com.granbery.tigershoes.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {

	@Id @GeneratedValue
	private int id;
	
	@Column(nullable = false)
	private Calendar data;
	
	@OneToMany(mappedBy = "pedido", cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Item> itens = new ArrayList<Item>();

	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	private Cliente cliente;
	
	public int getId() {
		return id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	
	
}
