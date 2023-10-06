package Telas;

import Processamento.DeteccaoFinal;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Processamento.Processamento_Imagem_;

/**
 * @author João Victor do Rozário Recla - 2022/2
 */
public class Tela_Aplicacao_Lote extends javax.swing.JFrame {
    
    // Tipos de aplicacao.
    public boolean Detectar_RI         = false;
    public boolean Detectar_BI         = false;
    public boolean Aplicar_segmentacao = false;
    
    // Nome do metodo a ser aplicado.
    public String Metodo_nome      = "_Metodo_";
    public int    Segmentacao_tipo = 0;
    
    // Atributos.
    private int Qnt_imagens;
    private boolean Finalizado = false;
    private int Qnt_imgs_processadas = 0;
    private File Pasta_origem, Pasta_destino;
    public  File Caminho = new File("/home/");
    private boolean Escolheu_origem = false, Escolheu_destino = false;

    
    /**
     * Creates new form TelaPostPasta
     */
    public Tela_Aplicacao_Lote() {   
        
        initComponents();
        Mensagem_Aviso_.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Campo_Pasta_Origem_ = new javax.swing.JTextField();
        Selecionar_Pasta_Origem_ = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Campo_Pasta_Destino_ = new javax.swing.JTextField();
        Selecionar_Pasta_Destino_ = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Opcao_PNG_ = new javax.swing.JRadioButton();
        Opcao_JPG_ = new javax.swing.JRadioButton();
        Opcao_BMP_ = new javax.swing.JRadioButton();
        Mensagem_Aviso_ = new javax.swing.JLabel();
        Cancelar_ = new javax.swing.JButton();
        Aplicar_ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aplicação em Lote");
        setFocusCycleRoot(false);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Aplicação em Lote");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("        Selecione uma pasta com arquivos de imagem:");

        Campo_Pasta_Origem_.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        Campo_Pasta_Origem_.setText("Selecione uma pasta de origem...");
        Campo_Pasta_Origem_.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Selecionar_Pasta_Origem_.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Selecionar_Pasta_Origem_.setText("Selecionar...");
        Selecionar_Pasta_Origem_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Selecionar_Pasta_Origem_ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Selecione uma pasta para salvar as imagens processadas:              ");

        Campo_Pasta_Destino_.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        Campo_Pasta_Destino_.setText("Selecione uma pasta de destino...");
        Campo_Pasta_Destino_.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Selecionar_Pasta_Destino_.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Selecionar_Pasta_Destino_.setText("Selecionar...");
        Selecionar_Pasta_Destino_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Selecionar_Pasta_Destino_ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Selecione a(s) extensão(ões) das imagens que devem ser  processadas:");

        Opcao_PNG_.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Opcao_PNG_.setSelected(true);
        Opcao_PNG_.setText("PNG");

        Opcao_JPG_.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Opcao_JPG_.setText("JPEG/JPG");

        Opcao_BMP_.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Opcao_BMP_.setText("BMP");

        Mensagem_Aviso_.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Mensagem_Aviso_.setForeground(new java.awt.Color(255, 0, 0));
        Mensagem_Aviso_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Mensagem_Aviso_.setText("[Mensagem de Aviso]");

        Cancelar_.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Cancelar_.setText("Cancelar");
        Cancelar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancelar_ActionPerformed(evt);
            }
        });

        Aplicar_.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Aplicar_.setText("Aplicar");
        Aplicar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aplicar_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Campo_Pasta_Origem_)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Selecionar_Pasta_Origem_, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Campo_Pasta_Destino_)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Selecionar_Pasta_Destino_, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(Cancelar_, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(Aplicar_, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Opcao_PNG_)
                        .addGap(31, 31, 31)
                        .addComponent(Opcao_JPG_)
                        .addGap(30, 30, 30)
                        .addComponent(Opcao_BMP_)
                        .addGap(205, 205, 205))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Mensagem_Aviso_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Campo_Pasta_Origem_, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Selecionar_Pasta_Origem_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Selecionar_Pasta_Destino_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Campo_Pasta_Destino_, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Opcao_PNG_)
                    .addComponent(Opcao_JPG_)
                    .addComponent(Opcao_BMP_))
                .addGap(10, 10, 10)
                .addComponent(Mensagem_Aviso_)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Aplicar_)
                    .addComponent(Cancelar_))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    /*  Metodo para selecionar uma pasta com arquivos de imagem.    */
    private void Selecionar_Pasta_Origem_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Selecionar_Pasta_Origem_ActionPerformed

        try{
           
            // Configura e abre uma janela de dialogo.
            JFileChooser Fs = new JFileChooser(Caminho);
            Fs.setDialogTitle("Selecione uma pasta com arquivos de imagem...");
            Fs.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            Fs.setAcceptAllFileFilterUsed(false);
            int Retorno = Fs.showOpenDialog(null);
            
            // Seleciona a pasta.
            if (Retorno == JFileChooser.APPROVE_OPTION){
                
                Campo_Pasta_Origem_.setText(Fs.getSelectedFile().getPath());
                Pasta_origem    = Fs.getSelectedFile();
                Caminho         = Fs.getCurrentDirectory();
                Escolheu_origem = true;
            }           
        } catch(NullPointerException ex){
            Logger.getLogger(Tela_Aplicacao_Lote.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_Selecionar_Pasta_Origem_ActionPerformed

    
    /*  Metodo para aplicar algoritmos em um lote de imagens.   */
    private void Aplicar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aplicar_ActionPerformed

        if(Escolheu_origem && Escolheu_destino){

            Finalizado  = false;
            Qnt_imagens = 0;
            Qnt_imgs_processadas = 0;
            Mensagem_Aviso_.setVisible(false);

            // Calcula a quantidade de arquivos de imagem na pasta de origem.
            for(File Arquivos: Pasta_origem.listFiles()){

                if((Opcao_PNG_.isSelected() && Arquivos.getName().toLowerCase().endsWith(".png"))||
                   (Opcao_JPG_.isSelected() && Arquivos.getName().toLowerCase().endsWith(".jpg")) ||
                   (Opcao_JPG_.isSelected() && Arquivos.getName().toLowerCase().endsWith(".jpeg")) ||
                   (Opcao_BMP_.isSelected() && Arquivos.getName().toLowerCase().endsWith(".bmp")))
                {
                    Qnt_imagens++;
                }                               
            }
            
            
            // Cria uma Thread.
            Thread T1 = new Thread(){
                
                @Override
                
                public void run(){
                    
                    for(File Arquivos: Pasta_origem.listFiles()){
                        
                        // Identifica os arquivos de imagem, com a extensao selecionada, dentro da pasta.
                        if((Opcao_PNG_.isSelected() && Arquivos.getName().toLowerCase().endsWith(".png"))||
                           (Opcao_JPG_.isSelected() && Arquivos.getName().toLowerCase().endsWith(".jpg")) ||
                           (Opcao_JPG_.isSelected() && Arquivos.getName().toLowerCase().endsWith(".jpeg")) ||
                           (Opcao_BMP_.isSelected() && Arquivos.getName().toLowerCase().endsWith(".bmp")))
                        {
                            
                            try {
                                
                                // Pega uma imagem.
                                BufferedImage Img_original   = ImageIO.read(Arquivos);
                                BufferedImage Img_Processada = Img_original;
                                
                                // Aplica algum algoritmo.
                                if(Detectar_RI)              Img_Processada = Processamento_Imagem_.RI_(Img_original);
                                else if(Detectar_BI){
                                    //Selecionando o método de blueness de acordo com o nome setado na outra tela
                                    if("_BlueGabautz".equals(Metodo_nome)) Img_Processada = Processamento_Imagem_.BI_(Img_original);
                                    else if("_BlueGasparini".equals(Metodo_nome)) Img_Processada = Processamento_Imagem_.BIA_(Img_original);
                                    //QUANDO IMPLEMENTAR O 3º METODO, METER O NOME DE JANELA AQUI PRA CHAMAR O BLUENESS EM LOTE!!!!
                                    //else if("_BlueGabautz".equals(Metodo_nome)) Img_Processada = Processamento_Imagem_.BI_(Img_original);
                                    
                                }
                                else if(Aplicar_segmentacao) Img_Processada = Processamento_Imagem_.Segment_(Img_original, Segmentacao_tipo);
                                // Salva a imagem processada.
                                File Fo = new File(Pasta_destino.getPath() +"/" +Arquivos.getName().substring(0, Arquivos.getName().length() - 4) +Metodo_nome +".png");
                                ImageIO.write(Img_Processada, "png", Fo);
                                Qnt_imgs_processadas++;
                                
                            } catch (IOException ex) {
                                Logger.getLogger(Tela_Aplicacao_Lote.class.getName()).log(Level.SEVERE, null, ex);
                            }    
                        }                
                    }
                    
                    Finalizado = true;
                }
            };
            
            T1.start();   // Inicia a Thread.
            
            
            // Cria uma Thread.
            Thread T2 = new Thread(){
                
                @Override
                
                public void run(){
                    
                    // Exibe e executa uma janela de carregamento.
                    Tela_Carregamento_ Tc = new Tela_Carregamento_();
                    Tc.setVisible(true);
                    while(!Finalizado){
                        
                        Tc.Atualizar_Progresso_(Qnt_imgs_processadas, Qnt_imagens);
                    }
                    Tc.dispose();
                    
                    if(Qnt_imgs_processadas > 0 ){
                        
                        // Exibe uma mensagem confirmando o fim da aplicacao do algoritmo.
                        JOptionPane.showMessageDialog(rootPane, Qnt_imgs_processadas +" imagens foram processadas com sucesso!", "Aplicação realizada!", JOptionPane.INFORMATION_MESSAGE);                
                        Desktop desktop = Desktop.getDesktop();
                        
                        try {
                            desktop.open(Pasta_destino);    // Abre a pasta de destino.
                        }catch (IOException ex) {
                            Logger.getLogger(Tela_Aplicacao_Lote.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        
                        Mensagem_Aviso_.setText("Não foram encontradas imagens, com as extensões especificadas, na pasta de origem!");
                        Mensagem_Aviso_.setVisible(true);
                    }
                }
            };
            
            T2.start();   // Inicia a Thread.
            
            
        }else if(!Escolheu_origem){
            
            Mensagem_Aviso_.setText("A pasta de origem não foi especificada!");
            Mensagem_Aviso_.setVisible(true);            
        }else if(!Escolheu_destino){
            
            Mensagem_Aviso_.setText("A pasta de destino não foi especificada!");
            Mensagem_Aviso_.setVisible(true);      
        }
    }//GEN-LAST:event_Aplicar_ActionPerformed

    
    /*  Metodo para cancelar a aplicacao de algum
        algoritmo em um lote de imagens.    */
    private void Cancelar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancelar_ActionPerformed
        this.dispose();
    }//GEN-LAST:event_Cancelar_ActionPerformed

    
    /*  Metodo para selecionar uma pasta de destino para as imagens processadas.    */
    private void Selecionar_Pasta_Destino_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Selecionar_Pasta_Destino_ActionPerformed

        try{
            
            // Configura e abre uma janela de dialogo.
            JFileChooser Fs = new JFileChooser(Caminho);
            Fs.setDialogTitle("Selecione uma pasta para as imagens processadas...");
            Fs.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            Fs.setAcceptAllFileFilterUsed(false);
            int Retorno = Fs.showOpenDialog(null);
            
            // Seleciona a pasta.
            if (Retorno == JFileChooser.APPROVE_OPTION){
            
                Campo_Pasta_Destino_.setText(Fs.getSelectedFile().getPath());
                Pasta_destino = Fs.getSelectedFile();
                Caminho       = Fs.getCurrentDirectory();
                Escolheu_destino = true;
            }
        } catch(NullPointerException ex){
            Logger.getLogger(Tela_Aplicacao_Lote.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Selecionar_Pasta_Destino_ActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Aplicacao_Lote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Aplicacao_Lote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Aplicacao_Lote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Aplicacao_Lote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Aplicacao_Lote().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aplicar_;
    private javax.swing.JTextField Campo_Pasta_Destino_;
    private javax.swing.JTextField Campo_Pasta_Origem_;
    private javax.swing.JButton Cancelar_;
    private javax.swing.JLabel Mensagem_Aviso_;
    private javax.swing.JRadioButton Opcao_BMP_;
    private javax.swing.JRadioButton Opcao_JPG_;
    private javax.swing.JRadioButton Opcao_PNG_;
    private javax.swing.JButton Selecionar_Pasta_Destino_;
    private javax.swing.JButton Selecionar_Pasta_Origem_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
