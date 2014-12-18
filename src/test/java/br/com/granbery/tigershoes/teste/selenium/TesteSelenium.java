package br.com.granbery.tigershoes.teste.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class TesteSelenium {

	private WebDriver driver = new FirefoxDriver();
	
	
	public void digitarValor(String id,String valor){
		driver.findElement(By.id(id));
	}
	
	public void abrirTela(){
		driver.get("http://localhost:8080/TigerShoes/index");
	}
	public void abrirLink(String link){
		driver.get(link);
	}
	
	public void clicar(String id) {
		driver.findElement(By.id(id)).click();
	}
	public void clicarMenu(String menu){
		driver.findElement(By.className(menu)).click();
	}
	public void digitar(String texto, String id){
		driver.findElement(By.id(id)).sendKeys(texto);
	}
	
	
	
}
