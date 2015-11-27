package Aula3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class Videos {
	
	//id do livro,Video
	private HashMap<Integer,Video> videos = new HashMap<Integer,Video>();
	//id do livro, rating do livro
	private HashMap<Integer, ArrayList<Integer>> rating = new HashMap<Integer,ArrayList<Integer>>();

	public void adVideo(String title, String category, int age){
		Video novo = new Video(title, category, age);
		int key = this.videos.size() + 1;
		
		this.videos.put(key,novo);
	}
	
	//guarda o id do video e a sua classificacao
	public void Rating(int id, int rate){
		
		do{
		
			//arraylist temporario para armazenar os rates
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			
			if (rating.get(id)==null){
				tmp.add(rate);
				
				rating.put(id, tmp);
				
				System.out.println("Classifica��o considerada! Obrigada!");
				
			}else{
				tmp = rating.get(id);
				tmp.add(rate);
				
				rating.put(id, tmp);
				
				System.out.println("Classifica��o considerada! Obrigada!");
			}
		}while(rate<0 || rate>10);
	}
	
	//verifica se o video foi adicionado
	public boolean existeVideo(int id){
		return this.videos.containsKey(id);
	}
	
	public void removVideo(String titulo){
		int key = searchKey(titulo);
		
		if(key>0 && videos.containsKey(key)){
			videos.remove(key);
			System.out.println("V�deo removido com sucesso!");
		}else{
			System.err.println("N�o foi poss�vel remover! Verifique o t�tulo.");
		}
	}
	
	public int searchKey(String titulo){
		int key=0;
		
		for (int i = 1; i <= videos.size(); i++) {
			if(videos.get(i).getTitulo().equals(titulo)){
				key = i;
			}
		}
		return key;
	}
	
	public void apresentar(){
		for (int i = 1; i <= videos.size(); i++) {
			System.out.println("ID: " + i + " " + this.videos.get(i).toString());
		}
	}

	public void ListarRating(){
		//contem o arraylist dos rates de cada video
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		//contem a soma dos rates/N e o id do video
		TreeMap<Double, Integer> sum = new TreeMap<Double,Integer>();
		
		Double soma = 0.0;
		Double increment = 0.0;
		
		//percorrer todos os videos
		for(int i : rating.keySet()){
			tmp = rating.get(i);
			for (Integer j = 0; j < tmp.size(); j++) {
				soma += tmp.get(j);
				increment++;
			}
			sum.put(soma/increment,i);
			soma = 0.0;
			increment = 0.0;
		}
		
		Set<Double> sorted = sum.keySet();
		Double[] array = new Double[sum.size()];
		array = sorted.toArray(new Double[0]);
		
		for(int i=0; i<array.length; i++){
			System.out.println("Rate: " + array[i] + " do v�deo com ID " + sum.get(array[i]));
		}
		
	}
	
	public void verRating(int id){
		double soma = 0;
		
		if(rating.containsKey(id)){
			if(rating.size()==0){
				System.out.println("Ainda n�o h� informa��o dispon�vel!");
			}else{
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp = rating.get(id);
				
				for (int i = 0; i < tmp.size(); i++) {
					soma += tmp.get(i);
				}
				
				System.out.println("Rating total: " + tmp.size());
				System.out.println("Rating m�dio: " + soma/tmp.size());
			}
		}else{
			System.out.print("O v�deo ainda n�o possui rating!");
		}
	}
}
