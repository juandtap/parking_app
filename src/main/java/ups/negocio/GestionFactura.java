package ups.negocio;

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
			throw new Exception("Factura no existe !");
			
		} else {

			System.out.println("Se crea una nueva Factura.");
			
			
			try {
				this.facturaDAO.insert(factura);
			} catch (Exception e) {
				throw new Exception("Error al insertar nueva Factura: "+e.getMessage());
			}
		}
		
		
		
		
		
	}
	
	

}
