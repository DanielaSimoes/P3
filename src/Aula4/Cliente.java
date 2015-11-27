package Aula4;

public class Cliente extends Pessoa {
	private static int numSocioAtual = 1;
	private int numSocio;
	
	public Cliente(String nome, int cc, Data dataNasc){
		super(nome, cc, dataNasc);
		this.numSocio = this.numSocioAtual++;
	}
	
	public String toString(){
		return super.toString() + " N¼ Socio: " + this.numSocio;
	}
	
}
