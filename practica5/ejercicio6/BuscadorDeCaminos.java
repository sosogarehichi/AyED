package practica5.ejercicio6;

import practica5.ejercicio1.*;
import practica5.ejercicio1.adjList.*;
import java.util.List;
import java.util.LinkedList;


public class BuscadorDeCaminos {
    private Graph<String> bosque;

    public BuscadorDeCaminos(Graph<String> bosque) {
        this.bosque = bosque;
    }

    public List<List<String>> recorridosMasSeguro() {
        boolean[] visitados = new boolean[this.bosque.getSize()];
        Vertex<String> origen = this.bosque.search("Casa Caperucita");
        Vertex<String> destino = this.bosque.search("Casa Abuelita");
        List<List<String>> caminos = new LinkedList<List<String>>();
        if (origen != null && destino != null) {
            rms(this.bosque, origen, destino, visitados, caminos, new LinkedList<String>());
        }
        return caminos;
    }

    private void rms(Graph<String> bosque, Vertex<String> actual, Vertex<String> destino, boolean[] visitados, List<List<String>> caminos, LinkedList<String> caminoAct) {
        visitados[actual.getPosition()] = true;
        caminoAct.add(actual.getData());

        if (actual.getData().equals(destino.getData())) { // SI SE LLEGÓ AL DESTINO EN EL CAMINO ACTUAL
            caminos.add(new LinkedList<String>(caminoAct)); // lo agregamos a la lista de caminos
        } else {
            for (Edge<String> e : bosque.getEdges(actual)) {
                Vertex<String> vecino = e.getTarget();
                int cant = e.getWeight();
                if (!visitados[vecino.getPosition()] && cant < 5) {
                    rms(bosque, vecino, destino, visitados, caminos, caminoAct);
                }
            }
        }
        visitados[actual.getPosition()] = false;
        caminoAct.remove(caminoAct.size() - 1);
    }

    public static void main(String[] args) {
        Graph<String> bosque = new AdjListGraph<String>();
        Vertex<String> v1 = bosque.createVertex("Casa Caperucita");
        Vertex<String> v2 = bosque.createVertex("Claro 3");
        Vertex<String> v3 = bosque.createVertex("Claro 1");
        Vertex<String> v4 = bosque.createVertex("Claro 2");
        Vertex<String> v5 = bosque.createVertex("Claro 5");
        Vertex<String> v6 = bosque.createVertex("Claro 4");
        Vertex<String> v7 = bosque.createVertex("Casa Abuelita");
        bosque.connect(v1, v2, 4);
        bosque.connect(v2, v1, 4);
        bosque.connect(v1, v3, 3);
        bosque.connect(v3, v1, 3);
        bosque.connect(v1, v4, 4);
        bosque.connect(v4, v1, 4);
        bosque.connect(v2, v5, 15);
        bosque.connect(v5, v2, 15);
        bosque.connect(v3, v5, 3);
        bosque.connect(v5, v3, 3);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v4, v5, 11);
        bosque.connect(v5, v4, 11);
        bosque.connect(v4, v6, 10);
        bosque.connect(v6, v4, 10);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v5, v7, 4);
        bosque.connect(v7, v5, 4);
        bosque.connect(v6, v7, 9);
        bosque.connect(v7, v6, 9);
        BuscadorDeCaminos bos = new BuscadorDeCaminos(bosque);
        List<List<String>> lis = bos.recorridosMasSeguro();
        for (List<String> l : lis) {
            System.out.println(l);
        }
    }
}
