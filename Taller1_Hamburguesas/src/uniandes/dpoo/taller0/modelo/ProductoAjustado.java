package uniandes.dpoo.taller0.modelo;

import java.util.ArrayList;

/*
 * Esta clase encapsula la información de un producto ajustado del menú.
 */
public class ProductoAjustado implements Producto {
	
	// ************************************************************************
	// Atributos
	// ************************************************************************
	
	/**
	 * El producto base que se va a modificar.
	 */
	private ProductoMenu base;
	
	/**
	 * Listas de los ingredientes que se quieren agregar y eliminar
	 * del producto base.
	 */
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	

	// ************************************************************************
	// Constructores
	// ************************************************************************
	
	/**
	 * Construye un nuevo producto ajustado, inicializando los atributos con los 
	 * valores de los parámetros.
	 * 
	 * @param base El producto base.
	 */
	public ProductoAjustado(ProductoMenu base) { 
		this.base = base;
		this.agregados = new ArrayList<>();
		this.eliminados = new ArrayList<>();
	}
	

	// ************************************************************************
	// Métodos para consultar los atributos
	// ************************************************************************
	
	@Override
	public String getNombre() {
		return base.getNombre();
	}
	
	@Override
	public int getPrecio() {
		int nuevoPrecio = base.getPrecio();
		for (Ingrediente ingrediente:agregados) {
			nuevoPrecio += ingrediente.getCostoAdicional();
		}
		return nuevoPrecio;
	}
	
	
	// ************************************************************************
	// Otros métodos
	// ************************************************************************
	
	@Override
	public String generarTextoFactura() {
		String factura = "\n" + base.getNombre() + "\t" + base.getPrecio();
		for (Ingrediente ingrediente:agregados) {
			factura += "\n+ " + ingrediente.getNombre() + "\t" + ingrediente.getCostoAdicional();
		}
		for (Ingrediente ingrediente:eliminados) {
			factura += "\n- " + ingrediente.getNombre() + "\t0";
		}
		return factura;
	}
	
	@Override
	public String generarTextoFacturaTxt() {
		String factura = base.getNombre() + "\t" + base.getPrecio();
		for (Ingrediente ingrediente:agregados) {
			factura += ingrediente.getNombre() + "\t" + ingrediente.getCostoAdicional();
		}
		for (Ingrediente ingrediente:eliminados) {
			factura += ingrediente.getNombre() + "\t0";
		}
		return factura;
	}
	
	public void agregarIngrediente(Ingrediente ingrediente) {
		agregados.add(ingrediente);
	}
	
	public void eliminarIngrediente(Ingrediente ingrediente) {
		eliminados.add(ingrediente);
	}
	
}
