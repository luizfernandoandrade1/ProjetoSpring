package br.com.granbery.tigershoes.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.granbery.tigershoes.dao.ClienteDAO;
import br.com.granbery.tigershoes.dao.PedidoDAO;
import br.com.granbery.tigershoes.dao.ProdutoDAO;
import br.com.granbery.tigershoes.model.Cliente;
import br.com.granbery.tigershoes.model.Item;
import br.com.granbery.tigershoes.model.Pedido;
import br.com.granbery.tigershoes.model.Produto;

public class TestePedido {

	
	@Test
	public void persistPedido(){
		Produto produto = new Produto();
		produto = ProdutoDAO.getInstance().getById(1);
		
		Cliente cliente = new Cliente();
		
		cliente = ClienteDAO.getInstance().getById(1);
		
		Item item = new Item();
		List<Item> itens = new ArrayList<>();
		
		item.setProduto(produto);
		item.setQuantidade(5);
		
		itens.add(item);
		itens.add(item);
		
		Pedido pedido = new Pedido();
		pedido.setData(Calendar.getInstance());
		pedido.setItens(itens);
		pedido.setCliente(cliente);
		
		item.setPedido(pedido);
		
		
		Assert.assertTrue(PedidoDAO.getInstace().persistPedido(pedido));
		
	}
}
