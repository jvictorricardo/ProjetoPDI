package Processamento;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * @author João Victor do Rozário Recla - 2022/2
 */
public class Blueness_Index_Antonio {
    public static BufferedImage Blueness_Antonio(BufferedImage imagem) {
        double max = 0;
        double min = 255;
        double ri;
        double r;
        double g;
        double b;
        
        for(int i = 0; i < imagem.getWidth(); i++) {
            for(int j = 0; j < imagem.getHeight(); j++) {
		Color c = new Color(imagem.getRGB(i, j));
		double rOriginal = new Double(c.getRed());
		double gOriginal = new Double(c.getGreen());
                double bOriginal = new Double(c.getBlue());
                                                                                           
                if((rOriginal==0) && (gOriginal==0) && (bOriginal==0)){
                    r = g = b = 1/3;  
                } else {
                    r = rOriginal / (rOriginal+gOriginal+bOriginal);
                    g = gOriginal / (rOriginal+gOriginal+bOriginal);
                    b = bOriginal / (rOriginal+gOriginal+bOriginal);
                }
                                                                                           
                if(r+g+b!=0){		
                    ri = (double)(Math.pow(b,2) /  Math.pow(r + g+ b,2));
                }else{
                    ri = 0;
                }	
                if (ri < min) min = ri;
                if (ri > max) max = ri;
            }
        }
		
        for(int i = 0; i < imagem.getWidth(); i++) {
            for(int j = 0; j < imagem.getHeight(); j++) {
                Color c = new Color(imagem.getRGB(i, j));
                double rOriginal = new Double(c.getRed());
                double gOriginal = new Double(c.getGreen());
                double bOriginal = new Double(c.getBlue());
                                                                                           
                if((rOriginal==0) && (gOriginal==0) && (bOriginal==0)){
                    r = g = b = 1/3;  
                } else {
                    r = rOriginal / (rOriginal+gOriginal+bOriginal);
                    g = gOriginal / (rOriginal+gOriginal+bOriginal);
                    b = bOriginal / (rOriginal+gOriginal+bOriginal);
                }
				
                if(r+g+b!=0){		
                    ri = (double)(Math.pow(b,2) /  Math.pow(r + g+ b,2));
                }else{
                    ri = 0;
                }

                if(((r + g + b) <= 0)){ 
                    Color novo = new Color(0, 0, 0);
                    imagem.setRGB(i, j, novo.getRGB());
                } else {
                    double riNormalizado = 255 * ((ri - min) / (max - min));
                    int riBW = (int) riNormalizado;

                Color novo = new Color(riBW, riBW, riBW);
                imagem.setRGB(i, j, novo.getRGB());
                }
            }
        }
        return imagem;
    }
}