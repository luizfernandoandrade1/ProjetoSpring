package br.com.granbery.tigershoes.teste;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.granbery.tigershoes.dao.FornecedorDAO;
import br.com.granbery.tigershoes.dao.ProdutoDAO;
import br.com.granbery.tigershoes.enums.EstadoProduto;
import br.com.granbery.tigershoes.model.Fornecedor;
import br.com.granbery.tigershoes.model.Produto;

public class TesteProduto {

	@Test
	public void persistirProduto(){
		Fornecedor fornecedor = new Fornecedor();
		fornecedor = FornecedorDAO.getInstance().getById(2);
		Produto produto = new Produto();
		produto.setMarca("Nike Mercurial");
		produto.setModelo("Chuteira");
		produto.setEstadoProduto(EstadoProduto.INATIVO);
		produto.setCaminhoImagem("http://img.kstatic.com.br/p/Ride---Kanui-TC3AAnis-Ride---Kanui-Stale-Fish-Special-7558-08689-1-zoom.jpg");
		produto.setNumero("43");
		produto.setPreco(250.00);
		produto.setFornecedor(fornecedor);
		Assert.assertTrue(ProdutoDAO.getInstance().persist(produto));
	}
	
	@Test
	public void findProdutoByMarca(){
		List<Produto> produtos = new ArrayList<Produto>(); 
		produtos = ProdutoDAO.getInstance().getByMarca("Nike");
		
		Assert.assertTrue(produtos.size()>0);
	}
}

