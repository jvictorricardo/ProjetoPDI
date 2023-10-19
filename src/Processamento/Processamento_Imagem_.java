package Processamento;

import java.awt.image.BufferedImage;

/**
 * @author João Victor do Rozário Recla - 2022/2
 */
public class Processamento_Imagem_ {
        
        /*  Metodo para a deteccao de
            Blueness Index em imagens.  */
	public static BufferedImage BI_(BufferedImage Imagem){
            
            // Aplicacao do algoritmo.
            return Blueness_Index_.Blueness_(Imagem);
	}
        
        //Criando o método para chamar o blueness do código do antonio
        public static BufferedImage BIA_(BufferedImage Imagem){
            
            // Aplicacao do algoritmo.
            return Blueness_Index_Antonio.Blueness_Antonio(Imagem);
	}
        
	
        /*  Metodo para aplicar uma
            segmentacao em imagens. */
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
