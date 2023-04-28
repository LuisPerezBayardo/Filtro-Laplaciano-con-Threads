/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import javax.imageio.ImageIO;


public class ClientSession implements Serializable{
    
    private static final long serialVersionUID = 20120731125400L;
    
    //Imagen sin el filtro:
    private String extOriginalImage = "";
    private byte[] originalImage = null;
    
    //Imagen con el filtro:
    private String extResultImage = "";
    private byte[] resultImage = null;
    
    //id del cliente
    private int IdClient = -1;
    
    //tiempos tardados:
    private long time_init = -1;
    private long time_finished = -1;
    private long time = -1;

    public ClientSession(  ) {
        
        this.time_init      = 0;
        this.time_finished  = 0;
        this.time           = 0;
        
    }
    
    public long getTime_init() {
        return time_init;
    }

    public void setTime_init(long time_init) {
        this.time_init = time_init;
    }

    public long getTime_finished() {
        return time_finished;
    }

    public void setTime_finished(long time_finished) {
        this.time_finished = time_finished;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getExtOriginalImage() {
        return extOriginalImage;
    }

    public void setExtOriginalImage(String extOriginalImage) {
        this.extOriginalImage = extOriginalImage;
    }

    public String getExtResultImage() {
        return extResultImage;
    }

    public void setExtResultImage(String extResultImage) {
        this.extResultImage = extResultImage;
    }
    
    
    
    public void setOriginalImage(BufferedImage img, String format) throws IOException
    {
        this.originalImage =null;
        this.extOriginalImage = format;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, format, baos);     
        this.originalImage = baos.toByteArray();
        
    }
    public void setResultImage(BufferedImage img, String format) throws IOException
    {
        this.resultImage = null;
        this.extResultImage = (this.extOriginalImage.isEmpty())? format: this.extOriginalImage;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, format, baos);     
        this.resultImage = baos.toByteArray();
        
    }
    
    public BufferedImage getOriginalImage() {
        InputStream is = new ByteArrayInputStream(this.originalImage);
        BufferedImage bi;
        try {
            bi = ImageIO.read(is);
            return bi;
        } catch (IOException ex) {
            System.out.println(ex);
            return null;
        }    
    }

    public void setOriginalImage(BufferedImage originalImage) {
        
        try {
            if(originalImage == null){
                this.originalImage = null;
                return;
            }
            this.setOriginalImage(originalImage, this.extOriginalImage);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public BufferedImage getResultImage() {
         InputStream is = new ByteArrayInputStream(this.resultImage);
        BufferedImage bi;
        try {
            bi = ImageIO.read(is);
            return bi;
        } catch (IOException ex) {
            System.out.println(ex);
            return null;
        }    
    }

    public void setResultImage(BufferedImage resultImage) {
        try {
            if(resultImage == null){
                this.resultImage = null;
                return;
            }
            this.setResultImage(resultImage, this.extOriginalImage);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public int getIdClient() {
        return IdClient;
    }

    public void setIdClient(int IdClient) {
        this.IdClient = IdClient;
    }
    

}
