package Aula5;

public class Motorizado extends Veiculo{

	private int cilindrada;
	private int VelMax;
	private String matricula;
	
	public Motorizado(int ano, String cor, int nRodas, int VelMax, int cilindrada, String matricula){
		super(ano, cor, nRodas);
		
		if(cilindrada<=0){
			throw new IllegalArgumentException("Cilindrada inv‡lido! ");
		}else{
			this.cilindrada = cilindrada;
		}
		
		if(VelMax<=0){
			throw new IllegalArgumentException("Velocidade m‡xima inv‡lido! ");
		}else{
			this.VelMax = VelMax;
		}
		
		if(matricula.length()<=0){
			throw new IllegalArgumentException("Matr’cula inv‡lido! ");
		}else{
			this.matricula = matricula;
		}
		
	}
}
