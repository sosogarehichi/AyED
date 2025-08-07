package ParcialesArboles.parcial4;

import practica3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class ParcialAG2 {

    public static List<Integer> resolver (GeneralTree<Integer> arbol){
        LinkedList<Integer> max = new LinkedList<Integer>();
        int valor = -1;
        if (!arbol.isEmpty()) {
            resuelve(arbol, max, new LinkedList<Integer>(), valor, 1, 0);
        }
        return max;
    }

    private static void resuelve(GeneralTree<Integer> ag, LinkedList<Integer> listMax, LinkedList<Integer> listActual, int valorMax, int nivel, int suma) {
        if (ag.getData() == 1) {
            listActual.add(ag.getData());
            suma += ag.getData() * nivel;
        }

        if (ag.isLeaf()) {
            if (suma > valorMax) {
                valorMax = suma;
                listMax.clear();
                listMax.addAll(listActual);
            }
        } else {
            for (GeneralTree<Integer> hijo : ag.getChildren()) {
                resuelve(hijo, listMax, listActual, valorMax, nivel + 1, suma);
            }
        }

        if (ag.getData() == 1) {
            listActual.remove(listActual.size() - 1);
        }
    }

    public static void main(String[] args) { // este main NO es mío
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(1));
        subChildren1.add(new GeneralTree<Integer>(1));
        subChildren1.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subA = new GeneralTree<Integer>(1, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(subA);
        subChildren2.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(0, subChildren2);

        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subB = new GeneralTree<Integer>(0, subChildren3);
        List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
        subChildren4.add(subB);
        GeneralTree<Integer> subC = new GeneralTree<Integer>(0, subChildren4);
        List<GeneralTree<Integer>> subChildren5 = new LinkedList<GeneralTree<Integer>>();
        subChildren5.add(new GeneralTree<Integer>(1));
        subChildren5.add(subC);
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(1, subChildren5);

        List<GeneralTree<Integer>> subChildren6 = new LinkedList<GeneralTree<Integer>>();
        subChildren6.add(new GeneralTree<Integer>(0));
        subChildren6.add(new GeneralTree<Integer>(0));
        GeneralTree<Integer> subD = new GeneralTree<Integer>(0, subChildren6);
        List<GeneralTree<Integer>> subChildren7 = new LinkedList<GeneralTree<Integer>>();
        subChildren7.add(subD);
        GeneralTree<Integer> subE = new GeneralTree<Integer>(0, subChildren7);
        List<GeneralTree<Integer>> subChildren8 = new LinkedList<GeneralTree<Integer>>();
        subChildren8.add(subE);
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(1, subChildren8);

        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(1, arbol);

        System.out.println(resolver(a));


    }
}
