

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;




public class Ventana_JFrame extends javax.swing.JFrame {
    BufferedImage imagen_original;
    Filtros filtros = new Filtros();

    private ClientServices stub;
    
    private ClientSession client;
    
    
    public Ventana_JFrame() throws NotBoundException, MalformedURLException, RemoteException {
//        this.stub = (ClientServices) Naming.lookup("rmi://localhost:5000/server");
        this.stub = (ClientServices) Naming.lookup("rmi://192.168.1.121:5000/server");
        this.client = this.stub.login();
        System.out.println("Soy el cliente con el id: " + this.client.getIdClient());
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_img_original = new javax.swing.JPanel();
        jPanel_img_con_filtro = new javax.swing.JPanel();
        btn_cargar_img = new javax.swing.JButton();
        btn_filtro_secuencial = new javax.swing.JButton();
        btn_filtro_concurrente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_tiempo_secuencial = new javax.swing.JLabel();
        lbl_tiempo_concurrente = new javax.swing.JLabel();
        sld_threshold = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_threshold_conc = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lbl_tiempo_paralela = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Filtros");

        jPanel_img_original.setBackground(new java.awt.Color(0, 255, 204));

        javax.swing.GroupLayout jPanel_img_originalLayout = new javax.swing.GroupLayout(jPanel_img_original);
        jPanel_img_original.setLayout(jPanel_img_originalLayout);
        jPanel_img_originalLayout.setHorizontalGroup(
            jPanel_img_originalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );
        jPanel_img_originalLayout.setVerticalGroup(
            jPanel_img_originalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );

        jPanel_img_con_filtro.setBackground(new java.awt.Color(0, 255, 204));
        jPanel_img_con_filtro.setPreferredSize(new java.awt.Dimension(544, 315));

        javax.swing.GroupLayout jPanel_img_con_filtroLayout = new javax.swing.GroupLayout(jPanel_img_con_filtro);
        jPanel_img_con_filtro.setLayout(jPanel_img_con_filtroLayout);
        jPanel_img_con_filtroLayout.setHorizontalGroup(
            jPanel_img_con_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );
        jPanel_img_con_filtroLayout.setVerticalGroup(
            jPanel_img_con_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );

        btn_cargar_img.setText("Cargar Imagen");
        btn_cargar_img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargar_imgActionPerformed(evt);
            }
        });

        btn_filtro_secuencial.setText("Aplicar Filtro Secuencial");
        btn_filtro_secuencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtro_secuencialActionPerformed(evt);
            }
        });

        btn_filtro_concurrente.setText("Aplicar Filtro Concurrente");
        btn_filtro_concurrente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtro_concurrenteActionPerformed(evt);
            }
        });

        jLabel1.setText("Ultimo tiempo secuencial:");

        jLabel2.setText("Ultimo tiempo concurrente:");

        lbl_tiempo_secuencial.setText("---------");

        lbl_tiempo_concurrente.setText("---------");

        sld_threshold.setMaximum(1000);
        sld_threshold.setMinimum(1);

        jLabel3.setText("THRESHOLD");

        jLabel4.setText("1");

        jLabel5.setText("1000");

        jLabel7.setText("Threshold:");

        lbl_threshold_conc.setText("--------");

        jButton1.setText("Aplicar con RMI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Ultimo tiempo paralela");

        lbl_tiempo_paralela.setText("--------");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel_img_original, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_cargar_img)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(185, 185, 185))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sld_threshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(89, 89, 89)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_img_con_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(btn_filtro_secuencial, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_tiempo_secuencial)
                                    .addComponent(lbl_tiempo_concurrente))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_threshold_conc))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_tiempo_paralela))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn_filtro_concurrente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)))))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_img_con_filtro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_img_original, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cargar_img)
                    .addComponent(btn_filtro_secuencial)
                    .addComponent(btn_filtro_concurrente)
                    .addComponent(jLabel3)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(lbl_tiempo_secuencial)
                                .addComponent(jLabel5)
                                .addComponent(jLabel8)
                                .addComponent(lbl_tiempo_paralela))
                            .addComponent(sld_threshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lbl_tiempo_concurrente)
                            .addComponent(jLabel7)
                            .addComponent(lbl_threshold_conc)))
                    .addComponent(jLabel4))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btn_cargar_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargar_imgActionPerformed
        // TODO add your handling code here:
        String ruta;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilter() {

            @Override
            public String getDescription() {
                return "JPG Images (*.jpg)";
            }

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    String filename = f.getName().toLowerCase();
                    return filename.endsWith(".jpg") || filename.endsWith(".jpeg") ;
                }
            }
         });
        int valor = fileChooser.showOpenDialog(fileChooser);
        if (valor == JFileChooser.APPROVE_OPTION) {
            ruta = fileChooser.getSelectedFile().getAbsolutePath();    
            
        } else {
            ruta = "";
            //ruta = "D:\\Luisibi\\Documents\\CETI\\Ingenieria en desarrollo de software\\Semestre 7\\Computación paralela\\Intersemestral\\Parcial 2\\Proyecto\\Proyecto_FiltroLaplacianoConThreads\\src\\proyecto_filtrolaplacianoconthreads\\imagen1.png";
        }
        
        if(ruta == null)
            return;
        
        if(ruta.isEmpty())
            return;
        
        try{
            this.clearValuesInClient();
            imagen_original = ImageIO.read(new File(ruta));
            this.client.setOriginalImage(imagen_original, "jpg");
        }catch (IOException ex) {Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);}
        Imagen im = new Imagen(jPanel_img_original, imagen_original);
        jPanel_img_original.add(im).repaint();
    }//GEN-LAST:event_btn_cargar_imgActionPerformed

    private void btn_filtro_secuencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtro_secuencialActionPerformed
        // TODO add your handling code here:
        //jPanel_img_con_filtro.removeAll();
        //jPanel_img_con_filtro.repaint();
        BufferedImage imagenFiltro = filtros.aplicarFiltroSecuencial(imagen_original, 100);
        Imagen im2 = new Imagen(jPanel_img_original, imagenFiltro);
        jPanel_img_con_filtro.add(im2).repaint();
        lbl_tiempo_secuencial.setText(filtros.tiempo + " ms");
        //lbl_threshold_sec.setText(sld_threshold.getValue() + " ");
    }//GEN-LAST:event_btn_filtro_secuencialActionPerformed

    private void btn_filtro_concurrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtro_concurrenteActionPerformed
         // TODO add your handling code here:
        //jPanel_img_con_filtro.removeAll();
        //jPanel_img_con_filtro.repaint();
        BufferedImage imagenFiltro = filtros.aplicarFiltroConcurrente(imagen_original, sld_threshold.getValue());
        Imagen im2 = new Imagen(jPanel_img_original, imagenFiltro);
        jPanel_img_con_filtro.add(im2).repaint();
        lbl_tiempo_concurrente.setText(filtros.tiempo + " ms");
        lbl_threshold_conc.setText(sld_threshold.getValue() + " ");
    }//GEN-LAST:event_btn_filtro_concurrenteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            
            this.client.setOriginalImage(this.imagen_original);
            ClientSession cl = this.stub.applyFilterConcurrentMethod(this.client, sld_threshold.getValue());
            
            if(cl == null)
            {
                System.out.println("Error al aplicar el filtro.");
                return;
            }
            
            this.client.setResultImage(cl.getResultImage());
            this.client.setTime_finished(cl.getTime_finished());
            this.client.setTime_init(cl.getTime_init());
            this.client.setTime(cl.getTime());
            
            
            Imagen im2 = new Imagen(jPanel_img_original, this.client.getResultImage());
            jPanel_img_con_filtro.add(im2).repaint();
            lbl_tiempo_paralela.setText(this.client.getTime() + " ms");
            lbl_threshold_conc.setText(sld_threshold.getValue() + " ");
            
            
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void clearValuesInClient(){
        //this.imagen_original = null;
        //this.client.setOriginalImage(null);
        //this.client.setResultImage(null);
        this.client.setTime_finished(0);
        this.client.setTime_init(0);
        this.client.setTime(0);
        
    }
    
    
    
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
            java.util.logging.Logger.getLogger(Ventana_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Ventana_JFrame().setVisible(true);
                } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                    System.out.println(ex);
                }
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cargar_img;
    private javax.swing.JButton btn_filtro_concurrente;
    private javax.swing.JButton btn_filtro_secuencial;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel_img_con_filtro;
    private javax.swing.JPanel jPanel_img_original;
    private javax.swing.JLabel lbl_threshold_conc;
    private javax.swing.JLabel lbl_tiempo_concurrente;
    private javax.swing.JLabel lbl_tiempo_paralela;
    private javax.swing.JLabel lbl_tiempo_secuencial;
    private javax.swing.JSlider sld_threshold;
    // End of variables declaration//GEN-END:variables
}





class Imagen extends javax.swing.JPanel {
    int x, y;
    BufferedImage image;

    public Imagen(JPanel jPanel1, BufferedImage image) {
        this.x = jPanel1.getWidth();
        this.y = jPanel1.getHeight();
        this.setSize(x, y);
        this.image = image;
    }

    @Override
    public void paint(Graphics g) {
        //int color;
        int w = image.getWidth();
        int h = image.getHeight();

        BufferedImage dimg = new BufferedImage(x, y, image.getType());
        Graphics2D g2d = dimg.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(image, 0, 0, x, y, 0, 0, w, h, null);
        g2d.dispose();

        image = dimg;

        /*for (int j = 0; j < image.getHeight(); j = j + 2) {
            for (int i = x / 2; i < image.getWidth(); i++) {
                color = image.getRGB(i, j);
                image.setRGB(i, j, color - 150);
            }
        }*/
        g.drawImage(image, 0, 0, this);
        
    }    
}


