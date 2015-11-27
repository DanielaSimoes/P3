package Aula2;

public class Estudantes{
	private String nome;
	private int cc;
	private Data dataNasc;
	private int nMec;
	private String curso;
	
	public Estudantes(String nome, int cc, Data dataNasc, int nMec, String curso){
		this.nome = nome;
		this.cc = cc;
		this.dataNasc = dataNasc;
		this.nMec = nMec;
		this.curso = curso;
	}
	
	public int getCC(){
		return this.cc;
	}
	
	public String toString(){
		return "Nome: " + this.nome + ", CC: " + this.cc + ", Data de Nascimento:" 
				+ this.dataNasc + ", N¼ Mec: " + this.nMec + ", Curso: " + this.curso;
	}

}