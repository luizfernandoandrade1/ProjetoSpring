package br.com.granbery.tigershoes.dao;

import javax.persistence.EntityManager;

import br.com.granbery.tigershoes.util.JPAUtil;

public class RendaDAO implements AbstractDAO{
	
	private static RendaDAO instance = new RendaDAO();
	
	public static RendaDAO getInstance() {
		if (instance == null){
			instance = new RendaDAO();
		}
		return instance;
	}
	
	private EntityManager em = JPAUtil.getEntityManager();
	
	@Override
	public boolean persist(Object renda) {
		try{
			em.getTransaction().begin();
			em.persist(renda);
			em.getTransaction().commit();				
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			em.getTransaction().rollback();					
			return false;	
		}
			
	}

	@Override
	public Object recuperarObjeto(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean recuperarPorEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}
}
