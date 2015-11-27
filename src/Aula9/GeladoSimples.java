package Aula9;

public class GeladoSimples implements GeladoInterface{
	private String sabor = "";
	private int qtd;
	
	public GeladoSimples(String sabor){
		this.sabor = sabor;
	}
	
	public void base(int n){
		this.qtd = n;
		System.out.print("\n" + qtd + " bolas de " + sabor());
	}
	
	@Override public String sabor(){
		return "Gelado de " + this.sabor;
	}
	
	

}
