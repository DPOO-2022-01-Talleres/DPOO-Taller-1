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
import uniandes.dpoo.taller0.modelo.Pedido;
import uniandes.dpoo.taller0.modelo.ProductoMenu;

/**
 * Esta clase permite ejecutar todos los procedimientos necesarios para
 * el correcto funcionamiento del restaurante.
 */
public class Restaurante {

	/**
	 * Pendientes:
	 *  > Documentar listas menuBaseArray y combosArray.
	 */
		
	// ************************************************************************
	// Atributos
	// ************************************************************************
	
	/**
	 * Tabla de Hash que guarda la información de los combos.
	 * Las llaves son los nombres de los combos.
	 * Los valores son objetos de tipo Combo.
	 */
	private HashMap<String, Combo> combos;
	
	/**
	 * Tabla de Hash que guarda la información de los pedidos.
	 * Las llaves son ID de pedidos anteriormente realizados.
	 * Los valores son objetos de tipo Pedido.
	 */
	public HashMap<Integer, Pedido> pedidos = new HashMap<Integer, Pedido>();
		
	/**
	 * Pedido que se está realizando actualmente.
	 */
	private Pedido pedidoEnCurso;
	
	/**
	 * Tabla de Hash que guarda la información de los productos del menú.
	 * Las llaves son los nombres de los productos básicos.
	 * Los valores son objetos de tipo ProductoMenu.
	 */
	private HashMap<String, ProductoMenu> menuBase;
	
	/**
	 * Lista que guarda objetos de tipo Ingrediente.
	 */
	private ArrayList<Ingrediente> ingredientes;
	
	
	private ArrayList<ProductoMenu> menuBaseLista;
	
	
	private ArrayList<Combo> combosLista;		
	
	
	
	// ************************************************************************
	// Constructores
	// ************************************************************************
	
	public Restaurante() {
		this.combos = new HashMap<>();
		this.menuBase = new HashMap<>();
		this.ingredientes = new ArrayList<>();
		this.menuBaseLista = new ArrayList<>();
		this.combosLista = new ArrayList<>();
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
	public ArrayList<Ingrediente> getIngredientes(){
		return ingredientes;
	}
	
	public HashMap<String, Combo> getCombos(){
		return combos;
	}
	
	public ArrayList<ProductoMenu> getMenuBaseLista() {
		return menuBaseLista;
	}
	
	public ArrayList<Combo> getCombosLista() {
		return combosLista;
	}
	
	

	// ************************************************************************
	// Métodos de los pedidos
	// ************************************************************************

	/**
	 * Crea un nuevo pedido
	 * 
	 * @param nombreCliente
	 * @param direccionCliente
	 */
	public void iniciarPedido (String nombreCliente, String direccionCliente) {
		pedidoEnCurso = new Pedido(nombreCliente, direccionCliente);
	}


	/**
	 * Guarda la factura del pedido y lo cierra.
	 * @throws IOException 
	 */
	public void cerrarYGuardarPedido () throws IOException {
		pedidoEnCurso.guardarFactura();
	}
	
	public Pedido consultarPedidoPorId (int id) {
		return pedidos.get(id);
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
	public void cargarInformacionRestaurante() throws IOException {
		cargarIngredientes();
		cargarMenu();
		cargarCombos();
	}
	
	/**
	 * Permite cargar la información del archivo ingredientes.txt.
	 * 
	 * @param archivoIngredientes El archivo ingredientes.txt.
	 * @throws IOException
	 */
	private void cargarIngredientes() throws IOException {
		
		// Abrir el archivo y leer la primera línea.
		String nombreArchivo = System.getProperty("user.dir") + "/data/ingredientes.txt";
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea = br.readLine();
		
		// Leer línea a línea hasta que se llegue a la última.
		while (linea != null) {
			
			// Separar las partes de la línea y guardarlas en un arreglo.
			String[] partes = linea.split(";");
			
			// Crear el ingrediente y su información y guardarlo en ingredientes.
			String nombre = partes[0];
			int costoAdicional = Integer.parseInt(partes[1]);
			Ingrediente nuevoIngrediente = new Ingrediente(nombre, costoAdicional);
			ingredientes.add(nuevoIngrediente);
			
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
	private void cargarMenu() throws IOException {
		
		// Abrir el archivo y leer la primera línea.
		String nombreArchivo = System.getProperty("user.dir") + "/data/menu.txt";
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea = br.readLine();
		
		// Leer línea a línea hasta que se llegue a la última.
		while (linea != null) {
			
			// Separar las partes de la línea y guardarlas en un arreglo.
			String[] partes = linea.split(";");
			
			// Crear el producto y su información y guardarlo en menuBase y menuBaseLista.
			String nombre = partes[0];
			int precioBase = Integer.parseInt(partes[1]);
			ProductoMenu nuevoProductoMenu = new ProductoMenu(nombre, precioBase);
			menuBase.put(nombre, nuevoProductoMenu);
			menuBaseLista.add(nuevoProductoMenu);
			
			// Leer la siguiente línea.
			linea = br.readLine();
			
		}
		br.close();
	}
	
	
	private 
	
	/**
	 * Permite cargar la información del archivo combos.txt.
	 * 
	 * @param archivoCombos El archivo combos.txt.
	 * @throws IOException
	 */
	private void cargarCombos() throws IOException {
		
		// Abrir el archivo y leer la primera línea.
		String nombreArchivo = System.getProperty("user.dir") + "/data/combos.txt";
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea = br.readLine();
		
		// Leer línea a línea hasta que se llegue a la última.
		while (linea != null) {
			
			// Separar las partes de la línea y guardarlas en un arreglo.
			String[] partes = linea.split(";");
			
			/**
			 *  Crear el combo y su información y guardarlo en combos y combosLista.
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
			combosLista.add(nuevoCombo);
			
			// Leer la siguiente línea.
			linea = br.readLine();
			
		}
		br.close();
	}
	
}
