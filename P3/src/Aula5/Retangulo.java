package Aula5;

public class Retangulo extends Figura{

	private int altura;
	private int largura;
	private Ponto centro;
	
	public Retangulo(int altura, int largura){
		this.altura = altura;
		this.largura = largura;
		this.centro = new Ponto(0,0);
	}
	
	public Retangulo(int x, int y, int altura, int largura){
		this.altura = altura;
		this.largura = largura;
		this.centro = new Ponto(x,y);
	}
	
	public Retangulo(Retangulo a){
		this.altura = a.altura();
		this.largura = a.largura();
		this.centro = a.centro();
	}
	
	public int getX(){
		return this.centro.getX();
	}
	
	public int getY(){
		return this.centro.getY();
	}
	
	public int altura(){
		return this.altura;
	}
	
	public int largura(){
		return this.largura;
	}
	
	public double area(){
		return altura*largura;
	}
	
	public double perimetro(){
		return altura*2 + largura*2;
	}
	
	public Ponto centro(){
		return this.centro;
	}
	
	public boolean equals(Retangulo b){
		return altura==b.altura() && largura==b.largura() && b.centro().equals(this.centro());
	}
	
	public String toString(){
		return "Ret�ngulo: \n Altura: " + altura + " Largura: " + largura + " Centro: " + this.centro;
	}
	
}
