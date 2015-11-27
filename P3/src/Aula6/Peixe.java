package Aula6;

public class Peixe extends Alimento{

	private static final long serialVersionUID = 1L;
	public enum TipoPeixe {congelado, fresco}
	private TipoPeixe V;
	
	public Peixe(TipoPeixe variedade, double proteinas, double calorias, double peso){
		super(proteinas, calorias, peso);
		
		try{
			this.V = variedade;
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("Tipo inv‡lido!\nPermitidos: Congelado, Fresco.");
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
		Peixe other = (Peixe) obj;
		if (V != other.V)
			return false;
		return true;
	}
	
	

}
