package ups.servicios;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import ups.modelo.Vehiculo;
import ups.negocio.GestionVehiculo;

@Path("parking")
public class VehiculoService {
	
	@Inject
	private GestionVehiculo gestionVehiculo;
	
	@GET
	@Path("vehiculos")
	@Produces("application/json")
	public List<Vehiculo> getAll() throws Exception{
		try {
			return this.gestionVehiculo.getAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	
	
	@POST
	@Path("nuevovehiculo")
	@Produces("application/json")
	@Consumes("application/json")
	public Response save(Vehiculo vehiculo) {
		System.out.println("Servicio POST: "+vehiculo.toString());
		try {
			gestionVehiculo.save(vehiculo);
			return Response.status(Response.Status.OK).entity(vehiculo).build();
			
		} catch (Exception e) {
			System.out.println("Error en servicio POST: "+e.getMessage());
			var error = new Error();
			error.setCodigo(91);
			error.setMensaje(e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
		
	}
	
	
	
	

}
