package Aula11;

public class Cereal extends Alimento implements Vegetariano{
	public Cereal(String nome, double proteinas, double calorias, double peso){
		super(nome, proteinas, calorias, peso);
	}
	
	public double getCalorias(){
		return super.getCalorias();
	}
	
	public String toString(){
		return super.toString();
	}
	
	@Override public int hashCode(){
		return super.hashCode();
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b);
	}
}
