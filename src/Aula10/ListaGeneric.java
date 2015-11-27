package Aula10;

public class ListaGeneric<T> {
	
	class Node<E>{
		Node next;
		T obj;
		public Node(T obj){
			this.obj = obj;
		}
	}
	
	Node<T> top = null;
	int size = 0;
	
	public void addElem(T p){
		Node novo = new Node(p);
		novo.next = top;
		top = novo;
		size++;
	}
	
	private boolean removeElem(T pessoa){
		Node<T> tmp = top;
		if(top.obj.equals(pessoa) && top.next==null){
			top = null;
			size--;
			return true;
		}else if(top.obj.equals(pessoa) && top.next!=null){
			top = top.next;
			size--;
			return true;
		}
		
		while(tmp.next!=null){
			if(tmp.next.obj.equals(pessoa)){
				tmp.next = tmp.next.next;
				size--;
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}
	
	public String toString(){
		Node<T> tmp = top;
		String out = "";
		while(tmp!=null){
			out += "\n"+tmp.obj;
			tmp = tmp.next;
		}
		return out;
	}
	
	public GenericIterator<T> iterator(){
		return (this).new MyIterator();
	}

	private class MyIterator implements GenericIterator<T>{
		Node<T> tmp = top;
		
		@Override public boolean hasNext(){
			return (tmp!=null);
		}
		
		@Override public void remove() throws Exception{
			throw new Exception("Impossivel remover");
		}
		
		@Override public T next(){
			T p = tmp.obj;
			tmp = tmp.next;
			return p;
		}
	}
}
