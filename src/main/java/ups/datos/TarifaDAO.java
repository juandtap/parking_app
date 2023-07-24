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
	
	public void create(Tarifa tarifa) throws Exception{
		em.persist(tarifa);
	}
	
	public List<Tarifa> getAll() throws Exception {
		String jpql = "SELECT t FROM Tarifa t";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
}
