package Aula9;

public abstract class ex3 {
	
	public static void main(String[] args) {
		VetorPessoas vp = new VetorPessoas();
		
		Data.today();
		for (int i=0; i<10; i++)
			vp.addPessoa(new Pessoa("Bebé no Vector "+i,1000+i, Data.today()));
		
		Iterador vec = vp.iterator();
		
		while ( vec.hasNext() )
			System.out.println( vec.next() );

		ListaPessoas lp = new ListaPessoas();
		
		for (int i=0; i<10; i++)
			lp.addPessoa(new Pessoa("Bebé na Lista "+i,2000+i, Data.today()));

		Iterador lista = lp.iterator();
		
		while ( lista.hasNext() )
			System.out.println( lista.next() );
	}
}
