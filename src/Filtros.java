

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Stack;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;




public class Filtros {
    
    public long TInicio, TFin, tiempo;
    Stack<Img_Row> tasks2do = new Stack<>();
    
    
    
    public BufferedImage aplicarFiltroSecuencial(BufferedImage imagen_original, int threshold){
        BufferedImage image = copyImage(imagen_original);
        /*
        FiltroAction task = new FiltroAction(1, image.getWidth()-1, 1, image.getHeight()-1, imagen_original, image, threshold);
        TInicio = System.currentTimeMillis();
        task.computeSecuentially();
        TFin = System.currentTimeMillis();
        */
        TInicio = System.currentTimeMillis();
        for (int y = 1; y < imagen_original.getHeight() - 1; y++) {
            for (int x = 1; x < imagen_original.getWidth() - 1; x++) {
                Color c00 = new Color(imagen_original.getRGB(x-1, y-1));
                Color c01 = new Color(imagen_original.getRGB(x-1, y));
                Color c02 = new Color(imagen_original.getRGB(x-1, y+1));
                Color c10 = new Color(imagen_original.getRGB(x, y-1));
                Color c11 = new Color(imagen_original.getRGB(x, y));
                Color c12 = new Color(imagen_original.getRGB(x, y+1));
                Color c20 = new Color(imagen_original.getRGB(x+1, y-1));
                Color c21 = new Color(imagen_original.getRGB(x+1, y));
                Color c22 = new Color(imagen_original.getRGB(x+1, y+1));
                int r = -c00.getRed() -   c01.getRed() - c02.getRed() +
                        -c10.getRed() + 9*c11.getRed() - c12.getRed() +
                        -c20.getRed() -   c21.getRed() - c22.getRed();
                int g = -c00.getGreen() -   c01.getGreen() - c02.getGreen() +
                        -c10.getGreen() + 9*c11.getGreen() - c12.getGreen() +
                        -c20.getGreen() -   c21.getGreen() - c22.getGreen();
                int b = -c00.getBlue() -   c01.getBlue() - c02.getBlue() +
                        -c10.getBlue() + 9*c11.getBlue() - c12.getBlue() +
                        -c20.getBlue() -   c21.getBlue() - c22.getBlue();
                r = Math.min(255, Math.max(0, r));
                g = Math.min(255, Math.max(0, g));
                b = Math.min(255, Math.max(0, b));
                Color color = new Color(r, g, b);
                image.setRGB(x, y, color.getRGB());
            }
        }
        TFin = System.currentTimeMillis();
        //System.out.println(threshold + " ");
        tiempo = TFin - TInicio;
        
        return image;
    }
    
    
    
    
    public BufferedImage aplicarFiltroConcurrente(BufferedImage imagen_original, int threshold){
        BufferedImage image = copyImage(imagen_original);
        ForkJoinPool pool = new ForkJoinPool();
        FiltroAction task = new FiltroAction(1, image.getWidth()-1, 1, image.getHeight()-1, imagen_original, image, threshold);
        TInicio = System.currentTimeMillis();
        pool.invoke(task);
        task.join();
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        //System.out.println(threshold + " ");
        return image;
    }
    
    
    
    public static BufferedImage copyImage(BufferedImage source){
        BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        Graphics g = b.getGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return b;
    }
    
}




class Img_Row implements Runnable{
    BufferedImage image;
    int j;
    int color;

    public Img_Row(BufferedImage image, int j) {
        this.image = image;
        this.j = j;
    }

    @Override
    public void run() {
        for (int i = 0; i < image.getWidth(); i = i + 1) {
            color = image.getRGB(i, j);
            image.setRGB(i, j, color - 150);
        }
    }      
}



class FiltroAction extends RecursiveAction{
    private int SEQUENTIAL_THRESHOLD = 10;
    private int x1, x2, y1, y2;
    private BufferedImage imagen_original, image;
    
    public FiltroAction(int x1, int x2, int y1, int y2, BufferedImage imagen_original, BufferedImage image, int threshold){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.imagen_original = imagen_original;
        this.image = image;
        this.SEQUENTIAL_THRESHOLD = threshold;
    }

    @Override
    protected void compute() {
        if(x2-x1>SEQUENTIAL_THRESHOLD){
            // Crear nuevos fork
            int media = (x1+x2)/2;
            FiltroAction fa1 = new FiltroAction(x1, media, y1, y2, imagen_original, image, SEQUENTIAL_THRESHOLD);
            FiltroAction fa2 = new FiltroAction(media, x2, y1, y2, imagen_original, image, SEQUENTIAL_THRESHOLD);
            fa1.fork();
            fa2.compute();
            fa1.join();
        }else if(y2-y1>SEQUENTIAL_THRESHOLD){
            // Crear nuevos fork
            int media = (y1+y2)/2;
            FiltroAction fa1 = new FiltroAction(x1, x2, y1, media, imagen_original, image, SEQUENTIAL_THRESHOLD);
            FiltroAction fa2 = new FiltroAction(x1, x2, media, y2, imagen_original, image, SEQUENTIAL_THRESHOLD);
            fa1.fork();
            fa2.compute();
            fa1.join();
        }else{
            // Calcular pixeles
            laplaciano(x1, x2, y1, y2);
        }
    }
    
    public void computeSecuentially(){
        if(x2-x1>SEQUENTIAL_THRESHOLD){
            // Crear nuevos fork
            int media = (x1+x2)/2;
            FiltroAction fa1 = new FiltroAction(x1, media, y1, y2, imagen_original, image, SEQUENTIAL_THRESHOLD);
            FiltroAction fa2 = new FiltroAction(media, x2, y1, y2, imagen_original, image, SEQUENTIAL_THRESHOLD);
            fa1.computeSecuentially();
            fa2.computeSecuentially();
        }else if(y2-y1>SEQUENTIAL_THRESHOLD){
            // Crear nuevos fork
            int media = (y1+y2)/2;
            FiltroAction fa1 = new FiltroAction(x1, x2, y1, media, imagen_original, image, SEQUENTIAL_THRESHOLD);
            FiltroAction fa2 = new FiltroAction(x1, x2, media, y2, imagen_original, image, SEQUENTIAL_THRESHOLD);
            fa1.computeSecuentially();
            fa2.computeSecuentially();
        }else{
            // Calcular pixeles
            laplaciano(x1, x2, y1, y2);
        }
    }

    private void laplaciano(int x1, int x2, int y1, int y2) {
        for (int y = y1; y < y2; y++) {
            for (int x = x1; x < x2; x++) {
                Color c00 = new Color(imagen_original.getRGB(x-1, y-1));
                Color c01 = new Color(imagen_original.getRGB(x-1, y));
                Color c02 = new Color(imagen_original.getRGB(x-1, y+1));
                Color c10 = new Color(imagen_original.getRGB(x, y-1));
                Color c11 = new Color(imagen_original.getRGB(x, y));
                Color c12 = new Color(imagen_original.getRGB(x, y+1));
                Color c20 = new Color(imagen_original.getRGB(x+1, y-1));
                Color c21 = new Color(imagen_original.getRGB(x+1, y));
                Color c22 = new Color(imagen_original.getRGB(x+1, y+1));
                int r = -c00.getRed() -   c01.getRed() - c02.getRed() +
                        -c10.getRed() + 9*c11.getRed() - c12.getRed() +
                        -c20.getRed() -   c21.getRed() - c22.getRed();
                int g = -c00.getGreen() -   c01.getGreen() - c02.getGreen() +
                        -c10.getGreen() + 9*c11.getGreen() - c12.getGreen() +
                        -c20.getGreen() -   c21.getGreen() - c22.getGreen();
                int b = -c00.getBlue() -   c01.getBlue() - c02.getBlue() +
                        -c10.getBlue() + 9*c11.getBlue() - c12.getBlue() +
                        -c20.getBlue() -   c21.getBlue() - c22.getBlue();
                r = Math.min(255, Math.max(0, r));
                g = Math.min(255, Math.max(0, g));
                b = Math.min(255, Math.max(0, b));
                Color color = new Color(r, g, b);
                image.setRGB(x, y, color.getRGB());
            }
        }
    }
}
