package ups.datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.modelo.Ticket;



@Stateless
public class TicketDAO  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	@PersistenceContext
	private EntityManager em;
 
	
	public void insert(Ticket ticket) {
		em.persist(ticket);
	}
	
	public void update(Ticket ticket) {
		em.merge(ticket);
	}
	
	public Ticket getById(int id) {
		Ticket t = em.find(Ticket.class,id);
		return t;
	}
	
	public void delete(int id) {
		Ticket t = em.find(Ticket.class,id);
		em.remove(t);
	}
	
	public List<Ticket> getAll(){
		String jpql = "SELECT t FROM Ticket t";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
	
	
	
}
