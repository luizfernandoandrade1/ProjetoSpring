package br.com.granbery.tigershoes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.granbery.tigershoes.enums.FaixaSalarial;

@Entity
public class Renda {
	
	@Id @GeneratedValue
	private int id;
	
	private String renda;
	
	@Enumerated
	@Column(nullable = false)
	private FaixaSalarial faixaSalarial;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getRenda() {
		return renda;
	}

	public void setRenda(String renda) {
		this.renda = renda;
	}

	public FaixaSalarial getFaixaSalarial() {
		return faixaSalarial;
	}

	public void setFaixaSalarial(FaixaSalarial faixaSalarial) {
		this.faixaSalarial = faixaSalarial;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
