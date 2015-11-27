package Aula9;

public class Topping extends GeladoDecorator{
	private String extra;
	
	public Topping(GeladoInterface g, String extra){
		super(g);
		this.extra = extra;
	}
	
	public String topping(){
		return this.extra;
	}
	
	public void base(int n){
		super.base(n);
		System.out.print(" com " + topping());
	}
}
