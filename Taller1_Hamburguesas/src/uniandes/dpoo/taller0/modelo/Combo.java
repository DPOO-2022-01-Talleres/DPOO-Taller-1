package uniandes.dpoo.taller0.modelo;

import java.util.ArrayList;

/**
 * Esta clase encapsula la información sobre los combos.
 */
public class Combo implements Producto {
	
	/**
	 * Lista de pendientes:
	 *  > Modificar UML por adición del atributo precioTotal.
	 *  > Método generarTextoFactura.
	 */
	
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
	private ArrayList<Producto> itemsCombo;
	
	
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
		return 0;
	}

	
	// ************************************************************************
	// Otros métodos
	// ************************************************************************

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Añade un ítem a la lista itemsCombo.
	 * 	
	 * @param itemCombo
	 */
	public void agregarItemACombo(Producto itemCombo) {
		itemsCombo.add(itemCombo);
	}
	
	
}
