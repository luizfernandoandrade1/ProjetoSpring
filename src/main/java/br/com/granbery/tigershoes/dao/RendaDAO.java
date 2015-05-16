package br.com.granbery.tigershoes.dao;

import javax.persistence.EntityManager;

import br.com.granbery.tigershoes.model.Renda;
import br.com.granbery.tigershoes.util.JPAUtil;

public class RendaDAO {
	
	private static RendaDAO instance = new RendaDAO();
	
	public static RendaDAO getInstance() {
		if (instance == null){
			instance = new RendaDAO();
		}
		return instance;
	}
	
	private EntityManager em = JPAUtil.getEntityManager();
	
	public boolean persistRenda(Renda renda) {
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
}
