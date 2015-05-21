package br.com.granbery.tigershoes.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.granbery.tigershoes.model.Pedido;
import br.com.granbery.tigershoes.util.JPAUtil;

public class PedidoDAO implements AbstractDAO {

	private static PedidoDAO instance = new PedidoDAO();
	
	public static PedidoDAO getInstace() {
		if (instance == null){
			instance = new PedidoDAO();
		}
		return instance;
	}
	
	private PedidoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private EntityManager em = JPAUtil.getEntityManager();
	
	@Override
	public boolean persist(Object pedido) {

		try{
			em.getTransaction().begin();
			em.persist(pedido);
			em.getTransaction().commit();
			return true;	
		}catch(Exception ex){
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;		
		}
	}
	
	public Pedido getById(final Long id) {
		Pedido pedido = em.find(Pedido.class, id); 
		return pedido;
    }
	
	@SuppressWarnings("unchecked")
	public List<Pedido> listPedido(Object object){		
		List<Pedido> pedidos;
		pedidos = em.createQuery("FROM" +Pedido.class.getName()).getResultList(); 
		return pedidos;
	}
	
	//Faz update do pedido
	public void merge(Pedido pedido) {

		try {
			em.getTransaction().begin();
            em.merge(pedido);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
	
	public void remove(Pedido pedido) {

		try {
			em.getTransaction().begin();
            pedido = em.find(Pedido.class, pedido.getId());
            em.remove(pedido);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
	
	public void removeById(final Long id) {

		try {
			em.getTransaction().begin();
            Pedido pedido = getById(id);
            remove(pedido);
        } catch (Exception ex) {
            ex.printStackTrace();
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
