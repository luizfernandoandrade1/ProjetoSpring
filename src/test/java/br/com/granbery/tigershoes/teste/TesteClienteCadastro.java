package br.com.granbery.tigershoes.teste;

import static org.easymock.EasyMock.createMock;

import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import br.com.granbery.tigershoes.controller.ClienteController;
import br.com.granbery.tigershoes.dao.AbstractDAO;
import br.com.granbery.tigershoes.dao.ClienteDAO;
import br.com.granbery.tigershoes.dao.RendaDAO;
import br.com.granbery.tigershoes.enums.FaixaSalarial;
import br.com.granbery.tigershoes.model.Cliente;
import br.com.granbery.tigershoes.model.Endereco;
import br.com.granbery.tigershoes.model.Renda;


public class TesteClienteCadastro {
	
	private Cliente cliente;
	private Endereco endereco;
	private Renda renda;
		
	@Before
	public void inicializa() {
		cliente = new Cliente();
		endereco = new Endereco();
		renda = new Renda();
	}
	
	@Test
	public void testClienteSemSenha() throws Exception {
		cliente.setSenha("");
		
		HttpSession requestMock = createMock(HttpSession.class);
		Endereco enderecoMock = createMock(Endereco.class);
		Renda rendaMock = createMock(Renda.class);
		AbstractDAO clienteDAO = createMock(ClienteDAO.class);
		AbstractDAO RendaDAO = createMock(RendaDAO.class);
		
		ClienteController clienteController = new ClienteController(clienteDAO, RendaDAO);
		
		ModelAndView mv = clienteController.salvarCliente(cliente, enderecoMock, rendaMock, requestMock);
		Assert.assertEquals("cliente/falha-cadastrar-cliente", mv.getViewName()); 
				
	}
	
	@Test
	public void testClienteSemCPF() throws Exception {
		cliente.setSenha("123456");
		cliente.setCpf("");
		
		HttpSession requestMock = createMock(HttpSession.class);
		Endereco enderecoMock = createMock(Endereco.class);
		Renda rendaMock = createMock(Renda.class);
		AbstractDAO clienteDAO = createMock(ClienteDAO.class);
		AbstractDAO RendaDAO = createMock(RendaDAO.class);
		
		ClienteController clienteController = new ClienteController(clienteDAO, RendaDAO);
		
		ModelAndView mv = clienteController.salvarCliente(cliente, enderecoMock, rendaMock, requestMock);
		Assert.assertEquals("cliente/falha-cadastrar-cliente", mv.getViewName()); 
				
	}

	@Test
	public void testClienteSemEmail() throws Exception {
		cliente.setSenha("123456");
		cliente.setCpf("336.211.075-41");
		cliente.setEmail("");
		
		HttpSession requestMock = createMock(HttpSession.class);
		Endereco enderecoMock = createMock(Endereco.class);
		Renda rendaMock = createMock(Renda.class);
		AbstractDAO clienteDAO = createMock(ClienteDAO.class);
		AbstractDAO RendaDAO = createMock(RendaDAO.class);
		
		ClienteController clienteController = new ClienteController(clienteDAO, RendaDAO);
		
		ModelAndView mv = clienteController.salvarCliente(cliente, enderecoMock, rendaMock, requestMock);
		Assert.assertEquals("cliente/falha-cadastrar-cliente", mv.getViewName()); 
		
	}
	
	@Test
	public void testClienteSemNome() throws Exception {
		cliente.setSenha("123456");
		cliente.setCpf("336.211.075-41");
		cliente.setEmail("charlinhocjc@gmail.com");
		cliente.setNome("");
		
		HttpSession requestMock = createMock(HttpSession.class);
		Endereco enderecoMock = createMock(Endereco.class);
		Renda rendaMock = createMock(Renda.class);
		AbstractDAO clienteDAO = createMock(ClienteDAO.class);
		AbstractDAO RendaDAO = createMock(RendaDAO.class);
		
		ClienteController clienteController = new ClienteController(clienteDAO, RendaDAO);
		
		ModelAndView mv = clienteController.salvarCliente(cliente, enderecoMock, rendaMock, requestMock);
		Assert.assertEquals("cliente/falha-cadastrar-cliente", mv.getViewName()); 
		
	}
	
	@Test
	public void testClienteSemEndereco() throws Exception {
		cliente.setSenha("123456");
		cliente.setCpf("336.211.075-41");
		cliente.setEmail("charlinhocjc@gmail.com");
		cliente.setNome("Charleston Campos");
		
		endereco = null;
		
		HttpSession requestMock = createMock(HttpSession.class);
		Renda rendaMock = createMock(Renda.class);
		AbstractDAO clienteDAO = createMock(ClienteDAO.class);
		AbstractDAO RendaDAO = createMock(RendaDAO.class);
		
		ClienteController clienteController = new ClienteController(clienteDAO, RendaDAO);
		
		ModelAndView mv = clienteController.salvarCliente(cliente, endereco, rendaMock, requestMock);
		Assert.assertEquals("cliente/falha-cadastrar-cliente", mv.getViewName()); 
		
	}
	
	@Test
	public void testClienteSemRenda() throws Exception {
		cliente.setSenha("123456");
		cliente.setCpf("336.211.075-41");
		cliente.setEmail("charlinhocjc@gmail.com");
		cliente.setNome("Charleston Campos");
	
		endereco.setRua("Negr�o de Lima");
		endereco.setCidade("Juiz de Fora");
		endereco.setEstado("Minas Gerais");
		endereco.setPais("Brasil");
		endereco.setCep("36000214");
		
		AbstractDAO clienteDAO = createMock(ClienteDAO.class);
		AbstractDAO RendaDAO = createMock(RendaDAO.class);
		
		HttpSession requestMock = createMock(HttpSession.class);
		
		renda = null;
		
		ClienteController clienteController = new ClienteController(clienteDAO, RendaDAO);
		ModelAndView mv = clienteController.salvarCliente(cliente, endereco, renda, requestMock);
		Assert.assertEquals("cliente/falha-cadastrar-cliente", mv.getViewName()); 
		
	}
	
	@Test
	public void testClienteClassePobre() throws Exception {
		cliente.setSenha("123456");
		cliente.setCpf("336.211.075-41");
		cliente.setEmail("charlinhocjc@gmail.com");
		cliente.setNome("Charleston Campos");
	
		endereco.setRua("Negr�o de Lima");
		endereco.setCidade("Juiz de Fora");
		endereco.setEstado("Minas Gerais");
		endereco.setPais("Brasil");
		endereco.setCep("36000214");
		
		HttpSession requestMock = createMock(HttpSession.class);
		
		AbstractDAO clienteDAO = createMock(ClienteDAO.class);
		AbstractDAO RendaDAO = createMock(RendaDAO.class);
		
		renda.setCliente(cliente);
		renda.setRenda("700");
		renda.setFaixaSalarial(FaixaSalarial.Pobre);
		
		ClienteController clienteController = new ClienteController(clienteDAO, RendaDAO);
		ModelAndView mv = clienteController.salvarCliente(cliente, endereco, renda, requestMock);
		Assert.assertEquals("cliente/sucesso-cadastro-cliente", mv.getViewName()); 
		
	}
	
	@Test
	public void testClienteClasseMediaBaixa() throws Exception {
		cliente.setSenha("123456");
		cliente.setCpf("336.211.075-41");
		cliente.setEmail("charlinhocjc@gmail.com");
		cliente.setNome("Charleston Campos");

		endereco.setRua("Negr�o de Lima");
		endereco.setCidade("Juiz de Fora");
		endereco.setEstado("Minas Gerais");
		endereco.setPais("Brasil");
		endereco.setCep("36000214");
		
		HttpSession requestMock = createMock(HttpSession.class);
		
		AbstractDAO clienteDAO = createMock(ClienteDAO.class);
		AbstractDAO RendaDAO = createMock(RendaDAO.class);
		
		renda.setCliente(cliente);
		renda.setRenda("1540");
		renda.setFaixaSalarial(FaixaSalarial.ClasseMediaBaixa);
		
		ClienteController clienteController = new ClienteController(clienteDAO, RendaDAO);
		ModelAndView mv = clienteController.salvarCliente(cliente, endereco, renda, requestMock);
		Assert.assertEquals("cliente/sucesso-cadastro-cliente", mv.getViewName()); 
		
	}
	
	@Test
	public void testClienteClasseMedia() throws Exception {
		cliente.setSenha("123456");
		cliente.setCpf("336.211.075-41");
		cliente.setEmail("charlinhocjc@gmail.com");
		cliente.setNome("Charleston Campos");

		endereco.setRua("Negr�o de Lima");
		endereco.setCidade("Juiz de Fora");
		endereco.setEstado("Minas Gerais");
		endereco.setPais("Brasil");
		endereco.setCep("36000214");
		
		HttpSession requestMock = createMock(HttpSession.class);
		
		AbstractDAO clienteDAO = createMock(ClienteDAO.class);
		AbstractDAO RendaDAO = createMock(RendaDAO.class);

		renda.setCliente(cliente);
		renda.setRenda("1925");
		renda.setFaixaSalarial(FaixaSalarial.ClasseMedia);
		
		ClienteController clienteController = new ClienteController(clienteDAO, RendaDAO);
		ModelAndView mv = clienteController.salvarCliente(cliente, endereco, renda, requestMock);
		Assert.assertEquals("cliente/sucesso-cadastro-cliente", mv.getViewName()); 
		
	}
	
	@Test
	public void testClienteClasseMediaAlta() throws Exception {
		cliente.setSenha("123456");
		cliente.setCpf("336.211.075-41");
		cliente.setEmail("charlinhocjc@gmail.com");
		cliente.setNome("Charleston Campos");

		endereco.setRua("Negr�o de Lima");
		endereco.setCidade("Juiz de Fora");
		endereco.setEstado("Minas Gerais");
		endereco.setPais("Brasil");
		endereco.setCep("36000214");
		
		HttpSession requestMock = createMock(HttpSession.class);
		
		AbstractDAO clienteDAO = createMock(ClienteDAO.class);
		AbstractDAO RendaDAO = createMock(RendaDAO.class);
		
		renda.setCliente(cliente);
		renda.setRenda("2813");
		renda.setFaixaSalarial(FaixaSalarial.ClasseMediaAlta);
		
		ClienteController clienteController = new ClienteController(clienteDAO, RendaDAO);
		ModelAndView mv = clienteController.salvarCliente(cliente, endereco, renda, requestMock);
		Assert.assertEquals("cliente/sucesso-cadastro-cliente", mv.getViewName()); 
		
	}
	
	@Test
	public void testClienteClasseAltaBaixa() throws Exception {
		cliente.setSenha("123456");
		cliente.setCpf("336.211.075-41");
		cliente.setEmail("charlinhocjc@gmail.com");
		cliente.setNome("Charleston Campos");
	
		endereco.setRua("Negr�o de Lima");
		endereco.setCidade("Juiz de Fora");
		endereco.setEstado("Minas Gerais");
		endereco.setPais("Brasil");
		endereco.setCep("36000214");
		
		HttpSession requestMock = createMock(HttpSession.class);
		
		AbstractDAO clienteDAO = createMock(ClienteDAO.class);
		AbstractDAO RendaDAO = createMock(RendaDAO.class);
	
		renda.setCliente(cliente);
		renda.setRenda("4845");
		renda.setFaixaSalarial(FaixaSalarial.ClasseAltaBaixa);
		
		ClienteController clienteController = new ClienteController(clienteDAO, RendaDAO);
		ModelAndView mv = clienteController.salvarCliente(cliente, endereco, renda, requestMock);
		Assert.assertEquals("cliente/sucesso-cadastro-cliente", mv.getViewName()); 
		
	}
	
	@Test
	public void testClienteClasseAlta() throws Exception {
		cliente.setSenha("123456");
		cliente.setCpf("336.211.075-41");
		cliente.setEmail("charlinhocjc@gmail.com");
		cliente.setNome("Charleston Campos");
	
		endereco.setRua("Negr�o de Lima");
		endereco.setCidade("Juiz de Fora");
		endereco.setEstado("Minas Gerais");
		endereco.setPais("Brasil");
		endereco.setCep("36000214");
		
		HttpSession requestMock = createMock(HttpSession.class);
		
		AbstractDAO clienteDAO = createMock(ClienteDAO.class);
		AbstractDAO RendaDAO = createMock(RendaDAO.class);
		
		renda.setCliente(cliente);
		renda.setRenda("12988");
		renda.setFaixaSalarial(FaixaSalarial.ClasseAlta);
		
		ClienteController clienteController = new ClienteController(clienteDAO, RendaDAO);
		ModelAndView mv = clienteController.salvarCliente(cliente, endereco, renda, requestMock);
		Assert.assertEquals("cliente/sucesso-cadastro-cliente", mv.getViewName()); 
		
	}
	
	
//	@Test
//	public void persistirCliente(){
//		Cliente cliente = new Cliente();
//		cliente.setNome("Charleston Campos Silva Pereira");
//		cliente.setEmail("charlinho@familia.com.br");
//		cliente.setCpf("22222222222");
//		cliente.setTipoCliente(TipoCliente.EXTERNO);
//		cliente.setSenha("tiger123");
//		
//		Endereco endereco = new Endereco();
//		endereco.setRua("Negr�o de Lima");
//		endereco.setCidade("Juiz de Fora");
//		endereco.setEstado("Minas Gerais");
//		endereco.setPais("Brasil");
//		endereco.setCep("36000214");
//		
//		cliente.setEndereco(endereco);
//		
//		Assert.assertTrue(ClienteDAO.getInstance().persistCliente(cliente));
//	}

}
