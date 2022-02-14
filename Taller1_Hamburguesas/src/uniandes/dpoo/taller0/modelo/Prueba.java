package uniandes.dpoo.taller0.modelo;

import java.util.HashMap;

import uniandes.dpoo.taller0.procesamiento.Restaurante;

public class Prueba {

	public static void main(String[] args) {
		Producto nuevoProd = new Producto();
		boolean resp = (nuevoProd instanceof Producto);
		System.out.println(resp);
	}

}
