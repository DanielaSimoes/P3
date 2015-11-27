package Aula11;

public class Quadrado extends Retangulo{
	private int lado;
	
	public Quadrado(int lado){
		super(lado, lado);
		this.lado = lado;
	}
	
	public Quadrado(Quadrado a){
		super(a.getX(), a.getY(), a.lado(),a.lado());
		this.lado = a.lado();
	}
	
	public Quadrado(int x, int y, int lado){
		super(x,y,lado,lado);
		this.lado = lado;
	}
	
	public int lado(){
		return this.lado;
	}
	
	public double Area(){
		double area = lado*lado;
		return area;
	}
	
	public double Perimetro(){
		double perimetro = lado*4;
		return perimetro;
	}
	
	public boolean equals(Quadrado b){
		return this.lado==b.lado() && b.centro().equals(this.centro());
	}
	
	public String toString(){
		String description = "Quadrado: \n Lado1: " + lado;
		return description;
	}
}
