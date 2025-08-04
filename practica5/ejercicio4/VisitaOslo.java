package practica5.ejercicio4;

import java.util.*;
import practica5.ejercicio1.*;
import practica5.ejercicio1.adjList.*;

/*
    Se quiere realizar un paseo en bicicleta por lugares emblemáticos de Oslo. Para esto se cuenta con un grafo de
    bicisendas. Partiendo desde el “Ayuntamiento” hasta un lugar destino en menos de X minutos, sin pasar por un
    conjunto de lugares que están restringidos.
 */

public class VisitaOslo {

    public LinkedList<String> paseoEnBici(Graph<String> grafo, String destino, int maxTiempo, List<String> restringido) {
        boolean [] visitados = new boolean[grafo.getSize()];
        LinkedList<String> camino = new LinkedList<String>();
        Vertex<String> origen = grafo.search("Ayuntamiento");
        Vertex<String> destinoV = grafo.search(destino);
        if (origen != null && destinoV != null) {
            PEB(grafo, origen, destinoV, visitados, camino, maxTiempo, 0, restringido);
        }
        return camino;
    }

    public boolean PEB(Graph<String> grafo, Vertex<String> actual, Vertex<String> destino, boolean[] visitados, LinkedList<String> camino, int maxTiempo, int actTiempo, List<String> restringidos){
        visitados[actual.getPosition()] = true;
        camino.add(actual.getData());

        if (actual.equals(destino)) {
            return true;
        }

        for (Edge<String> e : grafo.getEdges(actual)) {
            Vertex<String> vecino = e.getTarget();
            int peso = e.getWeight();

            if(!visitados[vecino.getPosition()] && !restringidos.contains(vecino.getData()) && actTiempo + peso < maxTiempo){
                if (PEB(grafo, vecino, destino, visitados, camino, maxTiempo, actTiempo + peso, restringidos)){
                    return true;
                }
            }
        }

        visitados[actual.getPosition()] = false;
        camino.remove(camino.size() - 1);
        return false;
    }

    public static void main(String[] args) {

        Graph<String> lugares = new AdjListGraph<String>();
        Vertex<String> v1 = lugares.createVertex("Holmenkollen");
        Vertex<String> v2 = lugares.createVertex("Parque Vigeland");
        Vertex<String> v3 = lugares.createVertex("Galería Nacional");
        Vertex<String> v4 = lugares.createVertex("Parque Botánico");
        Vertex<String> v5 = lugares.createVertex("Museo Munch");
        Vertex<String> v6 = lugares.createVertex("FolkMuseum");
        Vertex<String> v7 = lugares.createVertex("Palacio Real");
        Vertex<String> v8 = lugares.createVertex("Ayuntamiento");
        Vertex<String> v9 = lugares.createVertex("El Tigre");
        Vertex<String> v10 = lugares.createVertex("Akker Brigge");
        Vertex<String> v11 = lugares.createVertex("Museo Fram");
        Vertex<String> v12 = lugares.createVertex("Museo Vikingo");
        Vertex<String> v13 = lugares.createVertex("La Opera");
        Vertex<String> v14 = lugares.createVertex("Museo del Barco Polar");
        Vertex<String> v15 = lugares.createVertex("Fortaleza Akershus");

        lugares.connect(v1, v2, 30);
        lugares.connect(v2, v1, 30);
        lugares.connect(v2, v3, 10);
        lugares.connect(v3, v2, 10);
        lugares.connect(v3, v4, 15);
        lugares.connect(v4, v3, 15);
        lugares.connect(v4, v5, 1);
        lugares.connect(v5, v4, 1);

        lugares.connect(v5, v9, 15);
        lugares.connect(v9, v5, 15);
        lugares.connect(v9, v13, 5);
        lugares.connect(v13, v9, 5);
        lugares.connect(v13, v15, 10);
        lugares.connect(v15, v13, 10);

        lugares.connect(v2, v6, 20);
        lugares.connect(v6, v2, 20);
        lugares.connect(v6, v7, 5);
        lugares.connect(v7, v6, 5);
        lugares.connect(v7, v8, 5);
        lugares.connect(v8, v7, 5);
        lugares.connect(v6, v10, 30);
        lugares.connect(v10, v6, 30);
        lugares.connect(v10, v8, 20);
        lugares.connect(v8, v10, 20);
        lugares.connect(v8, v4, 10);
        lugares.connect(v4, v8, 10);
        lugares.connect(v8, v9, 15);
        lugares.connect(v9, v8, 15);

        lugares.connect(v6, v11, 5);
        lugares.connect(v11, v6, 5);
        lugares.connect(v10, v12, 30);
        lugares.connect(v12, v10, 30);
        lugares.connect(v11, v14, 5);
        lugares.connect(v14, v11, 5);
        lugares.connect(v12, v14, 5);
        lugares.connect(v14, v12, 5);

        List<String> lugaresRestringidos = new LinkedList<String>();
        lugaresRestringidos.add("Akker Brigge");
        lugaresRestringidos.add("Palacio Real");
        VisitaOslo vis = new VisitaOslo();
        List<String> camino = vis.paseoEnBici(lugares, "Museo Vikingo", 120, lugaresRestringidos);

        System.out.println(camino);

    }
}
