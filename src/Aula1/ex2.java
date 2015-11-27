package Aula1;
import java.util.*;

public class ex2 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int response = 0;
		
		do{
			try{
				System.out.println("Listar -> 1");
				System.out.println("Adicionar -> 2");
				System.out.println("Remover -> 3");
				System.out.println("Listar ordenado por CC -> 4");
				System.out.println("Listar ordenado por nome -> 5");
				System.out.println("Sair -> 0");
				response = sc.nextInt();
			}catch(InputMismatchException e){
				System.err.println("N‹o pode inserir letras onde devem constar nœmeros!");
			}
			
			switch(response){
				case 1: list();
					break;
				case 2: add();
					break;
				case 3:	remove();
					break;
				case 4: orderByCC();
					break;
				case 5: orderByName();
					break;
				case 0: 
					break;
			}
			
		}while(response!=0);
		
	}
	
	public static void orderByName(){
		Manager.orderByName();
	}
	
	public static void orderByCC(){
		Manager.orderByCC();
	}
	
	public static void remove(){
		Scanner sc = new Scanner(System.in);
		System.out.println("CC: ");
		String cc = sc.next();
		
		Manager.delete(cc);
	}
	
	public static void add(){
		Scanner sc = new Scanner(System.in);
		try{
			System.out.println("Nome: ");
			String name = sc.next();
			System.out.println("CC: ");
			int cc = sc.nextInt();
			System.out.println("Data de nascimento: ");
			System.out.println("Dia: ");
			int day = sc.nextInt();
			System.out.println("Ms: ");
			int month = sc.nextInt(); 
			System.out.println("Ano: ");
			int year = sc.nextInt();
		
			if (validateName(name) && validateCC(cc) && validateDate(day,month,year)){
				Data data = new Data(day, month, year);
				Pessoa nova = new Pessoa(name, cc, data);
				Manager.add(Integer.toString(cc), nova);
			}else{
				System.out.println("Inseriu dados incorretos!");
			}
			
		}catch(InputMismatchException e){
			System.err.println("N‹o pode inserir letras onde devem constar nœmeros!");
		}
		
	}
	
	public static boolean validateName(String name){
		if(name.length()>0)
			return true;
		else
			return false;
	} 
	
	public static boolean validateCC(int cc){
		if(cc>0 && Integer.toString(cc).length()==8) //o num de cc tem 8 digitos
			return true;
		else
			return false;
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
				case 11:
					if(day>0 && day <=30){
						return true;
					}
			}
		}else{
			return false;
		}
		
		return false;
	}
	
	public static void list(){
		Manager.list();
	}
	
}