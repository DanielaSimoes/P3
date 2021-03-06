package Aula5;

import java.util.HashMap;
import java.util.Set;

public class Listas {
	    // String => Key => CC da pessoa
		private HashMap<String, Pessoa> lista = new HashMap<String, Pessoa>();
		
		public void add(int cc, Pessoa p){
			lista.put(Integer.toString(cc), p);
		}
		
		public void apresentar(){
			String[] array = new String[lista.size()];
			Set<String> set = lista.keySet();
			array = set.toArray(new String[0]);
			Pessoa[] people = new Pessoa[lista.size()];
			
			for(int i=0; i<array.length; i++){
				people[i] = lista.get(array[i]);
			}
			
			for(int k=0; k<people.length; k++){
				System.out.println("Name: " + people[k].getName() + " Data de nascimento: " + people[k].getDate() + " CC: " + people[k].getCC());
			}
		}
}
