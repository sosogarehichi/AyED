package ParcialesGrafos.parcial2;

import practica5.ejercicio1.*;
import java.util.LinkedList;

public class Parcial2 {

    public String resolver(Graph<Recinto> sitios, int tiempo) {
        boolean[] visitados = new boolean[sitios.getSize()];
        LinkedList<String> camino = new LinkedList<String>();
        Vertex<Recinto> origen = sitios.getVertex(1);
        String res = "No Alcanzable";
        if (origen != null) {
            int peso = origen.getData().getTiempo();
            if (resuelve(sitios, origen, visitados, camino, tiempo - peso)) {
                res = "Alcanzable";
            }
        }
        return res;
    }

    private boolean resuelve(Graph<Recinto> sitios, Vertex<Recinto> actual, boolean[] visitados, LinkedList<String> camino, int tiempo){
        visitados[actual.getPosition()] = true;
        camino.add(actual.getData().getNombre());

        if (camino.size() == sitios.getSize()) {
            return true;
        }

        for (Edge<Recinto> e : sitios.getEdges(actual)) {
            Vertex<Recinto> vecino = e.getTarget();
            int peso = e.getWeight() + vecino.getData().getTiempo();
            if (!visitados[vecino.getPosition()] && peso <= tiempo) {
                if (resuelve(sitios, vecino, visitados, camino, tiempo - peso)) {
                    return true;
                }
            }
        }
        visitados[actual.getPosition()] = false;
        camino.remove(camino.size() - 1);
        return false;
    }
}
