package Aula7;
import java.io.File;

public class ex2 {
	
		public static void main(String args[]){
			File f1 = new File("Figura.bmp");
			BitMap bmp = new BitMap(f1);
			System.out.println(bmp.equals(bmp));
			//catacteristics of f1
			System.out.println(bmp);
			//copy
			File f2 = new File("Test1.bmp");
			bmp.write(f2);
			//get the raw
			File f3 = new File("Test.raw");
			bmp.getBmpRaw(f3);
			//reisize image
			File f4 = new File("Resized14.bmp");
			bmp.resize025(f4);
			//flip vertical 
			File f5 = new File("FlipImageVertical.bmp");
			bmp.flipVertical(f5);
			//flip horizontal 
			File f6 = new File("FlipImageHorizontal.bmp");
			bmp.flipHorizontal(f6);
		}
	}
