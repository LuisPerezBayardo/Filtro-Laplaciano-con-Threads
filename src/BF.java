/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.io.Serializable;
import java.util.Hashtable;


public class BF extends BufferedImage implements Serializable{
    
    private static final long serialVersionUID = 20120731125400L;
    
    public BF(int width, int height, int imageType) {
        super(width, height, imageType);
    }

    public BF(int width, int height, int imageType, IndexColorModel cm) {
        super(width, height, imageType, cm);
    }

    public BF(ColorModel cm, WritableRaster raster, boolean isRasterPremultiplied, Hashtable<?, ?> properties) {
        super(cm, raster, isRasterPremultiplied, properties);
    }
    
    
}
