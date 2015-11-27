package Aula6;
import java.util.HashMap;
import java.io.Serializable;

public class Prato implements Comparable, Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nome;
	private int index;
	private HashMap<Integer,Alimento> alimentos = new HashMap<Integer,Alimento>();
	
	public Prato(String nome){
		this.nome = nome;
	}
	
	public boolean addIngrediente(Alimento b){
		alimentos.put(index,b);
		index++;
		return true;
	}
	
	public boolean remIngrediente(Alimento b){
		if(alimentos.containsValue(b)){
			alimentos.remove(b);
			return true;
		}
		return false;
	}
	
	public String getAlimentos(){
		String lista = "";
		for(Integer key : alimentos.keySet()){
			lista += alimentos.get(key).toString() + " ";
		}
		return lista;
	}
	
	public double PesoTotal(){
		double pesoTotal = 0;
		for(Integer key : alimentos.keySet()){
			pesoTotal += alimentos.get(key).getPeso();
		}
		return pesoTotal;
	}
	
	public double Calorias(){
		double cal = 0;
		for(Integer key : alimentos.keySet()){
			cal += alimentos.get(key).getCalorias();
		}
		return cal;
	}
	
	public double Proteinas(){
		double p = 0;
		for(Integer key : alimentos.keySet()){
			p += alimentos.get(key).getProteinas();
		}
		return p;
	}
	
	public String toString(){
		return "Nome: " + this.nome + ", Alimentos: " + this.getAlimentos();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((alimentos == null) ? 0 : alimentos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prato other = (Prato) obj;
		if (alimentos == null) {
			if (other.alimentos != null)
				return false;
		} else if (!alimentos.equals(other.alimentos))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	@Override public int compareTo(Object b) {
		double thisCalorias = Calorias();
		double bCalorias = ((Prato)b).Calorias();
		
		if(thisCalorias < bCalorias){
			return -1;
		}else if(thisCalorias == bCalorias){
			return 0;
		}else{
			return 1;
		}	
	}
	
}
