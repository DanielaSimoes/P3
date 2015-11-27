package Aula4;

public class Ponto{

	private int x;
	private int y;
	
	public Ponto(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Ponto(Ponto centro){
		this.x = centro.getX();
		this.y = centro.getY();
	}
	
	public String toString(){
		String description = " x: " + getX() + " y: " + getY() + " ";
		return description;
	}

	public boolean equals(Ponto p){
		return p.x==x && p.y==y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
}
