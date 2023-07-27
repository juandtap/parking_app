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
		if (tarifa.getTipoTarifa().equals("")) {
			throw new Exception("Tipo de tarifa vacio !");
		} else {
			System.out.println("Se crea nueva tarifa.");
			
			this.tarifaDAO.create(tarifa);
			
		}
	}
	
	public List<Tarifa> getAll()  throws Exception{
		
		return tarifaDAO.getAll();
		

	}
	
	public void update(Tarifa tarifa) throws Exception{
		
		System.out.println("Se actualiza la tarifa.");
		this.tarifaDAO.update(tarifa);
		
		
	}
	
	public Tarifa findById(int id) throws Exception{
		
		return this.tarifaDAO.getById(id);
		
	}
}
