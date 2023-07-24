package ups.servicios;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import ups.modelo.Ticket;
import ups.negocio.GestionTicket;

@Path("parking")
public class TicketService {

	
	
	@Inject
	private GestionTicket gestionTicket;
	
	
	@GET
	@Path("vehiculos")
	@Produces("application/json")
	public List<Ticket> getAll() throws Exception{
		return this.gestionTicket.getAll();
	}
	
}


