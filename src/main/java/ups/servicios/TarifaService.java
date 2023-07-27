package ups.servicios;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
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
		try {
			return this.gestionTarifa.getAll();
		} catch (Exception e) {
			System.out.println("Error en servicio GET tarifa");
			throw new Exception(e.getMessage());
		}
		
	}
	
	@POST
	@Path("nuevatarifa")
	@Produces("application/json")
	@Consumes("application/json")
	public Response save(Tarifa tarifa) {
		System.out.println("Servicio POST: "+tarifa.toString());
		try {
			this.gestionTarifa.save(tarifa);
			return Response.status(Response.Status.OK).entity(tarifa).build();
		} catch (Exception e) {
			System.out.println("Error en servicio POST: "+e.getMessage());
			var error = new Error();
			error.setCodigo(91);
			error.setMensaje("Error al crear Tarifa: "+e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
		
	}
	
	
	
	@PUT
	@Path("actualizartarifa")
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(Tarifa tarifa) {
		 System.out.println("Servicio PUT: " + tarifa.toString());
		 try {
			Tarifa tarifaToEdit = this.gestionTarifa.findById(tarifa.getId());
			if (tarifaToEdit == null) {
				var error = new Error();
				error.setCodigo(90);
				error.setMensaje("Id de objeto no existe: ");
				return Response.status(Response.Status.NOT_FOUND).entity(error).build();
			}
			
			System.out.println("Id tarifa encontrado");
			
			tarifaToEdit.setTipoTarifa(tarifa.getTipoTarifa());
			tarifaToEdit.setPrecioHora(tarifa.getPrecioHora());
			tarifaToEdit.setDescripcion(tarifa.getDescripcion());
			
			this.gestionTarifa.update(tarifaToEdit);
			
			return Response.status(Response.Status.OK).entity(tarifaToEdit).build();
			
			
		} catch (Exception e) {
			
			System.out.println("Error en servicio PUT: " + e.getMessage());
	        var error = new Error();
	        error.setCodigo(92);
	        error.setMensaje("Error al actualizar la tarifa: " + e.getMessage());
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
			
		}
	}
	
}
