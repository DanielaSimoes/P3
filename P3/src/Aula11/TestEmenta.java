package Aula11;

public class TestEmenta {
	public static void main(String args[]){
		Manager ementa = new Manager();
		
		Carne c1 = new Carne(Carne.VariedadeCarne.frango,  300, 345.3, 22.3);
		Carne c2 = new Carne(Carne.VariedadeCarne.porco,  301, 335.3, 21.3);
		Carne c3 = new Carne(Carne.VariedadeCarne.peru,  341, 335.3, 21.1);
		
		ementa.adIngrediente(c1);
		ementa.adIngrediente(c2);
		ementa.adIngrediente(c3);
		
		Cereal ce1 = new Cereal("Cereal", 120, 333, 12);
		Cereal ce2 = new Cereal("Cereal F", 120, 333, 12);
		Cereal ce3 = new Cereal("Cereal B", 120, 333, 12);
		
		ementa.adIngrediente(ce1);
		ementa.adIngrediente(ce2);
		ementa.adIngrediente(ce3);
		
		ementa.imprimir();
		
		ementa.criaPrato("Prato1", "Normal");
		System.out.println(ce1);
		ementa.adIngredientePrato(ce1, "Prato1");
		System.out.println("aqui");
		
		ementa.criaPrato("V1", "Vegetariano");
		ementa.adIngredientePrato(c3, "V1");
		
		ementa.selecionaP("V1");
		
		ementa.apagaPrato("V1");
		
		ementa.criaPrato("V2", "Vegetariano");
		
		ementa.adIngredientePrato(ce2, "V2");
		ementa.adIngredientePrato(ce3, "V2");
				
		ementa.criaPrato("V1", "Vegetariano");
		ementa.adIngredientePrato(c3, "V1");
		
		ementa.criaPrato("V2", "Vegetariano");
		ementa.adIngredientePrato(ce3, "V2");
	
		ementa.criaPrato("V3", "Vegetariano");
		ementa.adIngredientePrato(ce1, "V3");
	
		
		ementa.adPrato("V1", Ementa.DiaSemana.Sexta);
		ementa.adPrato("V2", Ementa.DiaSemana.Segunda);
		ementa.adPrato("V3", Ementa.DiaSemana.Sexta);
		
		ementa.imprimir();
		
		ementa.remPrato("V2", Ementa.DiaSemana.Segunda);
			
		ementa.imprimir();
	
	}
}

