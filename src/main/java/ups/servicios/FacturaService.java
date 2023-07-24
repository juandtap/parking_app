package ups.servicios;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import ups.modelo.Factura;
import ups.negocio.GestionFactura;

@Path("parking")
public class FacturaService {
	
	@Inject
	private GestionFactura gestionFactura;

	
	
	@GET
	@Path("vehiculos")
	@Produces("application/json")
	public List<Factura> getAll() throws Exception{
		return this.gestionFactura.getAll();
	}
}
