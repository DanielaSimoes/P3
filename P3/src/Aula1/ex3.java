package Aula1;
import java.util.*;

public class ex3 {
	
	public static void main (String args[]) {
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		
		do{
			try{
				System.out.println("Adicionar c�rculo -> 1");
				System.out.println("Adicionar quadrado -> 2");
				System.out.println("Adicionar ret�ngulo -> 3");
				System.out.println("Ver todos os atributos de cada figura -> 4");
				System.out.println("Verificar se dois c�rculos s�o iguais -> 5");
				System.out.println("Verificar se dois c�rculos se intercetam -> 6");
				choice = sc.nextInt();
				
				switch(choice){
					case 1:
						Figuras.addCirculo();
						break;
					case 2:
						Figuras.addQuadrado();
						break;
					case 3:
						Figuras.addRetangulo();
						break;
					case 4:
						Figuras.show();
						break;
					case 5:
						Figuras.verificarIgualdade();
						break;
					case 6:
						Figuras.verificarIntersecao();
						break;
					case 0:
						break;
						
				}
			}catch(InputMismatchException e){
				System.err.println("N�o pode inserir letras onde devem constar n�meros!");
			}
			
		}while(choice!=0);
		
		
	}
}