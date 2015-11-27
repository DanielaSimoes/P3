package Aula9;

abstract class GeladoDecorator implements GeladoInterface{
	protected GeladoInterface g;
	
	GeladoDecorator(GeladoInterface g){
		this.g = g;
	}
	
	public String sabor(){
		return g.sabor();
	}

	public void base(int base){
		g.base(base);
	}
}
