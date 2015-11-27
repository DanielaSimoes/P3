package Aula11;


public class PratoVegetariano extends Prato{
	public PratoVegetariano(String nome){
		super(nome);
	}
	
	public String toString(){
		return super.toString();
	}
	
	public boolean addIngrediente(Vegetariano v){
		if (v instanceof Vegetariano)
			return super.addIngrediente((Alimento)v);
		
		return false;
	}
	
	@Override public int hashCode(){
		return super.hashCode();
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b);
	}
}
