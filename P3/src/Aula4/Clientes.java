package Aula4;

import java.util.HashMap;

public class Clientes{

	// o num de socio sera automaticamente atribuido
	private HashMap<Integer,Cliente> clientes = new HashMap<Integer,Cliente>();
	
	//adiciona um aluno
	public void adCliente(String nome, int cc, Data dataNasc, int nMec, String curso){
		Aluno novo = new Aluno(nome, cc, dataNasc, nMec, curso);
		int key = clientes.size() + 1;
		
		this.clientes.put(key,novo);
	}

	//adiciona um funcionario
	public void adCliente(String nome, int cc, Data dataNasc, int nFunc, int nif){
		Funcionario novo = new Funcionario(nome, cc, dataNasc, nFunc, nif);
		int key = clientes.size() + 1;
		
		this.clientes.put(key,novo);
	}
	
	public void removCliente(int cc){
		int key = searchKey(cc);
		
		if(key>0 && clientes.containsKey(key)){
			clientes.remove(key);
			System.out.println("Utilizador removido com sucesso!");
		}else{
			System.err.println("Nao foi poss’vel remover! Verifique o CC.");
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
			if(clientes.get(i) instanceof Aluno){
				Aluno tmp = (Aluno)clientes.get(i);
				System.out.println(clientes.get(i).toString());
				System.out.println("Curso: " + tmp.getCurso());
				System.out.println("nMec: " + tmp.nMec());
			}else{
				Funcionario tmp = (Funcionario)clientes.get(i);
				System.out.println(clientes.get(i).toString());
				System.out.println("NIF: " + tmp.getNif());
				System.out.println("N¼ Funcion‡rio: " + tmp.getNumF());
			}
			
		}
	}
	
	public boolean existeUtilizador(int numSocio){
		return clientes.containsKey(numSocio);
	}
} 


