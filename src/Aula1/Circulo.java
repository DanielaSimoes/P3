package Aula1;

public class Circulo {
	private double raio;
	private Ponto centro;
	
	public Circulo(Ponto centro, double raio){
		this.centro = centro;
		this.raio = raio;
	}
	
	public Circulo(double x, double y,  double raio){
		Ponto centro = new Ponto(x,y);
		this.centro = centro;
		this.raio = raio;
	}
	
	public double Area(){
		double area = 3.14*raio*raio;
		return area;
	}
	
	public double Perimetro(){
		double perimetro = 3.14*2*raio;
		return perimetro;
	}
	
	public String toString(){
		String description = "C’rculo: \n Raio: " + raio + " Centro: " + centro + " çrea " + Math.round(Area()*100)/100D + " Per’metro " + Math.round(Perimetro()*100)/100D;
		return description;
	}
}