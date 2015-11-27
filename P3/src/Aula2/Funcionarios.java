package Aula2;

public class Funcionarios{
	private String nome;
	private int cc;
	private Data dataNasc;
	private int nFunc;
	private int nif;
	
	public Funcionarios(String nome, int cc, Data dataNasc, int nFunc, int nif){
		this.nome = nome;
		this.cc = cc;
		this.dataNasc = dataNasc;
		this.nFunc = nFunc;
		this.nif = nif;
	}
	

	public int getCC(){
		return this.cc;
	}
	
	public String toString(){
		return "Nome: " + this.nome + ", CC: " + this.cc + ", Data de Nascimento:" 
				+ this.dataNasc + ", N¼ Funcion‡rio: " + this.nFunc + ", NIF: " + this.nif;
	}


}