package Aula9;

public class Cone extends GeladoDecorator{
	private int qtd;
	public Cone(GeladoInterface g){
		super(g);
	}
	
	public void base(int n){
		super.base(n);
		System.out.print(" em cone");
	}
}
