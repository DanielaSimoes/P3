package Aula12;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.Scanner;

public class ex1 {
	
	public static void main(String args[]) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		try {
			Scanner sc = new Scanner(System.in);
			String disponiveis[] = {"Aula12.Data", "Aula12.Pessoa"};
			String className;
			
			for (int i = 0; i < disponiveis.length; i++) {
				System.out.println("Strings disponiveis: " + disponiveis[i]);
			}
			className = sc.nextLine();
			
			String option;
			Class<?> p = Class.forName(className);
			LinkedList<String> ll = new LinkedList<>();
			
			getters insp = new getters(p);
			System.out.println(insp.getChar());
			
			System.out.println("-------------------------------");
			
			System.out.print("Quer criar instâncias? ");
			option = sc.next();
			
			if(option.equalsIgnoreCase("y")){
			
				do{
					
					Object inst = insp.instance();
					ll.add((String)inst.toString());
					
					System.out.print("Quer criar mais instâncias? ");
					option = sc.next();
					
					System.out.println(insp.getMethods());
					System.out.println("Escolha o metodo: ");
					int x = sc.nextInt();
					
					insp.doMethods(x, inst);
	
				}while(option.equalsIgnoreCase("y"));
			}
			
			System.out.println("-------------------------------");
			
			for(Object b : ll.toArray()){
				System.out.println(b);
			}
			
			sc.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Class não encontrada! ");
		}
	}
}
