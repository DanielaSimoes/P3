package Aula11;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OccurencesCounter {
	private HashMap<String, Integer> words = new HashMap<>();
	private int num = 0;
	
	public void read(File file) throws IOException{
		Scanner reader = new Scanner(file);
		
		while(reader.hasNext()){
			
			String tmp = reader.next();
			
			if(words.containsKey(tmp)){
				num = words.get(tmp);
				num++;
				words.put(tmp, num);
			}else{
				words.put(tmp, 1);
			}
			
		}
		reader.close();
	}
	
	public String ListOfOccurences(){
		String tmp = "";
		for(Entry<String, Integer> it : words.entrySet()){
			tmp += it.getKey() + "   " + it.getValue() + "\n";
		}
		return tmp;
	}
}
