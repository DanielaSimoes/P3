package Aula6;
import java.util.HashMap;
import java.io.Serializable;

public class Ementa implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String nome;
	private String local;
	private HashMap<Prato, DiaSemana> pratos = new HashMap<Prato,DiaSemana>();
	
	public Ementa(String nome, String local){
		this.nome = nome;
		this.local = local;
	}
	
	public void adPrato(DiaSemana d,Prato p){
		pratos.put(p, d);
	}
	
	public void remPrato(DiaSemana d,Prato p){
		if(pratos.containsKey(p)){
			pratos.remove(p);
		}else{
			System.out.println("Imposs�vel remover prato!");
		}
	}
	
	public String Imprimir(){
		return this.toString();
	}
	
	public enum DiaSemana{
		Segunda(0), Terca(1), Quarta(2), Quinta(3), Sexta(4), Sabado(5), Domingo(6);
		
		private int dia;
		
		DiaSemana(int dia){
			this.dia = dia;
		}
		
		public int intDia(){
			return dia;
		}
		
		public static DiaSemana rand(){
			switch((int)(Math.random()*6)){
			case 0:
				return DiaSemana.Segunda;
			case 1:
				return DiaSemana.Terca;
			case 2:
				return DiaSemana.Quarta;
			case 3:
				return DiaSemana.Quinta;
			case 4:
				return DiaSemana.Sexta;
			case 5:
				return DiaSemana.Sabado;
			case 6:
				return DiaSemana.Domingo;
			default:
				return DiaSemana.Domingo;
			}
		}
	}
	
	public void addPrato(Prato b, DiaSemana n){
		pratos.put(b,n);
	}
	
	public String getPratos(){
		String lista = "";
		
		for(Prato key : pratos.keySet()){
		    lista += ("Dia: " + pratos.get(key) + ", Alimentos = " + key + "\n");
		}
		
		return lista;
	}
	
	public String toString(){
		return "Nome: " + this.nome + ", Local: " + this.local + ", \nPratos: " + this.getPratos();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pratos == null) ? 0 : pratos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ementa other = (Ementa) obj;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pratos == null) {
			if (other.pratos != null)
				return false;
		} else if (!pratos.equals(other.pratos))
			return false;
		return true;
	}
	
	
}
