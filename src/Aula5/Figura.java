package Aula5;

public abstract class Figura implements Comparable{
	
	public int compareTo(Object obj){
		if(this.area() > ((Figura)obj).area()){
			return 1;
		}else if(this.area() < ((Figura)obj).area()){
			return -1;
		}
		return 0;
	}
	
	public Ponto centro(){
		return centro();
	}
	
	public abstract double area();
	public abstract double perimetro();
}
