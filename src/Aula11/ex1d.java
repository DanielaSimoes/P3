package Aula11;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ex1d {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		String name;
		
		System.out.println("Introduza o nome do ficheiro: ");
		name = sc.nextLine();
		
		File file = new File(name);
		
		OccurencesCounterOrdenated counter = new OccurencesCounterOrdenated();
		counter.read(file);
		
		System.out.println(counter.ListOfOccurences());
	}
}
