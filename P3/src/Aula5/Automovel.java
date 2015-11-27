package Aula5;

public class Automovel extends Motorizado{
	
	public Automovel(int ano, String cor, int nRodas, int VelMax, int cilindrada, String matricula){
		super(ano, cor, nRodas, VelMax, cilindrada, matricula);
	}
	
	public String toString(){
		return super.toString();
	}
	
}
