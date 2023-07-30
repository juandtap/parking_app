package ups.negocio;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.datos.TarifaDAO;
import ups.modelo.Tarifa;

@Stateless
public class GestionTarifa {
	
	@Inject
	private TarifaDAO tarifaDAO;
	
	public void save(Tarifa tarifa) throws Exception{
		if (tarifa.getTarifa().equals("")) {
			throw new Exception("Nombre de tarifa vacio !");
		} else {
			System.out.println("Se crea nueva tarifa.");
			try {
				this.tarifaDAO.create(tarifa);
			} catch (Exception e) {
				throw new Exception("Error al crear tarifa: "+e.getMessage());
			}
			
			
		}
	}
	
	public List<Tarifa> getAll()  throws Exception{
		
		try {
			return tarifaDAO.getAll();
		} catch (Exception e) {
			throw new Exception("Error al recuperar tarifas: "+e.getMessage());
		}
		
		
		

	}
	
	public void update(Tarifa tarifa) throws Exception{
		
		System.out.println("Se actualiza la tarifa.");
		try {
			this.tarifaDAO.update(tarifa);
		} catch (Exception e) {
			throw new Exception("Error al actualizar tarifa: "+e.getMessage());
		}
		
		
		
	}
	
	public Tarifa findById(int id) throws Exception{
		System.out.println("Se busca tarifa "+id);
		try {
			return this.tarifaDAO.getById(id);
		} catch (Exception e) {
			throw new Exception("Error al encontrar tarifa: "+id+", "+e.getMessage());
		}
		
		
	}
	
	public void delete(int id )throws Exception {
		System.out.println("Se elimina tarifa: "+id);
		try {
		this.tarifaDAO.delete(id);
			
		} catch (Exception e) {
			throw new Exception("Error al eliminar tarifa: "+id+", "+e.getMessage());
		}
		
	}
}
