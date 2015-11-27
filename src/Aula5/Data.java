package Aula5;

import java.util.Scanner;

public class Data {
	
	private int day;
	private int month;
	private int year;
	
	public Data(int day, int month, int year){
		Scanner sc = new Scanner(System.in);
		
		if (validateDate(day,month, year)){
			this.day = day;
			this.month = month;
			this.year = year;
		}else{	
			boolean valido = false;
			
			do{
				System.out.println("Data nao valida! Insira novamente: ");

				System.out.println("Dia: ");
				int dia = sc.nextInt();
				System.out.println("Mas: ");
				int mes = sc.nextInt();
				System.out.println("Ano: ");
				int ano = sc.nextInt();
				
				if(validateDate(dia,mes,ano)){
					valido = true;
				}
				
			}while(valido!=true);
		}
	}
	
	public String toString(){
		return this.day + "/" + this.month + "/" + this.year;
	}
	
	public static boolean validateDate(int day, int month, int year){
		if (year>0 && year<=2015){
			switch(month){
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					if(day>0 && day <=31){
						return true;
					}
				case 2:
					if(year%4==0 && year%400==0){ //verificar se e bissexto
						if(day>0 && day <=29){
							return true;
						}
					}else{
						if(day>0 && day <=28){
							return true;
						}
					}
				case 4:
				case 6:
				case 9:	
				case 11:
					if(day>0 && day <=30){
						return true;
					}
			}
		}
		
		return false;
	}
}