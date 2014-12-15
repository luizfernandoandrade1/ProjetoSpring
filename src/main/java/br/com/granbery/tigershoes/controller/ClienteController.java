package br.com.granbery.tigershoes.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.granbery.tigershoes.dao.ClienteDAO;
import br.com.granbery.tigershoes.enums.TipoCliente;
import br.com.granbery.tigershoes.model.Cliente;
import br.com.granbery.tigershoes.model.Endereco;
import br.com.granbery.tigershoes.model.Item;

@Controller
public class ClienteController {
	
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
		cliente = ClienteDAO.getInstance().logarCliente(cliente);
		
		if((cliente!=null && listaItens!=null)) {
			session.setAttribute("cliente", cliente);
			mv = new ModelAndView("redirect:/listaProdutosCarrinho");
			mv.addObject("cliente", cliente);
			mv.addObject("tipoCliente", cliente.getTipoClienteString());
			
			return mv;
		}
		
		if(cliente!=null) {
			session.setAttribute("cliente", cliente);
			mv = new ModelAndView("index");
			mv.addObject("cliente", cliente);
			mv.addObject("tipoCliente", cliente.getTipoClienteString());
			return mv;
			
		} else {
			String message = "Usuário é Senha Invalidos!";
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
	public ModelAndView salvarCliente(Cliente cliente, Endereco endereco, HttpSession session) {
		String message = "Cliente Cadastrado com Sucesso!";
		ModelAndView mv = new ModelAndView("cliente/sucesso-cadastro-cliente");
	
		cliente.setTipoCliente(TipoCliente.INTERNO);
		
		cliente.setEndereco(endereco);
		
		ClienteDAO.getInstance().persistCliente(cliente);
		
		if(cliente!=null) {
			session.setAttribute("cliente", cliente);
		}	
		mv.addObject("message", message);
		mv.addObject("nome", cliente.getNome());
		mv.addObject("tipoCliente", cliente.getTipoClienteString());
		return mv;
	}
}
