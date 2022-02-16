package uniandes.dpoo.taller0.consola;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;

import uniandes.dpoo.taller0.modelo.Bebida;
import uniandes.dpoo.taller0.modelo.Combo;
import uniandes.dpoo.taller0.modelo.Ingrediente;
import uniandes.dpoo.taller0.modelo.Pedido;
import uniandes.dpoo.taller0.modelo.ProductoAjustado;
import uniandes.dpoo.taller0.modelo.ProductoMenu;
import uniandes.dpoo.taller0.procesamiento.RestauranteModificado;

/**
 * Esta clase permite ejecturar la aplicación y llevar a cabo todas las
 * acciones requeridas. Entre ellas:
 *  1. Mostrar el menú.
 *  2. Iniciar un nuevo pedido.
 *  3. Agregar un elemento a un pedido.
 *  4. Cerrar un pedido y guardar factura.
 *  5. Consultar la información de un pedido dado su id.
 */
public class AplicacionModificada {
	
	// ************************************************************************
	// Atributos
	// ************************************************************************
	
	/*
	 * Objeto que guarda el restaurante.
	 */
	private RestauranteModificado rest;
		
	
	
	// ************************************************************************
	// Métodos de impresión
	// ************************************************************************

	/**
	 * Imprime el menú del restaurante.
	 */
	public void mostrarMenu() {
		System.out.println("\nOpciones de la aplicación:");
		System.out.println(" 1. Mostrar el menú.");
		System.out.println(" 2. Iniciar un nuevo pedido.");
		System.out.println(" 3. Agregar un elemento a un pedido.");
		System.out.println(" 4. Cerrar un pedido y guardar la factura.");
		System.out.println(" 5. Consultar la información de un pedido dado su id.");
		System.out.println(" 6. Salir de la aplicación.");
	}
	
	/**
	 * Imprime el menú de productos básicos.
	 */
	public void imprimirProductosBasicos() {
		String menu = "";
		menu += "\nProductos básicos: " ;
		menu += "\n1. Corral: 14000";
		menu += "\n2. Corral queso: 16000";
		menu += "\n3. Corral pollo: 15000";
		menu += "\n4. Corralita: 13000";
		menu += "\n5. Todoterreno: 25000";
		menu += "\n6. 1/2 de libra: 25000";
		menu += "\n7. Especial: 24000";
		menu += "\n8. Casera: 23000";
		menu += "\n9. Mexicana: 22000";
		menu += "\n10. Criolla: 22000";
		menu += "\n11. Costeña: 20000";
		menu += "\n12. Hawaina: 20000";
		menu += "\n13. Wrap de pollo: 15000";
		menu += "\n14. Wrap de lomo: 22000";
		menu += "\n15. Ensalada mexicana: 20900";
		menu += "\n16. Papas medianas: 5500";
		menu += "\n17. Papas grandes: 6900";
		menu += "\n18. Papas en casco medianas: 5500";
		menu += "\n19. Papas en casco grandes: 6900";
		menu += "\n20. Agua cristal sin gas: 5000";
		menu += "\n21. Agua cristal con gas: 5000";
		menu += "\n22. Gaseosa: 5000";
		System.out.println(menu);
	}
	
	/*
	 * Imrpime el menú de ingredientes.
	 */
	public void imprimirIngredientes() {
		String menuIngredientes = "";
		menuIngredientes += "\nIngredientes";
		menuIngredientes += "\n1. Lechuga: 1000";
		menuIngredientes += "\n2. Tomate: 1000";
		menuIngredientes += "\n3. Cebolla: 1000";
		menuIngredientes += "\n4. Queso mozarella: 2500";
		menuIngredientes += "\n5. Huevo: 2500";
		menuIngredientes += "\n6. Queso americano: 2500";
		menuIngredientes += "\n7. Tocineta express: 2500";
		menuIngredientes += "\n8. Papa callejera: 2000";
		menuIngredientes += "\n9. Pepinillos: 2500";
		menuIngredientes += "\n10. Cebolla grille: 2500";
		menuIngredientes += "\n11. Suero costeño: 3000";
		menuIngredientes += "\n12. Frijol refrito: 4500";
		menuIngredientes += "\n13. Queso fundido: 4500";
		menuIngredientes += "\n14. Tocineta picada: 6000";
		menuIngredientes += "\n15. Piña: 2500";
		System.out.println(menuIngredientes);
	}
	
	private void imprimirBebidas() {
		String menuBebidas = "\nBebidas:";
		menuBebidas += "\n1. Agua cristal sin gas: 5000";
		menuBebidas += "\n2. Agua cristal con gas: 5000";
		menuBebidas += "\n3. Gaseosa: 5000";
		System.out.println(menuBebidas);
	}
	
	/**
	 * Imprime el menú de combos.
	 */
	public void imprimirCombos() {
		int opcion = 0;
		System.out.println("\nCombos: ");
		for (Combo combo:rest.getCombosLista()) {
			opcion = opcion + 1;
			System.out.println(opcion + ". " + combo.getNombre() + "\t" + combo.getPrecio());
		}
	}
	
	
	
	// ************************************************************************
	// Métodos main y relacionados
	// ************************************************************************

	/**
	 * Ejecuta la aplicación.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		AplicacionModificada aplicacion = new AplicacionModificada();
		aplicacion.ejecutarAplicacion(aplicacion);
	}
	
	/**
	 * Crea el restauranet e inicia la aplicación.
	 * 
	 * @param aplicacion
	 * @throws IOException
	 */
	public void ejecutarAplicacion(AplicacionModificada aplicacion) throws IOException {
		rest = new RestauranteModificado();
		System.out.println("RESTAURANTE HAMBURGUESAS");
		aplicacion.ejecutarOpcion(aplicacion);
	}
	
	/**
	 * Ejecuta la opción seleccionada por el usuario.
	 * 
	 * @param opcionSeleccionada
	 * @throws IOException 
	 */
	public void ejecutarOpcion(AplicacionModificada aplicacion) throws IOException {
		
		rest.cargarInformacionRestaurante();
		
		// Ciclo que permite usar la aplicación hasta que se desee salir.
		boolean continuar = true;
		while (continuar) {
			try	{
				
				mostrarMenu();
				int opcionSeleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
				
				if (opcionSeleccionada == 1) {
					imprimirProductosBasicos();
					imprimirCombos();
					imprimirBebidas();
				}
					
				else if (opcionSeleccionada == 2) {
					ejecutarNuevoPedido();
				}
				
				else if (opcionSeleccionada == 3) {
					ejecutarAgregarElemento();
				}
					
				else if (opcionSeleccionada == 4)
					rest.cerrarYGuardarPedido();
				
				else if (opcionSeleccionada == 5) {
					ejecutarConsultarInfoId();
				}
				
				else if (opcionSeleccionada == 6) {
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}					
				
				else
					System.out.println("Por favor seleccione una opción válida.");	
				
	
			}
			
			catch (NumberFormatException e) {
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	
	
	private void ejecutarAgregarElemento() {
		
		Pedido ped = rest.getPedidoEnCurso();
		ArrayList<ProductoMenu> menuBaseLista = rest.getMenuBaseLista();
		ArrayList<Ingrediente> ingredientes = rest.getIngredientes();
		Ingrediente ingredienteActual;
		ArrayList<Combo> combos = rest.getCombosLista();
		ArrayList<Bebida> bebidasLista = rest.getBebidas();
		
		System.out.println("\n¿Qué desea pedir? \n1. Producto Básico \n2. Combo \n3. Bebida");
		int opcionPedido = Integer.parseInt(input("\nIngrese el número de la opción elegida"));
		
		if (opcionPedido == 1) {
			
			imprimirProductosBasicos();
			int productoBasicoEscogido = Integer.parseInt(input("\nEscoja un producto básico"));
			ProductoMenu productoBasicoActual = menuBaseLista.get(productoBasicoEscogido - 1);
			ProductoAjustado productoActualAjustado = new ProductoAjustado(productoBasicoActual);
			
			boolean seguirModificando = true;
			while (seguirModificando) {
				System.out.println("\nModificación producto básico ");
				System.out.println("1. Agregar ingrediente\n2. Quitar ingredientes\n3. Terminar");
				int opcionIngrediente = Integer.parseInt(input("\n¿Qué desea hacer?"));
				if (opcionIngrediente == 1) {
					imprimirIngredientes();
					int opcionAgregarIngrediente = Integer.parseInt(input("\nEscoja un ingrediente"));
					ingredienteActual = ingredientes.get(opcionAgregarIngrediente - 1);
					productoActualAjustado.agregarIngrediente(ingredienteActual);
				}
				
				else if (opcionIngrediente == 2) {
					imprimirIngredientes();
					int opcionEliminarIngrediente = Integer.parseInt(input("\nEscoja un ingrediente"));
					ingredienteActual = ingredientes.get(opcionEliminarIngrediente - 1);
					productoActualAjustado.eliminarIngrediente(ingredienteActual);
				}
				
				else if (opcionIngrediente == 3) {
					seguirModificando = false;
				}
				
				else {
					System.out.println("Por favor, escoja una opción adecuada.");
				}				
			
			}
			
			ped.agregarProducto(productoActualAjustado);
		}
		
		else if (opcionPedido == 2) {
			imprimirCombos();
			int comboEscogido = Integer.parseInt(input("\nEscoja un combo"));
			ped.agregarProducto(combos.get(comboEscogido - 1));
			}
		
		else if (opcionPedido == 3) {
			imprimirBebidas();
			int bebidaEscogida = Integer.parseInt(input("\nEscoja una bebida"));
			ped.agregarProducto(bebidasLista.get(bebidaEscogida - 1));
			}
		
		else {
			System.out.println("Por favor, escoja una opción adecuada.");
		}
	}

	
	
	// ************************************************************************
	// Otros métodos
	// ************************************************************************
	
	/**
	 * 
	 */
	private void ejecutarNuevoPedido() {
		String nombreCliente = input("\nPor favor ingrese su nombre");
		String direccionCliente = input("Por favor ingrese su dirección");
		rest.iniciarPedido(nombreCliente, direccionCliente);
		System.out.println("El pedido ha sido inicializado.");
	}
	
	private void ejecutarConsultarInfoId() {
		int idPedidoAConsultar = Integer.parseInt(input("\nPor favor ingrese el ID del pedido"));
		String mensajeSalida = "\nInformación del pedido:";
		HashMap<Integer, ArrayList<String>> pedidos =  rest.getPedidos();
		ArrayList<String> listaCliente = pedidos.get(idPedidoAConsultar);
		mensajeSalida += "\n> ID: " + idPedidoAConsultar;
		mensajeSalida += "\n> Nombre cliente: " + listaCliente.get(1);
		mensajeSalida += "\n> Dirección del cliente: " + listaCliente.get(2);
		mensajeSalida += "\n> Factura del pedido:\n" + listaCliente.get(0);
		System.out.println(mensajeSalida);
	}
	
	
	// ************************************************************************
	// Otros métodos
	// ************************************************************************
	
	/**
	 * Este método sirve para imprimir un mensaje en la consola pidiéndole
	 * información al usuario y luego leer lo que escriba el usuario.
	 * 
	 * @param mensaje El mensaje que se le mostrará al usuario
	 * @return La cadena de caracteres que el usuario escriba como respuesta.
	 */
	public static String input(String mensaje) {
		try	{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e) {
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}


}
