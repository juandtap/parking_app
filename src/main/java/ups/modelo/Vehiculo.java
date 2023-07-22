package ups.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vehiculo {

	
	@Id	
	@Column(name="placa")
    private String placa;
	
    private String marca;
    
    private String descripcion;
    
    private String color;
    
    private String cedula;
    
    private String nombre;
    
    
    public Vehiculo() {
		// TODO Auto-generated constructor stub
	}

    
    

	public Vehiculo(String placa, String marca, String descripcion, String color, String cedula, String nombre) {
		this.placa = placa;
		this.marca = marca;
		this.descripcion = descripcion;
		this.color = color;
		this.cedula = cedula;
		this.nombre = nombre;
	}




	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
    

}
