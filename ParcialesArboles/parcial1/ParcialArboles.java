package ParcialesArboles.parcial1;
import practica2.ejercicio1.*;

public class ParcialArboles {

    public BinaryTree<Nodo> sumAndDif(BinaryTree<Integer> arbol) {
        BinaryTree<Nodo> arbol2 = new BinaryTree<Nodo>();
        if (!arbol.isEmpty()) {
            sad(arbol, arbol2, 0, 0);
        }
        return arbol2;
    }

    private void sad(BinaryTree<Integer> arbol, BinaryTree<Nodo> arbol2, int suma, int dif) {
        Nodo nodo = new Nodo();
        nodo.setSuma(suma + arbol.getData());
        // agarra el valor del nodo "original"
        // suma es el camino desde la raíz hasta la hoja (va acumulando)
        nodo.setDif(arbol.getData() - dif);
        // dif es en realidad el valor del nodo padre
        // debe restarse al valor del nodo actual y se guarda
        arbol2.setData(nodo);

        if (arbol.hasLeftChild()) {
            arbol2.addLeftChild(new BinaryTree<Nodo>());
            sad(arbol.getLeftChild(), arbol2.getLeftChild(), suma + arbol.getData(), arbol.getData());
        }
        if (arbol.hasRightChild()) {
            arbol2.addRightChild(new BinaryTree<Nodo>());
            sad(arbol.getRightChild(), arbol2.getRightChild(), suma + arbol.getData(), arbol.getData());
        }
    }
}
