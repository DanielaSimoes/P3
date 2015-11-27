package Aula9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ex1 {
	
	public static void main(String args[]) throws IOException {
		
		String teste = "Aveiro";
		
		ScannerAbeirense sc = new ScannerAbeirense(teste);
		System.out.println(sc.nextLine());
		
		File f = new File("test.txt");
		ScannerAbeirense r = new ScannerAbeirense(f);
		
		while(r.hasNext()){
			System.out.println(r.nextLine());
		}
		
		r.close();
		
	}

}
