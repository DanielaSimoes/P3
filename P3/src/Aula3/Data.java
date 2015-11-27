package Aula3;

public class Data {
	
	private int day;
	private int month;
	private int year;
	
	public Data(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public String toString(){
		return " Dia: " + this.day + " Mês: " + this.month + " Ano: " + this.year;
	}
	
}