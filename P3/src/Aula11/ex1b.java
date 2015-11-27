package Aula11;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ex1b {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		String name;
		
		System.out.println("Introduza o nome do ficheiro: ");
		name = sc.nextLine();
		
		File file = new File(name);
		
		WordCounter counter = new WordCounter();
		counter.read(file);
		
		System.out.println("Numero de palavras: " + counter.NumberOfWords());
		System.out.println("Numero de palavras diferentes: " + counter.NumberOfDifferentWords());
		
	}
}
