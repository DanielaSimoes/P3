package Aula4;
import java.util.ArrayList;

public class Disciplina {
	private String nome;
	private String areaCientifica;
	private int ECTs;
	private Professor responsavel;
	private ArrayList<Estudante> alunos = new ArrayList<Estudante>();
	
	public Disciplina(String nome, String areaCientifica, int ECTs, Professor responsavel){
		this.nome = nome;
		this.areaCientifica = areaCientifica;
		this.ECTs = ECTs;
		this.responsavel = responsavel;
	}
	
	public boolean addAluno(Estudante est){
		//Verificar se o aluno j‡ existe
		if(alunos.contains(est)){
			return false;
		}
		
		alunos.add(est);
		return true;
	}
	
	public boolean delAluno(int nMec){
		for (int i = 0; i < alunos.size(); i++) {
			if(alunos.get(i).nMec()==nMec){
				alunos.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean alunoInscrito(int nMec){
		for (int i = 0; i < alunos.size(); i++) {
			if(alunos.get(i).nMec()==nMec){
				return true;
			}
		}
		return false;
	}
	
	public int numAlunos(){
		return alunos.size();
	}
	
	public String toString(){
		return "Disciplina: " + this.nome + ", çrea cient’fica: " + this.areaCientifica + ", ECTs: " + this.ECTs + ",\nProfessor respons‡vel: " + this.responsavel; 
	}
	
	public Estudante[] getAlunos(){
		Estudante[] tmp = new Estudante[alunos.size()];
		tmp = alunos.toArray(tmp);
		return tmp;
	}
	
	public Estudante[] getAlunos(String tipo){
		ArrayList<Estudante> tmp = new ArrayList<Estudante>();
		for (int i = 0; i < alunos.size(); i++) {
			if((alunos.get(i) instanceof Bolseiro && tipo.equals("Bolseiro")) || (alunos.get(i) instanceof Estudante && tipo.equals("Estudante"))){
				tmp.add(alunos.get(i));
			}
		}
		
		Estudante[] tmp2 = new Estudante[tmp.size()];
		tmp2 = tmp.toArray(tmp2);
		
		return tmp2;
	}

}
