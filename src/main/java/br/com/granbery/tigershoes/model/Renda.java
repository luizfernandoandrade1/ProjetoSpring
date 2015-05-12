package br.com.granbery.tigershoes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import br.com.granbery.tigershoes.enums.FaixaSalarial;

@Entity
public class Renda {
	
	@Id @GeneratedValue
	private int id;
	
	private String renda;
	
	@Enumerated
	@Column(nullable = false)
	private FaixaSalarial faixaSalarial;
	
	@OneToMany(mappedBy="renda", fetch = FetchType.LAZY)
	private List<Cliente> clientes = new ArrayList<Cliente>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
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
}
