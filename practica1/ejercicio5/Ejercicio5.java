package practica1.ejercicio5;

/*
Dado un arreglo de valores tipo entero se desea calcular el valor máximo, mínimo, y promedio 
en un único método. Escriba tres métodos de clase, donde respectivamente: 
a. Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return"). 
b. Devuelva lo pedido interactuando con algún parámetro (el parámetro no puede ser de 
tipo arreglo). 
c. Devuelva lo pedido sin usar parámetros ni la sentencia "return".

 */

public class Ejercicio5 {
	
	private static int[] vector1  = {1,2,3,4,5,6,7,8};
	private static int[] vector2 = {1,2,3,4,-5,-6,7,8};
	private static Dato dat;
	
	public static int[] incisoA(int[] vector) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int prom = 0;
		for (int i= 0; i<vector.length; i++) {
			prom = prom + vector[i];
			if (vector[i] < min) {
				min = vector[i];
			}
			if (vector[i] > max) {
				max = vector[i];
			}
		}
		prom = prom / vector.length;
		return new int[]{max, min, prom};
	}
	
	public static void incisoB(Dato d) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		double prom = 0;
		for (int i= 0; i<vector2.length; i++) {
			prom = prom + vector2[i];
			if (vector2[i] < min) {
				min = vector2[i];
			}
			if (vector2[i] > max) {
				max = vector2[i];
			}
		}
		prom = prom / vector2.length;
		d.setMax(max);
		d.setMin(min);
		d.setPromedio(prom);
	}
	
	public static void incisoC() {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int prom = 0;
		for (int i= 0; i<vector1.length; i++) {
			prom = prom + vector1[i];
			if (vector1[i] < min) {
				min = vector1[i];
			}
			if (vector2[i] > max) {
				max = vector1[i];
			}
		}
		prom = prom / vector1.length;
		dat = new Dato(min, max, prom);
	}

	public static void main(String[] args) {
		Dato d = new Dato();
		int [] nums = {2,4,5,6,7,8,9,10};
		int[] resultado = incisoA(nums);
		System.out.println("Max: " + resultado[0] + " Min: " + resultado[1] + " Prom: " + resultado[2]);
		incisoB(d);
		System.out.println("Max: " + d.getMax() + " Min: " + d.getMin() + " Prom: " + d.getPromedio());
		incisoC();
		System.out.println("Max: " + dat.getMax() + " Min: " + dat.getMin() + " Prom: " + dat.getPromedio());
	}

}
