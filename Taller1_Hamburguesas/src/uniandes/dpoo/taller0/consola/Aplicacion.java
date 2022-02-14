package uniandes.dpoo.taller0.consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uniandes.dpoo.taller0.modelo.Pedido;
import uniandes.dpoo.taller0.procesamiento.Restaurante;

public class Aplicacion {
	
	private Restaurante rest = new Restaurante();
	private Pedido ped;
	
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
					mostrarMenu();
				else if (opcionSeleccionada == 2 && rest != null) {
					String nombreCliente = input("Por favor ingrese su nombre: ");
					String direccionCliente = input("Por favor ingrese su dirección: ");
					rest.iniciarPedido(nombreCliente, direccionCliente);
				}
					
				else if (opcionSeleccionada == 3 && rest != null) {
					String menu = "";
					menu += "\nProductos básicos: ";
					menu += "Corral: 14000";
					menu += "Corral queso: 16000";
					menu += "Corral pollo: 15000";
					menu += "Corralita: 13000";
					menu += "Todoterreno: 25000";
					menu += "1/2 de libra: 25000";
					menu += "Especial: 24000";
					menu += "Casera: 23000";
					menu += "Mexicana: 22000";
					menu += "Criolla: 22000";
					menu += "Costeña: 20000";
					menu += "Hawaina: 20000";
					menu += "Wrap de pollo: 15000";
					menu += "Wrap de lomo: 22000";
					menu += "Ensalada mexicana: 20900";
					menu += "Papas medianas: 5500";
					menu += "Papas grandes: 6900";
					menu += "Papas en casco medianas: 5500";
					menu += "Papas en casco grandes: 6900";
					menu += "Agua cristal sin gas: 5000";
					menu += "Agua cristal con gas: 5000";
					menu += "Gaseosa: 5000";
					
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
