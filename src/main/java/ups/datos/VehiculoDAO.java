package ups.datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.modelo.Vehiculo;

@Stateless
public class VehiculoDAO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public void create(Vehiculo vehiculo) throws Exception{
		em.persist(vehiculo);
	}
	
	public void update(Vehiculo vehiculo) throws Exception{
		em.merge(vehiculo);
	}
	
	
	public Vehiculo getById(String placa) throws Exception{
		Vehiculo v = em.find(Vehiculo.class,placa);
		return v;
	}
	
	public void delete(String placa) throws Exception{
		Vehiculo v = em.find(Vehiculo.class,placa);
		em.remove(v);
	}
	
	public List<Vehiculo> getAll() throws Exception{
		String jpql = "SELECT v FROM Vehiculo v";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
	

}
