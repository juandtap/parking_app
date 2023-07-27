package ups.servicios;

public class Error {
	
	/*
	 * Códigos de error
	 * 90.Error objeto no encontrado
	 * 91.Error al hacer POST
	 * 92.Error al hacer PUT
	 * 93.Error al hacer GET
	 * 94.Error al hacer DELETE
	 */
	
	private int codigo;
	private String mensaje;
	
	public Error() {
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
