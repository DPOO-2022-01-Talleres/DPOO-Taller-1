package uniandes.dpoo.taller0.modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Esta clase encapsula la información de un pedido y la guarda
 * en el archivo correspondiente.
 */
public class Pedido {

	/**
	 * Pendientes:
	 *  > Método guardarFactura().
	 *  > Asignar valor a idPedido.
	 */
	
	// ************************************************************************
	// Atributos
	// ************************************************************************
	
	/**
	 * Cantidad total de pedidos realizados.
	 */
	private static int numeroPedidos;
	
	/**
	 * ID del pedido.
	 */
	private int idPedido;
	
	/**
	 * Nombre del cliente.
	 */
	private String nombreCliente;
	
	/**
	 * Dirección del cliente.
	 */
	private String direccionCliente;
	
	/**
	 * Lista que contiene los ítems del pedido.
	 */
	private ArrayList<Producto> itemsPedido;
	
	
	// ************************************************************************
	// Constructores
	// ************************************************************************
	
	/**
	 * Construye un nuevo pedido e inicializa sus atributos con la información de
	 * los parámetros.
	 * 
	 * @param nombreCliente Nombre del cliente.
	 * @param direccionCliente Dirección del cliente.
	 */
	public Pedido(String nombreCliente, String direccionCliente) {
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.itemsPedido = new ArrayList<>();
		this.idPedido = (numeroPedidos + 1);
	}
	
	
	// ************************************************************************
	// Métodos para consultar los atributos
	// ************************************************************************
	
	/**
	 * Consulta el ID del pedido.
	 * 
	 * @return idPedido
	 */
	public int getIdPedido () {
		return idPedido;
	}
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	
	public String getDireccionCliente() {
		return direccionCliente;
	}
	
	
	// ************************************************************************
	// Otros métodos
	// ************************************************************************
	
	/** Añade un ítem a la lista de pedidos.
	 * 
	 * @param nuevoItem El ítem que se quiere añadir.
	 */
	public void agregarProducto(Producto nuevoItem) {
		itemsPedido.add(nuevoItem);
	}
	
	/**
	 * Calcula el precio neto (sin IVA) del pedido.
	 * 
	 * @return precioNeto
	 */
	private int getPrecioNetoPedido() {
		int precioNeto = 0;
		for (Producto item:itemsPedido) {
			precioNeto += item.getPrecio();
		}
		return precioNeto;
	}
	
	/**
	 * Calcula el valor del IVA sobre el pedido.
	 * 
	 * @return valorIva
	 */
	private int getPrecioIVAPedido() {
		return (int) Math.round((getPrecioNetoPedido() * 0.19));
	}
	
	/**
	 * Calcula el valor total del pedido (neto + IVA).
	 * 
	 * @return Precio total del pedido.
	 */
	private int getPrecioTotalPedido() {
		return (getPrecioNetoPedido() + getPrecioIVAPedido());
	}
	
	/**
	 * Genera la factura del pedido.
	 * 
	 * @return factura
	 */
	public String generarTextoFactura() {
		System.out.println("\nGracias por su pedido. La factura es la siguiente:\n");
		String factura = "";
		factura += "ID:\t" + getIdPedido();
		factura += "\nProducto\tValor";
		for (Producto item:itemsPedido) {
			factura += item.generarTextoFactura();
		}
		factura += "\n" + "Valor neto" + "\t" + getPrecioNetoPedido();
		factura += "\n" + "IVA" + "\t\t" + getPrecioIVAPedido();
		factura += "\n" + "Valor total" + "\t" + getPrecioTotalPedido();		
		return factura;
	}
	
	public String generarTextoFacturaTxt() {
		String factura = "";
		for (Producto item:itemsPedido) {
			factura += item.generarTextoFacturaTxt();
		}
		factura += "Valor neto" + "\t" + getPrecioNetoPedido();
		factura += "IVA" + "\t\t" + getPrecioIVAPedido();
		factura += "Valor total" + "\t" + getPrecioTotalPedido();		
		return factura;
	}
	
	/**
	 * Añade una factura al texto respectivo.
	 * 
	 * @param archivo
	 * @throws IOException 
	 */
	public void guardarFactura() throws IOException {
		String factura = generarTextoFactura();
		System.out.println(factura);
		factura = getIdPedido() + ";" + generarTextoFacturaTxt();
		factura += ";" + getNombreCliente() + ";" + getDireccionCliente() + "\n";
		FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/data/pedidos.txt", true);
		writer.write(factura);
		writer.close();
		numeroPedidos ++;
	}

}
