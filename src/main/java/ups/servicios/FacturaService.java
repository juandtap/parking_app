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
import ups.modelo.Factura;
import ups.modelo.Vehiculo;
import ups.negocio.GestionFactura;
import ups.utils.Codigos;
import ups.utils.Mensajes;

@Path("parking")
public class FacturaService {
	
	@Inject
	private GestionFactura gestionFactura;

	@GET
	@Path("facturas")
	@Produces("application/json")
	public List<Factura> getAll() throws Exception{
		try {
			return this.gestionFactura.getAll();
		} catch (Exception e) {
			System.out.println("Error en servicio GET"+e.getMessage());
			var error = new Error();
			error.setCodigo(Codigos.ERROR_GET_CODE);
			error.setMensaje(Mensajes.ERROR_GET_MESSAGE+" : "+e.getMessage());
			throw new Exception(error+" :"+e.getMessage());
		}
		
	}
	
	@GET
	@Path("buscarfactura/{id}")
	@Produces("application/json")
	public Factura getbyId(@PathParam("id") int id) throws Exception{
		try {
			
			return this.gestionFactura.findById(id);
			
		} catch (Exception e) {
			
			System.out.println("Error en servicio GET: objeto no econtrado "+e.getMessage());
			var error = new Error();
			error.setCodigo(Codigos.ERROR_NOT_FOUND_CODE);
			error.setMensaje(Mensajes.ERROR_NOT_FOUND_MESSAGE+" : "+e.getMessage());
			throw new Exception(error+" :"+e.getMessage());
		}
	}
	
	@POST
	@Path("nuevafactura")
	@Produces("application/json")
	@Consumes("application/json")
	public Response save(Factura factura) {
		System.out.println("Servicio POST: "+factura.toString());
		try {
			this.gestionFactura.save(factura);
			return Response.status(Response.Status.OK).entity(factura).build();
			
		} catch (Exception e) {
			System.out.println("Error en servicio POST: "+e.getMessage());
			var error = new Error();
			error.setCodigo(Codigos.ERROR_POST_CODE);
			error.setMensaje(Mensajes.ERROR_POST_MESSAGE+" : "+e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
		
	}
	
	@PUT
	@Path("actualizarfactura")
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(Factura factura) {
		System.out.println("Servicio PUT: "+factura.toString());
		try {
			Factura facturaToEdit = this.gestionFactura.findById(factura.getId());
			if (facturaToEdit == null) {
				var error = new Error()	;
				error.setCodigo(Codigos.ERROR_NOT_FOUND_CODE);
				error.setMensaje(Mensajes.ERROR_NOT_FOUND_MESSAGE);
				return Response.status(Response.Status.NOT_FOUND).entity(error).build();	
				
			}
			
			System.out.println("id factura encontrada");
			
			
			
			this.gestionFactura.update(facturaToEdit);
			
			return Response.status(Response.Status.OK).entity(facturaToEdit).build();
			
			
		} catch (Exception e) {
			System.out.println("Error en servicio PUT: " + e.getMessage());
	        var error = new Error();
	        error.setCodigo(Codigos.ERROR_PUT_CODE);
	        error.setMensaje(Mensajes.ERROR_PUT_MESSAGE+": " + e.getMessage());
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
		}
	}
	
	@DELETE
	@Path("eliminarfactura/{id}")
	public Response delete(@PathParam("id") int id) {
		
		try {
			this.gestionFactura.delete(id);
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
