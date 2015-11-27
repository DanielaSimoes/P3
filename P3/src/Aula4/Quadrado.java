package Aula4;

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
	
	public double area(){
		double area = lado*lado;
		return area;
	}
	
	public double perimetro(){
		double perimetro = lado*4;
		return perimetro;
	}
	
	public boolean equals(Quadrado b){
		return this.lado==b.lado() && b.centro().equals(this.centro());
	}
	
	public String toString(){
		return "Quadrado: \n Lado: " + lado + " Centro:" + super.centro();
	}

}
