package Aula11;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class WordCounter {
	
	private HashSet<String> differentWords = new HashSet<>();
	private int num = 0;
	
	public void read(File file) throws IOException{
		Scanner reader = new Scanner(file);
		
		while(reader.hasNext()){
			num++;
			differentWords.add(reader.next());
		}
		reader.close();
	}
	
	public int NumberOfWords(){
		return num;
	}
	
	public int NumberOfDifferentWords(){
		return differentWords.size();
	}
	
}
