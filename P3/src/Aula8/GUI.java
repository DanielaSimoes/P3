package Aula8;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class GUI{
	 public static void main(String[] args) {
		 
		//novo jogo
		JogoDoGalo jogo = new JogoDoGalo();
		 
		//interface
		JFrame board = new JFrame("Jogo do Galo!");
		board.setSize(450,450);
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel content = new JPanel();
		content.setBackground(Color.black);
		content.setLayout(new GridLayout(3,3));
		content.add(new Button(1,1,jogo));
		content.add(new Button(1,2,jogo));
		content.add(new Button(1,3,jogo));
		content.add(new Button(2,1,jogo));
		content.add(new Button(2,2,jogo));
		content.add(new Button(2,3,jogo));
		content.add(new Button(3,1,jogo));
		content.add(new Button(3,2,jogo));
		content.add(new Button(3,3,jogo));
		board.setContentPane(content);
		board.setVisible(true);	
		
	 }
}
