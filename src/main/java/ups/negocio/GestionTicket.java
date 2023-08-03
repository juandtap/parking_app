package ups.negocio;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
				ticket.setHoraEntrada(this.getHoraEntradaSalida());

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
	
	// metodo para registrar la hora de salida y el tiempo
	public void update(Ticket ticket) throws Exception{
		
		System.out.println("Se actualiza ticket con la hora de Salida, tiempo de parqueo y estado");
		try {
			// 
			
			ticket.setHoraSalida(this.getHoraEntradaSalida());
			ticket.setTiempoParqueo(this.getTiempoParqueo(ticket.getHoraEntrada(), ticket.getHoraSalida()));
			ticket.setEstadoSalida(true);
			this.ticketDAO.update(ticket);
		} catch (Exception e) {
			throw new Exception("Error al actualizar ticket: "+e.getMessage());
		}
		
		
		
	}
	
	// este metodo se utiliza si se quiere actualizar la info del vehiculo, como los datos del propietario
	public void updateDataClient(Ticket ticket) throws Exception{
		
		System.out.println("Se actualiza ticket con la informacion del propietario del vehiculo");
		try {
			// lo datos del cliente se reciben desde el frontend
			// y se setean en TicketServicio
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
	
	// Recupera la hora cuando se marca la entrada o registra vehicula (horaEntrada)
	// y tamabien cuando se marca la salida ( horaSalida)
	private LocalDateTime getHoraEntradaSalida() {
		return LocalDateTime.now();
	}
	
	/*
	 *  Calculo del tiempo de parqueo
	 *  horaSalida - horaEntrada
	 *  se usa despues de haber hecho un setHoraSalida() al ticket
	 *  el tipo LocalDateTime es inmutable por lo que no se pueden 
	 *  editar las horas de entrada y salida
 	 * */
	
	private int getTiempoParqueo(LocalDateTime horaEntrada, LocalDateTime horaSalida) {
		// calcula el tiempo entre la de entrada y salida
		// salida - entrada
		
		Duration tiempoParqueo = Duration.between(horaEntrada, horaSalida);
		
		int tiempoParqueoMinutos = (int) tiempoParqueo.toMinutes();
		
		System.out.println(">TIEMPO PARQUEO (min): "+tiempoParqueoMinutos);
		
		return tiempoParqueoMinutos;
	}
	
	

}
