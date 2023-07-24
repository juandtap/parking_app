package ups.datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.modelo.Factura;


@Stateless
public class FacturaDAO implements Serializable {
	

	
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	
	
	
	public void insert(Factura factura) {
		em.persist(factura);
	}
	
	public void update(Factura factura) {
		em.merge(factura);
	}
	
	public Factura getById(int id) {
		Factura f = em.find(Factura.class,id);
		return f;
	}
	
	public void delete(int id) {
		Factura f = em.find(Factura.class,id);
		em.remove(f);
	}
	
	public List<Factura> getAll(){
		String jpql = "SELECT f FROM Factura f";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
	
	
}
