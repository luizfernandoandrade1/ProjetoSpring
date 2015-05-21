package br.com.granbery.tigershoes.dao;

public interface AbstractDAO {

	public Object recuperarObjeto(Object object);
	public boolean persist(Object object);
	boolean recuperarPorEmail(String email);
}
