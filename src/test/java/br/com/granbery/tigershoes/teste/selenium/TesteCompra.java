package br.com.granbery.tigershoes.teste.selenium;

import org.junit.Test;

public class TesteCompra extends TesteSelenium{

	@Test
	public void iniciar(){
		abrirTela();
		clicar("btn_comprar");
		clicar("btn_add");
		clicar("btn_continuar_compras");
		abrirLink("http://localhost:8080/TigerShoes/listaProdutosCarrinho");
		digitar("5", "txt_quantidade");
		clicar("btn_finalizar");
		digitar("teste@teste.com", "txt_email");
		digitar("123", "txt_senha");
		clicar("btn_entrar");
		digitar("5", "txt_quantidade");
		clicar("btn_finalizar");
	}
}
