package ups.negocio;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.datos.TicketDAO;
import ups.modelo.Ticket;

@Stateless
public class GestionTicket {
	
	@Inject
	private TicketDAO ticketDAO;
	
	
	public void save( Ticket ticket) throws Exception {
		
		if (ticket.getId() == 0) {
			throw new Exception("Ticket vacio !");
		} else {
			System.out.println("Se crea nuevo Ticket.");

			try {

				this.ticketDAO.create(ticket);
			} catch (Exception e) {
				throw new Exception("Error al insertar nueva Ticket: " + e.getMessage());
			}
		}
	}
	
	
	
	
	public List<Ticket> getAll()  throws Exception{
		
		try {
			return ticketDAO.getAll();
		} catch (Exception e) {
			throw new Exception("Error al recuperar Tickets de la base de datos: "+e.getMessage());
			
		}
		
		
		
	}

}
