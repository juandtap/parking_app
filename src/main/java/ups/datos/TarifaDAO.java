package ups.datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.modelo.Tarifa;

@Stateless
public class TarifaDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@PersistenceContext
	EntityManager em;
	
	public void create(Tarifa tarifa){
		em.persist(tarifa);
	}
	
	public void update(Tarifa tarifa){
		em.merge(tarifa);
	}
	
	public Tarifa getById(int id) {
		Tarifa tarifa = em.find(Tarifa.class, id);
		return tarifa;
	}
	
	public void delete(int id) {
		Tarifa tarifa = em.find(Tarifa.class, id);
		em.remove(tarifa);
	}
	
	public List<Tarifa> getAll()  {
		String jpql = "SELECT t FROM Tarifa t";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
}
