package Aula6;

public class UtilCompare {
	
	public static Comparable findMax(Comparable[] lista){
		int indice = 0;
		for (int i = 0; i < lista.length; i++) {
			if(lista[i].compareTo(lista[indice])>0){
				indice = i;
			}
		}
		return lista[indice];
	}
	
	public static Comparable findMin(Comparable[] lista){
		int indice = 0;
		for (int i = 0; i < lista.length; i++) {
			if(lista[i].compareTo(lista[indice])<0){
				indice = i;
			}
		}
		return lista[indice];
	}
	
	public static Comparable[] sortArray(Comparable[] lista){
		Comparable[] sorted = new Comparable[lista.length];
		Comparable tmp;
		for (int i = 0; i < lista.length; i++) {
			for (int j = i+1; j < sorted.length; j++) {
				if(lista[i].compareTo(lista[j])>0){
					tmp = lista[i];
					lista[i] = lista[j];
					lista[j] = tmp;
				}
			}
		}
		return sorted;
	}

}