package practica1.ejercicio1;

import java.util.Scanner;

public class ejercicio1 {
	
	private static void imprimirConFor(int a, int b) {
		for (int i = a; i <= b; i++) {
			System.out.println(i);
		}
	}
	
	private static void imprimirConWhile(int a, int b) {
		while (a <= b) {
			System.out.println(a);
			a++;
		}
	}
	
	private static void imprimirRecursivo(int a, int b) {
		if (a <= b) {
			System.out.println(a);
			imprimirRecursivo(a + 1, b);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingrese primer número: ");
		int x = scanner.nextInt();
		System.out.println("Ingrese segundo número: ");
		int y = scanner.nextInt();
		
		// Chequear que el primero sea el menor
		if (x > y) {
			int aux = x;
			x = y;
			y = aux;
		}
		
		scanner.close();
		
		System.out.println("-For--------");
		imprimirConFor(x,y);
		System.out.println("-While--------");
		imprimirConWhile(x,y);
		System.out.println("-Recursivo-----");
		imprimirRecursivo(x,y);
		
	}

}
