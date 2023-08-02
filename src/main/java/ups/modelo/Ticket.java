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
	
	//tiempo en minutos
	private int tiempoParqueo;
	
	private boolean estadoSalida;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="placa_vehiculo")
	private Vehiculo vehiculo;
	
		
	public Ticket() {
		
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


	public int getTiempoParqueo() {
		return tiempoParqueo;
	}



	public void setTiempoParqueo(int tiempoParqueo) {
		this.tiempoParqueo = tiempoParqueo;
	}


	public boolean isEstadoSalida() {
		return estadoSalida;
	}


	public void setEstadoSalida(boolean estadoSalida) {
		this.estadoSalida = estadoSalida;
	}


	@Override
	public String toString() {
		return "Ticket [id=" + id + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + ", tiempoParqueo="
				+ tiempoParqueo + ", estadoSalida=" + estadoSalida + ", vehiculo=" + vehiculo + "]";
	}
	
	
	
	
}
