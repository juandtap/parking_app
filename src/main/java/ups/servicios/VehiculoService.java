package ups.servicios;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import ups.modelo.Vehiculo;
import ups.negocio.GestionVehiculo;
import ups.utils.Codigos;
import ups.utils.Mensajes;

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
			System.out.println("Error en servicio GET"+e.getMessage());
			var error = new Error();
			error.setCodigo(Codigos.ERROR_GET_CODE);
			error.setMensaje(Mensajes.ERROR_GET_MESSAGE+" : "+e.getMessage());
			throw new Exception(error+" :"+e.getMessage());
		}
		
	}
	
	@GET
	@Path("buscarvehiculo/{placa}")
	@Produces("application/json")
	public Vehiculo getbyId(@PathParam("placa") String placa) throws Exception{
		try {
			
			return this.gestionVehiculo.findById(placa);
			
		} catch (Exception e) {
			
			System.out.println("Error en servicio GET: objeto no econtrado "+e.getMessage());
			var error = new Error();
			error.setCodigo(Codigos.ERROR_NOT_FOUND_CODE);
			error.setMensaje(Mensajes.ERROR_NOT_FOUND_MESSAGE+" : "+e.getMessage());
			throw new Exception(error+" :"+e.getMessage());
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
			error.setCodigo(Codigos.ERROR_POST_CODE);
			error.setMensaje(Mensajes.ERROR_POST_MESSAGE+" : "+e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
		
	}
	
	@PUT
	@Path("actualizarvehiculo")
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(Vehiculo vehiculo) {
		System.out.println("Servicio PUT: "+vehiculo.toString());
		try {
			Vehiculo vehiculoToEdit = this.gestionVehiculo.findById(vehiculo.getPlaca());
			if (vehiculoToEdit == null) {
				var error = new Error()	;
				error.setCodigo(Codigos.ERROR_NOT_FOUND_CODE);
				error.setMensaje(Mensajes.ERROR_NOT_FOUND_MESSAGE);
				return Response.status(Response.Status.NOT_FOUND).entity(error).build();	
				
			}
			
			System.out.println("Placa vehiculo encontrada");
			
			vehiculoToEdit.setPlaca(vehiculo.getPlaca());
			vehiculoToEdit.setMarca(vehiculo.getMarca());
			vehiculoToEdit.setColor(vehiculo.getColor());
			vehiculoToEdit.setDescripcion(vehiculo.getDescripcion());
			vehiculoToEdit.setCedula(vehiculo.getCedula());
			vehiculoToEdit.setNombre(vehiculo.getNombre());
			
			return Response.status(Response.Status.NOT_FOUND).entity(vehiculoToEdit).build();
			
			
		} catch (Exception e) {
			System.out.println("Error en servicio PUT: " + e.getMessage());
	        var error = new Error();
	        error.setCodigo(Codigos.ERROR_PUT_CODE);
	        error.setMensaje(Mensajes.ERROR_PUT_MESSAGE+": " + e.getMessage());
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
		}
	}
	
	@DELETE
	@Path("eliminarvehiculo/{placa}")
	public Response delete(@PathParam("placa") String placa) {
		
		try {
			this.gestionVehiculo.delete(placa);
			return Response.status(Response.Status.OK).build();
			
		} catch (Exception e) {
			System.out.println("Error en servicio DELETE: " + e.getMessage());
	        var error = new Error();
	        error.setCodigo(Codigos.ERROR_DELETE_CODE);
	        error.setMensaje(Mensajes.ERROR_DELETE_MESSAGE+": " + e.getMessage());
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
		}
	}
	
	
	
	

}
