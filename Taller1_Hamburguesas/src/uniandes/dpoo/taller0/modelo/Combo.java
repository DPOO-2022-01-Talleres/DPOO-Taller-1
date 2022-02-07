package uniandes.dpoo.taller0.modelo;

/**
 * Esta clase encapsula la información sobre los combos.
 */
public class Combo {
	
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
	}
	
	
	// ************************************************************************
	// Métodos para consultar los atributos
	// ************************************************************************

	/**
	 * Consulta el nombre del combo.
	 * 
	 * @return nombreCombo
	 */
	public String getNombre() {
		return nombreCombo;
	}
	
	
}
