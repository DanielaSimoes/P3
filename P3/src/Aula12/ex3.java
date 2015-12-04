package Aula12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import Aula12.pluginsFiles.CSV;
import Aula12.pluginsFiles.Nokia;
import Aula12.pluginsFiles.vCard;

public class ex3 {
	private static Manager mng = new Manager();
	private static ArrayList<ReadWrite> plgs = new ArrayList<>();
	
	public static void main (String args[]) throws Exception {
		File proxyList = new File("src/Aula12/pluginsFiles"); 
		for (String f: proxyList.list()) {
			try {
				plgs.add(PluginManagerEx3.load("Aula12.pluginsFiles."+f.substring(0,f.lastIndexOf('.')), mng.getList())); 
			} catch (Exception e) { e.printStackTrace(); } 
		}
		
		Scanner sc = new Scanner(System.in);
		int response = 0;
		
		do{
			try{
				System.out.println("Listar -> 1");
				System.out.println("Adicionar -> 2");
				System.out.println("Remover -> 3");
				System.out.println("Listar ordenado por CC -> 4");
				System.out.println("Listar ordenado por nome -> 5");
				System.out.println("CSV write -> 6");
				System.out.println("CSV read -> 7");
				System.out.println("Nokia write -> 8");
				System.out.println("Nokia read -> 9");
				System.out.println("vCard write -> 10");
				System.out.println("vCard read -> 11");
				System.out.println("Sair -> 0");
				response = sc.nextInt();
			}catch(InputMismatchException e){
				System.err.println("Nao pode inserir letras onde devem constar numeros!");
			}
			
			switch(response){
				case 1: list();
					break;
				case 2: add();
					break;
				case 3:	remove();
					break;
				case 4: orderByCC();
					break;
				case 5: orderByName();
					break;
				case 6: csvW();
					break;
				case 7: csvR();
					break;
				case 8: NokiaW();
					break;
				case 9: NokiaR();
					break;
				case 10: vCardW();
					break;
				case 11: vCardR();
					break;
				case 0: 
					break;
			}
			
		}while(response!=0);
		
	}
	
	public static void orderByName(){
		mng.orderByName();
	}
	
	public static void orderByCC(){
		mng.orderByCC();
	}
	
	public static void remove(){
		Scanner sc = new Scanner(System.in);
		System.out.println("CC: ");
		String cc = sc.next();
		
		mng.delete(cc);
	}
	
	public static void add(){
		Scanner sc = new Scanner(System.in);
		try{
			System.out.println("Nome: ");
			String name = sc.next();
			System.out.println("CC: ");
			int cc = sc.nextInt();
			System.out.println("Data de nascimento: ");
			System.out.println("Dia: ");
			int day = sc.nextInt();
			System.out.println("Mes: ");
			int month = sc.nextInt(); 
			System.out.println("Ano: ");
			int year = sc.nextInt();
		
			if (validateName(name) && validateCC(cc) && validateDate(day,month,year)){
				Data data = new Data(day, month, year);
				Pessoa nova = new Pessoa(name, cc, data);
				mng.add(Integer.toString(cc), nova);
			}else{
				System.out.println("Inseriu dados incorretos!");
			}
			
		}catch(InputMismatchException e){
			System.err.println("Nao pode inserir letras onde devem constar numeros!");
		}
		
	}
	
	public static boolean validateName(String name){
		if(name.length()>0)
			return true;
		else
			return false;
	} 
	
	public static boolean validateCC(int cc){
		if(cc>0 && Integer.toString(cc).length()==8) //o num de cc tem 8 digitos
			return true;
		else
			return false;
	}
	
	public static boolean validateDate(int day, int month, int year){
		if (year>0 && year<=2015){
			switch(month){
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					if(day>0 && day <=31){
						return true;
					}
				case 2:
					if(year%4==0 && year%400==0){ //verificar se e bissexto
						if(day>0 && day <=29){
							return true;
						}
					}else{
						if(day>0 && day <=28){
							return true;
						}
					}
				case 4:
				case 6:
				case 11:
					if(day>0 && day <=30){
						return true;
					}
			}
		}else{
			return false;
		}
		
		return false;
	}
	
	public static void csvW() throws Exception{
		Class<?> cl = Class.forName("Aula12.pluginsFiles.CSV");
		CSV csv = null;
		
		for (ReadWrite rw: plgs) {
			if(rw.getClass() == cl){
				csv=(CSV)rw;
			}	
		}
	
		try{
			csv.write();
		}catch(Exception e){
			System.err.println("Failed to write!");
		}
	}
	
	public static void csvR() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Nome do ficheiro a ler? ");
		String fileName = sc.nextLine();
		File f = new File(fileName);
		
		Class<?> cl = Class.forName("Aula12.pluginsFiles.CSV");
		CSV csv = null;
		
		for (ReadWrite rw: plgs) {
			if(rw.getClass() == cl){
				csv=(CSV)rw;
			}	
		}
		
		try{
			readCSV(f);
		}catch(Exception e){
			System.err.println("Failed to read!");
		}
		
		System.out.println("Contactos lidos: ");
		csv.apresentar();
		
	}
	
	public static void list(){
		mng.list();
	}
	
	public static void NokiaW() throws Exception{
		
		Class<?> cl = Class.forName("Aula12.pluginsFiles.Nokia");
		Nokia nokia = null;
		
		for (ReadWrite rw: plgs) {
			if(rw.getClass() == cl){
				nokia=(Nokia)rw;
			}	
		}
		
		try{
			nokia.write();
		}catch(IOException e){
			System.err.println("Failed to write!");
		}
		
	}
	
	public static void NokiaR() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Nome do ficheiro a ler? ");
		String fileName = sc.nextLine();
		File f = new File(fileName);
		
		Class<?> cl = Class.forName("Aula12.pluginsFiles.Nokia");
		Nokia nokia = null;
		
		for (ReadWrite rw: plgs) {
			if(rw.getClass() == cl){
				nokia=(Nokia)rw;
			}	
		}
		
		try{
			readNokia(f);
		}catch(Exception e){
			System.err.println("Failed to read!");
		}
		
		System.out.println("Contactos lidos: ");
		nokia.apresentar();
		
	}
	
	public static void vCardW() throws Exception{
		
		Class<?> cl = Class.forName("Aula12.pluginsFiles.vCard");
		vCard vcard = null;
		
		for (ReadWrite rw: plgs) {
			if(rw.getClass() == cl){
				vcard=(vCard)rw;
			}	
		}
		
		try{
			vcard.write();
		}catch(IOException e){
			System.err.println("Failed to write!");
		}
		
	}
	
	public static void vCardR() throws Exception{
		Scanner sc = new Scanner(System.in);
		HashMap<String,Pessoa> tmp = null;
		System.out.println("Nome do ficheiro a ler? ");
		String fileName = sc.nextLine();
		File f = new File(fileName);
		
		Class<?> cl = Class.forName("Aula12.pluginsFiles.vCard");
		vCard vcard = null;
		
		for (ReadWrite rw: plgs) {
			if(rw.getClass() == cl){
				vcard=(vCard)rw;
			}	
		}

		try{
			readvCard(f);
		}catch(Exception e){
			System.err.println("Failed to read!");
		}
		
	}
	
	public static void readvCard (File f){
		Scanner reader = null;
		String line[] = null;
		String nome, cc, data;
		
		try{
			reader = new Scanner(f);
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
				
				System.out.println(nome + " " + cc + " " + data);
				
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		
		reader.close();
		
	}
	
	public static void readNokia(File f) throws IOException{
		Scanner reader = null;
		String line[] = null;
		String nome, cc, data;
		
		try{
			reader = new Scanner(f);
		}catch(FileNotFoundException e){
			System.err.println("Ficheiro nao encontrado!");
		}
		
		try{
			// o tipo de ficheiro nao e necessario ler
			reader.nextLine();
			
			while(reader.hasNextLine()){
				nome = reader.nextLine();
				cc = reader.nextLine();
				data = reader.nextLine();
				
				System.out.println(nome + " " + cc + " " + data);
				
				if(reader.hasNextLine() && reader.nextLine().equals("\n")){
					reader.nextLine();
				}
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		
		reader.close();
		
	}
	
	
	public static void readCSV(File f) throws IOException{
		Scanner reader = null;
		String line[] = null;
		String nome, cc, data;
		
		try{
			reader = new Scanner(f);
		}catch(FileNotFoundException e){
			System.err.println("Ficheiro nao encontrado!");
		}
		
		try{
			// o tipo de ficheiro nao e necessario ler
			reader.nextLine();
			
			while(reader.hasNextLine()){
				line = reader.nextLine().split("\t");
				nome = line[0];
				cc = line[1];
				data = line[2];
				
				System.out.println(nome + " " + cc + " " + data);
				
			}
		}catch(Exception e){
			System.err.println("Ficheiro lido incorretamente!");
		}
		
		reader.close();
		
	}
	
}
