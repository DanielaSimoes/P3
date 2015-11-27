package Aula10;

public abstract class Figura implements Comparable<Object>{

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
	
	abstract double Area();
	abstract double Perimetro();
	
	@Override public int compareTo(Object b){
		if(this.Area()<((Figura)b).Area()){
			return -1;
		}else if(this.Area()>((Figura)b).Area()){
			return 1;
		}else{
			return 0;
		}
	}
}
