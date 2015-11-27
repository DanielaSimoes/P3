package Aula3;

public class Mercadorias extends Veiculo{
	
	private char tipoCarta = 'C';

	public Mercadorias(int lotacao, int potencia, int cilindrada, int peso){
		super(lotacao,potencia,cilindrada,peso);
	}
	
	public String toString(){
		return super.toString() + " tipo de carta: " + this.tipoCarta;
	}
	
}
