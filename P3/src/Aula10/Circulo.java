package Aula10;

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

	public double Area(){
		double area = 3.14*raio*raio;
		return area;
	}

	public double Perimetro(){
		double perimetro = 3.14*2*raio;
		return perimetro;
	}

	public String toString(){
		String description = "Circulo: \n Raio: " + raio + " Centro: " + centro().toString();
		return description;
	}

	public boolean equals(Circulo b){
		return raio==b.raio() && b.centro().equals(this.centro());
	}
}
