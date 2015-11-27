package Aula3;

public class Condutor extends Pessoa{
	
	private char tipoCarta;
	
	public Condutor(String name, int cc, Data date, char tipoCarta){
		super(name,cc,date);
		if(tipoCarta != 'A' && tipoCarta != 'B' && tipoCarta != 'C' && tipoCarta != 'a' && tipoCarta != 'b' && tipoCarta != 'c'){
			throw new IllegalArgumentException("Categoria inv‡lida!");
		}
		this.tipoCarta = tipoCarta;
	}
	
	public String toString(){
		return super.toString() + " Tipo de carta: " + this.tipoCarta;
	}
	
}
