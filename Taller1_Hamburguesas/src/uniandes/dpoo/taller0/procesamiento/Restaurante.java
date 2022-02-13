package uniandes.dpoo.taller0.procesamiento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import uniandes.dpoo.taller0.modelo.Combo;
import uniandes.dpoo.taller0.modelo.Ingrediente;
import uniandes.dpoo.taller0.modelo.ProductoMenu;

/**
 * Esta clase permite ejecutar todos los procedimientos necesarios para
 * el correcto funcionamiento del restaurante.
 */
public class Restaurante {

	// ************************************************************************
	// Atributos
	// ************************************************************************
	
	/**
	 * Tabla de Hash que guarda la información de los pedidos.
	 * Las llaves son ID de pedidos anteriormente realizados.
	 * Los valores son objetos de tipo String que guardan la información de
	 * las facturas de los pedidos.
	 */
	private HashMap<Integer, String> pedidos;
	
	/**
	 * Pedido que se está realizando actualmente.
	 */
	private Pedido pedidoEnCurso;
	
	/**
	 * Tabla de Hash que guarda la información de los combos.
	 * Las llaves son nombres de los combos.
	 * Los valores son objetos de tipo Combo.
	 */
	private HashMap<String, Combo> combos;
	
	/**
	 * Tabla de Hash que guarda la información de los productos del menú.
	 * Las llaves son nombres de los productos.
	 * Los valores son objetos de tipo ProductoMenu.
	 */
	private HashMap<String, ProductoMenu> menuBase;
	
	/**
	 * Tabla de Hash que guarda la información de los ingredientes.
	 * Las llaves son nombres de los ingredientes.
	 * Los valores son objetos de tipo Ingrediente.
	 */
	private HashMap<String, Ingrediente> ingredientes;
	
	
	
	// ************************************************************************
	// Constructores
	// ************************************************************************
	
	public Restaurante() {
		this.pedidos = new HashMap<>();
		this.combos = new HashMap<>();
		this.menuBase = new HashMap<>();
		this.ingredientes = new HashMap<>();
	}
	
	
	
	// ************************************************************************
	// Métodos para consultar los atributos
	// ************************************************************************
	
	/**
	 * Consulta el pedido en curso.
	 * 
	 * @return pedidoEnCurso
	 */
	public Pedido getPedidoEnCurso() {
		return pedidoEnCurso;
	}
	
	/**
	 * Consulta el menú base del restaurante.
	 * 
	 * @return menuBase
	 */
	public HashMap<String, ProductoMenu> getMenuBase(){
		return menuBase;
	}
	
	/**
	 * Consulta los ingredientes.
	 * 
	 * @return ingredientes
	 */
	public HashMap<String, Ingrediente> getIngredientes(){
		return ingredientes;
	}
	
	
	
	// ************************************************************************
	// Métodos para cargar archivos
	// ************************************************************************
	
	/**
	 * Carga la información de los archivos.
	 * 
	 * @param archivoIngredientes
	 * @param archivoMenu
	 * @param archivoCombos
	 * @throws IOException
	 */
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) throws IOException {
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
	}
	
	/**
	 * Permite cargar la información del archivo ingredientes.txt.
	 * 
	 * @param archivoIngredientes El archivo ingredientes.txt.
	 * @throws IOException
	 */
	private void cargarIngredientes(File archivoIngredientes) throws IOException {
		
		// Abrir el archivo y leer la primera línea.
		BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
		String linea = br.readLine();
		
		// Leer línea a línea hasta que se llegue a la última.
		while (linea != null) {
			
			// Separar las partes de la línea y guardarlas en un arreglo.
			String[] partes = linea.split(";");
			
			// Crear el ingrediente y su información y guardarlo en ingredientes.
			String nombre = partes[0];
			int costoAdicional = Integer.parseInt(partes[1]);
			Ingrediente nuevoIngrediente = new Ingrediente(nombre, costoAdicional);
			ingredientes.put(nombre, nuevoIngrediente);
			
			// Leer la siguiente línea.
			linea = br.readLine();
			
		}
		br.close();
	}
	
	
	/**
	 * Permite cargar la información del archivo menu.txt.
	 * 
	 * @param archivoMenu El archivo menu.txt.
	 * @throws IOException
	 */
	private void cargarMenu(File archivoMenu) throws IOException {
		
		// Abrir el archivo y leer la primera línea.
		BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
		String linea = br.readLine();
		
		// Leer línea a línea hasta que se llegue a la última.
		while (linea != null) {
			
			// Separar las partes de la línea y guardarlas en un arreglo.
			String[] partes = linea.split(";");
			
			// Crear el producto y su información y guardarlo en menuBase.
			String nombre = partes[0];
			int precioBase = Integer.parseInt(partes[1]);
			ProductoMenu nuevoProductoMenu = new ProductoMenu(nombre, precioBase);
			menuBase.put(nombre, nuevoProductoMenu);
			
			// Leer la siguiente línea.
			linea = br.readLine();
			
		}
		br.close();
	}
	
	
	/**
	 * Permite cargar la información del archivo combos.txt.
	 * 
	 * @param archivoCombos El archivo combos.txt.
	 * @throws IOException
	 */
	private void cargarCombos(File archivoCombos) throws IOException {
		
		// Abrir el archivo y leer la primera línea.
		BufferedReader br = new BufferedReader(new FileReader(archivoCombos));
		String linea = br.readLine();
		
		// Leer línea a línea hasta que se llegue a la última.
		while (linea != null) {
			
			// Separar las partes de la línea y guardarlas en un arreglo.
			String[] partes = linea.split(";");
			
			/**
			 *  Crear el combo y su información y guardarlo en combos.
			 */
			String nombreCombo = partes[0];
			
			String cadenaDescuento = partes[1];
			Double descuento;
			descuento = (Double.parseDouble(cadenaDescuento.substring(0, cadenaDescuento.length() - 1)) / 100);
			
			Combo nuevoCombo = new Combo(descuento, nombreCombo);
			for (int i = 2; i < partes.length; i++ ) {
				String nombreItem = partes[i];
				ProductoMenu itemCombo = menuBase.get(nombreItem);
				nuevoCombo.agregarItemACombo(itemCombo);
			}
			combos.put(nombreCombo, nuevoCombo);
			
			// Leer la siguiente línea.
			linea = br.readLine();
			
		}
		br.close();
	}
	
	
	
	// ************************************************************************
	// Métodos de los pedidos
	// ************************************************************************

	public void iniciarPedido (String nombreCliente, String direccionCliente) {
		pedidoEnCurso = new Pedido(nombreCliente, direccionCliente);
	}
	
	
}
