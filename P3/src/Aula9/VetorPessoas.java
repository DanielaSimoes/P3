package Aula9;

public class VetorPessoas {
	
	private Pessoa[] vetor;
	private int pos;
	
	public VetorPessoas(){
		vetor = new Pessoa[1];
		pos = 0;
	}
	
	public void addPessoa(Pessoa p){
		if(pos==vetor.length){
			Pessoa[] redimensiona = new Pessoa[vetor.length + 1];
			System.arraycopy(vetor, 0, redimensiona, 0, vetor.length);
			vetor = redimensiona;
		}
		vetor[pos++] = p;
	}
	
	private void removePessoa(Pessoa p){
		int indice = 0;
		Pessoa[] tmp = new Pessoa[vetor.length-1];
		for (int i = 0; i < vetor.length; i++) {
			if(vetor[i].getCC()==p.getCC()){
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
	}
	
	public int getSize(){
		return vetor.length;
	}
	
	public Pessoa[] toArray(){
		return vetor;
	}
	
	public String toString(){
		String tmp = "";
		
		for(int i=0; i<pos; i++){
			tmp += "\n"+vetor[i];	
		}
		
		return tmp;
	}
	
	public Iterador iterator(){
		return (this).new MyIterator();
	}

	private class MyIterator implements Iterador{
		private int i = 0;
		
		@Override public boolean hasNext(){
			return (i<pos);
		}
		
		@Override public void remove(){
			removePessoa(vetor[i]);
			i--;
		}
		
		@Override public Pessoa next(){
			return vetor[i++];
		}
		
	}
		
}
