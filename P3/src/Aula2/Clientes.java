package Aula2;
import java.util.*;

public class Clientes {

	// o num de socio sera automaticamente atribuido
	private HashMap<Integer,Cliente> clientes = new HashMap<Integer,Cliente>();
	
	//adiciona um aluno
	public void adCliente(String nome, int cc, Data dataNasc, int nMec, String curso){
		Cliente novo = new Cliente(nome, cc, dataNasc, nMec, curso);
		int key = clientes.size() + 1;
		
		this.clientes.put(key,novo);
	}

	//adiciona um funcionario
	public void adCliente(String nome, int cc, Data dataNasc, int nFunc, int nif){
		Cliente novo = new Cliente(nome, cc, dataNasc, nFunc, nif);
		int key = clientes.size() + 1;
		
		this.clientes.put(key,novo);
	}
	
	public void removCliente(int cc){
		int key = searchKey(cc);
		
		if(key>0 && clientes.containsKey(key)){
			
			clientes.remove(key);
			
			System.out.println("Utilizador removido com sucesso!");
		}else{
			System.err.println("N‹o foi poss’vel remover! Verifique o CC.");
		}
	}
	
	//procura pela key na hashmap clientes, dado o numero de cc
	public int searchKey(int cc){
		int key=0;
		
		for (int i = 1; i <= clientes.size(); i++) {
			if(clientes.get(i).getCC()==cc){
				key = i;
			}
		}
		
		return key;
	}
	
	public void apresentar(){
		for (int i = 1; i <= clientes.size(); i++) {
			System.out.println("Num S—cio: " + i + clientes.get(i).toString());
		}
	}
	
	public boolean existeUtilizador(int numSocio){
		return clientes.containsKey(numSocio);
	}
} 
