package Aula3;

public class Aluno extends Cliente{
	private int nMec;
	private String curso;
	
	public Aluno(String nome, int cc, Data dataNasc, int nMec, String curso){
		super(nome,cc,dataNasc);
		this.nMec = nMec;
		this.curso = curso;
	}
	
	public String toString(){
		return super.toString() + ", nMec: " + this.nMec + ", Curso: " + this.curso;
	}

}
