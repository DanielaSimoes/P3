package Aula9;

public class ListaPessoas {
	
	class Node{
		Node next;
		Pessoa pessoa;
		public Node(Pessoa pessoa){
			this.pessoa = pessoa;
		}
	}
	
	Node top = null;
	int size = 0;
	
	public void addPessoa(Pessoa p){
		Node novo = new Node(p);
		novo.next = top;
		top = novo;
		size++;
	}
	
	private boolean removePessoa(Pessoa pessoa){
		Node tmp = top;
		if(top.pessoa.equals(pessoa) && top.next==null){
			top = null;
			size--;
			return true;
		}else if(top.pessoa.equals(pessoa) && top.next!=null){
			top = top.next;
			size--;
			return true;
		}
		
		while(tmp.next!=null){
			if(tmp.next.pessoa.equals(pessoa)){
				tmp.next = tmp.next.next;
				size--;
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}
	
	public Pessoa[] toArray(){
		Node tmp = top;
		Pessoa[] array = new Pessoa[size];
		int i = 0;
		while(tmp!=null){
			array[i++] = tmp.pessoa;
			tmp = tmp.next;
		}
		return array;
	}
	
	public String toString(){
		Node tmp = top;
		String out = "";
		while(tmp!=null){
			out += "\n"+tmp.pessoa;
			tmp = tmp.next;
		}
		return out;
	}
	
	public Iterador iterator(){
		return (this).new MyIterator();
	}

	private class MyIterator implements Iterador{
		Node tmp = top;
		
		@Override public boolean hasNext(){
			return (tmp.next!=null);
		}
		
		@Override public void remove(){
			removePessoa(tmp.pessoa);
			tmp = top;
		}
		
		@Override public Pessoa next(){
			Pessoa p = tmp.pessoa;
			tmp = tmp.next;
			return p;
		}
		
	}
	
}
