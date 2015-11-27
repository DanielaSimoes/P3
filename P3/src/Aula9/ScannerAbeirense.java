package Aula9;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class ScannerAbeirense implements Iterator<String>, Closeable{

	private Scanner sc;
	
	public ScannerAbeirense(String word){
		sc= new Scanner(word);
	}
	
	public ScannerAbeirense(File f) throws FileNotFoundException{
		sc = new Scanner(f);
	}
	
	public String conversao(String word){
		word = word.replace('V', 'B');
		word = word.replace('v', 'b');
		
		return word;
	}
	
	@Override
	public void close() throws IOException {
		sc.close();
	}

	@Override
	public boolean hasNext() {
		return sc.hasNext();
	}

	@Override
	public String next() {
		return conversao(sc.next());
	}
	
	public String nextLine(){
		return conversao(sc.nextLine());
	}

}
