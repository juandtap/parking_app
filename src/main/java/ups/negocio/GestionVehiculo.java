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
	
	public void update(Vehiculo vehiculo) throws Exception{
		
		System.out.println("Se actualiza la tarifa.");
		try {
			this.vehiculoDAO.update(vehiculo);
		} catch (Exception e) {
			throw new Exception("Error al actualizar vehiculo: "+e.getMessage());
		}
		
		
		
	}
	
	
	public Vehiculo findById(String placa) throws Exception{
		System.out.println("Se actualiza vehiculo: "+placa);
		try {
			return this.vehiculoDAO.getById(placa);
		} catch (Exception e) {
			throw new Exception("Error al encontrar vehiculo: "+placa+", "+e.getMessage());
		}
	}
	
	public void delete(String placa) throws Exception{
		System.out.println("Se elimina vehiculo: "+placa);
		try {
			this.vehiculoDAO.delete(placa);
		} catch (Exception e) {
			throw new Exception("Error al eliminar vehiculo: "+placa+", "+e.getMessage());
			
		}
	}

}
