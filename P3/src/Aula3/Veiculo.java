package Aula3;

public class Veiculo {
	
	private int lotacao;
	private int potencia;
	private int cilindrada;
	private int peso;
	
	public Veiculo(int lotacao, int potencia, int cilindrada, int peso){
		this.lotacao = lotacao;
		this.potencia = potencia;
		this.cilindrada = cilindrada;
		this.peso = peso;
	}
	
	public String toString(){
		return " Lotação: " + this.lotacao + " Potência: " + this.potencia + " Cilindrada: " + this.cilindrada + " Peso: " + this.peso;
	}
	
}
