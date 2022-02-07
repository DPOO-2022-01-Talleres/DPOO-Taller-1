package uniandes.dpoo.taller0.modelo;

/**
 * Esta clase encapsula la información sobre los ingredientes.
 */
public class Ingrediente {
	
	// ************************************************************************
	// Atributos
	// ************************************************************************

	/**
	 * El nombre del ingrediente.
	 */
	private String nombre;
	
	/**
	 * Costo adicional que se debe asumir por incluir el ingrediente.
	 */
	private int costoAdicional;
	
	private String albondiga;
	
	
	// ************************************************************************
	// Constructores
	// ************************************************************************

	/**
	 * Construye un nuevo ingrediente e inicializa sus atributos con la información de
	 * los parámetros.
	 * 
	 * @param nombre El nombre del ingrediente.
	 * @param costoAdicional El costo adicional por incluir e ingrediente.
	 */
	public Ingrediente(String nombre, int costoAdicional) {
		this.nombre = nombre;
		this.costoAdicional = costoAdicional;
	}
	
	
	// ************************************************************************
	// Métodos para consultar los atributos
	// ************************************************************************

	/**
	 * Consulta el nombre del ingrediente.
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Consulta el costo adicional del ingrediente.
	 * 
	 * @return costoAdicional
	 */
	public int getCostoAdicional() {
		return costoAdicional;
		
	
	}
}
