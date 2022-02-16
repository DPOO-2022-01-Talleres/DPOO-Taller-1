package uniandes.dpoo.taller0.modelo;

import java.util.ArrayList;

/**
 * Esta clase encapsula la información de un combo.
 */
public class Combo implements Producto {
	
	// ************************************************************************
	// Atributos
	// ************************************************************************

	/**
	 * El descuento del combo.
	 */
	private double descuento;
	
	/**
	 * El nombre del combo.
	 */
	private String nombreCombo;
	
	/**
	 * Lista de los productos que posee el combo.
	 */
	private ArrayList<ProductoMenu> itemsCombo;
	
	
	// ************************************************************************
	// Constructores
	// ************************************************************************

	/**
	 * Construye un nuevo combo e inicializa sus atributos con la información de
	 * los parámetros.
	 * 
	 * @param descuento El descuento del combo.
	 * @param nombreCombo El nombre del combo.
	 */
	public Combo(double descuento, String nombreCombo) {
		this.descuento = descuento;
		this.nombreCombo = nombreCombo;
		this.itemsCombo = new ArrayList<>();
	}
	
	
	// ************************************************************************
	// Métodos para consultar los atributos
	// ************************************************************************

	@Override
	public String getNombre() {
		return nombreCombo;
	}

	@Override
	public int getPrecio() {
		double precioComboDouble = 0;
		for (ProductoMenu item:itemsCombo) {
			precioComboDouble += (item.getPrecio() * (1 - descuento));
		}
		return (int) Math.round(precioComboDouble);
	}

	
	// ************************************************************************
	// Otros métodos
	// ************************************************************************

	@Override
	public String generarTextoFactura() {
		String factura = "\n" + nombreCombo + "\t" + getPrecio();
		return factura;
	}
	
	@Override
	public String generarTextoFacturaTxt() {
		String factura = nombreCombo + "\t" + getPrecio();
		return factura;
	}
	
	/**
	 * Añade un ítem a la lista itemsCombo.
	 * 	
	 * @param itemCombo
	 */
	public void agregarItemACombo(Producto itemCombo) {
		if (itemCombo instanceof ProductoMenu) {
			ProductoMenu item = (ProductoMenu) itemCombo;
			itemsCombo.add(item);
		}
	}
	
}