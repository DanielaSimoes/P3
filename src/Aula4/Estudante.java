package Aula4;

import java.util.*;

public class Estudante extends Pessoa{

		private Data dataInsc;
		private static int nMecAtual = 100;
		private int nMec;
		
		public Estudante(String name, int cc, Data dataN, Data dataInsc){
			super(name, cc, dataN);
			
			this.dataInsc = dataInsc;
			
			this.nMec = this.nMecAtual++;
		}
		
		public Estudante(String name, int cc, Data dataN){
			super(name, cc, dataN);
			this.nMec = this.nMecAtual++;
			
			Calendar c = new GregorianCalendar();
			int dia = c.get(Calendar.DAY_OF_MONTH);
			int mes = c.get(Calendar.MONTH)+1;
			int ano = c.get(Calendar.YEAR);
			Data data = new Data(dia, mes, ano);
			
			this.dataInsc = data;
		}
		
		public String nome(){
			return getName();
		}
		
		public int nMec(){
			return nMec;
		}
		
		@ Override public String toString(){
			return super.toString() + "\n Data de Inscrição:" + this.dataInsc + ", nMec " + this.nMec();
		}
	
}
