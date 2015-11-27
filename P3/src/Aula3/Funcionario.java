package Aula3;

public class Funcionario extends Cliente{
	private int nFunc;
	private int nif;
	
	public Funcionario(String nome, int cc, Data dataNasc, int nFunc, int nif){
		super(nome, cc, dataNasc);
		this.nFunc = nFunc;
		this.nif = nif;
	}
	
	public String toString(){
		return super.toString() + ", N¼ Funcion‡rio: " + this.nFunc + ", NIF: " + this.nif;
	}

}
