package br.com.granbery.tigershoes.controller;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.granbery.tigershoes.dao.PedidoDAO;
import br.com.granbery.tigershoes.dao.ProdutoDAO;
import br.com.granbery.tigershoes.enums.TipoCliente;
import br.com.granbery.tigershoes.model.Cliente;
import br.com.granbery.tigershoes.model.Item;
import br.com.granbery.tigershoes.model.Pedido;
import br.com.granbery.tigershoes.model.Produto;

@Controller
public class CarrinhoController {

	@RequestMapping("/adicionarProdutoCarrinho")
	public String adicionarProdutoCarrinho(int idProduto, HttpServletRequest request, HttpSession session) {
		Produto produto = ProdutoDAO.getInstance().getById(idProduto);
		Item item = new Item();
		
		item.setProduto(produto);
		
		
		if (request.getSession().getAttribute("carrinho") == null) {
			session.setAttribute("carrinho", new ArrayList<Item>());
		}
		
		((ArrayList<Item>) request.getSession().getAttribute("carrinho")).add(item);
		
		return "carrinho/sucesso-adicionado-carrinho";
	}
	
	@RequestMapping("/listaProdutosCarrinho")
	public ModelAndView listaProdutosCarrinho(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("carrinho/listar-produtos-carrinho");
		
		ArrayList<Item> listaItens = (ArrayList<Item>) request.getSession().getAttribute("carrinho");
	
		Pedido pedido = new Pedido();
		pedido.setItens(listaItens);
		mv.addObject("pedido", pedido);
		
		return mv;
	}
	
	@RequestMapping(value = "/executarCompra", method = RequestMethod.POST)
	public ModelAndView executarCompra(@ModelAttribute("itensForm") Pedido pedidoForm, HttpServletRequest request, Cliente cliente) {
		ModelAndView mv;
		ArrayList<Item> listaItens = (ArrayList<Item>) request.getSession().getAttribute("carrinho");
		
		cliente = (Cliente) request.getSession().getAttribute("cliente");
		
		for (Item itemSessao : listaItens) {
			for (Item pedido : pedidoForm.getItens()) {
				if(itemSessao.getProduto().getId() == pedido.getProduto().getId()) {
					itemSessao.setQuantidade(pedido.getQuantidade());
				}
			}			
		}
		
		if(cliente==null) {
			mv = new ModelAndView("cliente/login-cliente");
			mv.addObject("tipoCliente", TipoCliente.EXTERNO);
			return mv;
			
		} else {
			mv = new ModelAndView("pedido/sucesso-pedido");
			mv.addObject("cliente", cliente);
			mv.addObject("tipoCliente", cliente.getTipoClienteString());
			pedidoForm.setCliente(cliente);
			pedidoForm.setData(Calendar.getInstance());
			
			for (Item pedidoItem : pedidoForm.getItens()) {
				pedidoItem.setPedido(pedidoForm);
			}
			
			PedidoDAO.getInstace().persistPedido(pedidoForm);
			
			return mv;
			
		}
		
	}
}
