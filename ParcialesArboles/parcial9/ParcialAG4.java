package ParcialesArboles.parcial9;

import practica3.ejercicio1.GeneralTree;
import practica1.ejercicio8.*;

// lo arranqué y me rendí son las 2:36 am

public class ParcialAG4 {

    public int resolver(GeneralTree<Integer> arbol) {
        int suma = 0;
        if (!arbol.isEmpty()) {
            Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
            cola.enqueue(arbol);
            cola.enqueue(null);

            while (!cola.isEmpty()) {
                GeneralTree<Integer> aux = cola.dequeue();

                if (aux != null) {
                    if (aux.isLeaf()) {
                        suma *= aux.getData();
                    } else {
                        for (GeneralTree<Integer> hijo : aux.getChildren()) {
                            cola.enqueue(hijo);
                        }
                    }
                } else {
                    if (!cola.isEmpty()) {
                        cola.enqueue(null);
                    }
                }
            }
        }
        return suma;
    }
}
