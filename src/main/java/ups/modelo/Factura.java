package ups.modelo;

import java.time.LocalDate;

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
public class Factura {
	
	
	@Id
	@Column(name ="id_factura")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String numero;
	
	private LocalDate fecha;
	
	private float precio;
	
	@ManyToOne(cascade = CascadeType.ALL ,  fetch = FetchType.EAGER)
	@JoinColumn(name="id_ticket")
	private Ticket ticket;
	
	@ManyToOne(cascade = CascadeType.ALL ,  fetch = FetchType.EAGER)
	@JoinColumn(name="id_tarifa")
	private Tarifa tarifa;
	
	
	
	public Factura() {
		// TODO Auto-generated constructor stub
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}


	@Override
	public String toString() {
		return "Factura [id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", precio=" + precio + ", ticket="
				+ ticket + ", tarifa=" + tarifa + "]";
	}
	
	
	
	
	
	
	

}
