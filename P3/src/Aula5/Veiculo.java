package Aula5;

public class Veiculo implements Comparable{
	
	private int ano;
	private String cor;
	private int nRodas;
	
	public Veiculo(int ano, String cor, int nRodas){
		if(ano<=0){ 
			throw new IllegalArgumentException("Ano inv‡lido! ");
		}else{
			this.ano = ano;
		}
		
		if(cor.length()<=0){ 
			throw new IllegalArgumentException("Cor inv‡lida! ");
		}else{
			this.cor = cor;
		}
		
		if(nRodas<=0){ 
			throw new IllegalArgumentException("Num de rodas inv‡lido! ");
		}else{
			this.nRodas = nRodas;
		}
		
	}
	
	public int compareTo(Object b){
		if(this.ano<((Veiculo)b).ano){
			return -1;
		}else if(this.ano>((Veiculo)b).ano){
			return 1;
		}else{
			return 0;
		}
	}
	
	public String toString(){
		return "Ano: " + this.ano + ", Cor: " + this.cor + ", Num Rodas: " + nRodas;
	}
	
}
