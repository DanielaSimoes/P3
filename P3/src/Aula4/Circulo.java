package Aula4;

public class Circulo extends Figura{
	private int raio;
	
	public Circulo(Ponto centro, int raio){
		super(centro);
		this.raio = raio;
	}
	
	public Circulo(int raio){
		super(0,0);
		this.raio = raio;
	}
	
	public Circulo(Circulo a){
		super(a.centro());
		this.raio = a.raio();
	}
	
	public Circulo(int x, int y, int raio){
		super(x,y);

		this.raio = raio;
	}
	
	public Ponto centro(){
		return super.centro();
	}
	
	public int raio(){
		return this.raio;
	}
	
	public double area(){
		double area = 3.14*raio*raio;
		return area;
	}
	
	public double perimetro(){
		double perimetro = 3.14*2*raio;
		return perimetro;
	}
	
	public String toString(){
		return "C’rculo: \n Raio: " + raio + " Centro:" + centro().toString();
	}
	
	public boolean equals(Circulo b){
		return raio==b.raio() && b.centro().equals(this.centro());
	}
}
