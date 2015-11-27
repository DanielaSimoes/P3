package Aula11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class ex1a {

		public static void main(String[] args) {
			
		ArrayList<Pessoa> vp = new ArrayList<Pessoa>();
		for (int i=0; i<10; i++)
			vp.add(new Pessoa("Bebé no Vector "+i, 1000+i, Data.today()));
		
		Iterator<Pessoa> vec = vp.iterator();
		printSet(vp.iterator());
		
		LinkedList<Pessoa> lp = new LinkedList<Pessoa>();
		
		while ( vec.hasNext() )
			lp.add( vec.next() );
		
		Iterator<Pessoa> lista = lp.iterator();
		
		while ( lista.hasNext() ){
			System.out.println( lista.next() );
		}
		
		LinkedList<Figura> figList = new LinkedList<Figura>();
		
		LinkedList<Pessoa> p = new LinkedList<Pessoa>();
		
		figList.add(new Circulo (1,3, 1));
		figList.add(new Quadrado(3,4, 2));
		figList.add(new Retangulo(1,2, 2,5));
		printSet(figList.iterator());
		
		System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));
		// Partindo do principio que Quadrado extends Rectangulo:
		LinkedList< Retangulo > quadList = new LinkedList<Retangulo>();
		
		quadList.add(new Quadrado(3,4, 2));
		quadList.add(new Retangulo(1,2, 2,5));
		
		System.out.println("Soma da Area de Lista de Quadrados: " + sumArea(quadList));
		}
		
		public static double sumArea(LinkedList<? extends Figura> list){
			Iterator<? extends Figura> i = list.iterator();
			double sum = 0;
			
			while(i.hasNext()){
				sum += i.next().Area();
			}
			
			return sum;
		}
		
		public static void printSet(Iterator lista){
			
			while(lista.hasNext()){
				System.out.println(lista.next());
			}
			
		}
}
		
