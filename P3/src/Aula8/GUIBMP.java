package Aula8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUIBMP extends JFrame{
	private File bmpFile;
	private BitMap bmp;
	private JPanel imagem;
	private JPanel principal;
	private File selecionado;
	private File verticalFile;
	private File horizontalFile;
	private File ummeioFile;
		
	public static void main(String[] args){
			GUIBMP a = new GUIBMP();
	}
	
	public GUIBMP(){
		super("Editor de BMP");
		
		this.setSize(600,600);
		this.setVisible(true);
		this.setContentPane(design());
		
	}
	
	public JPanel design(){
		principal = new JPanel();
		principal.setSize(600,600);
		principal.setLayout(new BorderLayout());
		principal.setVisible(true);
		
		JFileChooser abrirFicheiro = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.bmp", "bmp");
		System.out.println(filtro);
		abrirFicheiro.addChoosableFileFilter(filtro);
		
		float resposta=0;
		
		try{
			resposta = abrirFicheiro.showDialog(null, "Escolha um ficheiro!");
		}catch(Exception e){
			System.exit(0);
		}
		
		if(resposta==JFileChooser.APPROVE_OPTION){
			bmpFile = abrirFicheiro.getSelectedFile();
			// criar o bmp
			bmp = new BitMap(bmpFile);
		}
		
		if(bmpFile == null || !bmpFile.isFile() || !bmpFile.exists() || !bmpFile.canRead()){
			System.exit(0);
		}

		//MENU
		JPanel menu = new JPanel();
		menu.setBorder(new EmptyBorder(10, 90, 10, 90));
		menu.setLayout(new GridLayout(1,5));
		menu.setVisible(true);
		
		JButton vertical = new JButton("Flip Verical");
		vertical.setVisible(true);
		menu.add(vertical);
		
		JButton horizontal = new JButton("Flip Horizontal");
		horizontal.setVisible(true);
		menu.add(horizontal);
		
		JButton ummeio = new JButton("Redimensionar 1/2");
		ummeio.setVisible(true);
		menu.add(ummeio);
		
		principal.add(menu, BorderLayout.NORTH);
		
		//menu2
		JPanel menu2 = new JPanel();
		menu2.setBorder(new EmptyBorder(0, 10, 10, 0));
		menu2.setLayout(new GridLayout(5,1));
		menu2.setVisible(true);
		
		JButton original = new JButton("Mostrar Original");
		original.setEnabled(false);
		original.setVisible(true);
		menu2.add(original);
		
		JButton mostrar_vertical = new JButton("Mostrar Flip Vertical");
		mostrar_vertical.setEnabled(false);
		mostrar_vertical.setVisible(true);
		menu2.add(mostrar_vertical);
		
		JButton mostrar_horizontal = new JButton("Mostrar Flip Horizontal");
		mostrar_horizontal.setEnabled(false);
		mostrar_horizontal.setVisible(true);
		menu2.add(mostrar_horizontal);
		
		JButton mostrar_ummeio = new JButton("Mostrar Redimensionar 1/2");
		mostrar_ummeio.setEnabled(false);
		mostrar_ummeio.setVisible(true);
		menu2.add(mostrar_ummeio);
		
		JButton gravar = new JButton("Gravar");
		gravar.setEnabled(false);
		gravar.setVisible(true);
		menu2.add(gravar);
		
		principal.add(menu2, BorderLayout.WEST);
		
		// foto
		imagem = new JPanel();
		imagem.setVisible(true);
		visualizar(bmpFile);
		
		principal.add(imagem);
		
		//listeners menu
		vertical.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vertical();
				original.setEnabled(true);
				mostrar_vertical.setEnabled(true);
			}
		});
		
		horizontal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				horizontal();
				original.setEnabled(true);
				mostrar_horizontal.setEnabled(true);
			}
		});
		
		ummeio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ummeio();
				original.setEnabled(true);
				mostrar_ummeio.setEnabled(true);
			}
		});
		
		//listeners menu2
		original.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visualizar(bmpFile);
				opcoes(bmpFile, gravar);
			}
		});
		
		mostrar_vertical.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visualizar(verticalFile);
				opcoes(verticalFile, gravar);
			}
		});
		
		mostrar_horizontal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visualizar(horizontalFile);
				opcoes(horizontalFile, gravar);
			}
		});
		
		mostrar_ummeio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visualizar(ummeioFile);
				opcoes(ummeioFile, gravar);
			}
		});
		
		gravar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gravar(gravar);
			}
		});
		
		return principal;
	}
	
	public void visualizar(File bmpFile){
		if(imagem!=null){
			principal.remove(imagem);
		}
		
		imagem = new JPanel();
		BufferedImage img;
		
		try{
			img = ImageIO.read(bmpFile);
			JLabel imgLabel = new JLabel(new ImageIcon(img));
			imgLabel.setVisible(true);
			imagem.add(imgLabel);
			principal.add(imagem, BorderLayout.CENTER);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		super.invalidate();
		super.validate();
		super.repaint();	}
	
	private void gravar(JButton b){
		JFileChooser abrirFicheiro = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.bmp", "bmp");
		abrirFicheiro.addChoosableFileFilter(filtro);
		abrirFicheiro.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		float resp = abrirFicheiro.showDialog(null, "Guardar.");
		if(resp == JFileChooser.APPROVE_OPTION){
			File dest_file = abrirFicheiro.getSelectedFile();
			selecionado.renameTo(dest_file);
			b.setEnabled(false);
		}else{
			print("Digite o nome do ficheiro .bmp e onde pretende gravar!");
			return;
		}
	}
	
	private void vertical(){
		try {
			verticalFile = File.createTempFile("flipV", ".bmp");
			bmp.flipVertical(verticalFile);
			visualizar(verticalFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void horizontal(){
		try {
			horizontalFile = File.createTempFile("flipH", ".bmp");
			bmp.flipHorizontal(horizontalFile);
			visualizar(horizontalFile);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	private void ummeio(){
		try {
			ummeioFile = File.createTempFile("flipUmMeio", ".bmp");
			bmp.resize025(ummeioFile);
			visualizar(ummeioFile);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	protected void print(String message){
		JOptionPane.showMessageDialog(getContentPane(), message);
	}
	
	private void opcoes(File selecionado, JButton...array){
		if(selecionado!=null){
			for(JButton bt : array){
				bt.setEnabled(true);
			}
		}
		this.selecionado = selecionado;
	}
	
}
