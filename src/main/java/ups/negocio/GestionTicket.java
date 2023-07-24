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
		
		if (ticket.getId() == 0 ) {
			throw new Exception("Ticket no existe !");
		} else {
			System.out.println("Se inserta nuevo Ticket.");
			
			try {
				
				this.ticketDAO.insert(ticket);
			} catch (Exception e) {
				throw new Exception("Error al insertar nueva Tarifa: "+e.getMessage());
			}
		}
	}
	
	
	
	
	public List<Ticket> getAll()  throws Exception{
		
		try {
			return ticketDAO.getAll();
		} catch (Exception e) {
			throw new Exception("Error al recuperar Tarifas de la base de datos: "+e.getMessage());
			
		}
		
		
		
	}

}
