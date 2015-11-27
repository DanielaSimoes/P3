package Aula6;

import java.io.Serializable;

public class Alimento implements Serializable{
	private static final long serialVersionUID = 1L;
	private double proteinas;
	private double calorias;
	private double peso;
	private String nome;
	
	public Alimento(double proteinas, double calorias, double peso){
		this.proteinas = proteinas;
		this.calorias = calorias;
		this.peso = peso;
	}
	
	public Alimento(String nome, double proteinas, double calorias, double peso){
		this.proteinas = proteinas;
		this.calorias = calorias;
		this.peso = peso;
		this.nome = nome;
	}
	
	public double getCalorias(){
		return this.calorias;
	}
	
	public double getPeso(){
		return ((this.peso)*(this.calorias))/100;
	}
	
	public double getProteinas(){
		return ((this.peso)*(this.proteinas))/100;
	}
	
	public String toString(){
		return "Calorias: " + this.calorias + ", Proteinas: " + this.proteinas + ", Peso: " + this.peso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(calorias);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(proteinas);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Alimento other = (Alimento) obj;
		if (Double.doubleToLongBits(calorias) != Double
				.doubleToLongBits(other.calorias))
			return false;
		if (Double.doubleToLongBits(peso) != Double
				.doubleToLongBits(other.peso))
			return false;
		if (Double.doubleToLongBits(proteinas) != Double
				.doubleToLongBits(other.proteinas))
			return false;
		return true;
	}	
	
}
