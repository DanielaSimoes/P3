package Aula2;

public class Video{
	// nao e necessario id declarado, visto que e sequencial
	private String title;
	private String category;
	private int age;
	
	public Video(String title, String category, int age){
		this.title = title;
		this.category = category;
		this.age = age;
	}
	
	public String getTitulo(){
		return this.title;
	}
	
	public String toString(){
		return  " T’tulo: " + this.title + " Categoria: " +
				this.category + " Idade: " + this.age;
	}
}