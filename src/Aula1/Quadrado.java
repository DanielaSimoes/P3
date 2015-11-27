package Aula1;

public class Quadrado {
	private double lado;
	
	public Quadrado(double lado){
		this.lado = lado;
	}
	
	public double Area(){
		double area = lado*lado;
		return area;
	}
	
	public double Perimetro(){
		double perimetro = lado*2;
		return perimetro;
	}
	
	public String toString(){
		String description = "Quadrado: \n Lado1: " + lado + " çrea: " + Area() + " Per’metro " + Perimetro();
		return description;
	}
}