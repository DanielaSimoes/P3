package Aula8;

import java.io.File;
import java.io.IOException;

public class QQSM {
	private Pergunta[] perguntas;
	private boolean cinquentacinquenta = true;
	private boolean chamada = true;
	private boolean publico = true;
	private int[] valor = {25, 50, 125, 250, 500, 750, 1500, 2500,
			5000, 10000, 16000, 32000, 64000, 125000, 250000};
	private int valorAtual;
	private int n = 0;

	public QQSM(File f) throws IOException{
		Parser parser = new Parser(f);
		perguntas = parser.getPerguntas();
		valorAtual = -1;
	}
	
	public Pergunta getPergunta(){
		this.n++;
		return perguntas[n];
	}
	
	public void acertou(){
		valorAtual++;
	}
	
	public int valorGanho(){
		if(valorAtual>=0)
			return valor[valorAtual];
		else
			return 0;
	}
	
	public boolean verificarTermino(){
		if(n==14)
			return true;
		else
			return false;
	}
	
}
