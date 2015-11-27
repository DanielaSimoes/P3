package Aula6;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class Manager implements Serializable{
	
	private static final long serialVersionUID = 1L;
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
			System.out.println("Imposs’vel apagar!");
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
			System.out.println("Imposs’vel adicionar!");
		}
	}
	
	public void remIngredientePrato(Alimento alimento, String nomePrato){
		if(alimento!=null){
			if(alimentos.containsValue(alimento)){
				Prato tmp = pratos.get(nomePrato);
				tmp.remIngrediente(alimento);
			}
		}else{
			System.out.println("Imposs’vel adicionar!");
		}
	}
	
	public void seralizeObject(File f){
		try {
			FileOutputStream out = new FileOutputStream(f.getPath()); 
			ObjectOutputStream s = new ObjectOutputStream(out);
			s.writeObject(alimentos);
			s.writeObject(pratos);
			s.writeObject(ementa);
			s.flush();
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void unserializeObject(File f){
		FileInputStream in = null;
		try {
			in = new FileInputStream(f.getPath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ObjectInputStream s = null;
		try {
			s = new ObjectInputStream(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			alimentos = (HashMap<Integer, Alimento>)s.readObject();
		    pratos = (HashMap<String, Prato>)s.readObject();
		    ementa = (Ementa)s.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
