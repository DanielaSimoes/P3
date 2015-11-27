package Aula3;

public class Passageiros extends Veiculo{
	
	private char tipoCarta = 'D';

	public Passageiros(int lotacao, int potencia, int cilindrada, int peso){
		super(lotacao, potencia, cilindrada, peso);
		if(peso>7000){
			throw new IllegalArgumentException("Peso bruto inválido!");
		}
		if(lotacao<=0 || lotacao>150){
			throw new IllegalArgumentException("Lotação inválida!");
		}
	}
	
	public String toString(){
		return super.toString() + " tipo de carta: " + this.tipoCarta;
	}
}
