package uniandes.dpoo.taller0.modelo;

public class Prueba {

	public static void main(String[] args) {
		String per1 = "99%";
		Double dou1;
		if (per1.length() > 2)
			dou1 = (Double.parseDouble(per1.substring(0, per1.length() - 1)) / 100);
		else
			dou1 = (Double.parseDouble(per1.substring(0, per1.length() - 1)) / 100);
		System.out.println(dou1);
	}

}
