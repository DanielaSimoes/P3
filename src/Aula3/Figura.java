package Aula3;

public class Figura {
	
	private Ponto centro;
	
	public Figura(int x, int y){
		Ponto novo = new Ponto(x,y);
		this.centro = novo;
	}
	
	public Figura(Ponto centro2){
		this.centro = centro2;
	}
	
	public int getX(){
		return centro.getX();
	}
	
	public int getY(){
		return centro.getY();
	}
	
	public Ponto centro(){
		return this.centro;
	}
	
}
