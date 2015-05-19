package br.com.granbery.tigershoes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.granbery.tigershoes.model.Cliente;
import br.com.granbery.tigershoes.util.JPAUtil;


public class ClienteDAO implements AbstractDAO {
	
	private static ClienteDAO instance = new ClienteDAO();
	
	public static ClienteDAO getInstance() {
		if (instance == null){
			instance = new ClienteDAO();
		}
		
		return instance;		
	}
	
	private ClienteDAO() {
		// TODO Auto-generated constructor stub
	}

	private EntityManager em = JPAUtil.getEntityManager();
	
	
	public boolean persistCliente(Cliente cliente) {

		try{
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
				
	}
	
	public Cliente getById(final int id) {
		Cliente cliente = em.find(Cliente.class, id);
		return cliente;
    }
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listaCliente(Object object){
		List<Cliente> clientes;
		clientes = em.createQuery("FROM" +Cliente.class.getName()).getResultList();
		return clientes;
	}
	
	//Faz update do cliente
	public void merge(Cliente cliente) {

		try {
			em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
	
	public void remove(Cliente cliente) {

		try {
			em.getTransaction().begin();
            cliente = em.find(Cliente.class, cliente.getId());
            em.remove(cliente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
	public void removeById(final int id) {

		try {
			em.getTransaction().begin();
            Cliente cliente = getById(id);
            remove(cliente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
	
	public Cliente recuperarCliente(Cliente cliente) {
		Query hql = em.createQuery("from Cliente c where c.email = :email and c.senha = :senha");
		hql.setParameter("email", cliente.getEmail());
		hql.setParameter("senha", cliente.getSenha());
		
		try {
			return (Cliente) hql.getSingleResult();			
		} catch (Exception e) {
			return null;
		}
				
	}
	
}
