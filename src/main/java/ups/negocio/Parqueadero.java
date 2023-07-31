package ups.negocio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

// Clase para realizar las acciones en mas de una entidad
// haciendo solo una llamada a un servicio
// pendiente su uso

@Stateless
public class Parqueadero {
	
	@Inject
	private GestionTicket gestionTicket;
	
	@Inject
	private GestionVehiculo gestionVehiculo;
	
	// crea o actualizar el vehiculo y crea el ticket con la hora de entrada
	public void registrarVehiculo() {
		
	}
	
	
}
