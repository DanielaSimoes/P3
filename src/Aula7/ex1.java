package Aula7;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class ex1 {
	static int counter = 0;
	static int test = 0;
	
	static ArrayList<Voo> voos = new ArrayList<Voo>();
	static HashMap<String, Integer> atraso = new HashMap<String, Integer>();
	
	public static void main(String args[]) throws IOException{
		
		BufferedReader in = new BufferedReader(new FileReader("voos.txt"));
		String line;
		
		while((line = in.readLine()) != null){
			if(test!=0){
				criarVoo(line);
			}
			test++;
		}
		
		in.close();
		//atraso();
		//tabela();
		//ordenacao();
		//storeRandomAccessFile();
		readRandomAccessFile();
	}
	
	public static void atraso(){
		String[] tmp;
		int minutos = 0;
		for (int i = 0; i < voos.size(); i++) {
			if(!voos.get(i).getAtraso().equals(" ") && !atraso.containsKey(voos.get(i).getOrigem())){
				tmp = voos.get(i).getAtraso().split(":");
				if(Integer.parseInt(tmp[0])>0){
					minutos = 60*Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[1]);
					atraso.put(voos.get(i).getOrigem(), minutos);
				}else{
					minutos = Integer.parseInt(tmp[1]);
					atraso.put(voos.get(i).getOrigem(), minutos);
				}
			}else{
				if(!voos.get(i).getAtraso().equals(" ")){
					tmp = voos.get(i).getAtraso().split(":");
					if(Integer.parseInt(tmp[0])>0){
						minutos = atraso.get(voos.get(i).getOrigem());
						minutos += 60*Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[1]);
						atraso.put(voos.get(i).getOrigem(), minutos);
					}else{
						minutos = atraso.get(voos.get(i).getOrigem());
						minutos += Integer.parseInt(tmp[1]);
						atraso.put(voos.get(i).getOrigem(), minutos);
					}
				}
			}
		}
		
		HashMap<String, Integer> sorted = sortPrintHashMap(atraso);
		System.out.printf("\n%25s %25s\n", "Origem", "Atraso médio");
		for(String key: sorted.keySet()){
			int min = (int)sorted.get(key);
			int h = (int) Math.floor(min / 60); 
			int m = min % 60;
			String hora = String.format("%d:%02d", h, m);
			System.out.printf("%25s %25sh \n", key, hora);
		}
	}
	
	public static void criarVoo(String line){
		String info[] = line.split("\t");
		Voo v;
		if(info.length==3){
			v = new Voo(info[0], info[1], info[2]);
		}else{
			v = new Voo(info[0], info[1], info[2], info[3]);
		}
		
		voos.add(v);
	}
	
	
	public static void tabela() throws IOException{
		File outputfile = new File("Infopublico.txt");
		FileWriter out = new FileWriter(outputfile); 
		String Line;
		
		Line = String.format("%-25s %-25s %-25s %-25s %-25s %-25s \n", "Hora", "Voo", "Companhia", "Origem", "Atraso", "Obs");
		System.out.print(Line);
				
		for (int i = 0; i < voos.size(); i++) {
			Line = String.format("%-25s %-25s %-25s %-25s %-25s %-25s \n", voos.get(i).hora, voos.get(i).getVoo(), voos.get(i).getCompanhia(), voos.get(i).getOrigem(), voos.get(i).getAtraso(), voos.get(i).obs());
			System.out.print(Line);	
			out.write(Line);
		}
		
		out.close();
	}
	
	public static void ordenacao(){
		int nVoos;
		// cidade, nVoos
		HashMap<String, Integer> qtd = new HashMap<String, Integer>();
		
		for (int i = 0; i < voos.size(); i++) {
			if(qtd.containsKey(voos.get(i).getOrigem())){
				nVoos = qtd.get(voos.get(i).getOrigem());
				nVoos++;
				qtd.put(voos.get(i).getOrigem(), nVoos);
			}else{
				qtd.put(voos.get(i).getOrigem(), 1);
			}
		}
		
		HashMap<String,Integer> sorted = sortPrintHashMap(qtd);
		
		ArrayList<String> descending = new ArrayList<String>(sorted.keySet());
		System.out.printf("\n%25s %25s\n", "Origem", "Nº Voos");
		
	     for(int i=descending.size()-1; i>=0; i--){
	    	 System.out.printf("%25s %25s\n", descending.get(i), sorted.get(descending.get(i)));
	     }
	}
	
	public static LinkedHashMap<String, Integer> sortPrintHashMap(HashMap<String, Integer> h){
		ArrayList<String> keys = new ArrayList<String>(h.keySet());
		ArrayList<Integer> values = new ArrayList<Integer>(h.values());
		Collections.sort(values);
		
		LinkedHashMap<String, Integer> sorted = new LinkedHashMap<String, Integer>();
		
		Iterator<Integer> value = values.iterator();
		while(value.hasNext()){
			Integer val = value.next();
			Iterator<String> key = keys.iterator();
			
			while(key.hasNext()){
				String k = key.next();
				String comp1 = h.get(k).toString();
				String comp2 = val.toString();
				
				if (comp1.equals(comp2)){
		               h.remove(key);
		               keys.remove(key);
		               sorted.put((String)k, (Integer)val);
		               break;
		           }
			}
		}
		return sorted;
		
	}
	
	public static void storeRandomAccessFile(){
		try{
			RandomAccessFile ra   = new RandomAccessFile("Infopublico.bin", "rw");
		    
			String Line = String.format("%-25s %-25s %-25s %-25s %-25s %-25s \n", "Hora", "Voo", "Companhia", "Origem", "Atraso", "Obs");
			System.out.print(Line);
					
			for (int i = 0; i < voos.size(); i++) {
				Line = String.format("%-25s %-25s %-25s %-25s %-25s %-25s \n", voos.get(i).hora, voos.get(i).getVoo(), voos.get(i).getCompanhia(), voos.get(i).getOrigem(), voos.get(i).getAtraso(), voos.get(i).obs());
				System.out.print(Line);	
				ra.write(Line.getBytes());
			}
			
			ra.close();
		} catch (IOException e) {
		       System.err.format("IOException: %s%n", e);
		}
	}
	
	public static void readRandomAccessFile(){
		try{
			RandomAccessFile ra   = new RandomAccessFile("Infopublico.bin", "rw");
			
		    while(ra.getFilePointer() < ra.length()){
			    System.out.println(ra.readLine());
		    }
		    ra.close();
		} catch (IOException e) {
		       System.err.format("IOException: %s%n", e);
		}
	}
	
}


