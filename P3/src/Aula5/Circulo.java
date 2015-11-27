package Aula5;

public class Circulo extends Figura{
	private int raio;
	private Ponto centro;
	
	public Circulo(Ponto centro, int raio){
		this.raio = raio;
	}
	
	public Circulo(int raio){
		this.raio = raio;
		this.centro = new Ponto(0,0);
	}
	
	public Circulo(Circulo a){
		this.raio = a.raio();
		this.centro = a.centro();
	}
	
	public Circulo(int x, int y, int raio){
		this.raio = raio;
		this.centro = new Ponto(x,y);
	}
	
	public Ponto centro(){
		return this.centro;
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
		return "C’rculo: \n Raio: " + raio + " Centro:" + this.centro.toString();
	}
	
	public boolean equals(Circulo b){
		return raio==b.raio() && b.centro().equals(this.centro());
	}
}