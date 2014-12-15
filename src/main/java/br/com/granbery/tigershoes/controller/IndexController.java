package br.com.granbery.tigershoes.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.granbery.tigershoes.dao.ProdutoDAO;
import br.com.granbery.tigershoes.enums.TipoCliente;
import br.com.granbery.tigershoes.model.Cliente;
import br.com.granbery.tigershoes.model.Produto;

@Controller
public class IndexController {
	
	@RequestMapping("/index") 
	public ModelAndView inicio(Cliente cliente, HttpServletRequest request) throws IOException{
		ModelAndView mv = new ModelAndView("index");
		cliente = (Cliente) request.getSession().getAttribute("cliente");
		
		if(cliente==null) {			
			List<Produto> listaProduto = ProdutoDAO.getInstance().listProduto();
			mv.addObject("listaProduto", listaProduto);
			mv.addObject("tipoCliente", TipoCliente.EXTERNO);
			return mv;
			
		} else {			
			List<Produto> listaProduto = ProdutoDAO.getInstance().listProduto();
			mv.addObject("listaProduto", listaProduto);
			mv.addObject("cliente", cliente);
			mv.addObject("tipoCliente", cliente.getTipoClienteString());			
			return mv;
		}
	}
	
}
