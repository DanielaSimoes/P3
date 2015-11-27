package Aula11;


public class Carne extends Alimento{

	public enum VariedadeCarne {vaca, porco, peru, frango, outra}
	private VariedadeCarne V;
	
	public Carne(VariedadeCarne variedade, double proteinas, double calorias, double peso){
		super(proteinas, calorias, peso);
		
		try{
			this.V = variedade;
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("Tipo invalido!\nPermitidos: Vaca, Porco, Peru, Frango, outra");
		}
	}
	
	public String toString(){
		return super.toString() + ", Variedade: " + this.V;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((V == null) ? 0 : V.hashCode());
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
		Carne other = (Carne) obj;
		if (V != other.V)
			return false;
		return true;
	}
}
