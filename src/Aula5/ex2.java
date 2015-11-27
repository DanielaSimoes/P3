package Aula5;

public class ex2 {

	public static void main(String[] args){
		Veiculo lista[] = {
			new Automovel(1994, "Branco", 4, 200,
					1000,"34-AB-76"),
			new Bicicleta(2011, "Preto", 2),
			new BicicletaPolicia(1780, "Azul", 2, 1, "PJ"),
			new CarroPolicia(2010, "Branco", 4, 150,
					1001,"12-GNR-12", 3, "GNR", 230, 5, "Gasolina"),
			new Moto(1980, "Branco", 2, 800, 1054, "AB-22-22"),
			new MotoPolicia(2003, "Azul", 2, 900,
					85,"AA-32-PSP",9, "PSP", 6, 78, "Gas—leo")
		};
		
		UtilCompare.sortArray(lista);
		
		for(Comparable row : lista){
			System.out.println("\n"+row);
		}
	}
	
}
