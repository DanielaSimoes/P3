package Aula1;

public class Retangulo {
	private int altura;
	private int largura;
	private int x;
	private int y;
	
	public Retangulo(int altura, int largura){
		this.altura = altura;
		this.largura = largura;
		this.x = 0;
		this.y = 0;
	}
	
	public Retangulo(int x, int y, int altura, int largura){
		this.altura = altura;
		this.largura = largura;
		this.x = x;
		this.y = y;
	}
	
	public double Area(){
		double area = altura*largura;
		return area;
	}
	
	public double Perimetro(){
		double perimetro = altura*2 + largura*2;
		return perimetro;
	}
	
	public String toString(){
		String description = "Ret�ngulo: \n Altura: " + altura + " Largura: " + largura + " �rea " + Area() + " Per�metro " + Perimetro();
		return description;
	}
}