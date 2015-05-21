package br.com.granbery.tigershoes.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.granbery.tigershoes.dao.AbstractDAO;
import br.com.granbery.tigershoes.dao.ClienteDAO;
import br.com.granbery.tigershoes.enums.TipoCliente;

@Entity
public class Cliente {

	@Id
	@GeneratedValue
	private int id;

	private String nome;
	private String cpf;
	private String email;
	private String senha;

	@Enumerated
	@Column(nullable = false)
	private TipoCliente tipoCliente;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Endereco> enderecos = new ArrayList<Endereco>();

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private Set<Pedido> pedidos;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Endereco> getEndereco() {
		return enderecos;
	}

	public void setEndereco(Endereco endereco) {
		this.enderecos.add(endereco);
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedido pedido) {
		this.pedidos.add(pedido);
	}

	public String getTipoClienteString() {
		return tipoCliente.name();
	}
	
	public String verificarEmailExistente(String email,ClienteDAO clienteDAO){
		if (clienteDAO.recuperarPorEmail(email)){
			return "Email já cadastrado!";
		} else {
			return "Email não cadastrado";
		}
	}
}
