package Aula12;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class Manager {
	
	// String => Key => CC da pessoa
	private HashMap<String, Pessoa> pessoas = new HashMap<String, Pessoa>();
	
	public void add(String cc, Pessoa p){
		if(!pessoas.containsKey(cc)){
			pessoas.put(cc, p);
		}else{
			System.out.println("Numero de cc duplicado, impossivel adicionar!");
		}
	}
	
	public void delete(String cc){
		if(pessoas.isEmpty()){
			System.out.println("Lista vazia, impossivel eliminar! ");
		}else{
			if(pessoas.containsKey(cc)){
				pessoas.remove(cc);
			}else{
				System.out.println("Numero de cc nao existe, impossivel eliminar!");
			}
		}
	}
	
	public void orderByCC(){
		TreeMap sortedHashMap = new TreeMap(pessoas);
		Set<String> sorted = sortedHashMap.keySet();
		String[] array = new String[pessoas.size()];
		array = sorted.toArray(new String[0]);
		
		for(int i=0; i<array.length; i++){
			System.out.println("CC: " + array[i] + " Nome: " + pessoas.get(array[i]).getName() + " Data de nascimento: " + pessoas.get(array[i]).getDate());
		}
		
	}
	
	public void orderByName(){
		Pessoa[] array = new Pessoa[pessoas.size()];
		//Set<Map.Entry<String, Pessoa>> map = pessoas.entrySet();
		array = pessoas.values().toArray(new Pessoa[0]);
		String[] names = new String[pessoas.size()];
		
		for(int j=0; j<array.length; j++){
			names[j] = array[j].getName();
		} 
		
		for(int i=0; i<names.length; i++){
			for(int k=i+1; k<names.length; k++){
				if(names[i].compareTo(names[k])>0){
					String tmp = names[i];
					names[i] = names[k];
					names[k] = tmp;
				}
			}
		}
		
		
		for(int u=0; u<names.length; u++){
			String key = searchKey(names[u]);
			System.out.println("Nome: " + names[u] + " CC: " + pessoas.get(key).getName() + " Data de nascimento: " +  pessoas.get(key).getDate());
		}
		
	}
	
	public String searchKey(String name){
		Set<String> keys = pessoas.keySet();
		String[] array = new String[pessoas.size()];
		array = keys.toArray(new String[0]);
		
		for(int i=0; i<array.length; i++){
			if(pessoas.get(array[i]).getName().equals(name)){
				return array[i];
			}
		}
		return "";
	}
	
	public void list(){
		String[] array = new String[pessoas.size()];
		Set<String> set = pessoas.keySet();
		array = set.toArray(new String[0]);
		Pessoa[] people = new Pessoa[pessoas.size()];
		
		for(int i=0; i<array.length; i++){
			people[i] = pessoas.get(array[i]);
		}
		
		for(int k=0; k<people.length; k++){
			System.out.println("Name: " + people[k].getName() + " Data de nascimento: " + people[k].getDate() + " CC: " + people[k].getCC());
		}
		
	}
	
	public HashMap<String,Pessoa> getList(){
		return this.pessoas;
	}
}