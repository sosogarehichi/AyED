package practica5.ejercicio3;

import java.util.LinkedList;
import java.util.List;

import practica5.ejercicio1.Graph;
import practica5.ejercicio1.Vertex;
import practica5.ejercicio1.Edge;

public class Mapa {
    private Graph<String> mapaCity;


    public Mapa(Graph<String> mapaCiudades) {
        this.mapaCity = mapaCiudades;
    }

    /*
     1. devolverCamino (String ciudad1, String ciudad2): List<String>
     Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso de que se
     pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).
     */

    public LinkedList<String> devolverCamino (String ciudad1, String ciudad2){
        boolean [] visitados = new boolean[this.mapaCity.getSize()]; // vector de visitados
        LinkedList<String> lista = new LinkedList<String>(); // lista para el camino
        Vertex<String> origen = this.mapaCity.search(ciudad1); // buscamos la ciudad de origen
        Vertex<String> destino = this.mapaCity.search(ciudad2); // y nuestro destino
        if (origen != null && destino != null) // si AMBOS son válidos --> recorremos
            inciso1(origen, destino, lista, visitados);
        return lista;
    }

    private boolean inciso1(Vertex<String> origen, Vertex<String> destino, LinkedList<String> camino, boolean[] visitados) {
    visitados[origen.getPosition()] = true; // marcamos el origen (pos actual) como visitado
		camino.add(origen.getData()); // lo añadimos a la lista (camino)
		if (origen.getData().equals(destino.getData())) // si es el destino, retornamos
            return true;

		for (Edge<String> e : this.mapaCity.getEdges(origen)) { // usamos los edges para obtener los vecinos
        Vertex<String> vecino = e.getTarget(); // sacamos el target del edge --> vecino

        if (!visitados[vecino.getPosition()]) { // si el vecino no está visitado

            if (inciso1(vecino, destino, camino, visitados)) // recursivamos
                return true;

        }
    }
		camino.remove(camino.size() - 1);
		return false;
    }

    /*
     2. devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades): List<String>
     Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades
     que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
     vacía. (Sin tener en cuenta el combustible).
     */

    public LinkedList<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades){
        boolean [] visitados = new boolean[this.mapaCity.getSize()];
        LinkedList<String> camino = new LinkedList<String>();
        Vertex<String> origen = this.mapaCity.search(ciudad1);
        Vertex<String> destino = this.mapaCity.search(ciudad2);
        if (origen != null && destino != null)
            inciso2(origen, destino, camino, visitados, ciudades);
        return camino;
    }

    private boolean inciso2(Vertex<String> origen, Vertex<String> destino, LinkedList<String> camino, boolean[] visitados, List<String> ciudades){

    }
}
