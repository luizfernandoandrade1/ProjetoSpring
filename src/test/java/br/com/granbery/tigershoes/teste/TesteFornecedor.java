package br.com.granbery.tigershoes.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.granbery.tigershoes.dao.FornecedorDAO;
import br.com.granbery.tigershoes.model.Endereco;
import br.com.granbery.tigershoes.model.Fornecedor;

public class TesteFornecedor {

	@Test
	public void persistirFornecedor(){
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("OnlineShoes");
		
		Endereco endereco = new Endereco();
		endereco.setRua("BR - 040");
		endereco.setCidade("Juiz de Fora");
		endereco.setEstado("Minas Gerais");
		endereco.setPais("Brasil");
		endereco.setCep("36055123");
		
		fornecedor.setEndereco(endereco);
		
		Assert.assertTrue(FornecedorDAO.getInstance().persist(fornecedor));
	}
}
