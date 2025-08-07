package ParcialesArboles.parcial6;

import practica2.ejercicio1.BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class Parcial {

    public List<Integer> resolver(BinaryTree<Integer> arbol) {
        LinkedList<Integer> lista = new LinkedList<Integer>();
        if (!arbol.isEmpty()) {
            nodosIgualDescendientes(arbol, lista);
        }
        return lista;
    }

    private void nodosIgualDescendientes(BinaryTree<Integer> ab, LinkedList<Integer> lista) {
        int cantIzq = 0;
        int cantDer = 0;
        if (ab.hasLeftChild()) {
            cantIzq = contarHijos(ab.getLeftChild());
        }
        if (ab.hasRightChild()) {
            cantDer = contarHijos(ab.getRightChild());
        }

        if (cantIzq == cantDer) {
            lista.add(ab.getData());
        }

        if (ab.hasLeftChild()) {
            nodosIgualDescendientes(ab.getLeftChild(), lista);
        }
        if (ab.hasRightChild()) {
            nodosIgualDescendientes(ab.getRightChild(), lista);
        }
    }

    private int contarHijos(BinaryTree<Integer> ab) {
        int cant = 1;
        if (ab.hasLeftChild()) {
            cant += contarHijos(ab.getLeftChild());
        }
        if (ab.hasRightChild()) {
            cant += contarHijos(ab.getRightChild());
        }
        return cant;
    }

}
