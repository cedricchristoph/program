/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
    public static BufferedImage loadImage(String path) {
	try {
            return ImageIO.read(ImageLoader.class.getResource(path));
	} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
