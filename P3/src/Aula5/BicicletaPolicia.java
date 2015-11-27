package Aula5;

public class BicicletaPolicia extends Bicicleta implements Policia{
	
	private int ID;
	private enum Tipo{GNR, PSP, PJ, Bombeiros, INEM};
	private Tipo tipo;

	BicicletaPolicia(int ano, String cor, int nRodas, int ID, String tipo){
		super(ano, cor, nRodas);
		if(ID<=0){ 
			throw new IllegalArgumentException("ID inv‡lido! ");
		}else{
			this.ID = ID;
		}
		
		try{
			this.tipo = Tipo.valueOf(tipo);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("Tipo inv‡lido!\nPermitidos: GNR, PSP, PJ, Bombeiros, INEM");
		}
	}
	
	public int getID(){
		return this.ID;
	}
	
	public String getTipo(){
		return this.tipo.toString();
	}
	
	public String toString(){
		return super.toString() + ", ID: " + this.ID + ", Tipo: " + this.tipo; 
	}
}
