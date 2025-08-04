package practica5.ejercicio5;

import practica5.ejercicio1.*;
import practica5.ejercicio1.adjList.*;
import java.util.*;
import practica1.ejercicio8.Queue;

public class BancoItau {

    public LinkedList<Persona> jubilados(Graph<Persona> personas, int valorMax, Persona empleado, int jubiladosMax) {
        boolean[] visitados = new boolean[personas.getSize()];
        LinkedList<Persona> lista = new LinkedList<Persona>();
        Vertex<Persona> origen = personas.search(empleado);

        if (origen != null) {
            BFS(personas, origen, lista, visitados, valorMax, jubiladosMax);
        }
        return lista;
    }

    private void BFS(Graph<Persona> personas, Vertex<Persona> actual, LinkedList<Persona> lista, boolean[] visitados, int valorMax, int jubiladosMax) {
        Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
        cola.enqueue(actual);
        cola.enqueue(null);
        visitados[actual.getPosition()] = true;

        while (actual != null && valorMax > 0 && cola.size() <= jubiladosMax) {
            actual = cola.dequeue();
            if (actual != null) {
                for (Edge<Persona> e : personas.getEdges(actual)) {
                    Vertex<Persona> vecino = e.getTarget();

                    if (!visitados[vecino.getPosition()]) {
                        cola.enqueue(vecino);

                        Persona per = vecino.getData();
                        if (per.cumple() && lista.size() < jubiladosMax) {
                            lista.add(per);
                        }
                    }
                }
            } else if (!cola.isEmpty()) {
                valorMax--;
                cola.enqueue(null);
            }

        }
    }

    public static void main(String[] args) {
        //todos los grafos, arboles y ejemplos de estructuras son robados de Matias Guaymas (te quiero mucho) --> gracias Rulo por el aporte
        Graph<Persona> grafo = new AdjListGraph<>();
        Persona p = new Persona("Empleado", "Matias", "AAA", true);
        Vertex<Persona> v1 = grafo.createVertex(p);
        Vertex<Persona> v2 = grafo.createVertex(new Persona("Jubilado", "Julian", "BBB", false));
        Vertex<Persona> v3 = grafo.createVertex(new Persona("Jubilado", "Francisco", "CCC", false));
        Vertex<Persona> v4 = grafo.createVertex(new Persona("Empleado", "Valentin", "DDD", true));
        Vertex<Persona> v5 = grafo.createVertex(new Persona("Jubilado", "Omar", "EEE", true));
        Vertex<Persona> v6 = grafo.createVertex(new Persona("Empleado", "Rosana", "FFF", true));
        Vertex<Persona> v7 = grafo.createVertex(new Persona("Jubilado", "Maria", "GGG", false));
        Vertex<Persona> v8 = grafo.createVertex(new Persona("Jubilado", "Sandra", "HHH", true));
        Vertex<Persona> v9 = grafo.createVertex(new Persona("Jubilado", "Matheo", "III", false));

        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);

        grafo.connect(v1, v9);
        grafo.connect(v9, v1);
        grafo.connect(v9, v8);
        grafo.connect(v8, v9);

        grafo.connect(v1, v4);
        grafo.connect(v4, v1);
        grafo.connect(v1, v6);
        grafo.connect(v6, v1);
        grafo.connect(v4, v5);
        grafo.connect(v5, v4);
        grafo.connect(v5, v7);
        grafo.connect(v7, v5);


        BancoItau banco = new BancoItau();

        System.out.println(banco.jubilados(grafo, 2, p, 40));
    }
}
