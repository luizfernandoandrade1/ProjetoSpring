package br.com.granbery.tigershoes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.granbery.tigershoes.model.Produto;
import br.com.granbery.tigershoes.util.JPAUtil;

public class ProdutoDAO {
	
	private static ProdutoDAO instance = new ProdutoDAO();
		
	public static ProdutoDAO getInstance() {
		if (instance == null){
			instance = new ProdutoDAO();
		}
		return instance;
	}
	
	private ProdutoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private EntityManager em = JPAUtil.getEntityManager();
	
	public boolean persistProduto(Produto produto) {
		try{
			em.getTransaction().begin();
			em.persist(produto);
			em.getTransaction().commit();				
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			em.getTransaction().rollback();					
			return false;	
		}
			
	}
	
	public Produto getById(final int id) {
		Produto produto = em.find(Produto.class, id); 
		return produto;
    }
	
	public List<Produto> getByMarca(String marca){

		Query query = em.createQuery("FROM Produto p WHERE p.marca like :marca");
		query.setParameter("marca", "%"+marca+"%");
		
		List resultList = query.getResultList();
		return (List<Produto>) resultList;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listProduto(){
		
		List<Produto> produtos;
		produtos = em.createQuery("FROM Produto").getResultList();
		return produtos;
	}
	

	public void merge(Produto produto) {

		try {
			em.getTransaction().begin();
            em.merge(produto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
	
	public void remove(Produto produto) {

		try {
			em.getTransaction().begin();
            produto = em.find(Produto.class, produto.getId());
            em.remove(produto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
	
	public void removeById(final int id) {
		
        try {
        	em.getTransaction().begin();
            Produto produto = getById(id);
            remove(produto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
	

}
