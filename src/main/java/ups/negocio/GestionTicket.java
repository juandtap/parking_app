package ups.negocio;

import java.time.LocalDateTime;
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
		
		if (ticket == null) {
			throw new Exception("Ticket vacio !");
		} else {
			System.out.println("Se crea nuevo Ticket.");

			try {
				
				ticket.setEstadoSalida(false);
				ticket.setHoraEntrada(getHoraEntrada());

				this.ticketDAO.create(ticket);
			} catch (Exception e) {
				throw new Exception("Error al crear nuevo Ticket: " + e.getMessage());
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
	
	public void update(Ticket ticket) throws Exception{
		
		System.out.println("Se actualiza  ticket.");
		try {
			this.ticketDAO.update(ticket);
		} catch (Exception e) {
			throw new Exception("Error al actualizar ticket: "+e.getMessage());
		}
		
		
		
	}
	
	
	public Ticket findById(int id) throws Exception{
		System.out.println("Se busca ticket: "+id);
		try {
			return this.ticketDAO.getById(id);
		} catch (Exception e) {
			throw new Exception("Error al encontrar ticket: "+id+", "+e.getMessage());
		}
	}
	
	public void delete(int id) throws Exception{
		System.out.println("Se elimina ticket: "+id);
		try {
			this.ticketDAO.delete(id);
		} catch (Exception e) {
			throw new Exception("Error al eliminar ticket: "+id+", "+e.getMessage());
			
		}
	}
	
	
	public LocalDateTime getHoraEntrada() {
		return LocalDateTime.now();
	}
	
	

}
