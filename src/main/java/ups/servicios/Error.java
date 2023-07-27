package ups.servicios;

public class Error {
	
	
	

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
