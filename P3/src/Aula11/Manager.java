package Aula11;

import java.util.HashMap;

public class Manager {

	private HashMap<String,Prato> pratos = new HashMap<String,Prato>();
	private HashMap<Integer, Alimento> alimentos = new HashMap<Integer, Alimento>();
	
	private Ementa ementa = new Ementa("Snack", "Aveiro");
	
	public void adIngrediente(Alimento b){
		alimentos.put(alimentos.size(), b);
	}
	
	public void adPrato(String nomeP, Ementa.DiaSemana d){
		if(pratos.containsKey(nomeP)){
			Prato tmp = pratos.get(nomeP);
			ementa.adPrato(d,tmp);
		}
	}
	
	public void remPrato(String nomeP, Ementa.DiaSemana d){
		if(pratos.containsKey(nomeP)){
			Prato tmp = pratos.get(nomeP);
			ementa.remPrato(d,tmp);
		}
	}
	
	public void imprimir(){
		ementa.Imprimir();
	}
	
	public void criaPrato(String nome, String tipo){
		Prato prato = null;
		if(nome.length()>0){
			if(tipo.equals("Normal"))
				prato = new Prato(nome);
			else if(tipo.equals("Vegetariano"))
				prato = new PratoVegetariano(nome);
			pratos.put(nome, prato);
			System.out.println("Prato criado!");
		}
	}
	
	public void criaPrato(String nome, String tipo, int cal){
		Prato prato = null;
		if(nome.length()>0){
			if (tipo.equals("Dieta"))
				prato = new PratoDieta(nome, cal);
			pratos.put(nome, prato);
			System.out.println("Prato criado!");
		}
	}
	
	public void apagaPrato(String nome){
		if(pratos.containsKey(nome)){
			pratos.remove(nome);
			System.out.println("Apagado!");
		}else{
			System.out.println("Impossivel apagar!");
		}
	}
	
	public void selecionaP(String nome){
		Prato tmp = pratos.get(nome);
		System.out.println(tmp.toString());
	}
	
	public void adIngredientePrato(Alimento alimento, String nomePrato){
		if(alimento!=null){
			if(alimentos.containsValue(alimento)){
				Prato tmp = pratos.get(nomePrato);
				tmp.addIngrediente(alimento);
			}
		}else{
			System.out.println("Impossivel adicionar!");
		}
	}
	
	public void remIngredientePrato(Alimento alimento, String nomePrato){
		if(alimento!=null){
			if(alimentos.containsValue(alimento)){
				Prato tmp = pratos.get(nomePrato);
				tmp.remIngrediente(alimento);
			}
		}else{
			System.out.println("Impossivel adicionar!");
		}
	}
	
}
