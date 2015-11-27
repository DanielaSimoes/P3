package Aula8;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

public class Button extends JToggleButton{
	
	private int x, y;
	protected JogoDoGalo jogo;

	public Button(int x, int y, JogoDoGalo jogo){
		super("");
		this.x = x;
		this.y = y;
		this.jogo = jogo;
		setFont(new Font("Helvetica", 1, 40));

		super.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				set();
			}
		});
	}
	
	public void set(){
		int tmp = jogo.alternar();
		if(tmp==-1){
			setEnabled(false);
			setText("0");
			jogo.escolha = -1;
			setText("<html>O</html>");
			jogo.set(this.x, this.y, tmp);
		}else{
			setText("X");
			jogo.escolha = 1;
			setEnabled(	false);
			setText("<html>X</html>");
			jogo.set(this.x, this.y, tmp);
		}
		vencedor();
	}
	
	public void vencedor(){
		if(jogo.terminado==1){
			String result;
			if(jogo.vencedor()==1){
				result = "O X venceu!";
			}else if(jogo.vencedor()==-1){
				result = "O O venceu!";
			}else if(jogo.vencedor()==0){
				result = "Empate!";
			}else{
				return;
			}
			JOptionPane.showMessageDialog(getRootPane(), result);
			System.exit(0);
		}
	}
}
