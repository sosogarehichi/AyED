package practica1.ejercicio5;

public class Dato {
	private int min;
	private int max;
	private double promedio;
	
	public Dato(int min, int max, double promedio) {
		super();
		this.min = min;
		this.max = max;
		this.promedio = promedio;
	}
	
	public Dato() {
	}
	
	public int getMin() {
		return min;
	}
	
	public void setMin(int min) {
		this.min = min;
	}
	
	public int getMax() {
		return max;
	}
	
	public void setMax(int max) {
		this.max = max;
	}
	
	public double getPromedio() {
		return promedio;
	}
	
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	
	

}
