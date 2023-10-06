/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Processamento;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author João
 */
public class DeteccaoFinal {
    public static BufferedImage Aplicar_Deteccao_Final_(BufferedImage ImgAtual, BufferedImage ImgOriginal){
        int Linha, Coluna;
        int Altura  = ImgAtual.getHeight();  // Altura da imagem.
        int Largura = ImgAtual.getWidth();   // Largura da imagem.
        // Buffer para a imagem final.
        BufferedImage ImgAtual_detectada = new BufferedImage(Largura, Altura, ImgAtual.getType());
        
        
        // Loop para finalizar a imagem.
        for(Linha = 0; Linha < Altura; Linha++){
            for(Coluna = 0; Coluna < Largura; Coluna++){
                
                // Cor da imagem binarizada
                Color Cor1 = new Color(ImgAtual.getRGB(Coluna, Linha));
                // Cor da imagem Original.
                Color Cor2 = new Color(ImgOriginal.getRGB(Coluna, Linha));
                
                
                Color Resultado;
                //Se for preto
                if(Color.BLACK.hashCode() == Cor1.hashCode()){
                    //fica preto
                    Resultado = Color.BLACK;
                }
                //Se ñ for preto
                else{
                    //seta pro pixel da imagem original
                    Resultado = new Color(Cor2.getRed(), Cor2.getGreen(), Cor2.getBlue());
                }
                
                
                // Montagem da imagem final.
                ImgAtual_detectada.setRGB(Coluna, Linha, Resultado.getRGB());
            }
        }
        
        return ImgAtual_detectada;
    }
}
