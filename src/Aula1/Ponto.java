package Aula1;

public class Ponto {
	private double x;
	private double y;
	
	public Ponto(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		String description = " x: " + x + " y " + y;
		return description;
	}
	
}