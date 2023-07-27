package ups.negocio;

import java.util.List;


import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.datos.FacturaDAO;
import ups.modelo.Factura;


@Stateless
public class GestionFactura {
	
	@Inject
	private FacturaDAO facturaDAO;
	
	
	public void save(Factura factura) throws Exception{
		if (factura.getId()==0) {
			throw new Exception("Factura vacia !");
			
		} else {

			System.out.println("Se crea una nueva Factura.");

			try {
				this.facturaDAO.create(factura);
			} catch (Exception e) {
				throw new Exception("Error al crear nueva Factura: "+e.getMessage());
			}
		}
		
		
		
		
		
	}
	
	public List<Factura> getAll()  throws Exception{
		
		try {
			return facturaDAO.getAll();
		} catch (Exception e) {
			throw new Exception("Error al recuperar Facturas de la base de datos: "+e.getMessage());
			
		}
		
		
		
	}
	
	
	// Método para generar el numero de factura a partir del id(int)
	private String generateFacNumber(int id) {
		// Definimos el formato de la factura con ceros a la izquierda (6)
		String formatFac = "%06d";
		// Usamos String.format para generar el número de factura en el formato 
		// 000001
		String facNumber = String.format(formatFac, id);
		
		return facNumber;
	}
	
	

}
