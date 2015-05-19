package br.com.granbery.tigershoes.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ParseConversionEvent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.granbery.tigershoes.dao.AbstractDAO;
import br.com.granbery.tigershoes.dao.ClienteDAO;
import br.com.granbery.tigershoes.dao.RendaDAO;
import br.com.granbery.tigershoes.enums.FaixaSalarial;
import br.com.granbery.tigershoes.enums.TipoCliente;
import br.com.granbery.tigershoes.model.Cliente;
import br.com.granbery.tigershoes.model.Endereco;
import br.com.granbery.tigershoes.model.Item;
import br.com.granbery.tigershoes.model.Renda;

@Controller
public class ClienteController {
	
	ClienteDAO clienteDAO;
	
	public ClienteController() {
		clienteDAO = ClienteDAO.getInstance();
	}
	
	public ClienteController(AbstractDAO dao){
		this.clienteDAO = (ClienteDAO) dao;
	}
	
	@RequestMapping("/cadastrarCliente")
	public ModelAndView cadastrarCliente(Cliente cliente, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView ("cliente/cadastrar-cliente");
		cliente = (Cliente) request.getSession().getAttribute("cliente");
		
		if(cliente==null) {
			mv.addObject("tipoCliente", TipoCliente.EXTERNO);
			return mv;
			
		} else {
			mv.addObject("cliente", cliente);
			mv.addObject("tipoCliente", cliente.getTipoClienteString());
			return mv;
			
		}
		
	}
	
	@RequestMapping("/loginCliente")
	public ModelAndView loginCliente(Cliente cliente, HttpServletRequest request) {	
		ModelAndView mv = new ModelAndView ("cliente/login-cliente");		
		cliente = (Cliente) request.getSession().getAttribute("cliente");
		
		if(cliente==null) {
			mv.addObject("tipoCliente", TipoCliente.EXTERNO);
			return mv;
			
		} else {
			
			mv.addObject("cliente", cliente);
			mv.addObject("tipoCliente", cliente.getTipoClienteString());
			return mv;			
			
		}
		
	}
	
	@RequestMapping("/efetuarLogin")
	public ModelAndView efetuaLogin(Cliente cliente, HttpSession session, HttpServletRequest request) {
		ModelAndView mv;
		ArrayList<Item> listaItens = (ArrayList<Item>) request.getSession().getAttribute("carrinho");
		cliente = clienteDAO.recuperarCliente(cliente);
		
		if((cliente!=null && listaItens!=null)) {
			session.setAttribute("cliente", cliente);
			mv = new ModelAndView("redirect:/listaProdutosCarrinho");
			mv.addObject("cliente", cliente);
			mv.addObject("tipoCliente", cliente.getTipoClienteString());
			
			return mv;
		} else if(cliente!=null) {
			session.setAttribute("cliente", cliente);
			mv = new ModelAndView("index");
			mv.addObject("cliente", cliente);
			mv.addObject("tipoCliente", cliente.getTipoClienteString());
			return mv;
			
		} else {
			String message = "Usuário ou Senha Invalidos!";
			mv = new ModelAndView("cliente/falha-login-cliente");
			mv.addObject("message", message);
			return mv;
		}
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(Cliente cliente, HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("index");
		session.invalidate();
		mv.addObject("tipoCliente", TipoCliente.EXTERNO);
		return mv;		
	}
	
	@RequestMapping("/salvarCliente")
	public ModelAndView salvarCliente(Cliente cliente, Endereco endereco, Renda renda, HttpSession session) {
		String message = "Cliente Cadastrado com Sucesso!";
		ModelAndView mv = new ModelAndView("cliente/sucesso-cadastro-cliente");
		
		if(cliente.getSenha().isEmpty()) {
			message = "Preencha a Senha do Cliente";
			mv = new ModelAndView("cliente/falha-cadastrar-cliente");
			mv.addObject("message", message);
			return mv;
		} else if (cliente.getCpf().isEmpty()) {
			message = "Preencha o CPF do Cliente";
			mv = new ModelAndView("cliente/falha-cadastrar-cliente");
			mv.addObject("message", message);
			return mv;
		} else if (cliente.getEmail().isEmpty()) {
			message = "Preencha o E-mail do Cliente";
			mv = new ModelAndView("cliente/falha-cadastrar-cliente");
			mv.addObject("message", message);
			return mv;
		} else if (cliente.getNome().isEmpty()) {
			message = "Preencha o Nome do Cliente";
			mv = new ModelAndView("cliente/falha-cadastrar-cliente");
			mv.addObject("message", message);
			return mv;
		} else {
			
			session.setAttribute("cliente", cliente);
			
			cliente.setTipoCliente(TipoCliente.INTERNO);
			
			if(verificaEndereco(endereco) != null) {
				message = verificaEndereco(endereco);
				mv = new ModelAndView("cliente/falha-cadastrar-cliente");
				return mv;
				
			} else {
				
				cliente.setEndereco(endereco);
				
				if(renda == null) {
					message = "Faixa Salarial não foi informada!";
					mv = new ModelAndView("cliente/falha-cadastrar-cliente");
					return mv;
					
				} else {
					
					int valor = Integer.parseInt(renda.getRenda());
					
					if(valor == FaixaSalarial.Pobre.getValor()) {
						renda.setFaixaSalarial(FaixaSalarial.Pobre);
						
					} else if (valor == FaixaSalarial.ClasseMediaBaixa.getValor()) {
						renda.setFaixaSalarial(FaixaSalarial.ClasseMediaBaixa);
						
					} else if (valor == FaixaSalarial.ClasseMedia.getValor()) {
						renda.setFaixaSalarial(FaixaSalarial.ClasseMedia);
						
					} else if (valor == FaixaSalarial.ClasseMediaAlta.getValor()) {
						renda.setFaixaSalarial(FaixaSalarial.ClasseMediaAlta);
						
					} else if (valor == FaixaSalarial.ClasseAltaBaixa.getValor()) {
						renda.setFaixaSalarial(FaixaSalarial.ClasseAltaBaixa);
						
					} else {
						renda.setFaixaSalarial(FaixaSalarial.ClasseAlta);
						
					}				
					
					renda.setCliente(cliente);
					ClienteDAO.getInstance().persistCliente(cliente);
					RendaDAO.getInstance().persistRenda(renda);
					
					mv.addObject("message", message);
					mv.addObject("nome", cliente.getNome());
					mv.addObject("tipoCliente", cliente.getTipoClienteString());
					return mv;
				}
			}
		}
		
	}
	
	private String verificaEndereco(Endereco endereco) {
	
	if(endereco == null) {
			return "Favor preencha o Endereço corretamente!";
	}
	return null;
	
	}
}