package br.com.granbery.tigershoes.teste;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.granbery.tigershoes.dao.AbstractDAO;
import br.com.granbery.tigershoes.dao.ClienteDAO;
import br.com.granbery.tigershoes.model.Cliente;

public class TesteEmailExistente {
	
	String email;
	@Before
	public void inicializar(){
		 email = "teste@teste.com";
		 
	}
	
	
	@Test
	public void testarEmailExistente(){
		
		AbstractDAO clienteDAO = createMock(ClienteDAO.class);
		expect(clienteDAO.recuperarPorEmail(email)).andReturn(true);
		
		Cliente cliente = new Cliente(clienteDAO);
		Assert.assertEquals("Email já cadastrado!", cliente.verificarEmailExistente(email));
	}
	
	@Test
	public void testarEmailNaoExistente(){
		
		AbstractDAO clienteDAO = createMock(ClienteDAO.class);
		expect(clienteDAO.recuperarPorEmail(email)).andReturn(false);
		
		Cliente cliente = new Cliente(clienteDAO);
		Assert.assertEquals("Email não cadastrado", cliente.verificarEmailExistente(email));
	}
}
