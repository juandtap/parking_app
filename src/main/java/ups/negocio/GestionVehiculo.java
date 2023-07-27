package ups.negocio;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.datos.VehiculoDAO;
import ups.modelo.Vehiculo;

@Stateless
public class GestionVehiculo {
	
	@Inject
	private VehiculoDAO vehiculoDAO;
	
	
	public void save (Vehiculo vehiculo)throws Exception{
		
		if (vehiculo.getPlaca().equals("")) {
			throw new Exception("Vehiculo sin placa!");
		} else {
			System.out.println("Se crea nuevo Vehiculo.");
			
			try {
				this.vehiculoDAO.create(vehiculo);
			} catch (Exception e) {
				
				throw new Exception("Error al crear nuevo Vehiculo: "+e.getMessage());
			}

		}
	
	}
	
	
	public List<Vehiculo> getAll()  throws Exception{
		
		try {
			return vehiculoDAO.getAll();
		} catch (Exception e) {
			throw new Exception("Error al recuperar Vehiculos de la base de datos: "+e.getMessage());
			
		}
		
		
		
	}

}
