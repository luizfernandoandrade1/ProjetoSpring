package br.com.granbery.tigershoes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.granbery.tigershoes.dao.FornecedorDAO;
import br.com.granbery.tigershoes.dao.ProdutoDAO;
import br.com.granbery.tigershoes.enums.TipoCliente;
import br.com.granbery.tigershoes.model.Cliente;
import br.com.granbery.tigershoes.model.Fornecedor;
import br.com.granbery.tigershoes.model.Produto;

@Controller
public class ProdutoController {

	@RequestMapping("/detalharProduto")
	public ModelAndView detalharProduto(int idProduto, Cliente cliente, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("produto/detalhar-produto");
		Produto produto = ProdutoDAO.getInstance().getById(idProduto);
		cliente = (Cliente) request.getSession().getAttribute("cliente");
		
		if(cliente==null) {
			mv.addObject("tipoCliente", TipoCliente.EXTERNO);
			mv.addObject("produto", produto);
			return mv;
			
		} else {
			mv.addObject("produto", produto);
			mv.addObject("cliente", cliente);
			mv.addObject("tipoCliente", cliente.getTipoClienteString());
			return mv;			
		}
		
	}

	@RequestMapping("/cadastrarProduto")
	public ModelAndView cadastrarProduto(Cliente cliente, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("produto/cadastrar-produto");
		List<Fornecedor> listaFornecedor = FornecedorDAO.getInstance().listFornecedor();
		cliente = (Cliente) request.getSession().getAttribute("cliente");
		
		if(cliente==null) {
			mv.addObject("tipoCliente", TipoCliente.EXTERNO);
			mv.addObject("listaFornecedor", listaFornecedor);			
			return mv;
			
		} else {
			mv.addObject("listaFornecedor", listaFornecedor);			
			mv.addObject("cliente", cliente);
			mv.addObject("tipoCliente", cliente.getTipoClienteString());
			return mv;			
		}

	}

	@RequestMapping("/cadastrarProdutoPost")
	public ModelAndView cadastrarProdutoPost(Produto produto, int id_fornecedor, Cliente cliente, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("produto/sucesso-cadastro-produto");
		Fornecedor fornecedor = FornecedorDAO.getInstance().getById(id_fornecedor);
		produto.setFornecedor(fornecedor);
		cliente = (Cliente) request.getSession().getAttribute("cliente");
		
		if(cliente==null) {
			mv.addObject("tipoCliente", TipoCliente.EXTERNO);			
			return mv;
			
		} else {
			ProdutoDAO.getInstance().persistProduto(produto);
			mv.addObject("message", "Produto Cadastrado com Sucesso!");					
			mv.addObject("cliente", cliente);
			mv.addObject("tipoCliente", cliente.getTipoClienteString());
			return mv;			
		}
		
	}

	@RequestMapping("/atualizarProduto")
	public ModelAndView atualizarProduto(int idProduto, Cliente cliente, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("produto/cadastrar-produto");
		Produto produto = ProdutoDAO.getInstance().getById(idProduto);
		List<Fornecedor> listaFornecedor = FornecedorDAO.getInstance().listFornecedor();
		cliente = (Cliente) request.getSession().getAttribute("cliente");

		if(cliente==null) {
			mv.addObject("tipoCliente", TipoCliente.EXTERNO);			
			mv.addObject("produto", produto);
			mv.addObject("listaFornecedor", listaFornecedor);
			return mv;
			
		} else {
			ProdutoDAO.getInstance().persistProduto(produto);
			mv.addObject("message", "Produto Cadastrado com Sucesso!");					
			mv.addObject("cliente", cliente);
			mv.addObject("tipoCliente", cliente.getTipoClienteString());
			return mv;			
		}
				
	}

	@RequestMapping("/atualizarProdutoPost")
	public ModelAndView atualizarProdutoPost(Produto produto, int id_fornecedor, Cliente cliente, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("produto/sucesso-cadastro-produto");
		String message = "Produto Alterado com Sucesso!";
		Fornecedor fornecedor = FornecedorDAO.getInstance().getById(id_fornecedor);
		cliente = (Cliente) request.getSession().getAttribute("cliente");
				
		if(cliente==null) {
			mv.addObject("tipoCliente", TipoCliente.EXTERNO);			
			mv.addObject("message", message);
			return mv;
			
		} else {
			ProdutoDAO.getInstance().persistProduto(produto);					
			produto.setFornecedor(fornecedor);
			ProdutoDAO.getInstance().merge(produto);
			mv.addObject("cliente", cliente);
			mv.addObject("tipoCliente", cliente.getTipoClienteString());
			return mv;			
		}
		
	}

	@RequestMapping("/listarProdutos")
	public ModelAndView listarProdutos(Cliente cliente, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("produto/listar-produtos");
		List<Produto> listaProduto = ProdutoDAO.getInstance().listProduto();
		cliente = (Cliente) request.getSession().getAttribute("cliente");
		
		if(cliente==null) {
			mv.addObject("tipoCliente", TipoCliente.EXTERNO);			
			mv.addObject("listaProduto", listaProduto);
			return mv;
			
		} else {
			mv.addObject("cliente", cliente);
			mv.addObject("listaProduto", listaProduto);
			mv.addObject("tipoCliente", cliente.getTipoClienteString());
			return mv;			
		}
		
	}

	@RequestMapping("/deletarProduto")
	public ModelAndView deletarProduto(int idProduto, Cliente cliente, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("produto/sucesso-cadastro-produto");
		String message = "Produto Removido com Sucesso!";
		cliente = (Cliente) request.getSession().getAttribute("cliente");
		
		if(cliente==null) {
			mv.addObject("tipoCliente", TipoCliente.EXTERNO);			
			return mv;
			
		} else {
			ProdutoDAO.getInstance().removeById(idProduto);
			mv.addObject("message", message);
			mv.addObject("cliente", cliente);
			mv.addObject("tipoCliente", cliente.getTipoClienteString());
			return mv;			
		}
	}

	@RequestMapping("/buscarProdutoPelaMarca")
	public ModelAndView buscarProdutoPelaMarca(String marca, Cliente cliente, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("index");
		List<Produto> listaProduto = ProdutoDAO.getInstance().getByMarca(marca);
		cliente = (Cliente) request.getSession().getAttribute("cliente");
		
		if(cliente==null) {
			mv.addObject("tipoCliente", TipoCliente.EXTERNO);			
			mv.addObject("listaProduto", listaProduto);
			return mv;
			
		} else {
			mv.addObject("cliente", cliente);
			mv.addObject("listaProduto", listaProduto);
			mv.addObject("tipoCliente", cliente.getTipoClienteString());
			return mv;			
		}
	}
}
