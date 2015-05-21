package br.com.granbery.tigershoes.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.granbery.tigershoes.model.Fornecedor;
import br.com.granbery.tigershoes.util.JPAUtil;

public class FornecedorDAO implements AbstractDAO {
	private static FornecedorDAO instance = new FornecedorDAO();
	
	public static FornecedorDAO getInstance() {
		if (instance == null){
			instance = new FornecedorDAO();
		}
		return instance;
	}
	
	private FornecedorDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private EntityManager em = JPAUtil.getEntityManager();
	
	@Override
	public boolean persist(Object fornecedor) {

		try{
			em.getTransaction().begin();
			em.persist(fornecedor);
			em.getTransaction().commit();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;		
		}
	}
	
	public Fornecedor getById(final int i) {
        Fornecedor fornecedor = em.find(Fornecedor.class, i); 
        return fornecedor;
    }
	
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listFornecedor(){
		List<Fornecedor> fornecedores;
		fornecedores = em.createQuery("FROM Fornecedor").getResultList(); 
		return fornecedores;
	}
	

	public void merge(Fornecedor fornecedor) {

		try {
			em.getTransaction().begin();
            em.merge(fornecedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
	
	public void remove(Fornecedor fornecedor) {

		try {
			em.getTransaction().begin();
            fornecedor = em.find(Fornecedor.class, fornecedor.getId());
            em.remove(fornecedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
	public void removeById(final int id) {
        
		try {
			em.getTransaction().begin();
            Fornecedor fornecedor = getById(id);
            remove(fornecedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
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
