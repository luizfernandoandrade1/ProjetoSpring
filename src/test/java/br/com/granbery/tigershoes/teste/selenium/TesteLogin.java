package br.com.granbery.tigershoes.teste.selenium;

import junit.framework.Assert;

import org.junit.Test;

public class TesteLogin extends TesteSelenium {

	
	@Test
	public void testarClienteValidoComItem(){
		abrirTela();
		clicar("btn_comprar");
		clicar("btn_add");
		clicar("btn_continuar_compras");
		abrirLink("http://localhost:8080/TigerShoes/listaProdutosCarrinho");
		digitar("1", "txt_quantidade");
		clicar("btn_finalizar");
		digitar("teste@teste.com", "txt_email");
		digitar("123", "txt_senha");
		clicar("btn_entrar");
		Assert.assertEquals("Olá, Fulano de Tal", capturarTexto("cmb_login"));
		finalizarFirefox();
	}
	
	@Test
	public void testarClienteValido(){
		abrirTela();
		clicar("cmb_login");
		clicar("opt_entrar");
		digitar("teste@teste.com", "txt_email");
		digitar("123", "txt_senha");
		clicar("btn_entrar");
		Assert.assertEquals("Olá, Fulano de Tal", capturarTexto("cmb_login"));
		finalizarFirefox();
	}
	@Test
	public void testarClienteInvalido(){
		abrirTela();
		clicar("cmb_login");
		clicar("opt_entrar");
		digitar("teste@teste.com.br", "txt_email");
		digitar("123", "txt_senha");
		clicar("btn_entrar");
		Assert.assertEquals("Usuário ou Senha Invalidos!", capturarTexto("err_login"));
		finalizarFirefox();
	}
}
