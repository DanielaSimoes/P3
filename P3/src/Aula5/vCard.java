package Aula5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class vCard extends Listas implements ReadWriteInterface{
	
	private HashMap<String, Pessoa> pessoas;
	private File fileToRead;
	
	public vCard(HashMap<String, Pessoa> pessoas){
		this.pessoas = pessoas;
	}
	
	public vCard(File f){
		this.fileToRead = f;
	}
	
	public void read() throws IOException{
		Scanner reader = null;
		String line[] = null;
		String nome, cc, data;
		
		try{
			reader = new Scanner(fileToRead);
		}catch(FileNotFoundException e){
			System.err.println("Ficheiro nao encontrado!");
		}
		
		try{
			// o tipo de ficheiro nao e necessario ler
			reader.nextLine();
			
			while(reader.hasNextLine()){
				line = reader.nextLine().split("#");
				nome = line[1];
				cc = line[2];
				data = line[3];
				save(nome, cc,data);
				
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		
		reader.close();
		
	}
	
	public void save(String nome, String cc, String data){
		String DataTmp[] = data.split("/");
		int dia = Integer.parseInt(DataTmp[0]);
		int mes = Integer.parseInt(DataTmp[1]);
		int ano = Integer.parseInt(DataTmp[2]);
		Data d = new Data(dia,mes,ano);
		
		//criar a pessoa lida
		Pessoa p = new Pessoa(nome,Integer.parseInt(cc),d);
		
		//adiciona-la a lista
		add(Integer.parseInt(cc), p);
	}
	
	public void write() throws IOException{
		FileWriter wr = new FileWriter(new File("vCard"));
		wr.write("vCard \n");
		wr.flush();
		
		String[] array = new String[pessoas.size()];
		Set<String> set = pessoas.keySet();
		array = set.toArray(new String[0]);
		Pessoa[] people = new Pessoa[pessoas.size()];
		
		for(int i=0; i<array.length; i++){
			Pessoa p =  pessoas.get(array[i]);
			wr.write("#"+p.getName() + "#" + p.getCC() + "#" + p.getDate() + "\n");
		}
		
		wr.close();
	}
}
