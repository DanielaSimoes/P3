package Aula4;
import java.util.ArrayList;

public class ColecaoFiguras {
	private double maxArea;
	private ArrayList<Figura> figuras = new ArrayList<Figura>();
	
	public ColecaoFiguras(double maxArea){
		this.maxArea = maxArea;
	}
	
	public boolean addFigura(Figura f){
		if((areaTotal()+f.area())>maxArea || figuras.contains(f)){
			return false;
		}
		
		figuras.add(f);
		return true;
	}
	
	public boolean delFigura(Figura f){
		if(figuras.contains(f)){
			figuras.remove(f);
			return true;
		}
		return false;
	}
	
	public double areaTotal(){
		double areaTotal = 0;
		for (int i = 0; i < figuras.size(); i++) {
			areaTotal += figuras.get(i).area();
		}
		return areaTotal;
	}
	
	public boolean exists(Figura f){
		if(figuras.contains(f)){
			return true;
		}
		
		return false;
	}
	
	public String toString(){
		String result = "";
		for (int i = 0; i < figuras.size(); i++) {
			result += figuras.get(i).toString() + "\n";
		}
		return result;
	}
	
	public Figura[] getFiguras(){
		Figura[] tmp = new Figura[figuras.size()];
		tmp = figuras.toArray(tmp);
		return tmp;
	}
	
	public Ponto[] getCentros(){
		Ponto[] tmp = new Ponto[figuras.size()];
		for (int i = 0; i < figuras.size(); i++) {
			tmp[i] = figuras.get(i).centro();
		}
		return tmp;
	}

}
