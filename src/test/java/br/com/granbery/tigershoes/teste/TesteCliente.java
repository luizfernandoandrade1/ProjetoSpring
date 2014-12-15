package br.com.granbery.tigershoes.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.granbery.tigershoes.dao.ClienteDAO;
import br.com.granbery.tigershoes.enums.TipoCliente;
import br.com.granbery.tigershoes.model.Cliente;
import br.com.granbery.tigershoes.model.Endereco;


public class TesteCliente {
	
	
	@Test
	public void persistirCliente(){
		Cliente cliente = new Cliente();
		cliente.setNome("Charleston Campos Silva Pereira");
		cliente.setEmail("charlinho@familia.com.br");
		cliente.setCpf("22222222222");
		cliente.setTipoCliente(TipoCliente.EXTERNO);
		cliente.setSenha("tiger123");
		
		Endereco endereco = new Endereco();
		endereco.setRua("Negrão de Lima");
		endereco.setCidade("Juiz de Fora");
		endereco.setEstado("Minas Gerais");
		endereco.setPais("Brasil");
		endereco.setCep("36000214");
		
		cliente.setEndereco(endereco);
		
		Assert.assertTrue(ClienteDAO.getInstance().persistCliente(cliente));
	}

}
