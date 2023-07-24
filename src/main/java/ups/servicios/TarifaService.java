package ups.servicios;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import ups.modelo.Tarifa;
import ups.negocio.GestionTarifa;

@Path("parking")
public class TarifaService {
	
	@Inject
	private GestionTarifa gestionTarifa;
	
	@GET
	@Path("tarifas")
	@Produces("application/json")
	public List<Tarifa> getAll() throws Exception{
		return this.gestionTarifa.getAll();
	}
	
	@POST
	@Path("nuevatarifa")
	@Produces("application/json")
	@Consumes("application/json")
	public Response save(Tarifa tarifa) {
		System.out.println("Servicio POST: "+tarifa.toString());
		try {
			gestionTarifa.save(tarifa);
			return Response.status(Response.Status.OK).entity(tarifa).build();
		} catch (Exception e) {
			System.out.println("Error en servicio POST: "+e.getMessage());
			var error = new Error();
			error.setCodigo(91);
			error.setMensaje(e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
		
	}
	
}
