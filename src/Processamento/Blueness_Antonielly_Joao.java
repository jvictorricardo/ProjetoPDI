package Processamento;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Blueness_Antonielly_Joao {
    
    /*  Algoritmo para deteccao de Blueness Index, feito a partir da combinação
        de dois algoritmos existentes: o de João (sobrenome) e o de Antônio 
        (sobrenome).
    */
    public static BufferedImage Blueness_(BufferedImage imagem) {
        //variaveis antonio
        double max = 0;
        double min = 255;
        double ri;
        double r;
        double g;
        double b;
        
        
        //variaveis joao r.
        double BI;                              // Indice de Blueness.
        int K = 14;                             // Indice K.
        double Index_max = Double.MIN_VALUE;    // Inidce maximo.
        double Index_min = Double.MAX_VALUE;    // Indice minimo.        
        
        // Auxiliares para a aplicacao do metodo.
        double BI_A[][] = new double[imagem.getWidth()][imagem.getHeight()];
        double BI_B[][] = new double[imagem.getWidth()][imagem.getHeight()];
        

        //minhas variaveis
        Color resultadoAlg1[][] = new Color[imagem.getWidth()][imagem.getHeight()];
        Color resultadoAlg2[][] = new Color[imagem.getWidth()][imagem.getHeight()];
        
        
        /*
            Aplicando o método do antonio e armazenando em uma matriz.
            Talvez não seja o método mais eficiente em qurstão de custo computa_
            _cional, mas fica aí por enquanto.
      
            Loop para percorrer os pixels da imagem (Coluna x Linha), e
            calcular os indices maximo e minimo de Bluness na imagem:
        */
        
        for(int i = 0; i < imagem.getWidth(); i++) {
            for(int j = 0; j < imagem.getHeight(); j++) {
		Color c = new Color(imagem.getRGB(i, j));
		double rOriginal = Double.valueOf(c.getRed());
		double gOriginal = Double.valueOf(c.getGreen());
                double bOriginal = Double.valueOf(c.getBlue());
                                                                                           
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
	
        /*
            Loop para normalização dos pixeis obtidos no processo de blueness.
        */
        for(int i = 0; i < imagem.getWidth(); i++) {
            for(int j = 0; j < imagem.getHeight(); j++) {
                Color c = new Color(imagem.getRGB(i, j));
                double rOriginal = Double.valueOf(c.getRed());
                double gOriginal = Double.valueOf(c.getGreen());
                double bOriginal = Double.valueOf(c.getBlue());
                                                                                           
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
                    resultadoAlg1[i][j] = new Color(0, 0, 0);
                } else {
                    double riNormalizado = 255 * ((ri - min) / (max - min));
                    int riBW = (int) riNormalizado;
                    resultadoAlg1[i][j] = new Color(riBW, riBW, riBW);
                }
            }
        }
        
        
        
        /*
            Aplicando o método do joão do rosário e armazenando em uma matriz.
            Talvez não seja o método mais eficiente em qurstão de custo computa_
            _cional, mas fica aí por enquanto.
      
            Loop para percorrer os pixels da imagem (Coluna x Linha), e
            calcular os indices maximo e minimo de Bluness na imagem:
        */
        for(int i = 0; i < imagem.getWidth(); i++) { //for para as linhas
            for(int j = 0; j < imagem.getHeight(); j++) {

                // Niveis de cor de cada pixel.
                Color C = new Color(imagem.getRGB(i, j));
                double R = Double.valueOf(C.getRed());
                double G = Double.valueOf(C.getGreen());
                double B = Double.valueOf(C.getBlue());
                
                // Aplicacao do metodo.
                BI_A[i][j] = Math.pow(B, 2);
                BI_B[i][j] = Math.pow(R, 2) + Math.pow(G, 2) + K;
                BI = (double)(BI_A[i][j] / BI_B[i][j]);
                
                // Indices de Blueness.
                if(BI < Index_min) Index_min = BI;
                if(BI > Index_max) Index_max = BI;
            }
        }

        
        /*  
            Loop para percorrer os pixels da imagem (Coluna x Linha),
            e normalizar os niveis de cor da imagem.
        */
        for(int i = 0; i < imagem.getWidth(); i++) {
            for(int j = 0; j < imagem.getHeight(); j++) {
                // Indice de Blueness do pixel(i, j).
                BI = (double)(BI_A[i][j] / BI_B[i][j]);
                //Caso a área não seja de interesse
                if(BI_B[i][j] <= 0){
                    resultadoAlg2[i][j] = new Color(0, 0, 0);
                } else {
                    // Normalizacao dos niveis de cor.
                    double BI_normalizado = ((BI - Index_min) / (Index_max - Index_min)) * 255;
                    int BI_color = (int) BI_normalizado;
                    resultadoAlg2[i][j] = new Color(BI_color, BI_color, BI_color);
                }
            }
        }
        
        
        /*
            Colocando o maior resultado como resultado do blueness. No momento,
            o maior pixel tá sendo aquele com maior valor após obter a cor RGB
            e converter para Double
        */
        for(int i = 0; i < imagem.getWidth(); i++) {
            for(int j = 0; j < imagem.getHeight(); j++) {
                Double pixelRA =  Double.valueOf(resultadoAlg1[i][j].getRGB());
                Double pixelRB =  Double.valueOf(resultadoAlg2[i][j].getRGB());
                
                //System.out.println("PA: " + pixelRA + " \n");
                //System.out.println("PB: " + pixelRB + " \n");

                if(pixelRB <= pixelRA){
                    imagem.setRGB(i, j, resultadoAlg1[i][j].getRGB());
                }
                else{
                    imagem.setRGB(i, j, resultadoAlg2[i][j].getRGB());
                }
            }
        }
        
        
        
        return imagem;
    }
}