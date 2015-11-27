package Aula4;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ex3{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int escolha = 0;
		Requisicoes requisicoes = new Requisicoes();
		
		do{
			try{
				System.out.println("Adicionar utilizador - 1");
				System.out.println("Apresentar utilizadores  - 2");
				System.out.println("Adicionar vídeo  - 3");
				System.out.println("Apresentar vídeos  - 4");
				System.out.println("Remover utilizador  - 5");
				System.out.println("Remover vídeo  - 6");
				System.out.println("Requisitar vídeo  - 7 (CkeckIn)");
				System.out.println("Devolver vídeo  - 8 (CheckOut)");
				System.out.println("Mostrar disponibilidade  - 9");
				System.out.println("Mostrar histórico - 10");
				System.out.println("Listar vídeos por rating - 11");
				System.out.println("Ver rating - 12");
				escolha = sc.nextInt();
				
				switch(escolha){
					case 1:
						System.out.println("Estudante? S/N ");
						String c = sc.next();
						
						if(c.equals("S") || c.equals("s")){
							System.out.println("Nome: ");
							String nome = sc.next();
							System.out.println("CC: ");
							int cc = sc.nextInt();
							if(Integer.toString(cc).length()!=8){
								System.out.println("CC incorreto! Insira novamente:");
								do {
									System.out.println("CC: ");
									cc = sc.nextInt();
								} while (Integer.toString(cc).length()!=8);
							}
							System.out.println("Data de nascimento: ");
							System.out.println("Dia: ");
							int dia = sc.nextInt();
							System.out.println("Mês: ");
							int mes = sc.nextInt();
							System.out.println("Ano: ");
							int ano = sc.nextInt();
							Data dataN = new Data(dia,mes,ano);
							System.out.println("Número Mecanográfico: ");
							int nMec = sc.nextInt();
							System.out.println("Curso: ");
							
							String curso = sc.next();
							
							requisicoes.clientes.adCliente(nome, cc, dataN, nMec, curso);
						}else if(c.equals("N") || c.equals("n")){
							System.out.println("Nome: ");
							String nome = sc.next();
							System.out.println("CC: ");
							int cc = sc.nextInt();
							if(Integer.toString(cc).length()!=8){
								System.out.println("CC incorreto! Insira novamente:");
								do {
									System.out.println("CC: ");
									cc = sc.nextInt();
								} while (Integer.toString(cc).length()!=8);
							}
							System.out.println("Data de nascimento: ");
							System.out.println("Dia: ");
							int dia2 = sc.nextInt();
							System.out.println("Mês: ");
							int mes2 = sc.nextInt();
							System.out.println("Ano: ");
							int ano2 = sc.nextInt();
							Data dataNas = new Data(dia2,mes2,ano2);
							System.out.println("Número Funcionário: ");
							int nFunc = sc.nextInt();
							System.out.println("NIF: ");
							int nif = sc.nextInt();
							
							requisicoes.clientes.adCliente(nome, cc, dataNas, nFunc, nif);
						}else{
							System.err.println("Opção não válida!");
						}
						break;
					case 2:
						requisicoes.clientes.apresentar();
						break;
					case 3:
						System.out.println("Título?");
						String titulo = sc.next();
						System.out.println("Categoria?");
						String categoria = sc.next();
						System.out.println("Idade?");
						int idade = sc.nextInt();
						
						requisicoes.videos.adVideo(titulo, categoria, idade);
						break;
					case 4: 
						requisicoes.videos.apresentar();
						break;
					case 5:
						System.out.	print("CC?");
						int cc = sc.nextInt();
						requisicoes.clientes.removCliente(cc);
						break;
					case 6:
						System.out.println("Qual o título do vídeo?");
						String tit = sc.next();
						requisicoes.videos.removVideo(tit);
						break;
					case 7:
						System.out.println("Nº sócio: ");
						int num = sc.nextInt();
						
						System.out.println("ID do livro: ");
						int id = sc.nextInt();
						
						requisicoes.ckeckIn(id, num);
						break;
					case 8:
						requisicoes.checkOut();
						break;
					case 9:
						System.out.println("ID do Vídeo: ");
						int idV = sc.nextInt();
						requisicoes.disponibilidade(idV);
						break;
					case 10:
						requisicoes.apresentarHistorico();
						break;
					case 11:
						requisicoes.videos.ListarRating();
						break;
					case 12:
						System.out.println("ID do Vídeo: ");
						int idVideos = sc.nextInt();
						
						requisicoes.videos.verRating(idVideos);
						break;
				}
			}catch(InputMismatchException e){
				System.err.println("Não pode inserir letras onde devem constar números!");
				//limpar o scanner para continuar o programa caso exista excecao
				sc.next(); 
				continue;
			}
		}while(escolha!=0);
		
	}
}

