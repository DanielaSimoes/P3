package Aula4;

public class Retangulo extends Figura{

	private int altura;
	private int largura;
	
	public Retangulo(int altura, int largura){
		super(0,0);
		this.altura = altura;
		this.largura = largura;
	}
	
	public Retangulo(int x, int y, int altura, int largura){
		super(x,y);
		this.altura = altura;
		this.largura = largura;
	}
	
	public Retangulo(Retangulo a){
		super(a.getX(),a.getY());
		this.altura = a.altura();
		this.largura = a.largura();
	}
	
	public int getY(){
		return super.getY();
	}
	
	public int getX(){
		return super.getX();
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
		return super.centro();
	}
	
	public boolean equals(Retangulo b){
		return altura==b.altura() && largura==b.largura() && b.centro().equals(this.centro());
	}
	
	public String toString(){
		return "Ret�ngulo: \n Altura: " + altura + " Largura: " + largura + " Centro: " + super.centro();
	}
	
}
