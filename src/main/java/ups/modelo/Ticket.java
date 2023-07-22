package ups.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket {

	
	@Id
	@Column(name ="id_ticket")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private LocalDateTime horaEntrada;
	
	private LocalDateTime horaSalida;
	
	@ManyToOne(cascade = CascadeType.ALL ,  fetch = FetchType.EAGER)
	@JoinColumn(name="placa_vehiculo")
	private Vehiculo vehiculo;
	
	
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Ticket(LocalDateTime horaEntrada, LocalDateTime horaSalida, Vehiculo vehiculo) {
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
		this.vehiculo = vehiculo;
	}






	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}



	public void setHoraEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}



	public LocalDateTime getHoraSalida() {
		return horaSalida;
	}



	public void setHoraSalida(LocalDateTime horaSalida) {
		this.horaSalida = horaSalida;
	}



	public Vehiculo getVehiculo() {
		return vehiculo;
	}



	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}



	@Override
	public String toString() {
		return "Ticket [id=" + id + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + ", vehiculo="
				+ vehiculo + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
