package Aula5;

public class CarroPolicia extends Automovel implements Policia, MotorizadoInterface{
	private int ID;
	private enum Tipo{GNR, PSP, PJ, Bombeiros, INEM};
	private Tipo tipo;
	private int consumo;
	private String combustivel;
	private int potencia;

	public CarroPolicia(int ano, String cor, int nRodas, int VelMax, int cilindrada, String matricula, int ID, String tipo, int potencia, int consumo, String combustivel){
		super(ano, cor, nRodas, VelMax, cilindrada, matricula);
		
		if(combustivel.length()<=0){
			throw new IllegalArgumentException("Combust’vel inv‡lido! ");
		}else{
			this.combustivel = combustivel;
		}
		
		if(consumo<=0){
			throw new IllegalArgumentException("Consumo inv‡lido! ");
		}else{
			this.consumo = consumo;
		}
		
		if(potencia<=0){
			throw new IllegalArgumentException("Potencia inv‡lida! ");
		}else{
			this.potencia = potencia;
		}
		
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
	
	public int getPotencia(){
		return this.potencia;
	}
	
	public int getConsumo(){
		return this.consumo;
	}
	
	public String getCombustivel(){
		return this.combustivel;
	}
	
	public String toString(){
		return super.toString() + ", ID: " + this.ID + ", Tipo: " + this.tipo + ", Consumo: " + this.consumo + ", Combust’vel: " + this.combustivel + ", Potncia: " + this.potencia;
	}
	
}
