package br.com.granbery.tigershoes.enums;

public enum FaixaSalarial {
	
	Pobre("Pobre", 700),
	ClasseMediaBaixa("Classe Media Baixa", 1.540),
	ClasseMedia("Classe Media", 1.925),
	ClasseMediaAlta("Classe Media Alta", 2.813),
	ClasseAltaBaixa("Classe Alta Baixa", 4.845),
	ClasseAlta("Classe Alta", 12.988);
	
	private double valor;
	private String faixa;
	
	private FaixaSalarial(String nome, double valor) {
		this.faixa = nome;
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getNome() {
		return faixa;
	}
	public void setNome(String nome) {
		this.faixa = nome;
	}

}
