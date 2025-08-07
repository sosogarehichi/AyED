package ParcialesArboles.parcial8;

import practica2.ejercicio1.BinaryTree;

public class parcialAB4 {


    public Integer sumaImparesPosOrdenMayorA(BinaryTree<Integer> ab, int limite) {
        Integer aux = 0;
        if (!ab.isEmpty()) {
            aux = sumar(ab, limite);
        }
        return aux;
    }

    private Integer sumar(BinaryTree<Integer> ab, Integer limite) {
        int valor = 0;
        if (ab.getData() % 2 != 0 && ab.getData() > limite) {
            valor = ab.getData();
        }
        if (ab.hasLeftChild())
            valor += sumar(ab.getLeftChild(), limite);
        if (ab.hasRightChild()) {
            valor += sumar(ab.getRightChild(), limite);
        }
        return valor;
    }

}
