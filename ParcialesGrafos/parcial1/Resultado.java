package ParcialesGrafos.parcial1;

public class Resultado {
    private int cant;
    private boolean popular;

    public Resultado(){
    }

    public void setCant(int can) {
        this.cant = cant;
    }

    public int getCant(){
        return this.cant;
    }

    public void setPopular(boolean popular) {
        this.popular = popular;
    }

    public boolean getPopular() {
        return this.popular;
    }

    public void incCant(){
        this.cant++;
    }
}
