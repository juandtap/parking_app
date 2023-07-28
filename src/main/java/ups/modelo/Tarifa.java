package ups.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarifa {

	@Id
	@Column(name ="id_tarifa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String tarifa;
	
	@Column(nullable = false)
	private float precioHora;
	
	private int fraccionHora;
	
	private String descripcion;
	
	
	public Tarifa() {
		
	}
	
	


	public Tarifa(String tipoTarifa, float precioHora, String descripcion) {
		this.tarifa = tipoTarifa;
		this.precioHora = precioHora;
		this.descripcion = descripcion;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTarifa() {
		return tarifa;
	}


	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
	}


	public float getPrecioHora() {
		return precioHora;
	}


	public void setPrecioHora(float precioHora) {
		this.precioHora = precioHora;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getFraccionHora() {
		return fraccionHora;
	}


	public void setFraccionHora(int fraccionHora) {
		this.fraccionHora = fraccionHora;
	}




	@Override
	public String toString() {
		return "Tarifa [id=" + id + ", tarifa=" + tarifa + ", precioHora=" + precioHora + ", fraccionHora="
				+ fraccionHora + ", descripcion=" + descripcion + "]";
	}

	
	




	
	
	
	
	
}
