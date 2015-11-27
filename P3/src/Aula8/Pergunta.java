package Aula8;

import java.util.Arrays;

public class Pergunta {
	private String nivel;
	private String perguta;
	private String url;
	private String[] respostas;
	private String respostaCorreta;
	
	public Pergunta(String nivel, String pergunta, String url, String[] respostas, String respostaCorreta){
		this.nivel = nivel;
		this.perguta = pergunta;
		this.url = url.replace(":", "/");
		this.respostas = respostas;
		this.respostaCorreta = respostaCorreta;
	}
	
	public String[] getOpcoes(){
		return this.respostas;
	}
	
	public String respostaCorreta(){
		return this.respostaCorreta;
	}
	
	public String getImagem(){
		return this.url;
	}
	
	public String getNivel(){
		return this.nivel;
	}

	@Override
	public String toString() {
		return this.perguta;
	}
	
	
}
