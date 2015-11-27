package Aula11;

import java.util.ArrayList;
import java.util.List;


public class maiorFigura {
	private static Figura maiorArea;
	private static Figura maiorPerimetro;
	private static double area = 0;
	private static double areaEsp = 0;
	private static ArrayList<Figura> fig = new ArrayList<Figura>();
	
	private static Figura maiorFiguraJ8(List<Figura> figs) { 	
		figs.forEach(f -> {
			if (f.compareTo(maiorArea) > -1) 
				maiorArea = f;
		});
		
		return maiorArea;
	}
	
	private static Figura maiorFiguraPerimetroJ8(List<Figura> figs) { 
		
		figs.forEach(f -> {
			if (f.compareToPerimetro(maiorPerimetro) > -1) 
				maiorPerimetro = f;
		});
		
		return maiorPerimetro;
	}
	
	private static double sumArea(List<Figura> figs){
		area = 0;
		figs.forEach(f -> {
			area += f.Area();
		});
		
		return area;
	}
	
	private static double sumAreaEspecifica(List<Figura> figs, String tipo){
		areaEsp = 0;
		figs.forEach(f -> {
			if((f instanceof Quadrado) && tipo.equalsIgnoreCase("Quadrado")){
				areaEsp += f.Area();
			}else if(f instanceof Retangulo && tipo.equalsIgnoreCase("Retangulo")){
				areaEsp += f.Area();
			}else if(f instanceof Circulo && tipo.equalsIgnoreCase("Circulo")){
				areaEsp += f.Area();
			}
		});
		
		return areaEsp;
	}
	
	public static void main(String[] args) {
		
		fig.add(new Quadrado(1,1,1));
		fig.add(new Quadrado(1,1,2));
		fig.add(new Circulo(1,1,2));
		
		maiorPerimetro = fig.get(0);
		maiorArea = fig.get(0);
		
		maiorFigura obj = new maiorFigura();
		
		System.out.println(obj.sumArea(fig));
		System.out.println(obj.sumAreaEspecifica(fig, "Circulo"));
		System.out.println(obj.sumAreaEspecifica(fig, "Quadrado"));
		System.out.println(obj.maiorFiguraPerimetroJ8(fig));
		System.out.println(obj.maiorFiguraJ8(fig));
		
	}
	
}
