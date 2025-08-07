package ParcialesGrafos.parcial1;

import practica5.ejercicio1.*;
import practica1.ejercicio8.Queue;


public class Parcial1 {

    public Resultado nivelPopularidad(Graph<String> red, String usuario, int distancia, int umbral) {
        boolean[] visitados = new boolean[red.getSize()];
        Vertex<String> origen = red.search(usuario);
        Resultado res = new Resultado();
        if (origen != null) {
            res.setCant(0);
            res.setPopular(false);
            nivelResuelve(red, origen, visitados, distancia, umbral, res);
        } else
            return null;
        return res;
    }

    private void nivelResuelve(Graph<String> red, Vertex<String> actual, boolean[] visitados, int dist, int umbral, Resultado res) {
        Queue<Vertex<String>> cola = new Queue<Vertex<String>>();
        cola.enqueue(actual);
        cola.enqueue(null);
        visitados[actual.getPosition()] = true;

        while (!cola.isEmpty() && dist > 0) {
            actual = cola.dequeue();

            if (actual != null) {
                for (Edge<String> e : red.getEdges(actual)){
                    Vertex<String> vecino = e.getTarget();

                    if (!visitados[vecino.getPosition()]) {
                        visitados[vecino.getPosition()] = true;
                        cola.enqueue(vecino);
                        res.incCant();
                    }
                }
            } else if (!cola.isEmpty()) {
                dist--;
                cola.enqueue(null);
            }
        }

        if (res.getCant() >= umbral) {
            res.setPopular(true);
        }
    }
}
