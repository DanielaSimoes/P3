package Aula4;

public class Bolseiro extends Estudante{
	
	private int montante;
	public Bolseiro(String name, int cc, Data dataN){
		super(name, cc, dataN);
	}
	
	public Bolseiro(String name, int cc, Data dataN, Data dataInsc){
		super(name, cc, dataN, dataInsc);
	}
	
	public void setBolsa(int montante){
		this.montante = montante;
	}
	
	public double bolsa(){
		return this.montante;
	}
	
	
	@ Override public String toString(){
		return super.toString() + ", Montante: " + this.montante;
	}

}
