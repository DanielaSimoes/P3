package Aula8;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class GUIQQSM extends JFrame{
	
	private Pergunta pergunta;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private QQSM QQSM;
	private ButtonGroup group;
	
	public static void main(String[] args) throws IOException{
		GUIQQSM jogo = new GUIQQSM();
		jogo.setVisible(true);
	}
	
	public GUIQQSM() throws IOException{
		super("Quem quer ser milionário?");
		QQSM = new QQSM(new File("questions.txt"));
		
		this.setVisible(true);
		this.setSize(1200,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(design());
	}
	
	public JPanel design(){
		pergunta = QQSM.getPergunta();

		JPanel content = new JPanel();
		content.setSize(800,700);
		content.setLayout(new BorderLayout());
		content.setVisible(true);
		
		//imagem
		JPanel pictureBox = new JPanel(new BorderLayout());
		pictureBox.setVisible(true);
		
		try {	
			BufferedImage picture = ImageIO.read(new File(pergunta.getImagem()));
			JLabel pic = new JLabel(new ImageIcon(picture));
			pictureBox.add(pic, BorderLayout.WEST);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//pergunta
		JPanel askBox = new JPanel(new BorderLayout());
		JTextArea p = new JTextArea(pergunta.toString());
		p.setFont(new Font("Courier New", 1, 13));
		p.setVisible(true);
		
		askBox.add(p, BorderLayout.CENTER);
		askBox.setBorder(new EmptyBorder(80,30,80,30));
		pictureBox.add(askBox, BorderLayout.CENTER);
		
		//nivel
		JPanel nivel = new JPanel(new BorderLayout());
		JLabel dif = new JLabel("Premio:" + QQSM.valorGanho());

		dif.setVisible(true);
		nivel.add(dif, BorderLayout.EAST);
		dif.setVisible(true);
		
		pictureBox.add(nivel, BorderLayout.NORTH);
		
		content.add(pictureBox, BorderLayout.NORTH);
		
		//botoes
		JPanel grupo = new JPanel(new BorderLayout());
		grupo.setVisible(true);
		grupo.setLayout(new GridLayout(3,1));
		
		JPanel tmp = new JPanel();
		tmp.setVisible(true);
		
		ButtonGroup bt1 = new ButtonGroup();
		
		b1 = new JButton("Ajuda Publico");
		b2 = new JButton("Telefone");
		b3 = new JButton("50-50");
		
		
		bt1.add(b1);
		bt1.add(b2);
		bt1.add(b3);
		
		tmp.add(b1);
		tmp.add(b2);
		tmp.add(b3);
		
		//opcoes
		JPanel opcoes = new JPanel();
		opcoes.setLayout(new GridLayout(1,2));
		this.group = new ButtonGroup();
		
		JPanel opcoesAlinhar = new JPanel();
		opcoesAlinhar.setSize(200,200);
		opcoesAlinhar.setLayout(new GridLayout(2,1));
		
		for(String pergunta : pergunta.getOpcoes()){
			JRadioButton test = new JRadioButton(pergunta);
			group.add(test);
			opcoesAlinhar.add(test);
		}
		opcoes.add(opcoesAlinhar);
		
		JPanel setSize = new JPanel(new BorderLayout());
		JPanel gridTmp = new JPanel();
		JPanel j1 = new JPanel();
		JPanel j2 = new JPanel();
		b4 = new JButton("Desistir");
		b5 = new JButton("Confirmar");
		
		j1.add(b4);
		j2.add(b5);
		
		gridTmp.add(j1);
		gridTmp.add(j2);
		
		group.add(b5);
		group.add(b4);
		
		setSize.add(gridTmp, BorderLayout.SOUTH);
		setSize.setVisible(true);
				
		opcoes.setVisible(true);
		opcoes.add(setSize);
		
		grupo.add(tmp); //add os botoes
		grupo.add(opcoes); //adiciona as opcoes
		
		content.add(grupo, BorderLayout.CENTER);
		
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ajudaPublico();
			}
		});
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				telefonar();
			}
		});
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cinquentacinquenta();
			}
		});
		
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				darResposta();
			}
		});
		
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seguinte(textoBotaoSelecionado());
			}
		});
		
		return content;
	}
	
	public void ajudaPublico(){
		b1.setEnabled(false);
		
		String resposta = "";
		String nivel = pergunta.getNivel();
		System.out.println("TESTE" + nivel);
		String[] respostas = pergunta.getOpcoes();
		
		resposta += respostas[0] + " " +(int)(40+Math.random()*(50-Integer.parseInt(nivel))) + "%\n";
		resposta += respostas[1] + " " +(int)(18+Math.random()*(20-Integer.parseInt(nivel))) + "%\n";
		resposta += respostas[2] + " " +(int)(15+Math.random()*(30-Integer.parseInt(nivel))) + "%\n";		
		resposta += respostas[3] + " " +(int)(10+Math.random()*(14-Integer.parseInt(nivel))) + "%";
		JOptionPane.showMessageDialog(getContentPane(), resposta);
		
	}

	public void telefonar(){
		b2.setEnabled(false);
		
		String resposta = "";
		String nivel = pergunta.getNivel();
		String[] respostas = pergunta.getOpcoes();
		
		resposta += respostas[0] + " " +(int)(20+Math.random()*(50-Integer.parseInt(nivel))) + "%\n";
		resposta += respostas[1] + " " +(int)(18+Math.random()*(20-Integer.parseInt(nivel))) + "%\n";
		resposta += respostas[2] + " " +(int)(15+Math.random()*(30-Integer.parseInt(nivel))) + "%\n";		
		resposta += respostas[3] + " " +(int)(10+Math.random()*(14-Integer.parseInt(nivel))) + "%";
		JOptionPane.showMessageDialog(getContentPane(), resposta);
	}
	
	public void cinquentacinquenta(){
		b3.setEnabled(false);
		int i = 0;
		
		Enumeration<AbstractButton> elements = this.group.getElements();
		while (elements.hasMoreElements()){
			AbstractButton button = (AbstractButton)elements.nextElement();
		          if (button.isEnabled() && !(button.getText().equals(pergunta.respostaCorreta()))){
		            button.setEnabled(false); 
		            i++;
		          }
		          if(i==2){
		        	  break;
		          }
		}
	}
	
	public void darResposta(){
		JOptionPane.showMessageDialog(getContentPane(), pergunta.respostaCorreta());
		System.exit(0);
	}
	
	public void seguinte(String resposta){
		if(pergunta.respostaCorreta().equals(resposta)){
			JOptionPane.showMessageDialog(getContentPane(),
                    "Resposta correta!");
			QQSM.acertou();
			if(QQSM.verificarTermino()){
				JOptionPane.showMessageDialog(getContentPane(),
	                    "Parabens!\nValor ganho: " + QQSM.valorGanho());
						System.exit(0);
			}
			this.getContentPane().removeAll();
			Container teste = this.getContentPane();
			this.getContentPane().add(design());
			setVisible(true);
			getContentPane().doLayout();
		    update(getGraphics());
		}else{
			JOptionPane.showMessageDialog(getContentPane(),
                    "Resposta errada!\nResposta correta:"+pergunta.respostaCorreta()+"\nValor ganho: " + QQSM.valorGanho());
					System.exit(0);
		}
	}
	
	public String textoBotaoSelecionado(){
	     for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
	         AbstractButton button = buttons.nextElement();
	
	         if (button.isSelected()) {
	             return button.getText();
	         }
	     }
	     return null;
	}
}
