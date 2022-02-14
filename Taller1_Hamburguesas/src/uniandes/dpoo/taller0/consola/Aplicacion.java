package uniandes.dpoo.taller0.consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import uniandes.dpoo.taller0.modelo.Combo;
import uniandes.dpoo.taller0.modelo.Pedido;
import uniandes.dpoo.taller0.modelo.ProductoAjustado;
import uniandes.dpoo.taller0.modelo.ProductoMenu;
import uniandes.dpoo.taller0.procesamiento.Restaurante;

public class Aplicacion {
	
	private Restaurante rest = new Restaurante();
	private Pedido ped;
	private File archivoIngredientes;
	private File archivoMenu;
	private File archivoCombos;
	
	public String imprimirMenu() {
		String menu = "";
		menu += "\n Productos básicos: " ;
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
		
		menu += "\nCombos: ";
		
		HashMap<String, Combo> combos = rest.getCombos();
		var llaveValorCombo = combos.entrySet();
		int opcion = 0;
		for (var entry : llaveValorCombo) {
			opcion ++;
			menu += ("\n" + opcion +". " + entry.getKey() +  ": " + entry.getValue());
		}
		
		return menu;
	}
	
	private void escogerOpcionPedido(Restaurante rest) {
		System.out.println("Que desea pedir: \n1. Producto Básico \n2. Combo");
		int opcionPedido = Integer.parseInt(input("Ingrese el número de la opción elegida: "));
		
		if (opcionPedido == 1) {
			Pedido pedido = rest.getPedidoEnCurso();
			ArrayList<ProductoMenu> productosBase = rest.getMenuBase();
			int productoBasicoEscogido = Integer.parseInt(input("Escoja un producto básico: "));
			ProductoMenu productoBasicoActual = productosBase.get(productoBasicoEscogido);
			pedido.agregarProducto(productoBasicoActual);
			
			boolean masIngredientes = true;
			while (masIngredientes) {
				System.out.println("Desea agregar más ingredientes: ");
				System.out.println("1. Agregar ingredientes\n 2. Quitar ingredientes\n 3. Terminar pedido");
				
				int opcionIngredientes = Integer.parseInt(input("Ingrese el número de la opción elegida: "));
				
				ProductoAjustado productoActualAjustado = new ProductoAjustado(productoBasicoActual);
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
				
				if (opcionIngredientes == 1) {
					System.out.println(menuIngredientes);
					int opcionAgregarIngrediente = Integer.parseInt(input("Escoja un ingrediente"));
				}
			}
		}
		
		else if (opcionPedido == 2) {
			Pedido pedido = rest.getPedidoEnCurso();
			ArrayList<Combo> combos = rest.getCombosArray();
			int productoBasicoEscogido = Integer.parseInt(input("Escoja un producto básico: "));
			pedido.agregarProducto(combos.get(productoBasicoEscogido));
			}
	}
	
	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación");
		System.out.println("1. Mostrar el menú");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guardar la factura");
		System.out.println("5. Consultar la información de un pedido dado su id");
		System.out.println("6. Salir de la aplicación");
	}
	
	public void ejecutarOpcion(int opcionSeleccionada)
	{
		System.out.println("Restaurante Hamburguesas\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				if (opcionSeleccionada == 1)
					System.out.println(imprimirMenu());
				
				else if (opcionSeleccionada == 2 && rest != null) {
					rest.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);
					String nombreCliente = input("Por favor ingrese su nombre: ");
					String direccionCliente = input("Por favor ingrese su dirección: ");
					rest.iniciarPedido(nombreCliente, direccionCliente);
					
					
					
				}
				
				else if (opcionSeleccionada == 3 && rest != null) {
					
					ped.agregarProducto(null);
				}
					
				else if (opcionSeleccionada == 4 && rest != null)
					ejecutarAtletasPorPais();
				else if (opcionSeleccionada == 5 && rest != null)
					
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else if (calculadora == null)
				{
					System.out.println("Para poder ejecutar esta opción primero debe cargar un archivo de atletas.");
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	
	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		Aplicacion consola = new Aplicacion();
		int opcionSeleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
		consola.ejecutarOpcion(opcionSeleccionada);
	}

}
