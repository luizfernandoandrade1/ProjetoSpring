package br.com.granbery.tigershoes.teste;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;
import br.com.granbery.tigershoes.controller.ClienteController;
import br.com.granbery.tigershoes.dao.AbstractDAO;
import br.com.granbery.tigershoes.dao.ClienteDAO;
import br.com.granbery.tigershoes.model.Cliente;
import br.com.granbery.tigershoes.model.Endereco;
import br.com.granbery.tigershoes.model.Item;
import br.com.granbery.tigershoes.model.Renda;
import static org.easymock.EasyMock.*;

public class TesteClienteLogin {

	private Cliente cliente;
	
	@Before
	public void inicializa() {
		cliente = new Cliente();
	}
	
	@Test
	public void testarClienteValidoComItem(){
		cliente.setEmail("teste@teste.com");
		cliente.setSenha("123");
		ArrayList<Item> listaItens = null;
		
		AbstractDAO clienteDAO = createMock(ClienteDAO.class);
		expect(clienteDAO.recuperarCliente(cliente)).andReturn(cliente);
		replay(clienteDAO);
		
		HttpSession sessiontMock = createMock(HttpSession.class);
		sessiontMock.setAttribute("carrinho", listaItens);
		HttpServletRequest requestMock = createMock(HttpServletRequest.class);
		expect(requestMock.getSession()).andReturn((HttpSession) sessiontMock.getAttribute("carrinho"));
		replay(requestMock);
		
		ClienteController clienteController = new ClienteController(clienteDAO);
		ModelAndView mv = clienteController.efetuaLogin(cliente, sessiontMock, requestMock);
		Assert.assertEquals("index.jsp", mv.getViewName());
	}
}
