package Aula2;
import java.util.*;

public class Requisicoes {
	
	private HashMap<Integer,Integer> requisitados = new HashMap<Integer,Integer>();
	private ArrayList<String> historico = new ArrayList<String>(); 
	public Videos videos = new Videos();
	public Clientes clientes = new Clientes();
	
	public void disponibilidade(int id){
		//verificar se o video foi adicionado
		boolean existe = videos.existeVideo(id);
		
		if(existe && requisitados.containsKey(id)){
			System.out.println("O video j� se encontra requisitado!");
		}else if(existe && !requisitados.containsKey(id)){
			System.out.println("V�deo dispon�vel!");
		}else if(!existe){
			System.out.println("O v�deo n�o se encontra na lista!");
		}
	}
	
	//requisita um video pelo id do video e numero de socio
	public void ckeckIn(int id, int num){
	
		//verificar se o video foi adicionado
		boolean existe = videos.existeVideo(id);
		
		//verificar se o utilizador existe, assim como o video
		if(existe && requisitados.containsKey(id)){
			System.out.println("O video j� se encontra requisitado!");
		}else if(existe && !requisitados.containsKey(id) && permitirRequisicao(num) && clientes.existeUtilizador(num)){
			requisitados.put(id, num);
			
			System.out.println("Requisitado com sucesso!");
			
			//adiciona ao historico como requisitado
			adHistorico(id, num, 1); 
			
		}else if(!permitirRequisicao(num)){
			System.out.println("N�o pode requisitar mais v�deos!");
		}else if(!existe){
			System.out.println("O v�deo n�o se encontra adicionado!");
		}else if(!clientes.existeUtilizador(num)){
			System.out.println("O cliente n�o se encontra adicionado!");
		}
	}
	
	public void checkOut(){
		Scanner sc = new Scanner(System.in);
		
		try{
			System.out.println("N� s�cio: ");
			int num = sc.nextInt();
		
			System.out.println("ID do livro: ");
			int id = sc.nextInt();
		
			boolean existe = videos.existeVideo(id);
			//verificar se o livro existe, se esta requisitado, e se foi requisitado por esse num de socio
			if(existe && requisitados.containsKey(id) && requisitados.get(id)==num){
				requisitados.remove(id);
				adHistorico(id, num, 0); //adiciona ao historico como entregue
				System.out.println("Video devolvido com sucesso!");
				
				System.out.println("Adicione uma classifica��o do v�deo entre 1 e 10.");
				int classificacao = sc.nextInt();
				
				videos.Rating(id, classificacao);
				
			}else if(existe && !requisitados.containsKey(id)){
				System.out.println("O v�deo n�o se encontra requisitado para ser devolvido!");
			}else if(!existe){
				System.out.println("O v�deo n�o se encontra adicionado!");
			}
		}catch(InputMismatchException e){
			System.err.println("N�o pode inserir letras onde devem constar n�meros!");
		}
		
	}
	
	public void adHistorico(int id, int num, int x){
		//se x = 1 existe um checkin, se x=0, existe um checkout
		String requisito = new String();
		
		if(x==1){
			requisito = " requisitado ";
		}else if(x==0){
			requisito = " entregue ";
		}
		
		historico.add("O livro com o ID " + id + " foi " + requisito + " pelo utilizador com o n�mero de s�cio " + num);
	}
	
	public void apresentarHistorico(){
		
		if(historico.size()==0){
			System.out.println("Ainda n�o h� hist�rico dispon�vel!");
		}else{
			for (int i = 0; i < historico.size(); i++) {
				System.out.println(historico.get(i));
			}
		}
	}
	
	//conta quantos livros foram requisitados por determinado cliente
	public boolean permitirRequisicao(int numSocio){
		
		if(clientes.existeUtilizador(numSocio)){
			int counter = 0;
			
			for (int key : requisitados.keySet() ) {
			    if( requisitados.get(key)==numSocio);
			    counter++;
			}
			
			// limita os videos requisitados a 2
			if(counter>=2){
				return false;
			}
			
		}
		return true;
	}
	
}
