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
import ups.modelo.Ticket;
import ups.negocio.GestionTicket;
import ups.utils.Codigos;
import ups.utils.Mensajes;

@Path("parking")
public class TicketService {

	
	
	@Inject
	private GestionTicket gestionTicket;
	
	
	@GET
	@Path("tickets")
	@Produces("application/json")
	public List<Ticket> getAll() throws Exception{
		try {
			return this.gestionTicket.getAll();
		} catch (Exception e) {
			System.out.println("Error en servicio GET"+e.getMessage());
			var error = new Error();
			error.setCodigo(Codigos.ERROR_GET_CODE);
			error.setMensaje(Mensajes.ERROR_GET_MESSAGE+" : "+e.getMessage());
			throw new Exception(error+" :"+e.getMessage());
		}
		
	}
	
	@GET
	@Path("buscarticket/{id}")
	@Produces("application/json")
	public Ticket getbyId(@PathParam("id") int id) throws Exception{
		try {
			
			return this.gestionTicket.findById(id);
			
		} catch (Exception e) {
			
			System.out.println("Error en servicio GET: objeto no econtrado "+e.getMessage());
			var error = new Error();
			error.setCodigo(Codigos.ERROR_NOT_FOUND_CODE);
			error.setMensaje(Mensajes.ERROR_NOT_FOUND_MESSAGE+" : "+e.getMessage());
			throw new Exception(error+" :"+e.getMessage());
		}
	}
	
	@POST
	@Path("nuevoticket")
	@Produces("application/json")
	@Consumes("application/json")
	public Response save(Ticket ticket) {
		System.out.println("Servicio POST: "+ticket.toString());
		try {
			this.gestionTicket.save(ticket);
			return Response.status(Response.Status.OK).entity(ticket).build();
			
		} catch (Exception e) {
			System.out.println("Error en servicio POST: "+e.getMessage());
			var error = new Error();
			error.setCodigo(Codigos.ERROR_POST_CODE);
			error.setMensaje(Mensajes.ERROR_POST_MESSAGE+" : "+e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
		
	}
	
	
	@PUT
	@Path("actualizarticket")
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(Ticket ticket) {
		System.out.println("Servicio PUT: "+ticket.toString());
		try {
			Ticket ticketToEdit = this.gestionTicket.findById(ticket.getId());
			if (ticketToEdit == null) {
				var error = new Error()	;
				error.setCodigo(Codigos.ERROR_NOT_FOUND_CODE);
				error.setMensaje(Mensajes.ERROR_NOT_FOUND_MESSAGE);
				return Response.status(Response.Status.NOT_FOUND).entity(error).build();	
				
			}
			
			System.out.println("Id ticket encontrado");
			
			// la hora y el tiempo se actualizan en GestionTicket
			
			
			this.gestionTicket.update(ticketToEdit);
			
			
			return Response.status(Response.Status.OK).entity(ticketToEdit).build();
			
			
		} catch (Exception e) {
			System.out.println("Error en servicio PUT: " + e.getMessage());
	        var error = new Error();
	        error.setCodigo(Codigos.ERROR_PUT_CODE);
	        error.setMensaje(Mensajes.ERROR_PUT_MESSAGE+": " + e.getMessage());
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
		}
	}
	
	
	//este servicio se lo llama cuando al momento de generar la factura se quiere 
	//agregar los datos del propietario del vehiculo
	@PUT
	@Path("actualizardatoscliente")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateDataClient(Ticket ticket) {
		System.out.println("Servicio PUT: "+ticket.toString());
		try {
			Ticket ticketToEdit = this.gestionTicket.findById(ticket.getId());
			if (ticketToEdit == null) {
				var error = new Error()	;
				error.setCodigo(Codigos.ERROR_NOT_FOUND_CODE);
				error.setMensaje(Mensajes.ERROR_NOT_FOUND_MESSAGE);
				return Response.status(Response.Status.NOT_FOUND).entity(error).build();	
				
			}
			
			System.out.println("Id ticket encontrado");
			
			ticketToEdit.setVehiculo(ticket.getVehiculo());
			
			
			this.gestionTicket.updateDataClient(ticketToEdit);
			
			
			return Response.status(Response.Status.OK).entity(ticketToEdit).build();
			
			
		} catch (Exception e) {
			System.out.println("Error en servicio PUT: " + e.getMessage());
	        var error = new Error();
	        error.setCodigo(Codigos.ERROR_PUT_CODE);
	        error.setMensaje(Mensajes.ERROR_PUT_MESSAGE+": " + e.getMessage());
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
		}
	}
	
	@DELETE
	@Path("eliminarticket/{id}")
	public Response delete(@PathParam("id") int id) {
		
		try {
			this.gestionTicket.delete(id);
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


