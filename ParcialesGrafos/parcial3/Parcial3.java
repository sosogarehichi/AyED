package ParcialesGrafos.parcial3;

import practica5.ejercicio1.Edge;
import practica5.ejercicio1.Graph;
import practica5.ejercicio1.Vertex;
import practica5.ejercicio1.adjList.AdjListGraph;

import java.util.LinkedList;
import java.util.List;

public class Parcial3 {

    public List<String> recorrido (Graph<String> grafo, int cantLocalidades, int cantNafta, List<String> exceptuados){
        boolean[] visitados = new boolean[grafo.getSize()];
        LinkedList<String> camino = new LinkedList<String>();
        Vertex<String> origen = grafo.search("Mendoza");
        if (origen != null) {
            dfs(grafo, origen, camino, visitados, 1, cantLocalidades, 0, cantNafta, exceptuados);
        }
        return camino;
    }

    private boolean dfs(Graph<String> grafo, Vertex<String> actual, LinkedList<String> camino, boolean[] visitados, int cant, int cantLocalidades, int nafta, int cantNafta, List<String> exceptuados) {
        visitados[actual.getPosition()] = true;
        camino.add(actual.getData());

        if (cant == cantLocalidades) {
            return true;
        }

        for (Edge<String> e : grafo.getEdges(actual)) {
            Vertex<String> vecino = e.getTarget();
            int peso = e.getWeight();

            if (!visitados[vecino.getPosition()] && !exceptuados.contains(vecino.getData()) &&  nafta + peso <= cantNafta) {
                if (dfs(grafo, vecino, camino, visitados, cant + 1, cantLocalidades, nafta + peso, cantNafta, exceptuados)) {
                    return true;
                }
            }
        }

        visitados[actual.getPosition()] = false;
        camino.remove(camino.size() -1 );
        return false;
    }

    // main no hecho por mi!!
    public static void main(String args[]) {
        Graph<String> grafo = new AdjListGraph<String>();
        Vertex<String> v1 = grafo.createVertex("Mendoza");
        Vertex<String> v2 = grafo.createVertex("Tunuyán");
        Vertex<String> v3 = grafo.createVertex("San Martin");
        Vertex<String> v4 = grafo.createVertex("La Paz");
        Vertex<String> v5 = grafo.createVertex("Santa Rosa");
        Vertex<String> v6 = grafo.createVertex("San Rafael");
        Vertex<String> v7 = grafo.createVertex("Malargue");
        Vertex<String> v8 = grafo.createVertex("General Alvear");

        grafo.connect(v1, v2, 10);
        grafo.connect(v1, v3, 6);
        grafo.connect(v2, v3, 10);
        grafo.connect(v3, v4, 8);
        grafo.connect(v4, v5, 2);
        grafo.connect(v3, v6, 13);
        grafo.connect(v6, v2, 11);
        grafo.connect(v6, v8, 7);
        grafo.connect(v2, v7, 12);
        grafo.connect(v8, v7, 6);

        List<String> localidadesExceptuadas = new LinkedList<String>();
        localidadesExceptuadas.add("General Alvear");
        localidadesExceptuadas.add("La Paz");

        Parcial3 p = new Parcial3();

        System.out.println(p.recorrido(grafo, 5, 80, localidadesExceptuadas));
    }
}
