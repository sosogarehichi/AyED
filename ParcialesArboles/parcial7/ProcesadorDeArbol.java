package ParcialesArboles.parcial7;

import practica2.ejercicio1.BinaryTree;

import java.util.LinkedList;

public class ProcesadorDeArbol {
    private BinaryTree<Integer> arbol;

    public ProcesadorDeArbol(BinaryTree<Integer> ab) {
        this.arbol = ab;
    }

    public Resultado procesar() {
        int cant = 0;
        LinkedList<Integer> lista = new LinkedList<Integer>();
        if (!this.arbol.isEmpty()) {
            cant = resuelve(this.arbol, lista);
        }
        return new Resultado(lista, cant);
    }

    private int resuelve(BinaryTree<Integer> ab, LinkedList<Integer> lista) {
        int cant = 0;
        // si num es par aumento la variable de número par
        if (ab.getData() % 2 == 0) {
            cant++;
            if (ab.hasLeftChild() && ab.hasRightChild()) {
                lista.add(ab.getData());
            }
        }
        if (ab.hasLeftChild()) {
            cant += resuelve(ab.getLeftChild(), lista);
        }
        if(ab.hasRightChild()) {
            cant += resuelve(ab.getRightChild(), lista);
        }
        return cant;
    }

}
