package uniandes.dpoo.taller0.modelo;

public class Bebida implements Producto {
	
	private String nombre;
	private int precio;
	
	public Bebida(String nombre, int precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	@Override
	public int getPrecio() {
		return precio;
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String generarTextoFactura() {
		return "\n" + nombre + "\t" + precio;
	}
	
	@Override
	public String generarTextoFacturaTxt() {
		return nombre + "\t" + precio;
	}
	
}
