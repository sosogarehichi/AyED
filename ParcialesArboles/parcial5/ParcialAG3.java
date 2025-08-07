package ParcialesArboles.parcial5;

import practica3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class ParcialAG3 {

     public List<Integer> caminoHojaMasLejana(GeneralTree<Integer> arbol) {
         LinkedList<Integer> camino = new LinkedList<Integer>();
         if (!arbol.isEmpty()) {
             resolver(arbol, camino, new LinkedList<Integer>());
         }
         return camino;
     }

     private void resolver(GeneralTree<Integer> ab, LinkedList<Integer> camino, LinkedList<Integer> caminoAux){
         camino.add(ab.getData());

         if (ab.isLeaf()) {
             if (caminoAux.size() > camino.size()) {
                 camino.clear();
                 camino.addAll(caminoAux);
             }
         } else {
             for(GeneralTree<Integer> h: ab.getChildren()) {
                 this.resolver(h, camino, caminoAux);
             }
         }
         camino.remove(camino.remove(camino.size()-1));
     }
}
