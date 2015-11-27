package Aula9;

public class Copo extends GeladoDecorator{
	
	public Copo(GeladoInterface g){
		super(g);
	}
	
	public void base(int n){
		super.base(n);
		System.out.print(" em copo");
	}
}
