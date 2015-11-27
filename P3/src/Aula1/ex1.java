package Aula1;
import java.util.*;

public class ex1 {
static Scanner sc = new Scanner(System.in);	

	public static void main (String args[]) {
	
		System.out.println("Insira a string:");
		String str = sc.nextLine();
		
		boolean upper = SoMaiusculas(str);
		System.out.println("Apenas maiusculas: " + upper);
		
		boolean lower = SoMinusculas(str);
		System.out.println("Apenas minusculas: " + lower);
		
		int totalNums = QuantNums(str);
		System.out.println("Quantos digitos: " + totalNums);
		
		int totalPalavras = QuantPalavras(str);
		System.out.println("Quantas palavras: " + totalPalavras);
		
		String trocada = Trocar(str);
		System.out.println("Trocada: " + trocada);
		
	}
	
	public static boolean SoMaiusculas(String str){
		int isupper = 0;
		for(int i = 0; i < str.length(); i++){
			if(Character.isUpperCase(str.charAt(i))){
				isupper++;
			}
		}
		if(isupper==str.length())
			return true;
		else
			return false;
	}
	
	public static boolean SoMinusculas(String str){
		int islower = 0;
		for(int i = 0; i < str.length(); i++){
			if(Character.isLowerCase(str.charAt(i))){
				islower++;
			}
		}
		if(islower==str.length())
			return true;
		else
			return false;
	}
	
	public static int QuantNums(String str){
		int qnt=0;
		for(int i = 0; i < str.length(); i++){
			if(Character.isDigit(str.charAt(i))){
				qnt++;
			}
		}
		return qnt;
	}
	
	public static int QuantPalavras(String str){
		String tmp[] = str.split("[,;-?!... ]+");
		return tmp.length;
	}
	
	public static String Trocar(String str){
		String nova = "";
		if(str.length()%2!=0){
			for(int i = 0; i < str.length(); i++){
				if(i!=str.length()-1 && !Integer.toString(i).equals(" ")){
					nova +="" + Character.toString(str.charAt(i + 1)) + Character.toString(str.charAt(i));
					i++;
				}
			}
			nova += Character.toString(str.charAt(str.length()-1));
		}else{
			for(int i = 0; i < str.length(); i++){
					nova += Character.toString(str.charAt(i + 1)) + Character.toString(str.charAt(i));
					i++;
			}
		}
		return nova.toString();
	}

}