package Aula4;

public class Aluno extends Cliente{
	private int nMec;
	private String curso;
	
	public Aluno(String nome, int cc, Data dataNasc, int nMec, String curso){
		super(nome,cc,dataNasc);
		this.nMec = nMec;
		this.curso = curso;
	}
	
	public String toString(){
		return super.toString();
	}
	
	public String getCurso(){
		return this.curso;
	}
	
	public int nMec(){
		return this.nMec;
	}

}