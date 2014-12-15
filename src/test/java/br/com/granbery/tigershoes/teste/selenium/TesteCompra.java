package br.com.granbery.tigershoes.teste.selenium;

import org.junit.Test;

public class TesteCompra extends TesteSelenium{

	@Test
	public void iniciar(){
		abrirTela();
		clicar("btn_comprar");
		clicar("btn_add");
		clicar("btn_continuar_compras");
	}
}
