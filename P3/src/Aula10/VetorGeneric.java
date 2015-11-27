package Aula10;

public class VetorGeneric<T> {
	
	private T[] vetor;
	private int pos;
	
	public VetorGeneric(){
		vetor = (T[]) new Object[1];
		pos = 0;
	}
	
	public boolean addElem(T p){
				
		if(pos==vetor.length){
			T[] redimensiona = (T[]) new Object[vetor.length + 1];
			System.arraycopy(vetor, 0, redimensiona, 0, vetor.length);
			vetor = redimensiona;
		}
		vetor[pos++] = p;
		return true;
	}
	
	private boolean removeElem(T p){
		int indice = 0;
		int exists = 0;
		
		for (int i = 0; i < vetor.length; i++) {
			if(p==vetor[i])
				exists = 1;
			else
				return false;
		}
		
		T[] tmp = (T[]) new Object[vetor.length-1];
		for (int i = 0; i < vetor.length; i++) {
			if(vetor[i]==p){
				vetor[i] = null;
				break;
			}
		}
		
		for (int i = 0; i < tmp.length; i++) {
			if(vetor[i]!=null){
				tmp[i] = vetor[i];
			}
		}

		//copiar o ultimo elemento	
		if(vetor[vetor.length-1]!=null)
			tmp[tmp.length-1] = vetor[vetor.length-1];
		
		vetor = tmp;
		return true;
	}
	
	public int getSize(){
		return vetor.length;
	}
	
	public T[] toArray(){
		return vetor;
	}
	
	public String toString(){
		String tmp = "";
		
		for(int i=0; i<pos; i++){
			tmp += "\n"+vetor[i];	
		}
		
		return tmp;
	}
	
	public GenericIterator<T> iterator(){
		return (this).new MyIterator();
	}

	private class MyIterator implements GenericIterator<T>{
		private int i = 0;
		
		@Override public boolean hasNext(){
			return (i<pos);
		}
		
		@Override public void remove() throws Exception{
			throw new Exception("Impossivel remover");
		}
		
		@Override public T next(){
			return vetor[i++];
		}
		
	}
}
