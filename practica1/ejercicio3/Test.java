/*
Creación de instancias mediante el uso del operador new 
a. Cree una clase llamada Estudiante con los atributos especificados abajo y sus 
correspondientes métodos getters y setters (haga uso de las facilidades que brinda 
eclipse) 
● nombre 
● apellido 
● comision 
● email 
● direccion 
b. Cree una clase llamada Profesor con los atributos especificados abajo y sus 
correspondientes métodos getters y setters (haga uso de las facilidades que brinda 
eclipse) 
● nombre 
● apellido 
● email 
● catedra 
● facultad 
c. Agregue un método de instancia llamado tusDatos() en la clase Estudiante y en la 
clase Profesor, que retorne un String con los datos de los atributos de las mismas. 
Para acceder a los valores de los atributos utilice los getters previamente 
definidos. 
d. Escriba una clase llamada Test con el método main, el cual cree un arreglo con 2 
objetos Estudiante, otro arreglo con 3 objetos Profesor, y luego recorra ambos 
arreglos imprimiendo los valores obtenidos mediante el método tusDatos(). Recuerde 
asignar los valores de los atributos de los objetos Estudiante y Profesor invocando los 
respectivos métodos setters. 
e. Agregue dos breakpoints, uno en la línea donde itera sobre los estudiantes y otro en la 
línea donde itera sobre los profesores 
f. 
Ejecute la clase Test en modo debug y avance paso a paso visualizando si el 
estudiante o el profesor recuperado es lo esperado.
 
 */

package practica1.ejercicio3;

import java.util.Scanner;
import java.util.Random;
// int num = (Math.Random() * n) + 1

public class Test {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Estudiante[] estudiantes = new Estudiante[2];
		Profesor[] profesores = new Profesor[3];
		String dato;
		
		// carga estudiantes
		for (int i=0; i<2; i++) {
			estudiantes[i] = new Estudiante();
			System.out.print("Ingrese apellido: ");
			dato = s.nextLine();
			estudiantes[i].setApellido(dato);
			System.out.print("Ingrese nombre: ");
			dato = s.nextLine();
			estudiantes[i].setNombre(dato);
			System.out.print("Ingrese comision: ");
			dato = s.nextLine();
			estudiantes[i].setComision(dato);
			System.out.print("Ingrese email: ");
			dato = s.nextLine();
			estudiantes[i].setEmail(dato);
			System.out.print("Ingrese direccion: ");
			dato = s.nextLine();
			estudiantes[i].setDireccion(dato);
			System.out.println("---------------------------------");
		}
		
		System.out.println();
		System.out.println("Carga profesores: ");
		System.out.println();
		
		// carga profesor
		for (int i=0; i<3; i++) {
			profesores[i] = new Profesor();
			System.out.print("Ingrese apellido: ");
			dato = s.nextLine();
			profesores[i].setApellido(dato);
			System.out.print("Ingrese nombre: ");
			dato = s.nextLine();
			profesores[i].setNombre(dato);
			System.out.print("Ingrese catedra: ");
			dato = s.nextLine();
			profesores[i].setCatedra(dato);
			System.out.print("Ingrese email: ");
			dato = s.nextLine();
			profesores[i].setEmail(dato);
			System.out.print("Ingrese facultad: ");
			dato = s.nextLine();
			profesores[i].setFacultad(dato);
			System.out.println("---------------------------------");
		}
		
		s.close();
		
		// inciso D
		for (int i=0; i<2; i++) {
			System.out.println(estudiantes[i].tusDatos());
		}

		for (int i=0; i<3; i++) {
			System.out.println(profesores[i].tusDatos());
		}

		
	}

}
