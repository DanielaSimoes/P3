package Aula1;
import java.util.*;

public class Figuras {
	
	private static ArrayList<Retangulo> retangulos = new ArrayList<Retangulo>();
	private static ArrayList<Quadrado> quadrados = new ArrayList<Quadrado>();
	private static ArrayList<Circulo> circulos = new ArrayList<Circulo>();


	public static void addCirculo(){
		
		Scanner sc = new Scanner(System.in);
		
		try{
			System.out.print("Coordenada x: ");
			int x = sc.nextInt();
			System.out.print("Coordenada y: ");
			int y = sc.nextInt();
			System.out.print("Raio: ");
			int raio = sc.nextInt();
			
			Circulo novo = new Circulo(x,y,raio);
			circulos.add(novo);
		
		}catch(InputMismatchException e){
			System.err.println("N�o pode inserir letras onde devem constar n�meros!");
		}
		
	}
	
	public static void addQuadrado(){
		Scanner sc = new Scanner(System.in);
		
		try{
		
			System.out.print("Lado: ");
			int lado = sc.nextInt();
			
			Quadrado novo = new Quadrado(lado);
			quadrados.add(novo);
		
		}catch(InputMismatchException e){
			System.err.println("N�o pode inserir letras onde devem constar n�meros!");
		}
	}
	
	public static void addRetangulo(){
		
		Scanner sc = new Scanner(System.in);
		
		try{
			System.out.print("Altura: ");
			int altura = sc.nextInt();
			System.out.print("Largura: ");
			int largura = sc.nextInt();
			
			Retangulo novo = new Retangulo(altura, largura);
			retangulos.add(novo);
		}catch(InputMismatchException e){
			System.err.println("N�o pode inserir letras onde devem constar n�meros!");
		}
	}
	
	public static void show(){
		
		for(int i=0; i<retangulos.size(); i++){
			System.out.println(retangulos.get(i));
		}
		
		for(int i=0; i<quadrados.size(); i++){
			System.out.println(quadrados.get(i));
		}
		
		for(int i=0; i<circulos.size(); i++){
			System.out.println(circulos.get(i));
		}
	}
	
	public static boolean verificarIgualdade(){
		Scanner sc = new Scanner(System.in);
		
		try{
			System.out.print("Raio do primeiro c�rculo: ");
			int raio1 = sc.nextInt();
			System.out.print("Raio do segundo c�rculo: ");
			int raio2 = sc.nextInt();
			
			if(raio1==raio2){
				return true;
			}
		}catch(InputMismatchException e){
			System.err.println("N�o pode inserir letras onde devem constar n�meros!");
		}
		
		return false;
	}
	
	public static boolean verificarIntersecao(){
		Scanner sc = new Scanner(System.in);
		
		try{
			System.out.println("Primeiro c�rculo:");
			System.out.print("Coordenada x: ");
			int x1 = sc.nextInt();
			System.out.print("Coordenada y: ");
			int y1 = sc.nextInt();
			System.out.print("Raio: ");
			int raio1 = sc.nextInt();
			
			System.out.println("Segundo c�rculo:");
			System.out.print("Coordenada x: ");
			int x2 = sc.nextInt();
			System.out.print("Coordenada y: ");
			int y2 = sc.nextInt();
			System.out.print("Raio: ");
			int raio2 = sc.nextInt();
			
			int x = x1-x2;
			int y = y1-y2;
			int distanciaPontos = (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
			int raio = raio1 + raio2;
			
			if(distanciaPontos>raio){
				return true;
			}
			
		}catch(InputMismatchException e){
			System.err.println("N�o pode inserir letras onde devem constar n�meros!");
		}
		return false;

	}
}