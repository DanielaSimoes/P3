package Aula10;
import java.util.Iterator;

public class TestBinarySearchTree {

		public static void main(String[] args) { 
			BinarySearchTree<Figura> binary = new BinarySearchTree<Figura>(); 
			
			binary.insert(new Circulo (3,5,1));
			binary.insert(new Circulo (2,2,1));
			binary.insert(new Quadrado(3,8,4));
			binary.insert(new Quadrado(3,4,1));
			binary.insert(new Retangulo(1,1,2,5));
			binary.insert(new Quadrado(3,4,2));
			
			Iterator<Figura> it = binary.iterator();
			it.remove();
			printSet(it);
			System.out.println("Soma da Area de Lista de Figuras: " + sumArea(binary.iterator()));
		}
		
		private static <T> double sumArea(Iterator<T> it) {
			double sum = 0;
			try{
				while(it.hasNext()){
					sum += ((Figura)(it.next())).Area();
				}
			}catch(ClassCastException e){
				e.printStackTrace();
			}
			return sum;
		}

		private static <T> void printSet(Iterator<T> iterator) {
			while(iterator.hasNext()){
				System.out.println(iterator.next());
			}
		}
}
