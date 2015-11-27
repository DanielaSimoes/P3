package Aula6;

public class Legume extends Alimento implements Vegetariano{

	private static final long serialVersionUID = 1L;
	public Legume(String nome, double proteinas, double calorias, double peso){
		super(nome, proteinas, calorias, peso);
	}
	
	//n‹o sei se isto faz muito sentido
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
