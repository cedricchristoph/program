package local;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Used for loading the icons shown on the playground maps.
 * @author Cedric Christoph
 * @since 1.1.0
 * @version 1.0.0
 */
public class IconLoader {
    
    /**
     * File variable for root. Location where the images are on the device
     */
    private File root;
    
    /**
     * BufferedImages for each needed icon
     */
    private BufferedImage explosion, greyWater, water; 
    
    /**
     * Empty constructor. Loads root and the buffered images.
     * @throws IOException 
     */
    public IconLoader() throws IOException{
        root = new File(".");
        explosion = ImageIO.read(new File(root + "/explosion_small.jpg"));
        greyWater = ImageIO.read(new File(root + "/water_grey.jpg"));
        water = ImageIO.read(new File(root + "/water_blue.png"));
    }

    /**
     * Function that returns the root File.
     * @return 
     */
    public File getRoot() {
        return root;
    }

    /**
     * Function that returns the properly scaled explosion ImageIcon.
     * @param width Integer width of the element which it has to fit in.
     * @param height Integer height of the element which it has to fit in.
     * @return ImageIcon explosion
     */
    public ImageIcon getExplosion(int width, int height) {
        return new ImageIcon(scale(explosion, width, height));
    }

    /**
     * Function that returns the properly scaled grey water ImageIcon.
     * @param width Integer width of the element which it has to fit in.
     * @param height Integer height of the element which it has to fit in.
     * @return ImageIcon greyWater
     */
    public ImageIcon getGreyWater(int width, int height) {
        return new ImageIcon(scale(greyWater, width, height));
    }

    /**
     * Function that returns properly scaled water ImageIcon
     * @param width Integer width of the element which it has to fit in.
     * @param height Integer height of the element which it has to fit in.
     * @return ImageIcon water
     */
    public ImageIcon getWater(int width, int height) {
        return new ImageIcon(scale(water, width, height));
    }

    /**
     * Method to change root file
     * @param root File root
     */
    public void setRoot(File root) {
        this.root = root;
    }

    /**
     * Method to change explosion BufferedImage
     * @param explosion BufferedImage for explosion
     */
    public void setExplosion(BufferedImage explosion) {
        this.explosion = explosion;
    }

    /**
     * Method to change grey water BufferedImage
     * @param greyWater BufferedImage for grey water
     */
    public void setGreyWater(BufferedImage greyWater) {
        this.greyWater = greyWater;
    }

    /**
     * Method to change water BufferedImage
     * @param water BufferedImage for water
     */
    public void setWater(BufferedImage water) {
        this.water = water;
    }
    
    /**
     * Function to scale a buffered image to the given dimensions.
     * @param i BufferedImage to scale
     * @param width Integer width to fit
     * @param height Integer height to fit
     * @return Image properly scaled
     */
    private Image scale(BufferedImage i, int width, int height){
        return i.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
    }
    
}
