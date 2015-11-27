package Aula11;

public class Pessoa {
	private String name;
	private int cc;
	private Data date;
	
	public Pessoa(String name, int cc, Data date){
		this.name = name;
		this.cc = cc;
		this.date = date;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getDate(){
		return date.toString();
	}
	
	public int getCC(){
		return this.cc;
	}
	
	@Override public String toString(){
		return "Nome: " + this.name + " CC: " + this.cc + " Data de nascimento: " + date;
	}
}
