package Aula2;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Cliente {
	
	private Data dataInsc;
	private Funcionarios funcionario;
	private Estudantes estudante;
	
	//construtor que recebe um estudante
	public Cliente(String nome, int cc, Data dataNasc, int nMec, String curso){
		this.estudante = new Estudantes(nome, cc, dataNasc, nMec, curso);
		this.funcionario = null;
		
		Calendar c = new GregorianCalendar();
		int dia = c.get(Calendar.DAY_OF_MONTH);
		int mes = c.get(Calendar.MONTH)+1;
		int ano = c.get(Calendar.YEAR);
		Data data = new Data(dia, mes, ano);
		
		this.dataInsc = data;
	}
	
	//construtor que recebe um funcionario
	public Cliente(String nome, int cc, Data dataNasc, int nFunc, int nif){
		this.funcionario = new Funcionarios(nome, cc, dataNasc, nFunc, nif);
		this.estudante = null;
		
		Calendar c = new GregorianCalendar();
		int dia = c.get(Calendar.DAY_OF_MONTH);
		int mes = c.get(Calendar.MONTH)+1;
		int ano = c.get(Calendar.YEAR);
		Data data = new Data(dia, mes, ano);
		
		this.dataInsc = data;
	}
	
	public int getCC(){
		return (isEstudante() ? this.estudante.getCC() : this.funcionario.getCC());
	}
	
	public boolean isEstudante(){
		return this.funcionario == null;
	}
	
	public boolean isFuncionario(){
		return this.estudante == null;
	}
	
	public String toString(){
		return " Data de Inscrição:" + dataInsc.toString() + "\n" + (isEstudante() ? this.estudante : this.funcionario );
	}
}
