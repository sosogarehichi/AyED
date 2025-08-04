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

    public LinkedList<String> devolverCamino(String ciudad1, String ciudad2) {
        boolean[] visitados = new boolean[this.mapaCity.getSize()]; // vector de visitados
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

    public LinkedList<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades) {
        boolean[] visitados = new boolean[this.mapaCity.getSize()];
        LinkedList<String> camino = new LinkedList<String>();
        Vertex<String> origen = this.mapaCity.search(ciudad1);
        Vertex<String> destino = this.mapaCity.search(ciudad2);
        if (origen != null && destino != null)
            inciso2(origen, destino, camino, visitados, ciudades);
        return camino;
    }

    private boolean inciso2(Vertex<String> origen, Vertex<String> destino, LinkedList<String> lista, boolean[] visitados, List<String> ciudades) {
        // primero debo ver si está en la lista de prohibidos
        // si está --> se retorna para que siga con los otros
        if (ciudades.contains(origen.getData())) {
            return false;
        }
        visitados[origen.getPosition()] = true; // marcamos como visitado
        lista.add(origen.getData()); // agregamos a la lista

        if (origen.getData().equals(destino.getData())) // si es el destino, retornamos
            return true;

        for (Edge<String> e : this.mapaCity.getEdges(origen)) {
            Vertex<String> vecino = e.getTarget(); // extraemos el vecino

            if (!visitados[vecino.getPosition()] && !ciudades.contains(vecino.getData())) { // chequeamos si fue visitado y que no este prohibido
                if (inciso2(vecino, destino, lista, visitados, ciudades)) {
                    return true;
                }
            }
        }
        lista.remove(lista.size() - 1);
        return false;
    }

    /*
    3. caminoMasCorto(String ciudad1, String ciudad2): List<String>
     Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no
     existe camino retorna la lista vacía. (Las rutas poseen la distancia).
     */

    public LinkedList<String> caminoMasCorto(String ciudad1, String ciudad2) {
        boolean [] visitados = new boolean[this.mapaCity.getSize()];
        LinkedList<String>  camino = new LinkedList<String>();
        Vertex<String> origen = this.mapaCity.search(ciudad1);
        Vertex<String> destino = this.mapaCity.search(ciudad2);
        if (origen != null && destino != null) {
            inciso3(origen, destino, camino,  new LinkedList<String>(), visitados, 0, Integer.MAX_VALUE);
                                             // "camino actual"                    "distActual y distMinima"
        }
        return camino;
    }

    private int inciso3(Vertex<String> actual, Vertex<String> destino, LinkedList<String> camino, LinkedList<String> camActual, boolean [] visitados, int distActual, int distMin){
        visitados[actual.getPosition()] = true;
        camActual.add(actual.getData());

        if (actual.equals(destino) && distActual < distMin) {
            camino.removeAll(camino);
            camino.addAll(camActual);
            distMin = distActual;
        } else {
            for (Edge<String> e : this.mapaCity.getEdges(actual)) {
                Vertex<String> vecino = e.getTarget();
                int peso = e.getWeight();

                if (!visitados[vecino.getPosition()] && distActual + peso < distMin) {
                    inciso3(vecino, destino, camino, camActual, visitados, distActual + peso, distMin);
                }
            }
        }

        visitados[actual.getPosition()] = false;
        camActual.remove(camActual.size() - 1);
        return distMin;
    }

    /*
    4. caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto): List<String>
     Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe
     quedarse sin combustible y no puede cargar. Si no existe camino retorna la lista vacía.
     */

    public LinkedList<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanque) {
        boolean [] visitados = new boolean [this.mapaCity.getSize()];
        LinkedList<String> camino = new LinkedList<String>();
        Vertex<String> origen = this.mapaCity.search(ciudad1);
        Vertex<String> destino = this.mapaCity.search(ciudad2);
        if (origen != null && destino != null) {
            inciso4(origen, destino, camino, visitados, tanque);
        }
        return camino;
    }

    private boolean inciso4(Vertex<String> actual, Vertex<String> destino, LinkedList<String> camino, boolean [] visitados, int tanque) {
        visitados[actual.getPosition()] = true;
        camino.add(actual.getData());
        if (actual.equals(destino)) {
            return true;
        }

        for (Edge<String> e : this.mapaCity.getEdges(actual)) {
            Vertex<String> vecino = e.getTarget();

            if (!visitados[vecino.getPosition()] && e.getWeight() <= tanque) {
                if (inciso4(actual, destino, camino, visitados, tanque - e.getWeight())){
                    return true;
                }
            }
        }
        visitados[actual.getPosition()] = false;
         camino.remove(camino.size() - 1);
         return false;
    }

    /*
    5. caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto): List<String>
     Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2 teniendo en cuenta
     que el auto debe cargar la menor cantidad de veces. El auto no se debe quedar sin combustible en
     medio de una ruta, además puede completar su tanque al llegar a cualquier ciudad. Si no existe camino
     retorna la lista vacía.
     */

    public LinkedList<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanque) {
        boolean[] visitados = new boolean[this.mapaCity.getSize()];
        LinkedList<String> camino = new LinkedList<String>();
        Vertex<String> origen = this.mapaCity.search(ciudad1);
        Vertex<String> destino = this.mapaCity.search(ciudad2);
        if (origen != null && destino != null) {
            inciso5(origen, destino, visitados, camino, new LinkedList<String>(), tanque, 0, Integer.MAX_VALUE, tanque);
        }
        return camino;
    }

    private int inciso5(Vertex<String> actual, Vertex<String> destino, boolean[] visitados, LinkedList<String> camino, LinkedList<String> camActual, int combustible, int cantRecarga, int minRecarga, int tanque) {
        visitados[actual.getPosition()] = true;
        camActual.add(actual.getData());

        if (actual.equals(destino) && cantRecarga < minRecarga) {
            camino.removeAll(camino);
            camino.addAll(camActual);
            minRecarga = cantRecarga;
        } else {
            for (Edge<String> e : this.mapaCity.getEdges(actual)) {
                Vertex<String> vecino = e.getTarget();
                if (!visitados[vecino.getPosition()]) {
                    int peso = e.getWeight();
                    if (combustible >= peso) {
                        inciso5(vecino, destino, visitados, camino, camActual, combustible - peso, cantRecarga, minRecarga, tanque);
                    } else if (tanque >= peso) {
                        inciso5(vecino, destino, visitados, camino, camActual, tanque - peso, cantRecarga + 1, minRecarga, tanque);
                    }
                }
            }
        }
        visitados[actual.getPosition()] = false;
        camActual.remove(camActual.size() - 1);
        return minRecarga;
    }

}
