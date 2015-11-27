package Aula11;

public class PratoDieta extends Prato{
	private double limCalorias;
	
	public PratoDieta(String nome, double limCalorias){
		super(nome);
		if(limCalorias>=0){
			this.limCalorias = limCalorias;
		}
	}
	
	public String toString(){
		return super.toString() + ", Limite de Calorias: " + this.limCalorias;
	}
	
	public boolean addIngrediente(Alimento v){
		if(super.Calorias() + v.getCalorias() <= limCalorias)
			return super.addIngrediente(v);
		
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(limCalorias);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		PratoDieta other = (PratoDieta) obj;
		if (Double.doubleToLongBits(limCalorias) != Double
				.doubleToLongBits(other.limCalorias))
			return false;
		return true;
	}
}
