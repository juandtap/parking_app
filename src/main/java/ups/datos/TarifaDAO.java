package ups.datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.modelo.Tarifa;




@Stateless
public class TarifaDAO  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;

	
	public void insert(Tarifa tarifa) {
		em.persist(tarifa);
		
	}
	
	public void update(Tarifa tarifa) {
		em.merge(tarifa);
		
	}
	
	public Tarifa getById(int id) {
		Tarifa t = em.find(Tarifa.class,id);
		return t;
	}
	
	
	
	public void delete(int id) {
		Tarifa t = em.find(Tarifa.class,id);
		em.remove(t);
	}
	
	public List<Tarifa> getAll(){
		String jpql = "SELECT t FROM Tarifa t";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
	
}
