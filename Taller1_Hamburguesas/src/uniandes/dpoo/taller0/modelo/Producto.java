package uniandes.dpoo.taller0.modelo;

/**
 * Esta interfaz declara los métodos base que deben tener las clases
 * Combo, ProductoAjustado y ProductoMenu.
 */
public interface Producto {
	
	// ************************************************************************
	// Métodos para consultar los atributos
	// ************************************************************************

	/**
	 * Consulta el precio.
	 * 
	 * @return precio.
	 */
	public int getPrecio();
	
	/**
	 * Consulta el nombre.
	 * 
	 * @return nombre.
	 */
	public String getNombre();
	
	
	// ************************************************************************
	// Otros métodos
	// ************************************************************************

	/**
	 * Genera la cadena relacionada a la factura del pedido.
	 * 
	 * @return factura.
	 */
	public String generarTextoFactura();
	
	public String generarTextoFacturaTxt();
	
}
