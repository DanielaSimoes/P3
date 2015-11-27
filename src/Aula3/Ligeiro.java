package Aula3;

public class Ligeiro extends Veiculo{
	private char tipoCarta = 'B';
	
	public Ligeiro(int lotacao, int potencia, int cilindrada, int peso){
		super(lotacao,potencia,cilindrada,peso);
		if(peso>3500){
			throw new IllegalArgumentException("Peso bruto inválido!");
		}
		if(lotacao<=0 || lotacao>9){
			throw new IllegalArgumentException("Lotação inválida!");
		}
	}
	
	public String toString(){
		return super.toString() + " tipo de carta: " + this.tipoCarta;
	}
	
}
