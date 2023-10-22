package Processamento;

import java.awt.image.BufferedImage;


public class Processamento_Imagem_ {
        
        /*  Metodo para a deteccao de
            Blueness Index em imagens.  */
	public static BufferedImage BI_(BufferedImage Imagem){
            return Blueness_Index_.Blueness_(Imagem);
	}
        
        //Criando o método para chamar o blueness do código do antonio
        public static BufferedImage BIA_(BufferedImage Imagem){
            return Blueness_Index_Antonio.Blueness_Antonio(Imagem);
	}
        
        //Criando o método para chamar o blueness da combinação
        public static BufferedImage BIAJ_(BufferedImage Imagem){
            return Blueness_Antonielly_Joao.Blueness_(Imagem);
	}
        
	
        /*  Metodo para aplicar a segmentacao em imagens. */
	public static BufferedImage Segment_(BufferedImage Imagem, int Metodo) {            
            // Aplicacao do algoritmo.
            switch(Metodo){                
                case 1:  return Segmentacao_.Otsu_Binarization_(Imagem);
                case 2:  return Segmentacao_.Fuzzy_Huang_Binarization_(Imagem);
                case 3:  return Segmentacao_.LimiarEntropiaPun(Imagem);//foi adicionado aqui
                default: return Imagem;
            }
	}
}
