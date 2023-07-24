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
			throw new Exception("Vehiculo no existe..!");
		} else {
			System.out.println("Se inserta nuevo Vehiculo.");
			
			try {
				this.vehiculoDAO.insert(vehiculo);
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("Error al insertar nueva Vehiculo: "+e.getMessage());
			}

		}
	
	}
	
	
	public List<Vehiculo> getAll()  throws Exception{
		
		try {
			return vehiculoDAO.getAll();
		} catch (Exception e) {
			throw new Exception("Error al recuperar Tarifas de la base de datos: "+e.getMessage());
			
		}
		
		
		
	}

}
