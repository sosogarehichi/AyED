package ParcialesArboles.parcial7;

import java.util.LinkedList;

public class Resultado {
    private LinkedList<Integer> lista;
    private int cantPares;

    public Resultado(LinkedList<Integer> lista, int cantPares) {
        this.lista = lista;
        this.cantPares = cantPares;
    }

    public int getCantPares() {
        return cantPares;
    }

    public void setCantPares(int cantPares) {
        this.cantPares = cantPares;
    }

    public LinkedList<Integer> getLista() {
        return lista;
    }

    public void setLista(LinkedList<Integer> lista) {
        this.lista.addAll(lista);
    }
}
