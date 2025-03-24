package practica1.ejercicio2;

import java.util.Scanner;

public class ejercicio2 {
	
	public static int[] multiplos(int n) {
		int[] multiplosV = new int[n];
		for (int i=1; i <= n; i++) {
			multiplosV[i - 1] = n * i;
		}
		return multiplosV;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingrese número: ");
		int n = s.nextInt();
		
		int [] mult = multiplos(n);
		
		for (int num : mult) {
			System.out.println(num);
		}
		
	}

}
