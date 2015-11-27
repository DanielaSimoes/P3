package Aula3;

public class Motociclo extends Veiculo{
	
	private char tipoCarta = 'A';

	public Motociclo(int lotacao, int potencia, int cilindrada, int peso){
		super(lotacao, potencia, cilindrada, peso);
		if(peso>1000){
			throw new IllegalArgumentException("Peso bruto inválido!");
		}
		if(lotacao<=0 || lotacao>2){
			throw new IllegalArgumentException("Lotação inválida!");
		}
	}
	
	public String toString(){
		return super.toString() + " tipo de carta: " + this.tipoCarta;
	}
}
