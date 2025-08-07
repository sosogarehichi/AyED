package ParcialesArboles.parcial2;

import practica1.ejercicio8.Queue;
import practica3.ejercicio1.GeneralTree;

public class ParcialAG {

    public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
        boolean ok = false;
        if (!arbol.isEmpty()) {
            ok = eds(arbol);
        }
        return ok;
    }

    // resolver por casos --> arrancar por caso base
    private static boolean eds(GeneralTree<Integer> arbol) {
        boolean ok = true;
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        cola.enqueue(arbol);
        cola.enqueue(null);

        while (!cola.isEmpty() && ok) {
            GeneralTree<Integer> aux = cola.dequeue();
            int min = Integer.MAX_VALUE;
            for (GeneralTree<Integer> hijo : aux.getChildren()) {
                if (hijo.getData() < min) {
                    min = hijo.getData();
                }
                cola.enqueue(hijo);
            }
            if (!aux.isLeaf() && aux.getData() != min) {
                ok = false;
            }
        }
        return ok;
    }
}
