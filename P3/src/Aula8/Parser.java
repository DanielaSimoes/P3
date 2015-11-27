package Aula8;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
	private ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();
	
	public Parser(File f) throws IOException{
		FileReader reader = new FileReader(f);
		Scanner sc = new Scanner(reader);
		
		while(sc.hasNextLine()){
			parseLine(sc.nextLine());
		}
	}
	
	public void parseLine(String line){
		String[] tmp = line.split("&&");
		String[] respostas = {tmp[2], tmp[3], tmp[4], tmp[5]};
		Pergunta p = new Pergunta(tmp[6], tmp[1], tmp[0], respostas, tmp[2]);
		perguntas.add(p);
	}
	
	public Pergunta[] getPerguntas(){
		return perguntas.toArray(new Pergunta[0]);
	}
	
}
